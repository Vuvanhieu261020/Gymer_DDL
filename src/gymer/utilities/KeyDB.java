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


// class nay dung de tao key trong db


public class KeyDB {
    
    public static String genKey (){
        Calendar cal = Calendar.getInstance();
        long timeNumber = cal.getTimeInMillis();
        Long longLong = new Long(timeNumber);
        // sub string de la 7 vi neu return ca? longlong thi` qua dai`
        String key = longLong.toString().substring(7);
        return key;
    }
    
}
