import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class Lab8RED2
{
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
   
      gfx.begin();
      gfx.requestFocusInWindow();
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
         gfx.requestFocusInWindow();
      }
   }
}

class TrianglePanel extends JPanel
{
   public static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);

   private BufferedImage myImage;
   private Graphics myBuffer;
   private Timer t;
   private Triangle tri;
   private MovingSquare rocket;
   private boolean arrows;

   public TrianglePanel()
   {
      myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      tri = new Triangle(Color.black, 20, 20);
      tri.draw(myBuffer);
   
      addKeyListener(new KeyPress());
      setFocusable(true);
      requestFocusInWindow();
   
      t = new Timer(5, new AnimationListener());
      arrows = false;
   }

   public void paintComponent(Graphics g) //Required method to paint to the screen
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null); //Draw the buffered image we've stored as a field
   }

   public void begin()
   {
      t.start();  //Starts the timer!
   }

   public void animate()
   {
      //Start over with a blank background
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      tri.move();
      //Move the square (when we add multiple objects, they'll all need to move and draw)
      tri.draw(myBuffer);
      
      if (rocket != null)
      {
         if (rocket.getY() < 0)
         {
            rocket = null;
         }
         else
         {
            rocket.move();
            rocket.draw(myBuffer);
         }
      }
   
      //Call paintComponent
      repaint();
      updateUI();
   }

   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
      {
         animate();  //...hence animation!
      }
   }

   public void moveTriangle(int dx, int dy)
   {
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
      myBuffer.setColor(tri.getMyColor());
      tri.move();
      tri.draw(myBuffer);
      repaint();
   }

   public void newTriangle(Color c, int h, int w)
   {
      tri = new Triangle(c, h, w);
      moveTriangle(0, 0);
   }
   
   public void shoot()
   {
      if (rocket == null)
      {
         rocket = new MovingSquare(tri.tipX(), tri.tipY());
      }
   }

   class KeyPress extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
         int key = e.getKeyCode();
      
         if (key == KeyEvent.VK_UP)
         {
            tri.vertAdddy(-2);
            arrows = true;
         }
         if (key == KeyEvent.VK_RIGHT)
         {
            tri.horizAdddy(2);
            arrows = true;
         }
         if (key == KeyEvent.VK_DOWN)
         {
            tri.vertAdddy(2);
            arrows = true;
         }
         if (key == KeyEvent.VK_LEFT)
         {
            tri.horizAdddy(-2);
            arrows = true;
         }
         if (key == KeyEvent.VK_SPACE)
         {
            shoot();
         }
      }
      public void keyReleased(KeyEvent e)
      {
         int key = e.getKeyCode();
      
         if(key == KeyEvent.VK_UP)
         {
            tri.vertAdddy(0);
            arrows = false;
         }
         if(key == KeyEvent.VK_RIGHT)
         {
            tri.horizAdddy(0);
            arrows = false;
         }
         if(key == KeyEvent.VK_LEFT)
         {
            tri.horizAdddy(0);
            arrows = false;
         }
         if(key == KeyEvent.VK_DOWN)
         {
            tri.vertAdddy(0);
            arrows = false;
         }
      }
   }
}

class Triangle
{
   private int[] myXs;
   private int[] myYs;
   private int myWidth;
   private int myHeight;
   private Color myColor;
   private int mydy;
   private int mydx;

   //constructors
   public Triangle(Color c, int h, int w)
   {
      myWidth = w;
      myHeight = h;
      myColor = c;
      myXs = new int[]{200, 200-w/2, 200+w/2};
      myYs = new int[]{380 - h, 380, 380};
      mydy = 0;
      mydx = 0;
   }

   //instance method
   public void move()
   {
      for (int i = 0; i < 3; i ++)
      {
         myXs[i] += mydx;
         myYs[i] += mydy;
      }
   }

   public void vertAdddy(int dy)
   {
      mydy = dy;
   }

   public void horizAdddy(int dx)
   {
      mydx = dx;
   }

   public void draw(Graphics myBuffer)
   {
      myBuffer.setColor(myColor);
      myBuffer.fillPolygon(myXs, myYs, 3);
   }

   public Color getMyColor()
   {
      return myColor;
   }
   
   public int tipX()
   {
      return myXs[0];
   }
   
   public int tipY()
   {
      return myYs[0];
   }
}

class MovingSquare
{
   private int myX;
   private int myY;
   private int mySize;
   private Color myColor;
   private int mydy;
      
    // constructors
   public MovingSquare(int[] pos, int h)
   {
      mySize = 10;
      myY = TrianglePanel.FRAME - mySize;
      myX = (int)(Math.random() * (TrianglePanel.FRAME - mySize));
      myColor = new Color(10, 10, 10);
      mydy = -5;
   }
   
   public MovingSquare(int tipX, int tipY)
   {
      mySize = 10;
      myX = tipX;
      myY = tipY;
      myColor = new Color(10, 10, 10);
      mydy = -5;
   }
      
   //instance methods
   public void move()
   {
      myY += mydy;  //Move a certain distance upwards - this will happen every animation step
   }
      
   public int getY()
   {
      return myY;
   }   
   public void draw(Graphics myBuffer) 
   {
      myBuffer.setColor(myColor);
      myBuffer.fillRect(myX, myY, mySize, mySize);
   }
}