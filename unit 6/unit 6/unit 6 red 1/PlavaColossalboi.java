public class PlavaColossalboi implements Plant
{
   //Fields
   private int height;
   private int blooms;
   private int stage;
   private String sunlight;
   private double lastWater;
   private final int value = 15;
   
   //Constructors
   public PlavaColossalboi()
   {
      height = 400;
      blooms = 0;
      stage = 0;
      sunlight = "indirect";
      lastWater = 0;
   }
   public PlavaColossalboi(int customHeight, int customBlooms, int customStage, String customSunlight, double customLastWater)
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
      //13) Put into your own words - what does a Plava Colossalboi need to bloom?
      // A: Colossalboi starts off very tall. To blossom, it must shrink. Put under direct sunlight and water it between 0.2 and 0.5 times its height divided by 5
      if(stage >= 0)
      {
         if(sunlight.equals("direct"))
         {
            if(lastWater > 0.2 * height / 5 && lastWater < 0.5 * height / 5)
            {
               height = height - 100;
               stage++;
            }
         }
         else
         {
            height = height + 100;
            stage--;
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
         System.out.println("Your Plava Colossalboi is dead!");
      else
      {
         System.out.println("Your Plava Colossalboi is " + height + " inches tall.");
         System.out.println("It has " + blooms + " flowers.");
         if(stage == 0)
         {
            System.out.println("Your Plava Colossalboi is too tall.");
         }
         else if(stage == 1)
         {
            System.out.println("Your Plava Colossalboi has split off a second stem and looks healthier.");
         }
         else if(stage == 2)
         {
            System.out.println("Your Plava Colossalboi has buds.");
         }
         else
         {
            System.out.println("Your Plava Colossalboi is blooming!");
         }
      }
   }
   public boolean isAlive()
   {
      return stage >= 0;
   }
   public String toString()
   {
      return "Plava Colossalboi";
   }
}