import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Lab8BLUE2 {
   public static void main(String[] args)
   {
      JFrame frame = new JFrame("GUI with BorderLayout");
      frame.setSize(600, 430);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new GUIPanel());
      frame.setVisible(true);
   }
}