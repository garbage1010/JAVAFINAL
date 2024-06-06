import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level2 extends JFrame implements ActionListener {
    int framecounter = 1; // What frame are we on
    String key = "1011110110111101100000011111110111111101"; // Key for validation
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
    private int clicks = 0; // Declare clicks as a class variable to be accessible throughout the class

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

    // Start polling to handle frame changes
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
                            JTextField textfield = new JTextField();
                            JButton submit = new JButton("Submit");

                            textfield.setBounds(400, 400, 350, 200);
                            submit.setBounds(300, 400, 100, 25);
                            submit.addActionListener(p -> {
                                // Check if the input contains the key
                                String input = textfield.getText();
                                if (input.contains(key)) {
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
                        bg.setIcon(new ImageIcon(frame3)); // Update background image
                        break;
                    case 5:
                        timer.stop();
                        reader.setProgress(false);
                        bg.setIcon(new ImageIcon(frame4)); // Update background image
                        JButton window = new JButton();
                        window.setBounds(0, 0, 200, 200);
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
                        bg.setIcon(new ImageIcon(frame5)); // Final frame after minigame
                        PreCalcPanic.increment();
                        SaveThat.saveLevel(3);
                        scene.dispose(); 
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

    // Start the button mashing minigame
    private void startMinigame(){
        // Stop any existing timers
        timer.stop();
        reader.setProgress(false);

        // Create the minigame panel
        ButtonMashingMinigame minigame = new ButtonMashingMinigame();
        minigame.setBounds(0, 0, 800, 600);

        // Add the minigame panel to the scene
        scene.setContentPane(minigame);
        scene.revalidate();
        scene.repaint();
        minigame.startGame();

        // Create a timer to limit the time for the mini-game
        Timer bounds = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mini-game time is up, handle the click count
                System.out.println("Number of clicks: " + minigame.getMashCount());
                minigame.endGame(); // End the minigame
                endMinigame(); // Proceed after minigame ends
            }
        });
        bounds.setRepeats(false);
        bounds.start(); // Start the timer
    }

    // End the minigame and proceed to the next step
    private void endMinigame() {
        bg.setIcon(new ImageIcon(frame5)); // Set the final frame after minigame
        scene.setContentPane(bg);
        scene.add(reader.getButton());
        scene.repaint();
        reader.setProgress(true);
        reader.currentIndex++;
        reader.updateLabel();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new Level2();
    }
}
