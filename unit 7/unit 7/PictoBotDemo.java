import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class PictoBotDemo
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/picto3.map");  //Test on picto1.map, picto2.map, and picto3.map
      Display.setSize(10,10);
      Display.setSpeed(7);
      
      PictoBot pollock = new PictoBot();  //Only a default constructor
      pollock.rotate();
      
      //Test all three maps given above.
      //Aside from changing the map, don't modify this file.
      //(Though, if you want to see the maps before you start coding, you can comment out the PictoBot lines so you can do that.)
      //If your PictoBot rotates each pictograph 90 degrees, you win!
   }
}