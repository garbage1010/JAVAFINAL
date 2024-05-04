/*
 * "This creates the class for the first level of the game"
 */
package levels;

// Importing necessary libraries
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import javafx.event.ActionEvent;

// Class definition
public class Level1 extends JFrame implements ActionListener{

    // Creating a button
    JButton textbox = new JButton();

    // Constructor
    Level1(){

        // Setting button dimensions
        textbox.setBounds(0, 500, 200, 100);
        
        // Background image
        ImageIcon questionmarkbackground = new ImageIcon("textbox.png");

        // Creating a JLabel for background image
        JLabel bgimg = new JLabel();
        bgimg.setIcon(questionmarkbackground);

        // Creating and setting up the main frame
        JFrame scene1 = new JFrame();
        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene1.setSize(800, 600);
        scene1.setVisible(true);
        scene1.add(bgimg);
    }

    // This method is triggered when a button is pressed
    public void actionPerformed(ActionEvent e) {
        // Checks if the button pressed is the textbox button
        if(e.getSource()==textbox){
            // Action to be performed when the button is pressed
        }
    }
