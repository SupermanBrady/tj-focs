public class Square implements Shape, Comparable<Shape>
{
   //fields
   private double side1;
   
   //constructors
   public Square(double customSide1)
   {
      side1 = customSide1;
   }
      
   //additional instance methods
   public double getArea()
   {
      return (side1 * side1); 
   }
   
   public double getPerimeter()
   {
      return (side1 * 4);
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
      return "Square with side " + side1 + " has area " + getArea();
   }
}