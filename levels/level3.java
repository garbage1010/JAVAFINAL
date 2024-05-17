package levels;

// Importing necessary libraries
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Level3 extends JFrame implements ActionListener {
	
    int framecounter = 1; 
	
    Image frame1 = Toolkit.getDefaultToolkit().getImage("placeholder"); 
    Image frame2 = Toolkit.getDefaultToolkit().getImage("placeholder");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("placeholder"); 
    Image frame4 = Toolkit.getDefaultToolkit().getImage("placeholder"); 
    Image frame5 = Toolkit.getDefaultToolkit().getImage("placeholder");
    Image frame6 = Toolkit.getDefaultToolkit().getImage("placeholder"); 
    
    JLabel bg = new JLabel(); //Label to be used as background
    JFrame scene = new JFrame();// main frame
	
	public Level3(){

        //Set background to frame size and set original icon
        bg.setBounds(0, 0, 800, 600);
        
        //create scene
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setSize(800, 800);
        scene.setLayout(null);
        scene.setVisible(true);
        scene.setResizable(false);
        scene.add(bg);
        
        switch (framecounter) { 
			
			case 1: 
				bg.setIcon(new ImageIcon(frame1));
				break; 
			case 2: 
				bg.setIcon(new ImageIcon(frame2)); 
				break; 
			case 3: 
				bg.setIcon(new ImageIcon(frame3)); 
			case 4: 
				bg.setIcon(new ImageIcon(frame4)); 
				new TimingMiniGame(); 
			case 5: 
				bg.setIcon(new ImageIcon(frame5)); 
			case 6: 
				bg.setIcon(new ImageIcon(frame6)); 
			} 
		} 
	
	 public void actionPerformed(ActionEvent e) { 
		 framecounter++; 
    }
	
}
