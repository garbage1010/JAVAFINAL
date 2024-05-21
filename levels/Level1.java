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

    Timer timer;

    // Creating a button
    TextFileReader reader =new TextFileReader("levels\\images\\texts\\lv1dialogue.txt", 0, 600, 800, 200);

    //images used
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-1.PNG"); 
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-2-1.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\1\\Frame1-2-2.PNG");

    JLabel bg = new JLabel(); //Label to be used as background

    JButton errorbutton = new JButton();

    JFrame scene1 = new JFrame();
    // Constructor
    public Level1(){

        errorbutton.setOpaque(false);

        // Creating a JLabel for background image
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));


        // Creating and setting up the main frame

        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene1.setSize(800, 800);
        scene1.setLayout(null);
        scene1.setVisible(true);
        scene1.setResizable(false);
        scene1.add(bg);
        scene1.add(reader.getButton());
        startPolling(); //starts update checking

        //scene1.add(textbox);
    }
    private void startPolling() {
        timer = new Timer(500, e -> {
            try {
                int currentValue = reader.currentIndex;
                switch(currentValue){
                    case 4:
                        timer.stop();
                        reader.setProgress(false);
                        bg.setIcon(new ImageIcon(frame2));
                        scene1.add(errorbutton);
                        errorbutton.setBounds(385, 240, 30, 30);
                        errorbutton.addActionListener(l -> {
                            reader.setProgress(true);
                            reader.currentIndex++;
                            reader.updateLabel();
                            scene1.remove(errorbutton);
                            timer.start();
                        });
                    case 5:
                        timer.stop();
                        reader.setProgress(false);
                        bg.setIcon(new ImageIcon(frame3));
                        scene1.add(errorbutton);
                        errorbutton.setBounds();
                        errorbutton.addActionListener(l -> {
                            reader.setProgress(true);
                            reader.currentIndex++;
                            reader.updateLabel();
                            scene1.remove(errorbutton);
                            timer.start();
                        });
                    default:
                        System.out.println(reader.currentIndex);

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