/*
 * Level 2 - 5635290595
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
    Image frame1 = Toolkit.getDefaultToolkit().getImage("C:/Users/rory5/OneDrive/Documents/GitHub/JAVAFINAL/levels/images/Frame4-1.PNG"); 
    Image frame2 = Toolkit.getDefaultToolkit().getImage("C:/Users/rory5/OneDrive/Documents/GitHub/JAVAFINAL/levels/images/Frame4-2.PNG");

    JLabel bg = new JLabel(); //Label to be used as background
    JButton cipher; //cipher on first frame in the shelf
    JFrame scene = new JFrame();// main frame

    public Level2(){

        //Set background to frame size and set original icon
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));

        //create button for cipher
        cipher = new JButton();
        cipher.setFocusable(false);
        cipher.setBounds(425, 375, 100, 100);
        cipher.addActionListener(e -> {            
        if(framecounter==1){
            bg.setIcon(new ImageIcon(frame2)); //change background image
            scene.remove(cipher);
            scene.repaint();
            System.out.println("click");
            ++framecounter; //change frame count
            }
        });
        //cipher.setOpaque(false);


        //create scene
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setSize(800, 800);
        scene.setLayout(null);
        scene.setVisible(true);
        scene.setResizable(false);
        scene.add(bg);
        scene.add(cipher);

    }
    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==cipher){
            //what happens on first button press
            System.out.println("click");
            if(framecounter==1){
                bg.setIcon(new ImageIcon(frame2)); //change background image
                scene.remove(cipher);
                scene.repaint();
                System.out.println("click");
                ++framecounter; //change frame count
            }
        }
    }
 }