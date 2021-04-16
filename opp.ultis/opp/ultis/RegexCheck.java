package opp.ultis;
import java.util.regex.*;

public class RegexCheck {
    public boolean CheckDigit (String input){
        Pattern ptern = Pattern.compile("[0-9]*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = ptern.matcher(input);
        boolean result = matcher.matches();
        return result;
    }

    public boolean CheckMail (String input){
        Pattern ptern = Pattern.compile(".*@.*", Pattern.CASE_INSENSITIVE);
        Matcher matcher = ptern.matcher(input);
        boolean result = matcher.matches();
        return result;
    }
}