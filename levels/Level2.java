/*
 * Level 2
 */
package levels;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class Level2 extends JFrame implements ActionListener{

    int framecounter = 1; //what frame are we on
    
    //background image 
    //I have no idea how to access the subfolder images so forgive me but I have to leave it this way for now. I'll change it when I figure it out
    Image frame1 = Toolkit.getDefaultToolkit().getImage("C:/Users/rory5/OneDrive/Documents/GitHub/JAVAFINAL/levels/images/Frame2-1.PNG"); 
    
    JLabel bg = new JLabel();
    JButton text = new JButton();

    public Level2(){

        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));

        //create button
        text.setText("PlaceHolder");
        text.setFocusable(false);
        text.setBounds(0,600,800,200);


        
        //create scene
        JFrame scene = new JFrame();
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setSize(800, 800);
        scene.setLayout(null);
        scene.setVisible(true);
        scene.setResizable(false);
        scene.add(bg);
        scene.add(text);

        

    }
 }