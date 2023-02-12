public class Triangle implements Shape, Comparable<Shape>
{
   //fields
   private double side1;
   private double side2;
   private double side3;
   
   //constructors
   public Triangle(double customSide1, double customSide2, double customSide3)
   {
      side1 = customSide1;
      side2 = customSide2;
      side3 = customSide3;
   }
      
   //additional instance methods
   public double getArea()
   {
      double s = getPerimeter() / 2;
      double a = side1;
      double b = side2;
      double c = side3;
      return Math.sqrt(s * (s- a) * (s-b) * (s-c));
   }
   
   public double getPerimeter()
   {
      return (side1 + side2 + side3);
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
      return "Triangle with sides " + side1 + " " + side2 + " and " + side3 + " has area " + getArea();
   }
}