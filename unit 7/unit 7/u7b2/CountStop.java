import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class CountStop extends ObstacleBot
{
   //field:
   private int stopPoint;
   
   //constructor:
   public CountStop(int x, int s)
   {
      super(x);
      stopPoint = s;
   }
   
   //implementation:
   public boolean keepGoing()
   {
      if (stopPoint != getY())
         return true;
      else
         return false;
   }
}