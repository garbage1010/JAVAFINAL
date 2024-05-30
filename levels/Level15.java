import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Level15 extends JFrame implements ActionListener {

    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Frame3-1redo.PNG");
    Image Sprite = Toolkit.getDefaultToolkit().getImage("levels\\images\\15\\Sprite.PNG");

    
    JLabel bg = new JLabel();
    
    
    public Level15(){
        bg.setIcon(new ImageIcon(frame1));
        bg.setBounds(0,0,430,564);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 564);
        setLayout(null);
        setVisible(true);
        setResizable(false);
        add(bg);
    }
    
    public static void main(String[]args){
        new Level15();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}