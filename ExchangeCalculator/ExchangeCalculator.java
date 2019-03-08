import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExchangeCalculator {
    private Vector<Currency> rates = new Vector<>();
    // accepted formats: buy 9990 USD or sell 9999 USD exit
    public void calculateRates()throws Exception{
        Scanner scInput = new Scanner(System.in);
        while(scInput.hasNextLine()){
            String line = scInput.nextLine().trim();
            if(line.equalsIgnoreCase("exit"))
                break;
            double result = calculate(line);
            System.out.print(line+"\t");
            if(result > 0)
                System.out.print("+");
            System.out.println(String.format("%.4f",result));
        }
        scInput.close();
    }
    protected double calculate(String line) throws Exception{
        String act;
        String code;
        int n;
        double zlt;
        // accepted formats: buy 9990 USD or sell 9999 USD exit
        Pattern pat = Pattern.compile("(\\w+).+\\b(\\d+).+\\b(\\w+)");
        Matcher m = pat.matcher(line);
        if(!m.find()){
            System.out.println("Format not recognized.");
            throw new Exception();
        }
        act = m.group(1);
        code = m.group(3);
        try{
            String field = m.group(2);
            n = Integer.parseInt(field);
            if(act.equalsIgnoreCase("buy")){
                n = -1*n;
            }
            else if(act.equalsIgnoreCase("sell")){
                n = 1*n;
            }
            else {
                System.out.println("Format not recognized.");
                return 0.0;
            }

            for(int i=0;i<rates.size();i++){
                if(rates.get(i).getCode().equalsIgnoreCase(code)){
                    zlt = rates.get(i).getRate()*n/rates.get(i).getUnits();
                    return zlt;
                }
            }

        }catch (Exception ex){
            throw new Exception();
        }
        System.out.println("Unknown currency.");
        return 0.0;  // to be replaced
    }
    public ExchangeCalculator(String fn) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fn));
        while(sc.hasNextLine()){
            String line = sc.nextLine();
            try{
                Currency c = new Currency(line);
                rates.addElement(c);
            }catch(Exception ex){
            }
        }
        sc.close();
    }

    public  static void main(String[] args)throws Exception{
        String fn = "ExchangeRates.txt";
        ExchangeCalculator calc = null;
        try{
            calc  = new ExchangeCalculator(fn);
        }catch (FileNotFoundException e){
            System.err.println("Unable to read exchange rates from the file:"+fn);
            System.exit(1);
        }
        calc.calculateRates();
        System.exit(0);
    }
}
