import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GridGUIDemo
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("GUI with GridLayout");
      frame.setSize(400, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new GridGUIPanel());
      frame.setVisible(true);
   }
}

class GridGUIPanel extends JPanel
{
   JLabel number;
   int num;
   
   public GridGUIPanel()
   {
      //This is basically the same as the previous demo; only differences are commented.
      
      setLayout(new GridLayout(2, 3));  //Rows then columns
      
      JLabel title = new JLabel("GridLayout demonstration!");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title);  //You don't specify where to add a GUI element in this layout!  
                   //GridLayout adds across each row, one by one, so this is in the top left...
      
      num = 0;
      number = new JLabel("" + num);
      number.setFont(new Font("Serif", Font.BOLD, 80));
      number.setHorizontalAlignment(SwingConstants.CENTER);
      add(number);  //And this is top center...
      
      JLabel right = new JLabel("Click either button; watch what happens!");
      right.setFont(new Font("Serif", Font.BOLD, 12));
      right.setHorizontalAlignment(SwingConstants.CENTER);
      add(right);  //And this is top right...
      
      JButton addOne = new JButton("Add 1");
      addOne.addActionListener(new AddOneListener());
      add(addOne);  //And then the top row is filled, so this starts the next row...
      
      add(new JLabel(""));  //Use an empty label to fill the bottom center space...
      
      JButton addFive = new JButton("Add 5");
      addFive.addActionListener(new AddFiveListener());
      add(addFive);  //And this completes the layout.  Always add exactly the right 
                     //number of items to complete your grid layout!
   }
   
   //The listeners below are the same as the BorderPanel demo!
   private class AddOneListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         num += 1;
         number.setText("" + num);
      }
   }
   
   private class AddFiveListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         num += 5;
         number.setText("" + num);
      }
   }
}