import java.util.Arrays;

public class AnnouncerDemo
{
   public static void main(String args[])
   {
      Announcer one = new Announcer();
      Announcer two = new Announcer("Python is great for lists!");
      one.announce();
      two.announce();
      
      System.out.println(one.getMessage());
      System.out.println(one.sameMessage(two));
      
      one.setMessage("Both have strengths and weaknesses!");
      one.announce();
      
      Announcer three = new Announcer("I like to yell!", 6);
      three.announce();
      
      //This demonstrates good object design
      //We added protection so that you can't set numTimes to a neg number
      //See what happens when this runs:
      three.setNumTimes(-5);
   }
}