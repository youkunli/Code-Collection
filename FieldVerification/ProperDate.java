import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProperDate extends GregorianCalendar  {
    private static final long serialVersionUID = 1L;
    public ProperDate(String dateDsc)throws NotProperYearException,NotProperMonthException,NotProperDayException,Exception{
        int year = 0,month = 0,day = 0;
        dateDsc = dateDsc.trim();
        Pattern pat1 = Pattern.compile("(\\d{4})/(\\d{2})/(\\d{2})"); //1989/03/20
        Pattern pat2 = Pattern.compile("(\\d{2})/(\\d{2})/(\\d{4})"); //20/03/2018
        Matcher m1 = pat1.matcher(dateDsc);
        Matcher m2 = pat2.matcher(dateDsc);

        if(m1.find()){
            try{
                String field = m1.group(1);
                year = Integer.parseInt(field);
                field = m1.group(2);
                month = Integer.parseInt(field);
                field = m1.group(3);
                day = Integer.parseInt(field);
            }catch (Exception ex){
                throw new Exception();
            }
        }
        else if(m2.find()){
            try{
                String field = m2.group(3);
                year = Integer.parseInt(field);
                field = m2.group(2);
                month = Integer.parseInt(field);
                field = m2.group(1);
                day = Integer.parseInt(field);
            }catch (Exception ex){
                throw new Exception();
            }
        }
        else{
            throw new Exception();
        }
        if(year>2100 || year<1900){
            throw new NotProperYearException(year);
        }
        if(month>12 || month<1){
            throw new NotProperMonthException(month);
        }
        if((year%4==0&&year%100!=0)||year%400==0){
            if(month==2){
                if(day<1 || day>29){
                    throw new NotProperDayException(day);
                }
            }
            else if(month==4||month==6||month==9||month==11){
                if(day<1 || day>30){
                    throw new NotProperDayException(day);
                }
            }
            else{
                if(day<1 || day>31){
                    throw new NotProperDayException(day);
                }
            }
        }
        else{
            if(month==2){
                if(day<1 || day>28){
                    throw new NotProperDayException(day);
                }
            }
            else if(month==4||month==6||month==9||month==11){
                if(day<1 || day>30){
                    throw new NotProperDayException(day);
                }
            }
            else{
                if(day<1 || day>31){
                    throw new NotProperDayException(day);
                }
            }
        }
    }
}
