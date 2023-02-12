import java.io.File;
import java.util.Scanner;
import java.util.Arrays;

public abstract class MeasureSorter
{
   //fields
   public Measure[] measures;  //This is a public field because each class that extends this will need to access it directly!
   
   //constructor
   public MeasureSorter(String filename) throws Exception
   {
      Scanner infile = new Scanner( new File(filename) );
      int numitems = Integer.parseInt(infile.nextLine());
      measures = new Measure[numitems];
      for(int i = 0; i < numitems; i++)
      {
         measures[i] = makeMeasure(infile.nextLine());
      }
   }
   
   public Measure makeMeasure(String inVal)
   {
      inVal = inVal.strip();
      String[] vals = inVal.split(" ");
      int feet = Integer.parseInt(vals[0]);
      int inches = Integer.parseInt(vals[1]);
      return new Measure(feet, inches);
   }
   
   public String toString()
   {
      return Arrays.toString(measures);
   }
   
   public void swap(int i, int j)
   {
      Measure temp = measures[i];
      measures[i] = measures[j];
      measures[j] = temp;
   }
   
   public abstract void sortMe();
}