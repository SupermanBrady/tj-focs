import java.util.Arrays;

public class SelectionSorter extends MeasureSorter
{
   public SelectionSorter(String filename) throws Exception
   {
      super(filename);
   }
   
   public int findMinIndex(int startingIndex)  //Write and test this first!
   {
      int minIndex = startingIndex;
      for (int i = startingIndex; i < measures.length; i++)
      {
         if(measures[i].compareTo(measures[minIndex]) < 0)
            minIndex = i;            
      }
      return minIndex;
   }
      
   public void sortMe()  //For SelectionSorter to compile, this class needs to implement the abstract method sortMe() in MeasureSorter.  Right now the implementation is empty, but it will compile!  This allows you to test findMinIndex separately.
   {
      System.out.println(Arrays.toString(measures));
      for (int i = 0; i < measures.length - 1; i ++)
      {
         int swapI = findMinIndex(i);
         swap(i, swapI);
         System.out.println(Arrays.toString(measures));
      }
   }
}