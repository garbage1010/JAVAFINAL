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
import java.io.FileReader;
import java.awt.event.ActionEvent;


// Class definition
public class Level1 extends JFrame implements ActionListener{

    // Creating a button
    TextFileReader reader =new TextFileReader("levels\\images\\lv1dialogue.txt", 0, 600, 800, 200);
    
    // Constructor
    public Level1(){

         // Background image
        ImageIcon questionmarkbackground = new ImageIcon("levels\\images\\Frame1-1.PNG");
        ImageIcon textboxthingy = new ImageIcon("textbox.png"); 




        // Creating a JLabel for background image
        JLabel bgimg = new JLabel();
        bgimg.setIcon(questionmarkbackground);


        // Creating and setting up the main frame
        JFrame scene1 = new JFrame();
        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene1.setSize(800, 800);
        scene1.setVisible(true);
        scene1.setResizable(false);
        scene1.add(bgimg);
        scene1.add(reader.getButton());
        //scene1.add(textbox);
    }

    // This method is triggered when a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) { 
    
    }
}
