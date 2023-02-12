import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Lab8GREEN2
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("Lab 8-GREEN-02!");
      frame.setSize(400, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new green2Panel());
      frame.setVisible(true);
   }
}

class green2Panel extends JPanel
{
   JLabel number;  
   JTextField userIn;  //One new field, also because an action listener will need to access it.
   JTextField userIn2;
   double num;
   
   public green2Panel()
   {
      setLayout(new BorderLayout());
      
      //north
      JLabel title = new JLabel("Lab 8-GREEN-02!");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
      
      //center
      num = 0;
      number = new JLabel("" + num);
      number.setFont(new Font("Serif", Font.BOLD, 80));
      number.setHorizontalAlignment(SwingConstants.CENTER);
      add(number);
      
      //west
      JPanel westSubpanel = new JPanel();
      westSubpanel.setLayout(new GridLayout(2, 1));
      
      JLabel enter = new JLabel("Enter a number:");
      enter.setFont(new Font("Serif", Font.BOLD, 20));
      enter.setVerticalAlignment(SwingConstants.BOTTOM);
      
      westSubpanel.add(enter);
            
      userIn = new JTextField("0", 10);  
      userIn.setHorizontalAlignment(SwingConstants.CENTER); 
      westSubpanel.add(userIn);
      add(westSubpanel, BorderLayout.WEST);
   
      //east
      
      JPanel eastSubpanel = new JPanel();
      eastSubpanel.setLayout(new GridLayout(2, 1));
      
      JLabel enter2 = new JLabel("Enter a number:");
      enter2.setFont(new Font("Serif", Font.BOLD, 20));
      enter2.setVerticalAlignment(SwingConstants.BOTTOM);
      
      eastSubpanel.add(enter2);
      
      userIn2 = new JTextField("0", 10);  
      userIn2.setHorizontalAlignment(SwingConstants.CENTER); 
      eastSubpanel.add(userIn2);
      add(eastSubpanel, BorderLayout.EAST);
      
      //south
      JPanel southSubpanel = new JPanel();
      southSubpanel.setLayout(new GridLayout(1, 4));
      
      JButton addValue = new JButton("Add");
      addValue.addActionListener(new AddValueListener());
      southSubpanel.add(addValue);
      
      JButton subtractValue = new JButton("Subtract");
      subtractValue.addActionListener(new SubtractValueListener());
      southSubpanel.add(subtractValue);
      
      JButton multiplyValue = new JButton("Multiply");
      multiplyValue.addActionListener(new MultiplyValueListener());
      southSubpanel.add(multiplyValue);
      
      JButton divideValue = new JButton("Divide");
      divideValue.addActionListener(new DivideValueListener());
      southSubpanel.add(divideValue);
      
      add(southSubpanel, BorderLayout.SOUTH);
   }
   
   //ActionListener for the Add Value button
   private class AddValueListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double newVal = Double.parseDouble(userIn.getText());
         double newVal2 = Double.parseDouble(userIn2.getText());
         num = newVal + newVal2;
         number.setText("" + num);
      }
   }
   
      private class SubtractValueListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double newVal = Double.parseDouble(userIn.getText());
         double newVal2 = Double.parseDouble(userIn2.getText());
         num = newVal - newVal2;
         number.setText("" + num);
      }
   }
   
      private class MultiplyValueListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double newVal = Double.parseDouble(userIn.getText());
         double newVal2 = Double.parseDouble(userIn2.getText());
         num = newVal * newVal2;
         number.setText("" + num);
      }
   }
   
      private class DivideValueListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         double newVal = Double.parseDouble(userIn.getText());
         double newVal2 = Double.parseDouble(userIn2.getText());
         num = newVal / newVal2;
         number.setText("" + num);
      }
   }
}