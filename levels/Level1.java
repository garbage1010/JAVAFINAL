/*
 * "This creates the class for the first level of the game"
 */


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


// Class definition
public class Level1 extends JFrame implements ActionListener{

    int framecounter = 1;
    int textcounter = 1;
    // Creating a button
    TextFileReader reader =new TextFileReader("levels\\images\\lv1dialogue.txt", 0, 600, 800, 200);
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\Frame1-1.PNG"); 
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\Frame1-2.PNG");
    JLabel bg = new JLabel(); //Label to be used as background
    // Constructor
    public Level1(){

        // Creating a JLabel for background image
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));


        // Creating and setting up the main frame
        JFrame scene1 = new JFrame();
        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene1.setSize(800, 800);
        scene1.setLayout(null);
        scene1.setVisible(true);
        scene1.setResizable(false);
        scene1.add(bg);
        scene1.add(reader.getButton());
        startPolling();

        //scene1.add(textbox);
    }
    private void startPolling() {
        Timer timer = new Timer(500, e -> {
            try {
                int currentValue = reader.currentIndex;
                switch(currentValue){
                    case 4:
                        bg.setIcon(new ImageIcon(frame2));
                        reader.setProgress(false);
                    default:
                        System.out.println("uh");

                }
                
            } catch (Error er) {
                System.out.println(er);
            }
        });
        timer.start();
    }
    // This method is triggered when a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) { 
    
    }
}