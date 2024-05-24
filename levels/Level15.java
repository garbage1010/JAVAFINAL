import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Level15 extends JFrame implements ActionListener {
    
    public Level15(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLayout(null);
        setVisible(true);
        setResizable(false);
    }
    
    public static void main(String[]args){
        new Level15();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

}