import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Green_challenge2
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/maze.map");
      Display.setSize(8, 8);
      Display.setSpeed(10);
   
      Athlete karel = new Athlete();
   
      karel.putBeeper();
      karel.move();
      karel.putBeeper();
      karel.turnRight();
      karel.move();
      karel.putBeeper();
      karel.turnRight();
      karel.move();
      karel.putBeeper();
      karel.turnLeft();
      karel.move();
      karel.putBeeper();
      karel.turnLeft();
      karel.move();
      karel.putBeeper();
      karel.turnRight();
      karel.move();
      karel.putBeeper();
      karel.move();
      karel.putBeeper();
      karel.turnRight();
      karel.move();
      karel.putBeeper();
      karel.turnLeft();
      karel.move();
      karel.putBeeper();
      karel.turnLeft();
      karel.move();
      karel.putBeeper();
      karel.move();
      karel.putBeeper();
      karel.move();
      karel.putBeeper();
      karel.move();
      karel.putBeeper();
      karel.turnRight();
      karel.move();
      karel.putBeeper();
      karel.move();
   }
}