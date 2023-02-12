public class Circle implements Shape, Comparable<Shape>
{
   //fields
   private double radius;
   private double area;
   private double perimeter;
   
   //constructors
   public Circle(double customRadius)
   {
      radius = customRadius;
   }
      
   //additional instance methods
   public double getArea()
   {
      return (Math.PI * radius * radius); 
   }
   
   public double getPerimeter()
   {
      return (Math.PI * 2 * radius);
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
      return "Circle with radius " + radius + " has area " + getArea();
   }
}