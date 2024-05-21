
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame implements ActionListener{
    
    JButton start; // Button for starting the game
    JButton load; // Button for loading the game

    public StartMenu(){
        
        //Start Game Button
        start = new JButton(); // Initializing start button
        start.setBounds(150, 250, 500, 50); // Setting position and size
        start.setText("Start Game"); // Setting text
        start.setFocusable(false); // Making it non-focusable
        start.addActionListener(e -> System.out.println("START GAME!!")); // Adding action listener to print a message when clicked

        //Load Game Button
        load = new JButton(); // Initializing load button
        load.setBounds(150, 325, 500, 50); // Setting position and size
        load.setText("Load Game"); // Setting text
        load.setFocusable(false); // Making it non-focusable
        load.addActionListener(e -> System.out.println("LOAD GAME!!!")); // Adding action listener to print a message when clicked


        //Create Frame
        JFrame menu = new JFrame(); // Initializing frame
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
        menu.setLayout(null); // Setting layout to null
        menu.setSize(800, 600); // Setting size
        menu.setVisible(true); // Making it visible
        menu.setResizable(false); // Making it non-resizable
        menu.setTitle("Game Name!! I forgot what it was called!!"); // Setting title
        menu.getContentPane().setBackground(new Color(220, 220, 255)); // Setting background color
        menu.add(start); // Adding start button to the frame
        menu.add(load); // Adding load button to the frame


    }
    @Override
    public void actionPerformed(ActionEvent e) { 
        if(e.getSource()==load){
            
        }
    
    }
}