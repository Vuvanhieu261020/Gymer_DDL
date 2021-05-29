/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gymer.utilities;
import java.util.regex.*;
public class Regex {
    
    public static boolean AlphabetCheck (String Input){
        Pattern ptn = Pattern.compile("[A-z]+");
        Matcher mc = ptn.matcher(Input);
        if (mc.find()){
            return true;
        }
        return false;
    }
    
    public static boolean NumericCheck (String Input){
        Pattern ptn = Pattern.compile("[0-9]+");
        Matcher mc = ptn.matcher(Input);
        if (mc.find()){
            return true;
        }
        return false;
    }
    public static boolean EmailCheck (String Input){
        Pattern ptn = Pattern.compile(".+@.+");
        Matcher mc = ptn.matcher(Input);
        if (mc.find()){
            return true;
        }
        return false;
    }
}
