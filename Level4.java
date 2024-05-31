import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level4 extends JFrame implements ActionListener {

    Timer timer;

    public boolean isvisible = true;

    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv4dialogue.txt", 0, 600, 800, 200);

    // Images used
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Frame4-1.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Frame4-2.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Frame4-3.PNG");
    Image frame4 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Frame4-4.PNG");
    Image frame5 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Frame4-5.PNG");
    Image frame6 = Toolkit.getDefaultToolkit().getImage("levels\\images\\4\\Frame4-6.PNG");

    JLabel bg = new JLabel(); // Label to be used as background
    JButton errorbutton = new JButton();

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

        // Start the timer
        startPolling();
    }

    private void startPolling() {
        timer = new Timer(500, e -> {
            try {
                int currentIndex = reader.currentIndex;
                System.out.println("Current Index: " + currentIndex); // Debug print
                switch (currentIndex) {
                    case 4:
                        updateFrame(reader, frame2, 385, 240, 30, 30, 5);
                        break;
                    case 5:
                        updateFrame(reader, frame3, 449, 351, 30, 30, 6);
                        break;
                    case 7:
                        updateFrame(reader, frame4, 441, 237, 50, 50, 8);
                        break;
                    case 8:
                        bg.setIcon(new ImageIcon(frame5));
                        timer.stop();
                        break;
                    case 9:
                        bg.setIcon(new ImageIcon(frame6));
                        timer.stop();
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

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions if necessary
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Level4());
    }
}
