import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Follower extends Athlete
{
   //constructor:
   public Follower()
   {
      super(2, 2, Display.EAST, 0);
   }
   
   //other instance methods:
   public void follow()
   {
      while(nextToABeeper())
      {
         if(frontIsClear())
         {
            move();
         }
         else if (!frontIsClear()) // wall!
         {
            turnLeft();
            if(frontIsClear()) //can move left?
            {
               move();
            }
            else //if not move right
            {
               turnAround();
               move();
            }
         }
         // turn back as soon as off path, only triggers if not on beeper
         if(!nextToABeeper())
         {       
            turnAround();
            move();
            turnAround();
         //check if beeper to left
            turnLeft();
            move();
            if(!nextToABeeper())
            {       
               turnAround();
               move();
               turnLeft();
               //goes to check right side
               turnRight();
               move();
            }
         //check if beeper to right
            if(!nextToABeeper())
            {       
               turnAround();
               move();
               break;
            }
         }
      }
   }
}
