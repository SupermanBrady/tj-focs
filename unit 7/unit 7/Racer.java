import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Racer extends Athlete
{
   public Racer(int y)
   {
      super(1, y, Display.EAST, Display.INFINITY);
   }
   
   public void jumpRight()
   {
      turnLeft();
      move();
      turnRight();
      move();
      turnRight();
      move();
      turnLeft();
   }
   
   public void jumpLeft()
   {
      turnRight();
      move();
      turnLeft();
      move();
      turnLeft();
      move();
      turnRight();
   }
   
   public void sprint(int n)
   {
      for(int k=1; k <=n; k++)
         move();
   }
   
   public void drop(int n)
   {
      for(int k=1; k <=n; k++)
         putBeeper();
   }
   
   public void collect(int n)
   {
      for(int k=1; k <=n; k++)
         pickBeeper();
   }
   
   public void shuttle(int spacers, int beepers)
   {
      sprint(1);
      jumpRight();
      sprint(spacers);
      collect(beepers);
      turnAround();
      sprint(spacers);
      jumpLeft();
      sprint(1);
      drop(beepers);
      turnAround();         
   }
}