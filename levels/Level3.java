import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level3 extends JFrame implements ActionListener {

    Timer timer;

    public boolean isvisible = true;

    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv3dialogue.txt", 0, 600, 800, 200);

    // Images used
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame6-1.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame6-2.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame7-1.PNG");
    Image frame4 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame7-2.PNG");
    Image frame5 = Toolkit.getDefaultToolkit().getImage("levels\\images\\3\\Frame7-3.PNG");

    JLabel bg = new JLabel(); // Label to be used as background
    JButton errorbutton = new JButton();

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
        });

    private void updateFrame(TextFileReader reader, Image frame, int x, int y, int width, int height, int nextIndex) {
        System.out.println("Updating frame for index: " + reader.currentIndex); // Debug print
        timer.stop();
        reader.setProgress(false);
        bg.setIcon(new ImageIcon(frame));
        add(errorbutton);
        errorbutton.setBounds(x, y, width, height);
        errorbutton.addActionListener(l -> {
            System.out.println("Error button pressed for next index: " + nextIndex); // Debug print
            reader.setProgress(true);
            reader.currentIndex = nextIndex;
            reader.updateLabel();
            remove(errorbutton);
            timer.start();
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
