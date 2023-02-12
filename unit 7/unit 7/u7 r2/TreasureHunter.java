import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class TreasureHunter extends Athlete
{
   
   //constructor:
   public TreasureHunter()
   {
      super(1, 1, Display.EAST, 0);
   }
   
   //other instance methods:
   public void hunt()
   {
   int beeperCount = 0;
      while (beeperCount < 5)
      {
         while(!nextToABeeper() && frontIsClear())
         {
            move();
         }
         beeperCount = 0;
         while(nextToABeeper())
         {
        
            pickBeeper();
            beeperCount++;
         }
         if (beeperCount == 1)
            turnLeft();
         if (beeperCount == 2)
            turnAround();
         if (beeperCount == 3)
            turnRight();
      }
   }
}
