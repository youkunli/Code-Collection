import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Currency {
    private String name;
    private String code;
    private double rate;
    private int units;
    //   <mid-rate currency="Euro" units="1" code="EUR">4.2966</mid-rate>
    public Currency(String line) throws Exception {
        Pattern pat = Pattern.compile("currency=\"(\\w+).+units=\"(\\d+).+code=\"(\\w+).+>([-+]?[0-9]*\\.?[0-9]+)");
        Matcher m = pat.matcher(line);
        if(!m.find()){
            throw new Exception();
        }
        name = m.group(1);
        code = m.group(3);
        try{
            String field = m.group(2);
            units = Integer.parseInt(field);
            field = m.group(4);
            rate = Double.parseDouble(field);
        }catch (Exception ex){
            throw new Exception();
        }
    }

    public String getName(){
        return(name);
    }

    public String getCode(){
        return(code);
    }

    public double getRate(){
        return rate;
    }

    public int getUnits(){
        return units;
    }

    public String toString(){
        NumberFormat nf = NumberFormat.getNumberInstance(Locale.GERMAN);
        nf.setMaximumFractionDigits(4);
        String result = code+"\t["+units+"]\t"+nf.format(rate);
        return(result);
    }
}
