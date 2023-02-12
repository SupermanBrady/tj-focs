import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class TreasureHunterDemo
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/map3.map");  //Test on map1.map, map2.map, and map3.map
      Display.setSize(10,10);
      Display.setSpeed(10);
      
      TreasureHunter omalley = new TreasureHunter();  //Only a default constructor
      omalley.hunt();
      
      //Test all three maps given above.
      //Aside from changing the map, don't modify this file.
      //(Though, if you want to see the maps before you start coding, you can comment out the TreasureHunter lines so you can do that.)
      //If your TreasureHunter finds the treasure (ie, correctly visits each pile of beepers, ending on the stack of 5 beepers, where it stops) each time, you win!
   }
}