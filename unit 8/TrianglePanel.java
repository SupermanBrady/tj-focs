import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;

class TrianglePanel extends JPanel
{
   public static final int FRAME = 400;
   private static final Color BACKGROUND = new Color(204, 204, 204);
   
   private BufferedImage myImage;
   private Graphics myBuffer;
   
   private Triangle t;
   
   public TrianglePanel()
   {
      myImage = new BufferedImage(FRAME, FRAME, BufferedImage.TYPE_INT_RGB);
      myBuffer = myImage.getGraphics();
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0,0,FRAME,FRAME);
      t = new Triangle(Color.black, 20, 20);
   }
   
   public void paintComponent(Graphics g) //Required method to paint to the screen
   {
      g.drawImage(myImage, 0, 0, getWidth(), getHeight(), null); //Draw the buffered image we've stored as a field
   }
   
   public void moveTriangle(int dx, int dy)
   {
      myBuffer.setColor(BACKGROUND);
      myBuffer.fillRect(0, 0, FRAME, FRAME);
      myBuffer.setColor(t.getMyColor());
      t.move(dx, dy);
      t.draw(myBuffer);
      repaint();
   }
   
   public void newTriangle(Color c, int h, int w)
   {
      t = new Triangle(c, h, w);
      moveTriangle(0, 0);
   }
}
    
class Triangle
{
   private int[] myXs;
   private int[] myYs;
   private int myWidth;
   private int myHeight;
   private Color myColor;

   //constructors
   public Triangle(Color c, int h, int w)
   {
      myWidth = w;
      myHeight = h;
      myColor = c;
      myXs = new int[]{200, 200-w/2, 200+w/2};
      myYs = new int[]{380 - h, 380, 380};
   }

   //instance method
   public void move(int dx, int dy)
   {
      for (int i = 0; i < 3; i ++)
      {
         myXs[i] += dx;
         myYs[i] += dy;
      }
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
}