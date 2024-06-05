import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

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
    //private Player player; // Player for the background music

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
    }
        // Start the background music
           public static void playBackgroundMusic(String filePath) {
        try {
            // Open an audio input stream
            File musicFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);

            // Get a sound clip resource
            Clip clip = AudioSystem.getClip();

            // Open audio clip and load samples from the audio input stream
            clip.open(audioStream);

            // Start the clip in a loop
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Start playing the music
            clip.start();

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
        playBackgroundMusic("levels\\images\\audio\\lvl2ambience.mp3");

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

    // Start the button mashing minigame
    private void startMinigame(){
        // Create a timer to limit the time for the mini-game
        Timer bounds = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mini-game time is up, handle the click count
                System.out.println("Number of clicks: " + clicks);
                clicks = 0; // Reset clicks for a new game
                endMinigame(); // Proceed after minigame ends
            }
        });
        bounds.start(); // Start the timer

        // Stop any existing timers
        timer.stop();
        reader.setProgress(false);

        // Create the button for the minigame
        JButton masher = new JButton("Break the window!");
        masher.setBounds(0, 0, 100, 100);
        masher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clicks++; // Increment the click count
            }
        });
        bg.add(masher); // Add the button to the background
    }

    // End the minigame and proceed to the next step
    private void endMinigame() {
        bg.removeAll(); // Remove all components from bg
        bg.setIcon(new ImageIcon(frame5)); // Set the final frame after minigame
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
        SwingUtilities.invokeLater(() -> new Level2());
    }
}
