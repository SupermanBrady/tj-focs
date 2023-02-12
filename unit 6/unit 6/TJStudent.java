public class TJStudent
{
   //fields:
   private String name;
   private String year;
   private int age;
   
   //constructors:
   public TJStudent()
   {
      name = "TJ Student";
      year = "Freshman";
      age = 14;
   }
   public TJStudent(String customName, String customYear, int customAge)
   {
      name = customName;
      if (customYear.equals("Freshman") || customYear.equals("Sophomore") || customYear.equals("Junior") || customYear.equals("Senior"))
         year = customYear;  
      else {
         System.out.println("Error: " + customYear + " is not a valid year.");
         year = "Freshman"; 
      }
      if (customAge > 19 || customAge < 11)
      {
         System.out.println("Error: " + customAge + " is not a valid age.");
         age = 14;
      }
      else
         age = customAge;
   }
   
   //accessor & modifier instance methods:
   public void setName(String customName)
   {
      name = customName;
   }
   public String getName()
   {
      return name;
   }
   public void setYear(String customYear)
   {
      if (customYear.equals("Freshman") || customYear.equals("Sophomore") || customYear.equals("Junior") || customYear.equals("Senior"))
         year = customYear;  
      else
         System.out.println("Error: " + customYear + " is not a valid year.");
   }
   public String getYear()
   {
      return year;
   }
   public void setAge(int customAge)
   {
      if (customAge > 19 || customAge < 11)
         System.out.println("Error: " + customAge + " is not a valid age.");
      else
         age = customAge;
   }
   public int getAge()
   {
      return age;
   }
   
   //other instance methods:
   public boolean sameYear(TJStudent other)
   {
      return other.getYear().equals(year);
   }
   public boolean sameAge(TJStudent other)
   {
      return other.getAge() == age;
   }
   public void summarize()
   {
      System.out.println(name + " is a " + age + "-year-old " + year + ".");
   }
}