/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.utilities;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;    
/**
 *
 * @author luyen
 */
public class getDate { 
   public static String getTime (){  
       DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");  
       LocalDateTime now = LocalDateTime.now();  
       String result = now.toString();
       return result;
   }
}
