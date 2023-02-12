import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class ThreadRacer extends Racer implements Runnable
{
   //fields
   private int[] beepPlace = {}; 
   private int[] beepSize = {}; 
   
   //constructor
   public ThreadRacer(int y, int[] p, int[] s)
   {
      super(y);
      beepPlace = p;
      beepSize = s;
   }
   
   //runnable
   public void run()
   {
      for(int i = 0; i < beepPlace.length; i++)
      {
         shuttle(beepPlace[i], beepSize[i]);
      }
      move();
   }
   
} 