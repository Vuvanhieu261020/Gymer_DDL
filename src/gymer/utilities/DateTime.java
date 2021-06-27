/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.utilities;
import java.util.*;
import java.text.*;
import java.time.LocalDateTime;
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
        
        public static String getDateandTime(){
            LocalDateTime myObj = LocalDateTime.now();
            String datetime = myObj.toString();
            String date = datetime.substring(0,10);
            String time = datetime.substring(11,19);
            String result = date + " " + time;
            return result;
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
        
        
        public static String convertReadable_time (String input){
            String date;
            String month;
            String year;
            year = input.substring(0, 4);
            month = input.substring(5,7);
            date = input.substring(8,10);
            String result = date + "-" + month + "-" + year + " " + input.substring(11,19);
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
