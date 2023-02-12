import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class PileShifterDemo
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/piles.map");
      Display.setSize(10,10);
      Display.setSpeed(10);
      
      PileShifter mover = new PileShifter(9, 7);
      PileShifter shaker = new PileShifter(8, 4);
      PileShifter shifter = new PileShifter(7, 1);
     
      mover.shift();
      shaker.shift();
      shifter.shift();
   }
}