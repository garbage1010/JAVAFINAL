/*
 * "This creates the class for the first level of the game"
 */
package levels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Level1 extends JFrame implements ActionListener {

    // Creating a button
    private TextFileReader reader;

    // Constructor
    public Level1() {
        // Initialize the TextFileReader
        reader = new TextFileReader("levels\\images\\lv1dialogue.txt", 0, 600, 800, 200);

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

        // Creating the textbox button
        ImageIcon textboxthingy = new ImageIcon("textbox.png");
        JButton textbox = new JButton();
        textbox.setIcon(textboxthingy);
        textbox.setBounds(0, 500, 200, 100);
        textbox.addActionListener(e -> System.out.println("click"));

        // Adding components to the frame
        add(bgimg);
        add(reader.getButton());
        add(textbox);

        // Ensuring background image is on the bottom layer
        getContentPane().setComponentZOrder(bgimg, getContentPane().getComponentCount() - 1);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Handle action events if needed
    }

    public static void main(String[] args) { 
        // example usage 
        new Level1();
    }
}
