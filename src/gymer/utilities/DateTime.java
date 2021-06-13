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
        
        public static String convertReadable (String input){
            String date;
            String month;
            String year;
            year = input.substring(0, 4);
            month = input.substring(5,7);
            date = input.substring(8,10);
            String result = date + "-" + month + "-" + year;
            return result;
        }
        
        public static String convertDB (String input){
            String date;
            String month;
            String year;
            year = input.substring(6, 10);
            month = input.substring(3,5);
            date = input.substring(0,2);
            String result = year + "-" + month + "-" + date;
            return result;
        }
}
