public class ShapesReaderDemo
{
   public static void main(String[] args) throws Exception
   {
      ShapesReader demo = new ShapesReader("ShapesTest.txt");
      System.out.println(demo);
      demo.sortMe();
      System.out.println(demo);
   }
}