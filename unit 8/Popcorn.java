import javax.swing.*;
import java.awt.*;
public class Popcorn extends JPanel
{
   public void paintComponent(Graphics g)
   {
      //background
      
      g.setColor(new Color(255, 241, 212)); 	
      g.fillRect(0, 0, 400, 400);
      
      //explosion
      g.setColor(Color.WHITE);
      int xPoints[] = {25, 200, 375};		
      int yPoints[] = {300, 50, 300};		
      g.fillPolygon(xPoints, yPoints, 3);
      
      g.setColor(Color.YELLOW);
      int aPoints[] = {30, 215, 390};		
      int bPoints[] = {285, 35, 285};		
      g.drawPolygon(aPoints, bPoints, 3);
      
      //the box
      
      g.setColor(Color.WHITE);
      g.fillRect(100, 170, 150, 190);
      
      g.setColor(new Color(219, 60, 39)); //red
      for(int x = 100; x < 250; x+=20)
         g.fillRect(x, 170, 10, 190);
         
      g.setColor(Color.WHITE);
      g.fillOval(107, 225, 135, 80);
      
      //label
      
      g.setColor(new Color(250, 217, 67)); //yellow
      g.drawOval(110, 228, 127, 73);
      
      g.setFont(new Font("SansSerif", Font.BOLD, 20));
      g.setColor(new Color(250, 217, 67));
      g.drawString("POPCORN", 124, 273);
      
      //popcorn  
      for(int x = 93; x < 250; x+=40)
      {
         g.fillOval(x, 145, 30, 30);
         g.fillOval(x+17, 145, 30, 30);
         g.fillOval(x+8, 135, 30, 30);
      }
      
      for(int x = 100; x < 230; x+=50)
      {
         g.fillOval(x, 115, 30, 30);
         g.fillOval(x+17, 115, 30, 30);
         g.fillOval(x+8, 105, 30, 30);
      }
     
      g.fillOval(225, 340, 30, 30);
      g.fillOval(242, 340, 30, 30);
      g.fillOval(232, 330, 30, 30);
      
      //sign
      g.setColor(new Color(59, 59, 59)); //dark gray
      g.drawRect(50, 25, 275, 50);
      
      g.setFont(new Font("Monospaced", Font.BOLD, 22));
      g.setColor(new Color(59, 59, 59));
      g.drawString("hot 'n buttered :)", 65, 57);    
      
   }
}