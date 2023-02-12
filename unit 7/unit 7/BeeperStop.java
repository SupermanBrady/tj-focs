import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class BeeperStop extends ObstacleBot
{
   public BeeperStop(int column)
   {
      super(column);
   }
   public boolean keepGoing()
   {
      if(!nextToABeeper())
      {
         return true;
      }
      else
      {
         return false;
      }
   }
}