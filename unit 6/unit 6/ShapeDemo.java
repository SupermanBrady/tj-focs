import java.util.Arrays;

public class ShapeDemo
{
   public static void main(String[] args)
   {
      Shape t = new Triangle(5, 6, 7);  // Note the reference is a Shape!  This only works if Triangle implements Shape.
      System.out.println(t); // This will work if toString() is overridden correctly.
      System.out.println("Triangle area " + t.getArea() + " and perimeter " + t.getPerimeter());
      
      Shape c = new Circle(11.5);
      System.out.println(c);
      System.out.println("Circle area " + c.getArea() + " and circumference " + c.getPerimeter());
      
      Shape s = new Square(4.5);
      System.out.println(s);
      System.out.println("Square area " + s.getArea() + " and perimeter " + s.getPerimeter());
      
      Shape r = new Rectangle(9, 10.3);
      System.out.println(r);
      System.out.println("Rectangle area " + r.getArea() + " and perimeter " + r.getPerimeter());
      
      Shape p = new Parallelogram(6, 4, 3.375);
      System.out.println(p);
      System.out.println("Parallelogram area " + p.getArea() + " and perimeter " + p.getPerimeter());
   }
}