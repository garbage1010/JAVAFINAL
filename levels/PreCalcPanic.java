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

    SwingUtilities.invokeLater(() -> new Level1());

    new Level15();

    SwingUtilities.invokeLater(() -> new Level2());

    SwingUtilities.invokeLater(() -> new Level3());

    SwingUtilities.invokeLater(() -> new Level4());
    
  }
}
    
