import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class PileShifter extends Athlete
{
   public PileShifter(int x, int y)
   {
      super(x, y, Display.WEST, 0);
   }
   public void shift() //the code to get the bot to shift piles
   {      
      while(frontIsClear())
      {
         if (facingWest())
         {
            turnAround();
         }
         int beeperCount = 0;
         while(nextToABeeper())
         {
            pickBeeper();
            beeperCount++;
         }
         move();
         for (int i = 0; i < beeperCount; i++)
         {
            putBeeper();
         }
         turnAround();
         move();
         move();
      }
      turnAround();
      int beeperCount = 0;
      while(nextToABeeper())
      {
         pickBeeper();
         beeperCount++;
      }
      move();
      for (int i = 0; i < beeperCount; i++)
      {
         putBeeper();
      }
      turnAround();
      move();
   }
}
