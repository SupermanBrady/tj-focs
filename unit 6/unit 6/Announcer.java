public class Announcer
{
   //fields:
   private String message;
   private int numTimes;
   
   //constructors:
   public Announcer()
   {
      message = "Java is awesome for object oriented programming!";
      numTimes = 1;
   }
   public Announcer(String customMessage)
   {
      message = customMessage;
      numTimes = 1;
   }
   public Announcer(String customMessage, int customNumTimes)
   {
      message = customMessage;
      numTimes = customNumTimes;
   }
   
   //accessor & modifier instance methods:
   public void setMessage(String customMessage)
   {
         message = customMessage;
   }
   public String getMessage()
   {
      return message;
   }
   public void setNumTimes(int customNumTimes)
   {
      if(customNumTimes >= 0)
         numTimes = customNumTimes;
      else
         System.out.println("That is a bad number of times.");
   }
   public int getNumTimes()
   {
      return numTimes;
   }
   
   //other instance methods:
   public boolean sameMessage(Announcer other)
   {
      return other.getMessage().equals(message);
   }
   public void announce()
   {
      for(int i = 0; i < numTimes; i++)
      {
         System.out.println("I HAVE AN IMPORTANT ANNOUNCEMENT: " + message);
      }
   }
}