import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BorderGUIDemo
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("GUI with BorderLayout");
      frame.setSize(400, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new BorderGUIPanel());
      frame.setVisible(true);
   }
}

class BorderGUIPanel extends JPanel
{
   JLabel number;  //These are fields so that the action listeners can access them.
   int num;
   
   public BorderGUIPanel()
   {
      setLayout(new BorderLayout());
      
      //Create a title and add it to the north region of the BorderLayout.
      //This is not a field because it never needs to be modified.
      JLabel title = new JLabel("BorderLayout demonstration!");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
      
      //Create instructions and add to the south region of the BorderLayout.
      JLabel bottom = new JLabel("Click either button; watch what happens!");
      bottom.setFont(new Font("Serif", Font.BOLD, 12));
      bottom.setHorizontalAlignment(SwingConstants.CENTER);
      add(bottom, BorderLayout.SOUTH);
      
      //Initialize fields storing a number and a JLabel that we'll edit in the future.
      //NOTE THAT "num" AND "number" ARE ONLY ACCESSED, NOT DECLARED!
      //If you have a field, re-declaring that field (ie, writing "JLabel number" again)
      //makes a new local reference with the same name, IGNORING your field.
      num = 0;
      number = new JLabel("" + num);
      number.setFont(new Font("Serif", Font.BOLD, 80));
      number.setHorizontalAlignment(SwingConstants.CENTER);
      add(number);  //Automatically adds to the center region if no second arg is given.
      
      //Create a button that will add 1 to "num" and refresh the central JLabel.
      //Add to the west region of the BorderLayout.
      JButton addOne = new JButton("Add 1");
      addOne.addActionListener(new AddOneListener());
      add(addOne, BorderLayout.WEST);
      
      //Create a button that adds 5 to "num" and refreshes the central JLabel.
      //Add to the east region of the BorderLayout.
      JButton addFive = new JButton("Add 5");
      addFive.addActionListener(new AddFiveListener());
      add(addFive, BorderLayout.EAST);
   }
   
   //ActionListener for the add 1 button.
   //Note ActionListener is an interface!  We must implement "public void actionPerformed(ActionEvent e)".
   private class AddOneListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         //These two lines of code work because "num" and "number" are fields.
         num += 1;
         number.setText("" + num);
      }
   }
   
   //ActionListener for the add 5 button.
   private class AddFiveListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         num += 5;
         number.setText("" + num);
      }
   }
}