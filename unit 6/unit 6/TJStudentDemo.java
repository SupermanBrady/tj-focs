public class TJStudentDemo
{
   public static void main(String[] args)
   {
      TJStudent a = new TJStudent();
      a.summarize();
      a.setName("Java McProgrammy");
      a.summarize();
      System.out.println(a.getName());
      System.out.println(a.getYear());
      System.out.println(a.getAge());
      a.setYear("Sophomore");
      a.setYear("Junior");
      a.setYear("Senior");
      a.setYear("Freshman");
      a.setYear("Middle School");
      a.setAge(16);
      a.setAge(23);
      System.out.println();
      
      TJStudent b = new TJStudent("Lady Godiva", "Sophomore", 16);
      b.summarize();
      if(a.sameAge(b))
      {
         System.out.println(a.getName() + " and " + b.getName() + " are both " + a.getAge() + ".");
      }
      else
      {
         System.out.println(a.getName() + " and " + b.getName() + " are not the same age.");
      }
      b.setAge(15);
      if(a.sameAge(b))
      {
         System.out.println(a.getName() + " and " + b.getName() + " are both " + a.getAge() + ".");
      }
      else
      {
         System.out.println(a.getName() + " and " + b.getName() + " are not the same age.");
      }
      System.out.println();
      
      TJStudent c = new TJStudent("Bad Data", "Grown Up", 27);
      c.summarize();
      if(a.sameYear(c))
      {
         System.out.println(a.getName() + " and " + c.getName() + " are both in their " + a.getYear() + " year.");
      }
      else
      {
         System.out.println(a.getName() + " and " + c.getName() + " are not in the same year.");
      }
   }
}