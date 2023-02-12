public class PlavaShadyboi implements Plant
{
   //Fields
   private int height;
   private int blooms;
   private int stage;
   private String sunlight;
   private double lastWater;
   private final int value = 15;
   
   //Constructors
   public PlavaShadyboi()
   {
      height = 4;
      blooms = 0;
      stage = 0;
      sunlight = "indirect";
      lastWater = 0;
   }
   public PlavaShadyboi(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater)
   {
      height = customHeight;
      blooms = customBlooms;
      stage = customStage;
      sunlight = customSunlight;
      lastWater = customLastWater;
   }
   
   //Accessors & modifiers
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
      //13) Put into your own words - what does a Plava Shadyboi need to bloom?
      // A: Shadyboi needs to reach stage 3 or above. To get to stage 3, the last water needs to be between 0.5 times the height divided by 10 AND 0.6 times the height divided by 10
      // It also has to be put in the shade, or else it will lose height and stages. Once stage 3, it blooms 10.
      if(stage >= 0)
      {
         if(sunlight.equals("shade"))
         {
            if(lastWater > 0.4 * height / 10 && lastWater < 0.6 * height / 10)
            {
               stage++;
            }
         }
         else
         {
            height--;
            if(height == 0)
            {
               stage = -1;
            }
         }
      }
      if(stage >= 3)
      {
         stage = 3;
         blooms += 10;
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
         System.out.println("Your Plava Shadyboi is dead!");
      else
      {
         System.out.println("Your Plava Shadyboi is " + height + " inches tall.");
         System.out.println("It has " + blooms + " flowers.");
         if(stage == 0)
         {
            System.out.println("Your Plava Shadyboi is a depressing looking nub.");
         }
         else if(stage == 1)
         {
            System.out.println("Your Plava Shadyboi has split off a second stem and looks healthier.");
         }
         else if(stage == 2)
         {
            System.out.println("Your Plava Shadyboi has buds.");
         }
         else
         {
            System.out.println("Your Plava Shadyboi is blooming!");
         }
      }
   }
   public boolean isAlive()
   {
      return stage >= 0;
   }
   public String toString()
   {
      return "Plava Shadyboi";
   }
}