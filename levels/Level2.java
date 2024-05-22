/*
 * Level 2 - 5635290595
 */


import javax.swing.ImageIcon;
import javax.swing.JButton; 
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

public class Level2 extends JFrame implements ActionListener{

    int framecounter = 1; //what frame are we on
    String key = "1011110110111101100000011111110111111101";
    
    Timer timer;

    TextFileReader reader = new TextFileReader("levels\\images\\texts\\lv2dialogue.txt", 0, 600, 800, 200);

    
    //background image 
    Image frame1 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame4-1.PNG"); 
    Image frame2 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame4-2.PNG");
    Image frame3 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame4-3.PNG");
    Image frame4 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame4-4.PNG");
    Image frame5 = Toolkit.getDefaultToolkit().getImage("levels\\images\\2\\Frame5-2.PNG");

    JLabel bg = new JLabel(); //Label to be used as background
    JButton cipher; //cipher on first frame in the shelf
    JFrame scene = new JFrame();// main frame
    JTextField textfield = new JTextField();
    JButton submit = new JButton("Submit");

    public Level2(){

        //Set background to frame size and set original icon
        bg.setBounds(0, 0, 800, 600);
        bg.setIcon(new ImageIcon(frame1));

        //create button for cipher
        cipher = new JButton();
        cipher.setFocusable(false);
        cipher.setBounds(425, 375, 100, 100);
        cipher.setOpaque(false);



        //create scene
        scene.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        scene.setSize(800, 800);
        scene.setLayout(null);
        scene.setVisible(true);
        scene.setResizable(false);
        scene.add(reader.getButton());
        scene.add(bg);
        scene.add(cipher);
        startPolling();

    }
    private void startPolling() {
        timer = new Timer(500, e -> {
            try {
                int currentIndex = reader.currentIndex;
                switch (currentIndex) {
                    case 2:
                        timer.stop();
                        reader.setProgress(false);
                        cipher.addActionListener(l -> {            
                                bg.setIcon(new ImageIcon(frame2)); //change background image
                                scene.remove(cipher);
                                scene.repaint();
                                textfield.setBounds(400, 400, 350, 200);
                                submit.setBounds(300, 400, 100, 25);
                                submit.addActionListener(p -> {
                                    String uh = textfield.getText();
                                    if(uh.contains(key)){
                                        System.out.println(key);
                                        reader.setProgress(true);
                                        reader.currentIndex++;
                                        reader.updateLabel();
                                        scene.remove(submit);
                                        scene.remove(textfield);
                                        scene.repaint();
                                        timer.start();
                                    }
                                });
                                scene.add(submit);
                                scene.add(textfield);
                        });
                        break;
                    case 4:
                        bg.setIcon(new ImageIcon(frame3));
                        break;
                    case 5:
                        timer.stop();
                        reader.setProgress(false);
                        bg.setIcon(new ImageIcon(frame4));
                        JButton window = new JButton();
                        window.setBounds(0,0,100,100);
                        window.addActionListener(o ->
                        {
                            reader.setProgress(true);
                            reader.currentIndex++;
                            reader.updateLabel();
                            scene.remove(window);
                            scene.repaint();
                            timer.start();
                        });
                        scene.add(window);
                    case 6:
                        bg.setIcon(new ImageIcon(frame5));
                    default:
                        break;
                        
                }
            } 
            catch (Error er) {
                System.out.println(er);
            }
        });
        timer.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) { 
    }
}