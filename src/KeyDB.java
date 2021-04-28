import java.util.Calendar;

public class KeyDB {
   public static String genKey(String[] args) 
   {
       Calendar cal = Calendar.getInstance();
       long timeNumber = cal.getTimeInMillis();
       Long longLong = new Long(timeNumber);
       String key = longLong.toString();
       return key;
   }
}