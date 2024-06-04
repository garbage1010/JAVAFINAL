import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.FileInputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class Level4 extends JFrame implements ActionListener {

    Timer timer;
    public boolean isvisible = true;
    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv4dialogue.txt", 0, 600, 800, 200);

    selectSyringe = new JButton();
        selectSyringe.setFocusable(false);
        selectSyringe.setBounds(placeholder);
        selectSyringe.setOpaque(false);

    // Images used
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final1.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final2.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final3.PNG");
    Image frame4 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final4.PNG");
    Image frame5 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final5.PNG");
    Image frame6 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Final6.PNG");

    JLabel bg = new JLabel(); // Label to be used as background
    JButton errorbutton = new JButton();
    private Player player; // Player for the background music

    // Constructor
    public Level4() {
        // Setup the main frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(null);
        setVisible(true);
        setResizable(false);

        // Load game state
        // loadGameState(); // Commented out as the method is not defined

        // Setup background label
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));
        add(bg);

        // Add the reader button
        add(reader.getButton());

        // Start the background music
        startBackgroundMusic("levels\\images\\texts\\lvl4ambience.mp3");

        // Start the timer
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
                        // syringe selection minigame here
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

