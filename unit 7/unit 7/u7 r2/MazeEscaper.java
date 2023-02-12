import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class MazeEscaper extends Athlete
{
   //constructor:
   public MazeEscaper()
   {
      super(1, 1, Display.NORTH, 0);
   }
   
   //other instance methods:
   public void escape()
   {
      while (!nextToABeeper())
      {
         if (frontIsClear() && rightIsClear() && !leftIsClear())
         {
            move();
         }
         if (frontIsClear() && rightIsClear() && leftIsClear())
         {
            turnLeft();
            move();
         }
         if (frontIsClear() && !rightIsClear() && leftIsClear())
         {
            turnLeft();
            move();
         }
         if(frontIsClear() && !rightIsClear() && !leftIsClear())
         {
            move();
         }
         if (!frontIsClear() && rightIsClear() && !leftIsClear())
         {
            turnRight();
            move();
         }
         if (!frontIsClear() && !rightIsClear() && leftIsClear())
         {
            turnLeft();
            move();
         }
         if (!frontIsClear() && rightIsClear() && leftIsClear())
         {
            turnLeft();
            move();
         }
         if (!frontIsClear() && !rightIsClear() && !leftIsClear())
         {
            turnAround();
            move();
         }

      }
   }
}