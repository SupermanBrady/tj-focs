import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SubpanelGUIDemo
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("GUI with BorderLayout");
      frame.setSize(400, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new SubpanelGUIPanel());
      frame.setVisible(true);
   }
}

class SubpanelGUIPanel extends JPanel
{
   JLabel number;  
   JTextField userIn;  //One new field, also because an action listener will need to access it.
   int num;
   
   public SubpanelGUIPanel()
   {
      setLayout(new BorderLayout());
      
      //At first this is the same as the BorderGUIDemo.
      JLabel title = new JLabel("SubPanel demonstration!");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
      
      JLabel bottom = new JLabel("Click any button; watch what happens!");
      bottom.setFont(new Font("Serif", Font.BOLD, 12));
      bottom.setHorizontalAlignment(SwingConstants.CENTER);
      add(bottom, BorderLayout.SOUTH);
      
      num = 0;
      number = new JLabel("" + num);
      number.setFont(new Font("Serif", Font.BOLD, 80));
      number.setHorizontalAlignment(SwingConstants.CENTER);
      add(number);
      
      //But: now I want TWO buttons in the west region.  So: let's make a subpanel - a grid layout to hold two buttons.
      JPanel westSubpanel = new JPanel();
      westSubpanel.setLayout(new GridLayout(2, 1));
      JButton addOne = new JButton("Add 1");
      addOne.addActionListener(new AddOneListener());
      westSubpanel.add(addOne);  //Add the button TO THE SUBPANEL
      JButton addFive = new JButton("Add 5");
      addFive.addActionListener(new AddFiveListener());
      westSubpanel.add(addFive);  //Add the button TO THE SUBPANEL
      add(westSubpanel, BorderLayout.WEST);  //Add the SUBPANEL to the PANEL
      
      //In the east, I want a text field where the user can type and two buttons.
      //One will allow the user to set the current value, the other will add whatever they type.
      //Note again that since we'll need to refer to the text field inside action listeners,
      //every other element is newly DECLARED but we only REFERENCE the field userIn.
      //It does NOT say "JTextField userIn" below; we already declared that field.
      JPanel eastSubpanel = new JPanel();
      eastSubpanel.setLayout(new GridLayout(3, 1));  //Note the 3 this time, to fit 3 GUI elements
      userIn = new JTextField("0", 10);  //Text field will begin displaying the String "0" and be 10 characters wide
      userIn.setHorizontalAlignment(SwingConstants.CENTER);  //Put the text centered in the text field
      eastSubpanel.add(userIn);
      JButton resetValue = new JButton("Reset value");
      resetValue.addActionListener(new ResetValueListener());
      eastSubpanel.add(resetValue);
      JButton addValue = new JButton("Add value");
      addValue.addActionListener(new AddValueListener());
      eastSubpanel.add(addValue);
      add(eastSubpanel, BorderLayout.EAST);
   }
   
   
   //ActionListener for the add 1 button.
   private class AddOneListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
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
   
   //ActionListener for the Reset Value button
   private class ResetValueListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int newVal = Integer.parseInt(userIn.getText());  //Works because userIn is a field!
         num = newVal;
         number.setText("" + num);
      }
   }
   
   //ActionListener for the Add Value button
   private class AddValueListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         int newVal = Integer.parseInt(userIn.getText());
         num += newVal;
         number.setText("" + num);
      }
   }
}