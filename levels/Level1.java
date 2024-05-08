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
import java.awt.event.ActionEvent;


// Class definition
public class Level1 extends JFrame implements ActionListener{

    // Creating a button
    JButton textbox;
    
    // Constructor
    public Level1(){

        textbox = new JButton();
        // Setting button dimensions
        textbox.setBounds(0, 500, 20, 10);
        textbox.addActionListener(e -> System.out.println("click"));
        
        // Background image
        ImageIcon questionmarkbackground = new ImageIcon("Frame1-1.png");
        ImageIcon textboxthingy = new ImageIcon("textbox.png"); 

        // Creating a JLabel for background image
        JLabel bgimg = new JLabel();
        JLabel textbox = new JLabel(); 
        bgimg.setIcon(questionmarkbackground);
        textbox.setIcon(textboxthingy); 

        // Creating and setting up the main frame
        JFrame scene1 = new JFrame();
        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene1.setSize(800, 600);
        scene1.setVisible(true);
        scene1.setResizable(false);
        scene1.add(bgimg);
        scene1.add(textbox); 
        scene1.repaint();
        //scene1.add(textbox);
    }

    // This method is triggered when a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) { 
    
    }


}
