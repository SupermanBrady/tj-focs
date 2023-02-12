public interface Plant
{
   public int getHeight();
   public int getBlooms();
   public String getSunlight();
   public int getValue();
   public void setSunlight(String newSun);
   public void setWater(double tablespoons);
   public void grow();
   public int trim();
   public void statusReport();
   public boolean isAlive();
   //8) Why doesn't this interface need toString() defined?
   // A: nothing special specific to this game needs to happen, so it can use java's default toString method.
}