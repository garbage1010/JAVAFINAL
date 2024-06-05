import javax.swing.ImageIcon;
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class PreCalcPanic {
  public static void main(String[] args) {

    new StartMenu(); // Create an instance of StartMenu
    
    private void startPolling() {
    Timer timer = new Timer(500, e -> {
        try {
            System.out.println("Current Level: " + currentLevel); // Debug print
            if (currentLevel == 1) {
               SwingUtilities.invokeLater(() -> new Level1());
            } else if (currentLevel == 2) {
                new Level15();
            } else if (currentLevel == 3) {
                SwingUtilities.invokeLater(() -> new Level2());
            } else if (currentLevel == 4) {
                SwingUtilities.invokeLater(() -> new Level3());
            } else if (currentLevel == 5) {
                SwingUtilities.invokeLater(() -> new Level4());
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

  }
}
    
