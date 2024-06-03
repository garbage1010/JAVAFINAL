import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Level2 extends JFrame implements ActionListener {
    int framecounter = 1; // What frame are we on
    String key = "LEVELTWO";
    
    Timer timer;

    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv2dialogue.txt", 0, 600, 800, 200);
    
    // Background images
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame4-1.PNG"); 
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame4-2.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame4-3.PNG");
    Image frame4 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame4-4.PNG");
    Image frame5 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame5-2.PNG");

    JLabel bg = new JLabel(); // Label to be used as background
    JButton cipher; // Cipher on the first frame in the shelf
    JFrame scene = new JFrame(); // Main frame
    JTextField textfield = new JTextField();
    JButton submit = new JButton("Submit");

    // Minigame
    ButtonMashingMinigame minigame = new ButtonMashingMinigame();

    public Level2() {
        // Set background to frame size and set original icon
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));

        // Create button for cipher
        cipher = new JButton();
        cipher.setFocusable(false);
        cipher.setBounds(425, 375, 100, 100);
        cipher.setOpaque(false);

        // Create scene
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setSize(800, 800);
        scene.setLayout(null);
        scene.setVisible(true);
        scene.setResizable(false);
        scene.add(reader.getButton());
        scene.add(bg);
        scene.add(cipher);
        startPolling();
    }

    private void startPolling() {
        timer = new Timer(500, e -> {
            try {
                int currentIndex = reader.currentIndex;
                switch (currentIndex) {
                    case 2:
                        timer.stop();
                        reader.setProgress(false);
                        cipher.addActionListener(l -> {            
                            bg.setIcon(new ImageIcon(frame2)); // Change background image
                            scene.remove(cipher);
                            scene.repaint();
                            textfield.setBounds(400, 400, 350, 200);
                            submit.setBounds(300, 400, 100, 25);
                            submit.addActionListener(p -> {
                                String uh = textfield.getText();
                                if (uh.contains(key)) {
                                    System.out.println(key);
                                    reader.setProgress(true);
                                    reader.currentIndex++;
                                    reader.updateLabel();
                                    scene.remove(submit);
                                    scene.remove(textfield);
                                    scene.repaint();
                                    timer.start();
                                }
                            });
                            scene.add(submit);
                            scene.add(textfield);
                        });
                        break;
                    case 4:
                        bg.setIcon(new ImageIcon(frame3));
                        break;
                    case 5:
                        timer.stop();
                        reader.setProgress(false);
                        bg.setIcon(new ImageIcon(frame4));
                        JButton window = new JButton();
                        window.setBounds(0, 0, 100, 100);
                        window.addActionListener(o -> {
                            reader.setProgress(true);
                            reader.currentIndex++;
                            reader.updateLabel();
                            scene.remove(window);
                            scene.repaint();
                            timer.start();
                        });
                        scene.add(window);
                        break;
                    case 6:
                        startMinigame(); // Trigger the minigame on the second-to-last frame
                        break;
                    case 7:
                        bg.setIcon(new ImageIcon(frame5));
                        break;
                    default:
                        break;
                }
            } catch (Error er) {
                System.out.println(er);
            }
        });
        timer.start();
    }

    private void startMinigame() {
        getContentPane().removeAll();
        add(minigame);
        revalidate();
        repaint();
        minigame.startGame();

        // Timer to check when the minigame ends
        Timer checkEndTimer = new Timer(100, e -> {
            if (!minigame.isRunning()) {
                int mashCount = minigame.getMashCount();
                endMinigame(mashCount);
                ((Timer) e.getSource()).stop();
            }
        });
        checkEndTimer.start();
    }

    private void endMinigame(int mashCount) {
        getContentPane().removeAll();
        add(bg);
        add(reader.getButton());
        scene.add(cipher); // Add other components back if needed
        revalidate();
        repaint();
        System.out.println("Minigame ended. Mash count: " + mashCount);
        reader.setProgress(true);
        reader.currentIndex++;
        reader.updateLabel();
        bg.setIcon(new ImageIcon(frame5)); // Set the final frame after minigame
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Level2());
    }
}
