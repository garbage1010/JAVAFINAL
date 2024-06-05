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

    int currentIndex = 0; 
    boolean gameOver = false; 

    new StartMenu(); // Create an instance of StartMenu

    SwingUtilities.invokeLater(() -> new Level1());

    //call level 2 here 

    //call level 3 here 

    //add code to save progress here

    //initiate game over if gameOver is true 
    
  }
}
    
