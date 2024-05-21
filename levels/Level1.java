/*
 * "This creates the class for the first level of the game"
 */


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

public class Level1 extends JFrame implements ActionListener {

    int framecounter = 1;
    int textcounter = 1;
    // Creating a button
<<<<<<< Updated upstream
    private TextFileReader reader;

=======
    TextFileReader reader =new TextFileReader("levels\\images\\lv1dialogue.txt", 0, 600, 800, 200);
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\Frame1-1.PNG"); 
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\Frame1-2.PNG");
    JLabel bg = new JLabel(); //Label to be used as background
>>>>>>> Stashed changes
    // Constructor
    public Level1() {
        // Initialize the TextFileReader
        reader = new TextFileReader("levels\\images\\lv1dialogue.txt", 0, 600, 800, 200);

<<<<<<< Updated upstream
        // Setting frame properties
        setTitle("Level 1");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // Creating and setting a background image
        ImageIcon questionmarkbackground = new ImageIcon("levels\\images\\Frame1-1.PNG");
        JLabel bgimg = new JLabel();
        bgimg.setIcon(questionmarkbackground);
        bgimg.setBounds(0, 0, 800, 800);
=======
        // Creating a JLabel for background image
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));
>>>>>>> Stashed changes

        // Creating the textbox button
        ImageIcon textboxthingy = new ImageIcon("textbox.png");
        JButton textbox = new JButton();
        textbox.setIcon(textboxthingy);
        textbox.setBounds(0, 500, 200, 100);
        textbox.addActionListener(e -> System.out.println("click"));

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
    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events if needed
    }

    public static void main(String[] args) { 
        // example usage 
        new Level1();
    }
}
