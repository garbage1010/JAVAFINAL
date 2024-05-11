/*
 * Level 2
 */
package levels;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Level2 extends JFrame implements ActionListener{
    
    //background image 
    ImageIcon bgimg = new ImageIcon("images/Frame1-2.PNG");
    JLabel bg = new JLabel();

    public Level2(){

        bg.setIcon(bgimg);
        bg.setBounds(0, 0, 800, 600);
        
        //create scene
        JFrame scene = new JFrame();
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setSize(800, 600);
        scene.setLayout(null);
        scene.setVisible(true);
        scene.setResizable(false);
        scene.add(bg);
        

    }
 }