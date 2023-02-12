import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

public class RisingSquareDemo
{
   public static void main(String[] args)
   { 
      JFrame frame = new JFrame("GUI + a graphics JFrame");
      frame.setSize(500, 570);
      frame.setLocation(20, 20);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setContentPane(new RisingPanel());
      frame.setVisible(true);
   }
}

class RisingPanel extends JPanel
{
   AnimatedPanel gfx;  //As usual: graphics in a custom subpanel
   
   public RisingPanel()
   {
      setLayout(new BorderLayout());
      
      JLabel title = new JLabel("Animation / key demo!  Press 'Start' then hold 'Space'.");
      title.setFont(new Font("Serif", Font.BOLD, 20));
      title.setHorizontalAlignment(SwingConstants.CENTER);
      add(title, BorderLayout.NORTH);
      
      gfx = new AnimatedPanel();
      add(gfx);
      
      JButton startButton = new JButton("Start");
      startButton.addActionListener(new StartListener());
      add(startButton, BorderLayout.SOUTH); 
   }
   
   private class StartListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {
         gfx.begin();
         gfx.requestFocusInWindow();  //Don't forget this!
      }
   }
}

class AnimatedPanel extends JPanel
{
   public static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   
   private BufferedImage myImage;
   private Graphics myBuffer;
   private MovingSquare sq;
   private Timer t;
   private boolean space;
      
   public AnimatedPanel()
   {
      myImage =  new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      sq = new MovingSquare();
      sq.draw(myBuffer);
      
      addKeyListener(new Key());
      setFocusable(true);  //Don't forget this!
      
      t = new Timer(5, new AnimationListener());  //Once started, will call AnimationListener over and over; 5 millisecond delay each time
            
      space = false;
   }
   
   public void paintComponent(Graphics g)  //Required method to paint to the screen
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null);  //Draw the buffered image we've stored as a field
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
      
      //Move the square (when we add multiple objects, they'll all need to move and draw)
      sq.move();
      sq.draw(myBuffer);
      
      //Call paintComponent
      repaint();
   }
   
   private class AnimationListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)  //Gets called over and over by the Timer
      {
         animate();  //...hence animation!
      }
   }
   
   private class Key extends KeyAdapter
   {
      public void keyPressed(KeyEvent e)
      {
      	// check for space
         if(e.getKeyCode() == KeyEvent.VK_SPACE && !space)
         {
            sq.adddy(2);   //Add 2 to sq's movement per animation step; cancels the -2 already there, so sq is motionless
            space = true;  //See the video for an explanation of what's going on here; this is complicated
         }
      }
      
      public void keyReleased(KeyEvent e)  //Note keyReleased is called when... a key is released!
      {
      	// check for up arrow
         if(e.getKeyCode() == KeyEvent.VK_SPACE)
         {
            sq.adddy(-2);  //Add 2 to sq's movement per animation step; causes it to once again rise
            space = false;
         }
      }
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
   public MovingSquare()
   {
      mySize = 10;
      myY = AnimatedPanel.FRAME - mySize;
      myX = (int)(Math.random() * (AnimatedPanel.FRAME - mySize));
      myColor = new Color(10, 10, 10);
      mydy = -2;
   }
      
   //instance methods
   public void move()
   {
      myY += mydy;  //Move a certain distance upwards - this will happen every animation step
      if(myY < 0)   //If we reach the top of the screen, reset
      {
         myY = AnimatedPanel.FRAME - mySize;
         myX = (int)(Math.random() * (AnimatedPanel.FRAME - mySize));
      }
   }
   
   public void adddy(int dy)  //Allows the keyboard listener to modify animated behavior
   {
      mydy += dy;
   }
         
   public void draw(Graphics myBuffer) 
   {
      myBuffer.setColor(myColor);
      myBuffer.fillRect(myX, myY, mySize, mySize);
   }
}