import java.util.Arrays;

public class BubbleSorter extends MeasureSorter
{
   public BubbleSorter(String filename) throws Exception
   {
      super(filename);
   }
   
   public void bubbleUp() //go from left to right through the array once, swapping any out of order pairs
   {
      int N = measures.length;
      for(int j = 0; j < N - 1; j++) //N - 1 because the last *pair* starts at the SECOND to last *index*
      {
         if(measures[j].compareTo(measures[j+1]) > 0)  //if the Measure at index j is bigger than the Measure at index j+1
         {
            swap(j, j+1);
         }
      }
   }
   
   public void sortMe() //For class BubbleSorter, this implements bubble sort!
   {
      System.out.println(Arrays.toString(measures)); //print the starting state of the array
      int N = measures.length;
      for(int i = 0; i < N - 1; i++) //N - 1 again! Each bubble pass is guaranteed to place one more element correctly, but if 
      {                              //I correctly place N - 1 elements, then the last element is also automatically correct.
         bubbleUp();
         System.out.println(Arrays.toString(measures)); //print the array after each pass of bubbling
      }
      
   }
}