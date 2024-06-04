import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Level2 extends JFrame implements ActionListener {
    int framecounter = 1; // What frame are we on
    
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
    private Player player; // Player for the background music

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

        // Start the background music
        startBackgroundMusic("levels\\images\\texts\\lvl2ambience.mp3");

        startPolling();
    }

    private void startBackgroundMusic(String filepath) {
        new Thread(() -> {
            try {
                FileInputStream fis = new FileInputStream(filepath);
                player = new Player(fis);
                player.play();
            } catch (JavaLayerException | java.io.IOException e) {
                e.printStackTrace();
            }
        }).start();
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
                            JTextField textfield = new JTextField();
                            JButton submit = new JButton("Submit");

                            textfield.setBounds(400, 400, 350, 200);
                            submit.setBounds(300, 400, 100, 25);
                            submit.addActionListener(p -> {
                                // Proceed to the next dialogue line and frame
                                reader.setProgress(true);
                                reader.currentIndex++;
                                reader.updateLabel();
                                scene.remove(submit);
                                scene.remove(textfield);
                                scene.repaint();
                                timer.start();
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
                        bg.setIcon(new ImageIcon(frame5)); // Final frame after minigame
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
        // Create a timer to limit the time for the mini-game
        Timer bounds = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mini-game time is up, do something with the click count, like displaying it
                System.out.println("Number of clicks: " + clicks);
                // Optionally, you can reset the clicks for a new game
                clicks = 0;
            }
        });
        bounds.start(); // Start the timer

        // Stop any existing timers
        timer.stop();
         // Assuming reader is an instance of some class that has a setProgress method
        reader.setProgress(false);
    
        // Assuming bg is an instance of JLabel where you want to display an image
        bg.setIcon(new ImageIcon(frame5)); // Update bg image 
    
        JButton masher = new JButton("Click Me!"); // Provide text for the button
        masher.setBounds(0, 0, 100, 100);
        // Add an ActionListener to the button to handle click events
        masher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Increment the click count when the button is clicked
                clicks++;
            }
        });
        // Add the button to UI
        // and 'container' is the name of that container
        bg.add(masher);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new Level2();
    }
}
