import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;
import edu.fcps.karel2.*;
import java.lang.Math;

public class SeekerDemo
{
   public static void main(String[] args)
   {
      final int N = (int)(Math.random()*50+25);
      Display.setSize(N,N);
      Display.setSpeed(10);
      WorldBackend.getCurrent().putBeepers((int)(Math.random()*N+1), (int)(Math.random()*N+1), 1);
      
      Seeker redOctober = new Seeker();  //Only a default constructor
      redOctober.seek();
      
      //Test all three maps given above.
      //Aside from changing the map, don't modify this file.
      //If your Seeker class finds and retrieves the random beeper each time, you win!
   }
}