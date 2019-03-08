import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LastName {
    public void checkName(String name)throws NotProperException{
        name = name.trim();
        Pattern pat1 = Pattern.compile("[A-Z][a-z]+\\-[A-Z]");
        //Pattern pat2 = Pattern.compile("[A-Z][a-z]+\\-\\b");
        //Pattern pat3 = Pattern.compile("[A-Z][a-z]+\\-[");
        Matcher m1 = pat1.matcher(name);
        //Matcher m2 = pat2.matcher(name);
        //Matcher m3 = pat3.matcher(name);
        if(!m1.find()){
            throw new NotProperException(name);
        }

    }
}