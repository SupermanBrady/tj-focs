import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Jumper extends Athlete
{
   public Jumper(int x)
   {
      super(x, 1, Display.NORTH, Display.INFINITY);
   }
   
   public void jump()
   {
      for(int i = 0; i < 5; i++)
      {
         putBeeper();
         move();
      }
      turnAround();
      for(int i = 0; i < 5; i++)
      {
         move();
         pickBeeper();
      }
      turnAround();
   }   
}