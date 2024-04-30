import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;

public class PanelTest
{
   public static void main(String[]args)
   {
      JPanel redPanel = new JPanel();
      redPanel.setBounds(0, 0, 250, 250);
      redPanel.setBackground(Color.RED);
      
      JLabel label = new JLabel();
      label.setText("TEXT!!!");
      label.setFont(new Font("Gadugi", Font.PLAIN, 20));
      
      JFrame frame = new JFrame();
      frame.setSize(600, 600);
      frame.setVisible(true);
      //frame.add(redPanel);
      frame.add(label);
      

   }

}
