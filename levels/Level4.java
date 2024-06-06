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
import java.io.IOException;

public class Level4 extends JFrame implements ActionListener {

    Timer timer;
    public boolean isvisible = true;
    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv4dialogue.txt", 0, 600, 800, 200);

    // Images used
    ImageIcon frame1 = new ImageIcon("levels\\images\\4\\Final1.PNG");
    ImageIcon frame2 = new ImageIcon("levels\\images\\4\\Final2.PNG");
    ImageIcon frame3 = new ImageIcon("levels\\images\\4\\Final3.PNG");
    ImageIcon frame4 = new ImageIcon("levels\\images\\4\\Final4.PNG");
    ImageIcon frame5 = new ImageIcon("levels\\images\\4\\Final5.PNG");
    ImageIcon frame6 = new ImageIcon("levels\\images\\4\\Final6.PNG");
    ImageIcon frame7 = new ImageIcon("levels\\images\\4\\Goodgoodend.PNG");

    JLabel bg = new JLabel(); // Label to be used as background
    JButton selectSyringe;

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
        bg.setIcon(frame1);
        add(bg);

        // Add the reader button
        add(reader.getButton());

        // Start the background music
        //playBackgroundMusic(filePath);

        // Start the timer
        startPolling();
    }

    private void startPolling() {
        timer = new Timer(500, e -> {
            try {
                int currentIndex = reader.currentIndex;
                System.out.println("Current Index: " + currentIndex); // Debug print
                switch (currentIndex) {
                    case 2:
                        bg.setIcon(frame2);
                        break;
                    case 3:
                        bg.setIcon(frame3);
                        break;
                    case 4:
                        bg.setIcon(frame4);
                        break;
                    case 5:
                        bg.setIcon(frame5);
                        selectSyringe = new JButton();
                        selectSyringe.setFocusable(false);
                        selectSyringe.setBounds(100, 100, 100, 50); // Placeholder bounds
                        selectSyringe.setOpaque(false);
                        add(selectSyringe);
                        revalidate();
                        repaint();
                        break;
                    case 6:
                        bg.setIcon(frame6);
                        break;
                    case 7:
                        bg.setIcon(frame7);
                        PreCalcPanic.increment();
                        SaveThat.saveLevel(5);
                        dispose();
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

    private void updateFrame(TextFileReader reader, ImageIcon frame, int x, int y, int width, int height, int nextIndex) {
        reader.currentIndex = nextIndex;
        JButton errorbutton = new JButton();
        bg.setIcon(frame);
        errorbutton.setBounds(x, y, width, height);
        add(errorbutton);
        revalidate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions if necessary
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Level4());
    }
}
