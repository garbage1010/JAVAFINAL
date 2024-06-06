import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
<<<<<<< Updated upstream
import javax.sound.sampled.*;
=======
import java.io.FileInputStream;
import java.io.IOException;

>>>>>>> Stashed changes

public class Level4 extends JFrame implements ActionListener {

    Timer timer;
    public boolean isvisible = true;
    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv4dialogue.txt", 0, 600, 800, 200);

    // Images used
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final1.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final2.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final3.PNG");
    Image frame4 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final4.PNG");
    Image frame5 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final5.PNG");
    Image frame6 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final6.PNG");
    Image frame7 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Goodgoodend.PNG"); 

    JLabel bg = new JLabel(); // Label to be used as background
    new FadeOutOverlay(bg); 
<<<<<<< Updated upstream
    JButton selectSyringe;
    JButton errorbutton = new JButton(); // Assuming this button is needed
    String filePath = "levels\\images\\texts\\lvl4ambience.wav";
=======
    String filePath = "lvl4ambience.wav";

   
>>>>>>> Stashed changes

    // Constructor
    public Level4() {
        // Setup the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(null);
        setVisible(true);
        setResizable(false);

        // Setup background label
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));
        add(bg);

        // Add the reader button
        add(reader.getButton());

        // Start the background music
<<<<<<< Updated upstream
        playBackgroundMusic(filePath);
=======
        // Start the background music
        new playBackgroundMusic(filePath);
>>>>>>> Stashed changes

        // Start the timer
        startPolling();
    }
<<<<<<< Updated upstream

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

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
=======
>>>>>>> Stashed changes

    private void startPolling() {
        timer = new Timer(500, e -> {
            try {
                int currentIndex = reader.currentIndex;
                System.out.println("Current Index: " + currentIndex); // Debug print
                switch (currentIndex) {
                    case 2:
                        bg.setIcon(new ImageIcon(frame2));
                        break;
                    case 3:
                        bg.setIcon(new ImageIcon(frame3));
                        break;
                    case 4:
                        bg.setIcon(new ImageIcon(frame4));
                        break;
                    case 5:
                        bg.setIcon(new ImageIcon(frame5));
                        selectSyringe = new JButton();
                        selectSyringe.setFocusable(false);
                        selectSyringe.setBounds(100, 100, 100, 50); // Placeholder bounds
                        selectSyringe.setOpaque(false);
                        add(selectSyringe);
                        break;
                    case 6: 
                        bg.setIcon(new ImageIcon(frame6)); 
                        break; 
                    case 7: 
                        bg.setIcon(new ImageIcon(frame7)); 
                        PreCalcPanic.increment();
                        SaveThat.saveLevel(5);
                        scene.dispose(); 
                        break; 
                    default:
                        if (currentIndex < reader.lines.size()) {
                            reader.updateLabel(); // Ensure label updates even in default case
                            reader.currentIndex++;
                        }
                        break;
                }
            } catch (Exception er) {
                System.err.println("Error: " + er.getMessage());
            }
        });
        timer.start();
    }

    private void updateFrame(TextFileReader reader, Image frame, int x, int y, int width, int height, int nextIndex) {
        reader.currentIndex = nextIndex;
        bg.setIcon(new ImageIcon(frame));
        errorbutton.setBounds(x, y, width, height);
        add(errorbutton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions if necessary
    }
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Level4());
    }
}
