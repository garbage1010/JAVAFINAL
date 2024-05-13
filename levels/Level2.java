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
    Image frame2 = Toolkit.getDefaultToolkit().getImage("path");

    JLabel bg = new JLabel(); //Label to be used as background
    JButton text = new JButton(); //textbox
    JButton cipher = new JButton(); //cipher on first frame in the shelf
    JFrame scene = new JFrame();// main frame

    public Level2(){

        //Set background to frame size and set original icon
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));

        //create button for text box
        text.setText("PlaceHolder");
        text.setFocusable(false);
        text.setBounds(0,600,800,200);

        //create button for cipher
        cipher.setFocusable(false);
        cipher.setBounds(425, 375, 100, 100);
        //cipher.setOpaque(false);


        
        //create scene
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setSize(800, 800);
        scene.setLayout(null);
        scene.setVisible(true);
        scene.setResizable(false);
        scene.add(bg);
        scene.add(text);
        scene.add(cipher);

    }
    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==cipher){
            //what happens on first button press
            if(framecounter==1){
                bg.setIcon(new ImageIcon(frame2)); //change background image
                scene.remove(cipher);
                scene.repaint();
                ++framecounter; //change frame count
            }

        }
    
    }
 }