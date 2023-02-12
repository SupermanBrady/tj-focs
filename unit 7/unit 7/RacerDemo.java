import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class RacerDemo
{
   public static void runRace(Racer arg)
   {
      arg.shuttle(2, 7);
      arg.shuttle(4, 5);
      arg.shuttle(6, 3);
      arg.move();
   }
   public static void main(String[] args)
   {
      Display.openWorld("maps/shuttle.map");
      Display.setSize(10,10);
      Display.setSpeed(10);
      Racer r1 = new Racer(1);
      Racer r2 = new Racer(4);
      Racer r3 = new Racer(7);
      runRace(r1);
      runRace(r2);
      runRace(r3);
   }
}