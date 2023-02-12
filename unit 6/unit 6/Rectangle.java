public class Rectangle implements Shape, Comparable<Shape>
{
   //fields
   private double side1;
   private double side2;
   
   //constructors
   public Rectangle(double customSide1, double customSide2)
   {
      side1 = customSide1;
      side2 = customSide2;
   }
      
   //additional instance methods
   public double getArea()
   {
      return side1 * side2;
   }
   
   public double getPerimeter()
   {
      return (side1 + side1 + side2 + side2);
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
      return "Rectangle with sides " + side1 + " and " + side2 + " has area " + getArea();
   }
}