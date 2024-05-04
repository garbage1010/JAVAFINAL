
/*
 * "This creates the class for the first level of the game"
 */
package levels;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.*;

import javax.swing.ImageIcon;

public class Level1 extends JFrame{
    Level1(){
        //background image
        ImageIcon questionmarkbackground = new ImageIcon("textbox.png");

        //background made using jlabel
        JLabel bgimg = new JLabel();
        bgimg.setIcon(questionmarkbackground);

        JFrame scene1 = new JFrame();
        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene1.setSize(800, 600);
        scene1.setVisible(true);
        scene1.add(bgimg);

    }
}
