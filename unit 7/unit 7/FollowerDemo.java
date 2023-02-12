import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class FollowerDemo
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/path3.map");  //Test on path1.map, path2.map, and path3.map
      Display.setSize(10,10);
      Display.setSpeed(10);
      
      Follower dorothy = new Follower();  //Only a default constructor
      dorothy.follow();
      
      //Test all three maps given above.
      //Aside from changing the map, don't modify this file.
      //(Though, if you want to see the maps before you start coding, you can comment out the Follower lines so you can do that.)
      //If your Follower follows the path (ie, visits each beeper at least once and stops on the last beeper in the path) each time, you win!
   }
}