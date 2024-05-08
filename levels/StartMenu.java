package levels;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame implements ActionListener{
    
    JButton start;
    JButton load;

    public StartMenu(){
        
        //Start Game Button
        start = new JButton();
        start.setBounds(5, 10, 10, 10);
        start.addActionListener(e -> System.out.println("START GAME!!"));

        //Load Game Button
        load = new JButton();
        load.setBounds(10, 20, 10, 10);
        load.addActionListener(e -> System.out.println("LOAD GAME!!!"));


        //Create Frame
        JFrame menu = new JFrame();
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setSize(800, 600);
        menu.setVisible(true);
        menu.setResizable(false);
        menu.add(start);
        menu.add(load);


    }
    @Override
    public void actionPerformed(ActionEvent e) { 
    
    }
}