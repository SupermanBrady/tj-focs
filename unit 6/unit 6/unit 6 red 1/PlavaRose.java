public class PlavaRose implements Plant
{
   //Fields
   private int height;
   private int blooms;
   private int stage;
   private String sunlight;
   private double lastWater;
   private final int value = 5;  //9) What do you think is going on here?  What is "final"?  (Feel free to Google!)  Why is this value set outside the constructor?
   //A: Final is a variable that always contains the same value once it has been set. It is not in the constructor because it doesn't need extra changing/assigning
   
   //Constructors
   public PlavaRose()
   {
      height = 10;
      blooms = 0;
      stage = 0;
      sunlight = "shade";
      lastWater = 0;
   }
   public PlavaRose(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater)
   {
      height = customHeight;
      blooms = customBlooms;
      stage = customStage;
      sunlight = customSunlight;
      lastWater = customLastWater;
   }
   
   //Accessors & modifiers
   //10) Several accessors and modifiers are missing - why?
   // A: You can't "set" the plant's height or number of blooms because the user has to work for that. Or they are variables that the user should already know a get() function isn't necessary.
   public int getHeight()
   {
      return height;
   }
   public int getBlooms()
   {
      return blooms;
   }
   public String getSunlight()
   {
      return sunlight;
   }
   public int getValue()
   {
      return value;
   }
   public void setSunlight(String newSun)
   {
      
      if(newSun.equals("shade") || newSun.equals("indirect") || newSun.equals("direct"))
      {
         sunlight = newSun;
      }
   }
   public void setWater(double tablespoons)
   {
      if (isAlive()){
         if (tablespoons >= 0)
            lastWater = tablespoons;
         else
            System.out.println("Error : You can't water negative tablespoons of water!");
      }
      else
         System.out.println("Error : You can't water a dead plant!");
   }

   //Instance methods
   public void grow()
   {
      //12) Put into your own words: what does a Plava Rose need to bloom?
      // A: Plant needs to reach stage 3 to bloom. To reach stage 3, plant needs to be under direct sunlight. 
      //lastWater needs to be between 1.2 of the height divided by 10 AND twice the height divided by 10. if starting at stage 0, plant needs to be watered 3 times to bloom.
      if(stage >= 0)
      {
         if(sunlight.equals("direct"))
         {
            if(lastWater > 1.2 * height / 10 && lastWater < 2.0 * height / 10)
            {
               stage ++;
               height += 5;
            }
         }
         if(sunlight.equals("shade"))
         {
            stage --;
            height -= 5;
         }
      }
      if(stage >= 3)
      {
         stage = 3;
         blooms += 1;
      }
   }
   public int trim()
   {
      if(blooms > 0)
      {
         blooms--;
         return 1;
      }
      return 0;
   }
   public void statusReport()
   {
      if(stage == -1)
         System.out.println("Your Plava Rose is dead!");
      else
      {
         System.out.println("Your Plava Rose is " + height + " inches tall.");
         System.out.println("It has " + blooms + " flowers.");
         if(stage == 0)
         {
            System.out.println("Your Plava Rose looks like a bare stalk.");
         }
         else if(stage == 1)
         {
            System.out.println("Your Plava Rose has grown a few leaves.");
         }
         else if(stage == 2)
         {
            System.out.println("Your Plava Rose has a few flower buds.");
         }
         else
         {
            System.out.println("Your Plava Rose is blooming!");
         }
      }
   }
   public boolean isAlive()
   {
      return stage >= 0;
   }
   public String toString()
   {
      return "Plava Rose";
   }
}