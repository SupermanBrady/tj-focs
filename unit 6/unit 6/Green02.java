import java.util.Scanner;
import java.util.Arrays;

public class Green02

{
   public static void main(String[] args)
   
   {
      Scanner in = new Scanner(System.in); //remember to import!
      System.out.print("Please type a string: ");
      String s = in.nextLine();
      
      System.out.println("#1: " + s.charAt(2));
      System.out.println("#2: " + s.charAt(4));
      System.out.println("#3: " + s.length());
      System.out.println("#4: " + s.charAt(0));
      System.out.println("#5: " + s.charAt(s.length() - 1));
      System.out.println("#6: " + s.charAt(s.length() - 2));
      System.out.println("#7: " + s.substring(3, 8));
      System.out.println("#8: " + s.substring(s.length()-5, s.length()));
      System.out.println("#9: " + s.substring(3, s.length()));
      System.out.println("#10: " + s.toLowerCase());
      System.out.println("#11: " + s.toUpperCase());
      
      String[] letters = new String[s.length()];
      for (int i = 0; i < s.length(); i++)
         letters[i] = s.substring(i, i+1);
      System.out.println("#12: " + Arrays.toString(letters));
      
      String temp = s.substring(0, s.length() - 1);
      System.out.println("#13: " + temp);
      
      temp = s.substring(1, s.length());
      System.out.println("#14: " + temp);
      
      int count = 0;
      for (int i = 0; i < s.length(); i++){
         if (s.charAt(i) == 'e')
            count++;
      }
      System.out.println("#15: " + count);
      
      int count2 = 0;
      for (int i = 0; i < s.length(); i++){
         if (s.charAt(i) == 'e' || s.charAt(i) == 'E')
            count2++;
      }
      System.out.println("#16: " + count2);
      
      int vowcount = 0;
      String vowels = "aeiouAEIOU";
      for (int i = 0; i < s.length(); i++){ // loop thru the string
         for (int x = 0; x < vowels.length(); x++){ // loop thru vowels
            if (s.charAt(i) == vowels.charAt(x))
               vowcount++;
         }
      }
      System.out.println("#17: " + vowcount);
      
      char[] letters2 = new char[vowcount];
      int y = 0;
      for (int i = 0; i < s.length(); i++){ // loop thru string
         for (int x = 0; x < vowels.length(); x++){ // loop thru vowels
            if (s.charAt(i) == vowels.charAt(x)){
               letters2[y] = s.charAt(i);
               y++;
            }
         }
      }
      System.out.println("#18: " + Arrays.toString(letters2));
      
      String everyother = "";
      for (int i = 0; i < s.length(); i++)
         if (i % 2 == 0)
            everyother += s.substring(i, i+1);  
      System.out.println("#19: " + everyother);  
      
      String everyother1 = "";
      for (int i = 0; i < s.length(); i++)
         if (i % 2 != 0)
            everyother1 += s.substring(i, i+1);  
      System.out.println("#20: " + everyother1);  
      
      String[] combos = new String[s.length() - 1]; 
      for (int i = 0; i < combos.length; i++){
         combos[i] = s.substring(i, i+2);
      }
      System.out.println("#21: " + Arrays.toString(combos));
      
      String exclaim = "";
      for (int i = 0; i < s.length(); i++){
         if (i % 3 == 0)
            exclaim += "!";
         else
            exclaim += s.charAt(i);
      }
      System.out.println("#22: " + exclaim);
      
      String exclaim2 = "";
      for (int i = 0; i < s.length(); i++){
         if ((i+1) % 3 == 0)
            exclaim2 += "!";
         else
            exclaim2 += s.charAt(i);
      }
      System.out.println("#23: " + exclaim2);
   }
}