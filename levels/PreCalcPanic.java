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
    private static Timer timer;
    public static int currentLevel = 0;
    public static void main(String[] args) {
        startPolling();
        new StartMenu(); // Create an instance of StartMenu
    }


    public static void startPolling() {
        timer = new Timer(500, e -> {
            try {
                System.out.println("Current Level: " + currentLevel); // Debug print
                switch (currentLevel) {
                    case 1:// -> {
                        SwingUtilities.invokeLater(() -> {
                            System.out.println("Starting Level 1");
                            new Level1();
                        });
                        timer.stop();
                        break;
                    //}
                    case 2:// -> {
                        SwingUtilities.invokeLater(() -> {
                            System.out.println("Starting Level 1.5");
                            new Level15();
                        });
                        timer.stop();
                        break;
                    //}
                    case 3:
                        SwingUtilities.invokeLater(() -> {
                            System.out.println("Starting Level 2");
                            new Level2();
                        });
                        timer.stop();
                        break;
                    //}
                    case 4:// -> {
                        SwingUtilities.invokeLater(() -> {
                            System.out.println("Starting Level 3");
                            new Level3();
                        });
                        timer.stop();
                    //}
                    case 5:// -> {
                        SwingUtilities.invokeLater(() -> {
                            System.out.println("Starting Level 4");
                            new Level4();
                        });
                        timer.stop();
                        break;
                    //}
                    default:// -> {
                        System.out.println("Invalid level: " + currentLevel);
                        timer.stop();
                        break;
                    //}
                }
            } catch (Exception er) {
                System.err.println("Error: " + er.getMessage());
            }
        });
        timer.start();
    }

    public static void increment() {
        System.out.println("Incrementing level from " + currentLevel + " to " + (currentLevel + 1));
        currentLevel++;
    }

    public static void timerChange() {
        if (timer != null) {
            System.out.println("Restarting timer");
            timer.start();
        } else {
            System.out.println("Timer is null, initializing and starting");
            startPolling();
        }
    }
}
