import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

class GUIPanel extends JPanel 
{
   JTextField r;
   JTextField g;
   JTextField b;
   JTextField h;
   JTextField w;
   TrianglePanel gfx;

   public GUIPanel()
   {
      setLayout(new BorderLayout());
   
      //north
      JLabel title = new JLabel("The moving triangle!");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
      
      //west
      JPanel subpanel = new JPanel();
      subpanel.setLayout(new GridLayout(5, 2));
      
      JLabel redLabel = new JLabel("Red: ");
      redLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      subpanel.add(redLabel);
      r = new JTextField("0", 10);
      r.setHorizontalAlignment(SwingConstants.CENTER);
      subpanel.add(r);
      
      JLabel greenLabel = new JLabel("Green: ");
      greenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      subpanel.add(greenLabel);
      g = new JTextField("0", 10);
      g.setHorizontalAlignment(SwingConstants.CENTER);
      subpanel.add(g);
   
      
      JLabel blueLabel = new JLabel("Blue: ");
      blueLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      subpanel.add(blueLabel);
      b = new JTextField("0", 10);
      b.setHorizontalAlignment(SwingConstants.CENTER);
      subpanel.add(b);
      
      JLabel heightLabel = new JLabel("Height: ");
      heightLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      subpanel.add(heightLabel);
      h = new JTextField("0", 10);
      h.setHorizontalAlignment(SwingConstants.CENTER);
      subpanel.add(h);
   
      JLabel widthLabel = new JLabel("Width: ");
      widthLabel.setHorizontalAlignment(SwingConstants.RIGHT);
      subpanel.add(widthLabel);
      w = new JTextField("0", 10);
      w.setHorizontalAlignment(SwingConstants.CENTER);
      subpanel.add(w);
   
      add(subpanel, BorderLayout.WEST);
            
      //south
      
      JButton reset = new JButton("Reset with a new triangle!");
      reset.setHorizontalAlignment(JButton.CENTER);
      reset.addActionListener(new resetListener());
      add(reset, BorderLayout.SOUTH);
      
      //center 
      
      gfx = new TrianglePanel();
      add(gfx, BorderLayout.CENTER); 
      
      addKeyListener(new KeyPress());  //Key listeners listen for keyboard inputs
      setFocusable(true);
      
      gfx.moveTriangle(0, 0); 
        
   }

   private class resetListener implements ActionListener 
   {
      public void actionPerformed(ActionEvent e) 
      {
         int rInt = Integer.parseInt(r.getText());
         int gInt = Integer.parseInt(g.getText());
         int bInt = Integer.parseInt(b.getText());
         int wInt = Integer.parseInt(w.getText());
         int hInt = Integer.parseInt(h.getText());
      
         gfx.newTriangle(new Color(rInt, gInt, bInt), wInt, hInt);
         requestFocusInWindow();
      }
   }
   
   private class KeyPress extends KeyAdapter
   {
      public void keyPressed(KeyEvent e) 
      {
         int key = e.getKeyCode();
         
         if (key == KeyEvent.VK_UP)
         {
            gfx.moveTriangle(0, -10);
         }
         if (key == KeyEvent.VK_RIGHT)
         {
            gfx.moveTriangle(10, 0);
         }       
         if (key == KeyEvent.VK_DOWN)
         {
            gfx.moveTriangle(0, 10);
         }
         if (key == KeyEvent.VK_LEFT)
         {
            gfx.moveTriangle(-10, 0);
         }
      }
   }
}