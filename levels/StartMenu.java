import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartMenu extends JFrame implements ActionListener {
    
    JButton start; // Button for starting the game
    JButton load; // Button for loading the game
    JPanel blackOverlay; // Panel for the black overlay
    float opacity = 1.0f; // Initial opacity

    public StartMenu() {
        
        // Start Game Button
        start = new JButton(); // Initializing start button
        start.setBounds(150, 250, 500, 50); // Setting position and size
        start.setText("Start Game"); // Setting text
        start.setFocusable(false); // Making it non-focusable
        start.addActionListener(e -> {
            PreCalcPanic.increment();
            SaveThat.saveLevel(0);
            System.exit(0);
        }); // Adding action listener to print a message when clicked

        // Load Game Button
        load = new JButton(); // Initializing load button
        load.setBounds(150, 325, 500, 50); // Setting position and size
        load.setText("Load Game"); // Setting text
        load.setFocusable(false); // Making it non-focusable
        load.addActionListener(r ->{
            PreCalcPanic.currentLevel = LoadThat.loadLevel();
            System.out.println("Game loaded."); 
        }); 
    
        // Create Frame
        JFrame menu = new JFrame(); // Initializing frame
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Setting default close operation
        menu.setLayout(null); // Setting layout to null
        menu.setSize(800, 600); // Setting size
        menu.setVisible(true); // Making it visible
        menu.setResizable(false); // Making it non-resizable
        menu.setTitle("Pre-Calc Panic: Integration By Parts"); // Setting title
        menu.getContentPane().setBackground(new Color(220, 220, 255)); // Setting background color
        menu.add(start); // Adding start button to the frame
        menu.add(load); // Adding load button to the frame
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {
        new StartMenu(); // Create an instance of StartMenu
    }
}
