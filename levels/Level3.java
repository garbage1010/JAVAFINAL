import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Level3 extends JFrame implements ActionListener {

    Timer timer;

    public boolean isvisible = true;

    // Assuming TextFileReader is a custom class you have defined elsewhere
    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv3dialogue.txt", 0, 600, 800, 200);

    // Images used
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame6-1.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame6-2.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame7-1.PNG");
    Image frame4 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame7-2.PNG");
    Image frame5 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame7-3.PNG");

    JLabel bg = new JLabel(); // Label to be used as background
    new FadeOutOverlayPanel(bg); // Add a fade-in 

    // Constructor
    public Level3() {
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
                        launchTimingGame();
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

    private void launchTimingGame() {
        // Stop the current timer
        timer.stop();
        // Create and display the TimingGame button
        SwingUtilities.invokeLater(() -> {
            TimingGame timingGame = new TimingGame();
            timingGame.setVisible(true);
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions if necessary
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Level3());
    }
}

