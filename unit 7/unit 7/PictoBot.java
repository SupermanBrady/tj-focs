import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class PictoBot extends Athlete
{
   //constructor:
   public PictoBot()
   {
      super(1, 1, Display.EAST, 0);
   }
   
   //other instance methods:
   public void rotate()
   {
      int col1 = 0;
      int col2= 0;
      int col3 = 0;
      int col4 = 0;
      int colCount = 0;
      
      turnLeft();
      while(nextToABeeper())
      {
         pickBeeper();
         col1++;
         move();
      }
      turnAround();
      for (int i = 0; i < col1; i++)
      {
         move();
      }
      colCount++;
      
      turnLeft();
      move();
      turnLeft();
      while(nextToABeeper())
      {
         pickBeeper();
         col2++;
         move();
      }
      turnAround();
      for (int i = 0; i < col2; i++)
      {
         move();
      }
      colCount++;
      
      turnLeft();
      move();
      turnLeft();
      while(nextToABeeper())
      {
         pickBeeper();
         col3++;
         move();
      }
      turnAround();
      for (int i = 0; i < col3; i++)
      {
         move();
      }
      colCount++;
      
      turnLeft();
      move();
      turnLeft();
      while(nextToABeeper())
      {
         pickBeeper();
         col4++;
         move();
      }
      turnAround();
      for (int i = 0; i < col4; i++)
      {
         move();
      }
      colCount++;
        
      //go back to (1, 1)
      turnRight();
      while(frontIsClear())
      {
         move();
      }
      
      turnRight();
      for (int i = 0; i < colCount - 1; i++)
      {
         move();
      }   
      turnRight();
      for (int i = 0; i < col1; i++)
      {
         putBeeper();
         move();
      }
      
      //go down a row
      turnRight();
      move();
      turnRight();
      while(frontIsClear())
      {
         move();
      }
      turnAround();
      
      for (int i = 0; i < col2; i++)
      {
         putBeeper();
         move();
      }
      
      //go down a row
      turnRight();
      move();
      turnRight();
      while(frontIsClear())
      {
         move();
      }
      turnAround();
      
      for (int i = 0; i < col3; i++)
      {
         putBeeper();
         move();
      }
      
      //go down a row
      turnRight();
      move();
      turnRight();
      while(frontIsClear())
      {
         move();
      }
      turnAround();
      
      for (int i = 0; i < col4; i++)
      {
         putBeeper();
         move();
      }
     
   }
}