import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class ThreadRacerDemo
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/shuttle2.map");
      Display.setSize(10,10);
      Display.setSpeed(8);
      Runnable r1 = new ThreadRacer(1, new int[]{0, 1, 2, 6}, new int[]{5, 1, 5, 2});
      Runnable r2 = new ThreadRacer(4, new int[]{1, 2, 4, 5, 6}, new int[]{1, 7, 1, 5, 3});
      Runnable r3 = new ThreadRacer(7, new int[]{2, 4, 5}, new int[]{4, 7, 2});
      Thread t1 = new Thread(r1);
      Thread t2 = new Thread(r2);
      Thread t3 = new Thread(r3);
      t1.start();
      t2.start();
      t3.start();
   }
}