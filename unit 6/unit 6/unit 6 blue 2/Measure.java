public class Measure implements Comparable<Measure>
{
   //fields
   private int feet, inches;
   
   //constructors
   public Measure()
   {
      feet = inches = 0;
   }
   public Measure(int x)
   {
      feet = x;
      inches = 0;
   }
   public Measure(int x, int y)
   {
      feet = x + (y / 12);
      inches = y % 12;
   }
   public Measure(Measure arg)
   {
      feet = arg.getFeet();
      inches = arg.getInches();
   }
   
   //accessors and modifiers
   public int getFeet()
   {
      return feet;
   }
   public int getInches()
   {
      return inches;
   }
   public void setFeet(int x)
   {
      feet = x;
   }
   public void setInches(int x)
   {
      feet += x / 12;
      inches += x % 12;
   }
   
   
   //other methods
   public int compareTo(Measure other)
   {
      if(feet < other.getFeet())
         return -1;
      if(feet > other.getFeet())
         return 1;
      if(inches < other.getInches())
         return -1;
      if(inches > other.getInches())
         return 1;
      return 0;
   }
   public boolean equals(Measure other)
   {
      return compareTo(other) == 0;
   }
   public String toString()
   {
      return feet + "'" + inches + "\"";
   }
}