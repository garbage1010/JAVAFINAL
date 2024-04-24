/*
 * "This creates the class for the first level of the game"
 */

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Level1 extends JFrame{
    Level1(){
        JFrame scene1 = new JFrame();
        scene1.setTitle("Pre-Calc Panic: Integration by Parts");
        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene1.setResizable(false);
        scene1.setSize(960, 540);
        scene1.setVisible(true);
        
        //objective
        JLabel objective = new JLabel();
        objective.setText("Placeholder!!");
        objective.setVerticalAlignment(JLabel.TOP);
    }
}