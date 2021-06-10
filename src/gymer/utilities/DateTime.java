/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.utilities;
import gymer.DAO.EquipmentImp;
import java.util.*;
import java.text.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author luyen
 */
public class DateTime {
        public static String getTimeFormat1(){
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date();
            return dateFormat.format(date);
        }
        public static String getTimeFormat2(){
            DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            Date date = new Date();
            return dateFormat.format(date);
        }
        
        
        public static String plusDate (String inDate, int Times) throws ParseException{
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date preproDate = new SimpleDateFormat("yyyy-MM-dd").parse(inDate);
            Calendar c = Calendar.getInstance(); 
            c.setTime(preproDate); 
            c.add(Calendar.DATE, Times);
            preproDate = c.getTime();
            return dateFormat.format(preproDate);
        }
}
