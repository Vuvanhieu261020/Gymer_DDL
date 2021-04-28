/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.utilities;
import java.util.Calendar;
/**
 *
 * @author luyen
 */
public class KeyDB {
    
    public static String genKey (){
        Calendar cal = Calendar.getInstance();
        long timeNumber = cal.getTimeInMillis();
        Long longLong = new Long(timeNumber);
        String key = longLong.toString();
        return key;
    }
    
}
