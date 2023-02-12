public class MeasureDemo
{
   public static void main(String[] args) throws Exception
   {
      //First: bubble sort.  This has been written for you, so you should be able to compile everything and run this now.
      
      System.out.println("Bubble Sort:");
      BubbleSorter bub = new BubbleSorter("measures_10.txt");
      bub.sortMe();
      System.out.println();
      
      
      //Second: selection sort.  Uncomment the first block of code to test findMinIndex, then when that's working complete the selection 
      //sort algorithm and uncomment the next block of code to test that.
      
      /*
      SelectionSorter sel = new SelectionSorter("measures_30.txt");  //I recommend using measures_30 for this but you can try the others too!
      for(int i = 0; i < sel.measures.length; i++)  //This works because measures is public
      {
         System.out.println("The Measure at index " + i + " is: " + sel.measures[i]);  //This works because measures is public
      }
      int startIndex = 0;  //Try different indices here; do several tests and spot check them for accuracy.
      int mI = sel.findMinIndex(startIndex);
      System.out.println("Your method says that the minimum value from index " + startIndex + " to the end of the array is at index " + mI +".  Make sure that's correct by looking at the output above!");
      */
      
      
      System.out.println("Selection Sort:");
      SelectionSorter sel = new SelectionSorter("measures_10.txt");
      sel.sortMe();
      System.out.println();
      
      
      
      //Third: insertion sort.  This one is up to you!  Feel free to add code to this demo to test something if you need to!
      
      
      System.out.println("Insertion Sort:");
      InsertionSorter in = new InsertionSorter("measures_10.txt");
      in.sortMe();
      System.out.println();
      
   }
}