import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public abstract class ObstacleBot extends Athlete implements Runnable
{
   //constructor:
   public ObstacleBot(int x)
   {
      super(x, 1, Display.NORTH, 0);
   }
   
   //abstract method:
   public abstract boolean keepGoing();
   
   //other instance methods:
   public void run()
   {
      while (keepGoing())
      {
         if (frontIsClear())
            move();
         else
            {
               turnRight();
               int strayCount = 0; //counts how far bot strayed from column
               while (!leftIsClear())
               {
                  move();
                  strayCount++;
               }
               turnLeft();
               move();
               turnLeft();               
               for(int i = 0; i < strayCount; i++)
               {
                  move();
               }    
               turnRight();        
            }
      }
   }
}