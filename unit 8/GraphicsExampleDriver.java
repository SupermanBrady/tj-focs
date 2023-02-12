    //Torbert, e-mail: smtorbert@fcps.edu	
	 //version 6.17.2003

   import javax.swing.JFrame;
    public class GraphicsExampleDriver
   {
       public static void main(String[] args)
      {
         JFrame frame = new JFrame("Build a House");
         frame.setSize(400, 425);      //In Windows, the menu bar at the top is 25 pixels tall...
         frame.setLocation(100, 50);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         frame.setContentPane(new Popcorn());    //...so we would expect the content pane to be 400x400.
         frame.setVisible(true);
      }
   }