import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class MazeEscaperDemo
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/maze1.map");  //Test on maze1.map, maze2.map, and maze3.map
      Display.setSize(10,10);
      Display.setSpeed(8);
      
      MazeEscaper houdini = new MazeEscaper();  //Only a default constructor
      houdini.escape();
      
      //Test all three maps given above.
      //Aside from changing the map, don't modify this file.
      //(Though, if you want to see the maps before you start coding, you can comment out the MazeEscaper lines so you can do that.)
      //If your MazeEscaper gets to the beeper and stops each time, you win!
   }
}