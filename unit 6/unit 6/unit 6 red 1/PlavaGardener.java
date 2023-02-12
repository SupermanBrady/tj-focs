import java.util.Scanner;

public class PlavaGardener
{
   //Global variables
   //1) How are these like fields?  How are they different? 
   //A: they're like fields because they are variables that contain information/stats. They are different because they are public and static.
   public static int money;
   public static Scanner in;
   public static Plant[] plants;
   
   public static void reportAllStatus()
   {
      boolean some = false;
      for(int i = 0; i < plants.length; i++)
      {
         if(plants[i] != null) //2) What is this line for? A: Makes sure the slot at this index is not empty; player has a plant 
         {
            some = true;
            System.out.println("In plot number " + i + ":");
            plants[i].statusReport();
            System.out.println();
         }
      }
      if(!some)
      {
         System.out.println("You don't have any plants!  Buy some at the store!");
      }
   }
   public static void waterAllPlants()
   {
      System.out.println("Most plants need somewhere between 0 and 2 tablespoons of water per day per 10 inches of height.");
      System.out.println("Plava plants might be unpredictable, though!");
      System.out.println("For each plant below, give a decimal value of tablespoons of water to give per day.");
      for(int i = 0; i < plants.length; i++)
      {
         if(plants[i] != null)
         {
            System.out.print("For plot number " + i + ", your " + plants[i] + " should get:");
            String inpt = in.nextLine();
            double water = Double.parseDouble(inpt);
            plants[i].setWater(water);  //3) This line relies on the Plant interface to work.  How? We do not know whether or not it is a Cactus or a Rose so it uses the interface to deal with that
         }
      }
   }
   public static void sunlightAllPlants()
   {
      System.out.println("You have three options for the sunlight each plant gets - direct, indirect, or shade.");
      System.out.println("For each plant below, either type what sunlight you'd like it to get, or just type 'x' if you want to leave it where it is.");
      for(int i = 0; i < plants.length; i++)
      {
         if(plants[i] != null)
         {
            System.out.println("For plot number " + i + ", your " + plants[i] + " is currently getting " + plants[i].getSunlight() + ".");
            System.out.print("Type a different option to change, or 'x' to keep as is: ");
            String inpt = in.nextLine();
            plants[i].setSunlight(inpt); //4) Why don't I need to check to see if inpt has a valid answer before calling this?
            //A: If it's invalid, the sunlight will default to "shade", as the constructor says
         }
      }
   }
   public static void growAllPlants()
   {
      for(int i = 0; i < plants.length; i++)
      {
         if(plants[i] != null)
         {
            plants[i].grow(); 
         }
      }
   }
   public static Plant goShopping()
   {
      int count = 0;
      for(int i = 0; i < plants.length; i++)
      {
         if (plants[i] == null)
            count++;
      }
      if (count > 0) 
      {
         System.out.println("Welcome to the Plava plant store!");
         System.out.println("I currently have two options for sale.");
         System.out.println("1) Plava Rose -- $2");
         System.out.println("2) Plava Cactus -- $5");
         System.out.println("3) Plava Shadyboi -- $1");
         System.out.println("4) Plava Colossalboi -- $1");
         System.out.println("You currently have $" + money + ". ");
         System.out.print("What would you like to buy (type the number of the option you choose or 0 to buy nothing)? ");
         String inpt = in.nextLine();
         int choice = Integer.parseInt(inpt);
         if(choice == 1 && money >= 2)
         {
            money -= 2;
            return new PlavaRose();
         }
         else if(choice == 2 && money >= 5)
         {
            money -= 5;
            return new PlavaCactus();
         }
         else if(choice == 3 && money >= 1)
         {
            money -= 1;
            return new PlavaShadyboi();
         }
         else if(choice == 4 && money >= 1)
         {
            money -= 1;
            return new PlavaColossalboi();
         }
         System.out.println("You don't have enough money for that!");
         return null;
      }
      else
      {
         System.out.println("Welcome to the Plava plant store!");
         System.out.println("Sorry, but your plant slots are all full. A new plant cannot be bought. Bye");
         return null;
      }
   }
   public static void gameLoop()
   {
      while(true)  //5) This looks like it will go on forever!  How does this loop end? 
      // A: It ends when you type option 0, which quits the game, or when you type an invalid option number
      {
         System.out.println();
         System.out.println("You can choose any of the following options:");
         System.out.println("1) Check on the status of your plants");
         System.out.println("2) Decide how much to water each plant this week");
         System.out.println("3) Decide how much sunlight to give each plant this week");
         System.out.println("4) Wait a week to see how your plants grow/don't grow");
         System.out.println("5) Buy a new plant from the store");
         System.out.println("6) Throw away a plant that you own");
         System.out.println("7) Cut a flower off of one of your plants and sell it");
         System.out.println("0) Quit the game (your progress will not be saved)");
         System.out.print("Type the number of your choice: ");
         String inpt = in.nextLine();
         int choice = Integer.parseInt(inpt);
         if(choice == 1)
         {
            reportAllStatus();
         }
         else if(choice == 2)
         {
            waterAllPlants();
         }
         else if(choice == 3)
         {
            sunlightAllPlants();
         }
         else if(choice == 4)
         {
            System.out.println("A week passes.  Check your plant status to see how they did!");
            growAllPlants();
         }
         else if(choice == 5)
         {
            Plant temp = goShopping();
            if(temp != null)
            {
               int plot;
               for(plot = 0; plot < plants.length; plot++)
               {
                  if(plants[plot] == null)
                  {
                     plants[plot] = temp;
                     System.out.println("Your new plant is in plot #" + plot);
                     System.out.println();
                     break;
                  }
               }      
            }
         }
         else if(choice == 6)
         {
            System.out.print("Which plot would you like to throw away? ");
            String inpt2 = in.nextLine();
            int choice2 = Integer.parseInt(inpt2);
            plants[choice2] = null;
         }
         else if(choice == 7)
         {
            System.out.print("Which plot would you like to trim a bloom from? ");
            String inpoot = in.nextLine();
            int plotNum = Integer.parseInt(inpoot);
            if (plants[plotNum] == null)
               System.out.println("There are no plants in this plot! Please choose another or fill this plot with a plant");
            else
            {
               System.out.print("How many blooms would you like to trim off?");
               String inpoot2 = in.nextLine();
               int trimNum = Integer.parseInt(inpoot2);
               if (trimNum <= plants[plotNum].getBlooms())
               {
                  int cutted = 0;
                  for (int i = 0; i < trimNum; i++)
                     cutted += plants[plotNum].trim();
                  money += cutted * plants[plotNum].getValue(); 
                  System.out.println("You cut " + cutted + " blooms and your money is now " + money);
               }
               else
                  System.out.println("You don't have enough blooms to cut!");;           
            }
         }
         else
         {
            return;  //6) Why does this have nothing after it?  What does this do?
            // A: A return with nothing after ends the loop. This else statement accounts for quitting the game or typing an invalid option, both of which would end the game. 
         }
      }
   }
   public static void main(String[] args)
   {
      //7) Over the next three lines, the variable types are NOT given.  Why?
      // A: they were global variables that were already defined earlier.
      in = new Scanner(System.in);
      money = 10;
      plants = new Plant[10];
      
      System.out.println("Welcome to Plava Gardener!");
      gameLoop();
   }
}