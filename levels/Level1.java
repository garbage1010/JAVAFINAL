import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Level1 extends JFrame implements ActionListener {

    Timer timer;

    public boolean isvisible = true;

    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv1dialogue.txt", 0, 600, 800, 200);

    // Images used
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-1.PNG");
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-2-1.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-2-2.PNG");
    Image frame4 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-2-3.png");
    Image frame5 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-3.png");
    Image frame6 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame2-1.png");

    JLabel bg = new JLabel(); // Label to be used as background
    JButton errorbutton = new JButton();

    // Constructor
    public Level1() {
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
                        break;
                    case 9:
                        bg.setIcon(new ImageIcon(frame6));
                        timer.stop();
                        break;
                    default:
                        break;
                }
            } catch (Exception er) {
                System.err.println("Error: " + er.getMessage());
            }
        });
        timer.start();
    }

    private void updateFrame(TextFileReader reader, Image frame, int x, int y, int width, int height, int nextIndex) {
        System.out.println("Updating frame for index: " + reader.currentIndex); // Debug print
        timer.stop();
        reader.setProgress(false);
        bg.setIcon(new ImageIcon(frame));
        add(errorbutton);
        errorbutton.setBounds(x, y, width, height);
        removeAllActionListeners(errorbutton);
        errorbutton.addActionListener(l -> {
            System.out.println("Error button pressed for next index: " + nextIndex); // Debug print
            reader.setProgress(true);
            reader.currentIndex = nextIndex;
            reader.updateLabel();
            remove(errorbutton);
            timer.start();
        });
    }

    private void removeAllActionListeners(JButton button) {
        for (ActionListener al : button.getActionListeners()) {
            button.removeActionListener(al);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle button actions if necessary
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Level1());
    }
}
