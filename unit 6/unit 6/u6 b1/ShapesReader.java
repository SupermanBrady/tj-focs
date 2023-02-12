import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public class ShapesReader
{
   //fields
   private Shape[] shapes;
   
   //constructors
   public ShapesReader(String filename) throws Exception
   {
      Scanner infile = new Scanner( new File(filename) ); 
      int numItems = Integer.parseInt(infile.nextLine());
      shapes = new Shape[numItems];
      
      for(int i = 0; i < numItems; i++)
      {
         String[] temp = infile.nextLine().strip().split(" ");
         if (temp[0].equals("Triangle"))
         {
            double side1 = Double.parseDouble(temp[1]);
            double side2 = Double.parseDouble(temp[2]);
            double side3 = Double.parseDouble(temp[3]);
            shapes[i] = new Triangle(side1, side2, side3);
         }
         else if (temp[0].equals("Square"))
         {
            double side1 = Double.parseDouble(temp[1]);
            shapes[i] = new Square(side1);
         }
         else if (temp[0].equals("Rectangle"))
         {
            double side1 = Double.parseDouble(temp[1]);
            double side2 = Double.parseDouble(temp[2]);
            shapes[i] = new Rectangle(side1, side2);
         }
         else if (temp[0].equals("Circle"))
         {
            double radius = Double.parseDouble(temp[1]);
            shapes[i] = new Circle(radius);
         }
         else
         {
            double base = Double.parseDouble(temp[1]);
            double slantHeight = Double.parseDouble(temp[2]);
            double verticalHeight = Double.parseDouble(temp[3]);
            shapes[i] = new Parallelogram(base, slantHeight, verticalHeight);
         }
      }
   }
   
   //overriding stuff
   public String toString()
   {
      return Arrays.toString(shapes);
   }
   public void sortMe()
   {
      Arrays.sort(shapes);
   }
}