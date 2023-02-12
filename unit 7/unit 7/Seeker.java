import edu.fcps.karel2.Display;
import edu.fcps.karel2.Robot;

public class Seeker 
{

   Athlete[] seekah; 
   
   //constructor:
   public Seeker()
   {
      seekah = new Athlete[75];  
      for(int i = 0; i < 75; i++)
      {
         seekah[i] = new Athlete(1, i+1, Display.EAST, 0);
      }
   }
        
   //other instance methods:
   public void seek()
   {
      for (int i = 0; i < 75; i++)
      {
         {
            int vrie = 0;
            while(!seekah[i].nextToABeeper() && vrie < 75)
            {
               seekah[i].move();
               vrie++;
            } 
            if (seekah[i].nextToABeeper())
            {
               seekah[i].pickBeeper();
               seekah[i].turnAround();
               while(seekah[i].frontIsClear())
               {
                  seekah[i].move();
               }
               seekah[i].turnLeft();
               while(seekah[i].frontIsClear())
               {
                  seekah[i].move();
               }
               seekah[i].putBeeper();
               break;
            }
         }
      }
   }
}
