public class Parallelogram implements Shape, Comparable<Shape>
{
   //fields
   private double base;
   private double slantHeight;
   private double verticalHeight;
   
   //constructors
   public Parallelogram(double customBase, double customSlantHeight, double customVerticalHeight)
   {
      base = customBase;
      slantHeight = customSlantHeight;
      verticalHeight = customVerticalHeight;
   }
      
   //additional instance methods
   public double getArea()
   {
      return (base * verticalHeight); 
   }
   
   public double getPerimeter()
   {
      return (base + base + slantHeight + slantHeight);
   }
      
   public int compareTo(Shape x)
   {
      if (getArea() > x.getArea())
         return 1;
      else if (getArea() < x.getArea())
         return -1;
      else
         return 0;
   }
   
   //overriding toString
   public String toString()
   {
      return "Parallelogram with base " + base + " slant height " + slantHeight + " height " + verticalHeight + " has area " + getArea();
   }
}