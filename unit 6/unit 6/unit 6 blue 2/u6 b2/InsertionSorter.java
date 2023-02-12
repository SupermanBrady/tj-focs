import java.util.Arrays;

public class InsertionSorter extends MeasureSorter
{
   public InsertionSorter(String filename) throws Exception
   {
     super(filename);
   }
      
   public void sortMe()
   {
      for (int i = 1; i < measures.length; i++)
      {
         int x = i;
         while (x > 0 && measures[x].compareTo(measures[x-1]) < 0)
         {
            swap(x, x-1);
            x = x - 1;
         }
       System.out.println(Arrays.toString(measures));
      }
   }
}