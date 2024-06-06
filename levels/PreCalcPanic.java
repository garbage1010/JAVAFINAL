import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class PreCalcPanic {
    public static int currentLevel = 0;
    public static Timer timer;

    public static void main(String[] args) {
        startPolling();
        new StartMenu(); // Create an instance of StartMenu
    }

    private static void startPolling() {
        timer = new Timer(500, e -> {
            try {
                System.out.println("Current Level: " + currentLevel); // Debug print
                if (currentLevel == 1) {
                    SwingUtilities.invokeLater(() -> new Level1());
                    timer.stop();
                } else if (currentLevel == 2) {
                    new Level15();
                } else if (currentLevel == 3) {
                    SwingUtilities.invokeLater(() -> new Level2());
                    timer.stop();
                } else if (currentLevel == 4) {
                    SwingUtilities.invokeLater(() -> new Level3());
                    timer.stop();
                } else if (currentLevel == 5) {
                    SwingUtilities.invokeLater(() -> new Level4());
                    timer.stop();
                } else {
                    // Handle invalid level or default case
                    System.out.println("Invalid level: " + currentLevel);
                }
            } catch (Exception er) {
                System.err.println("Error: " + er.getMessage());
            }
        });
        timer.start();
    }

    public static void increment(){
        currentLevel++;
    }
}
