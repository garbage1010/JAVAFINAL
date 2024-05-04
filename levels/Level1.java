
/*
 * "This creates the class for the first level of the game"
 */
package levels;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.OverlayLayout;

public class Level1 extends JFrame{
    Level1(){
        //background image
        ImageIcon questionmarkbackground = new ImageIcon("/images/Frame1-1.PNG");
        JLabel bgimg = new JLabel();
        bgimg.setIcon(questionmarkbackground);
        bgimg.setVerticalAlignment(JLabel.CENTER);
        bgimg.setHorizontalAlignment(JLabel.CENTER);

        //panel
        JPanel redPanel = new JPanel();
        redPanel.setBounds(0, 0, 200, 20);
        redPanel.setBackground(Color.RED);
        
        //objective
        JLabel objective = new JLabel();
        objective.setText("Placeholder!!");
        objective.setFont(new Font("Comic Sans", Font.BOLD, 10));
        objective.setVerticalAlignment(JLabel.TOP);
        objective.setBounds(0, 0, 100, 10);
        
        //frame
        JFrame scene1 = new JFrame();
        scene1.setTitle("Pre-Calc Panic: Integration by Parts");
        //scene1.setLayout(new OverlayLayout());
        scene1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene1.setResizable(false);
        scene1.setSize(800, 600);
        scene1.setVisible(true);
        //scene1.add(redPanel);
        scene1.add(bgimg);
       
    }
}
