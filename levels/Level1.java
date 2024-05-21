/*
 * "This creates the class for the first level of the game"
 */

<<<<<<< HEAD

<<<<<<< Updated upstream
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
=======
// Importing necessary libraries
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
>>>>>>> Stashed changes
=======
// Importing necessary libraries
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.awt.event.ActionEvent;
>>>>>>> parent of d9b6966 (Update Level1.java)


// Class definition
public class Level1 extends JFrame implements ActionListener{

    int framecounter = 1;
    int textcounter = 1;
    // Creating a button
<<<<<<< HEAD
<<<<<<< Updated upstream
    private TextFileReader reader;

=======
    TextFileReader reader =new TextFileReader("levels\\images\\lv1dialogue.txt", 0, 600, 800, 200);
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\Frame1-1.PNG"); 
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\Frame1-2.PNG");
    JLabel bg = new JLabel(); //Label to be used as background
>>>>>>> Stashed changes
=======
    TextFileReader reader =new TextFileReader("levels\\images\\lv1dialogue.txt", 0, 600, 800, 200);
    
>>>>>>> parent of d9b6966 (Update Level1.java)
    // Constructor
    public Level1(){

<<<<<<< HEAD
<<<<<<< Updated upstream
        // Setting frame properties
        setTitle("Level 1");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Creating and setting a background image
=======
         // Background image
>>>>>>> parent of d9b6966 (Update Level1.java)
        ImageIcon questionmarkbackground = new ImageIcon("levels\\images\\Frame1-1.PNG");
        ImageIcon textboxthingy = new ImageIcon("textbox.png"); 




        // Creating a JLabel for background image
        JLabel bgimg = new JLabel();
        bgimg.setIcon(questionmarkbackground);
<<<<<<< HEAD
        bgimg.setBounds(0, 0, 800, 800);
=======
        // Creating a JLabel for background image
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));
>>>>>>> Stashed changes
=======
>>>>>>> parent of d9b6966 (Update Level1.java)


<<<<<<< HEAD
<<<<<<< Updated upstream
        // Adding components to the frame
        add(bgimg);
        add(reader.getButton());
        add(textbox);

        // Ensuring background image is on the bottom layer
        getContentPane().setComponentZOrder(bgimg, getContentPane().getComponentCount() - 1);

        setVisible(true);
    }

=======
        // Creating and setting up the main frame
        JFrame scene1 = new JFrame();
        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene1.setSize(800, 800);
        scene1.setLayout(null);
        scene1.setVisible(true);
        scene1.setResizable(false);
        scene1.add(bg);
        scene1.add(reader.getButton());

        //scene1.add(textbox);
    }
    private void startPolling() {
        Timer timer = new Timer(1000, e -> {
            try {
                int currentValue = reader.currentIndex;
                if (currentValue != lastValue) {
                    lastValue = currentValue;
                    label.setText("Current Value: " + currentValue);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        timer.start();
    }
    // This method is triggered when a button is pressed
>>>>>>> Stashed changes
=======
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
>>>>>>> parent of d9b6966 (Update Level1.java)
    @Override
    public void actionPerformed(ActionEvent e) { 
    
    }
}
