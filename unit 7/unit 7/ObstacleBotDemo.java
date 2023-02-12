import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class ObstacleBotDemo
{
   public static void main(String[] args)
   {
      Display.openWorld("maps/obstacle1.map");  //DON'T FORGET to test on obstacle2.map as well!
      Display.setSize(10,10);
      Display.setSpeed(6);
      
      //Test a single BeeperStop
      
      /*BeeperStop example = new BeeperStop(5); //Modify to test whichever column you like!
      example.run();
      */
  
      //Test multithreaded BeeperStops
      /*
      Thread[] bthreads = new Thread[10];
      for (int i = 0; i < 10; i++)
      {
         bthreads[i] = new Thread(new BeeperStop(i+1));
      }
      for (int i = 0; i < 10; i++)
      {
         bthreads[i].start();
      }
      */
      
      //Test a single CountStop
      /*
      CountStop example2 = new CountStop(4, 7); //Modify column and goal height!
      example2.run();
      */
            
      //Test multithreaded CountStops
      
      Thread[] cthreads = new Thread[10];
      for (int i = 0; i < 10; i++)
      {
         cthreads[i] = new Thread(new CountStop(i+1, i+1));
      }
      for (int i = 0; i < 10; i++)
      {
         cthreads[i].start();
      } 
      
   }
}
