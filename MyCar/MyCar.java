import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyCar {
    private double tankCapacity;
    private double tankLevel;
    private double fuelConsumption;
    private CarMakers maker;
    private double mileage;
    private Vector trip;


    public MyCar(String line) throws TankCapacityException,FuelConsumptionException{
        mileage = 0.0;
        tankLevel = 0.0;
        trip = new Vector();
        line = line.trim();
        Pattern pat = Pattern.compile("(\\w+)[\\t\\;\\,\\s](\\w+)[\\t\\;\\,\\s](\\w+)");
        Matcher m = pat.matcher(line);
        ///*
        if(m.find()){
            double tempTankCapacity = Double.valueOf(m.group(1));
            if(tempTankCapacity<20 || tempTankCapacity>80)
                throw new TankCapacityException(tempTankCapacity);
            tankCapacity = tempTankCapacity;

            double tempFuelConsumption = Double.valueOf(m.group(2));
            if(tempFuelConsumption<3 || tempFuelConsumption>20)
                throw new FuelConsumptionException(tempFuelConsumption);
            fuelConsumption = tempFuelConsumption;

            maker = CarMakers.convertString(m.group(3));
        }
        //*/

    }

    public void tankIt(double howMuch) throws TankItException{
        if((this.getFuelLevel()+howMuch)>tankCapacity)
            throw new TankItException(howMuch);
        tankLevel += howMuch;
        System.out.println("Successfully tank it "+howMuch+" liters, Current fuel level is "+this.getFuelLevel()+" liters.");
    }

    public void startTrip(double tripDistance) throws StartTripException{
        double temp = tripDistance*fuelConsumption/100.0;
        if(temp > tankLevel)
            throw new StartTripException(temp);
        tankLevel -= temp;
        mileage += tripDistance;
        trip.addElement(tripDistance);
        System.out.println("Successfully travel "+tripDistance+" kilometers.");
    }

    public double getMileage (){
        double totalMileage = 0.0;
        for(int i=0;i<trip.size();i++){
            totalMileage += Double.valueOf(trip.elementAt(i).toString());
        }
        System.out.println("Total mileage is "+totalMileage+" kilometers.");
        return totalMileage;
    }

    public double getLastTripDistance(){
        double lastTrip = 0.0;
        try{
            lastTrip = Double.valueOf(trip.lastElement().toString());
        }catch (Exception e){
            System.out.print("No Last trip.");
        }
        System.out.println("Last trip's distance is "+lastTrip+" kilometers.");
        return lastTrip;
    }

    public double getFuelLevel(){
        return tankLevel;
    }

    public String toString(){
        String carDescribe = "The car is a "+maker.getString()+"."+'\n'
                +"Tank capacity is "+tankCapacity+" liters."+'\n'
                +"Fuel consumption is "+fuelConsumption+" liters per 100 kilometers.";
        System.out.println(carDescribe);
        return carDescribe;
    }

 /*

    @Test
    public void main() throws Exception{
        MyCar myCar1 = new MyCar("100,10;BMW");
        MyCar myCar2 = new MyCar("50,2;BMW");
        MyCar myCar3 = new MyCar("50,10;qwer");
        System.out.println(myCar3.toString());
        MyCar myCar = new MyCar("50,10;FORD");
        System.out.println(myCar.toString());
        System.out.println("Current fuel level is "+myCar.getFuelLevel()+" liters");
        myCar.tankIt(60);
        myCar.tankIt(30);
        myCar.startTrip(10);
        System.out.println("Last trip distance is "+myCar.getLastTripDistance()+" kilometers");
        System.out.println("Current mileage is "+myCar.getMileage()+" kilometers");
        System.out.println("Current fuel level is "+myCar.getFuelLevel()+" liters");
        myCar.startTrip(20);
        myCar.startTrip(30);
        System.out.println("Last trip distance is "+myCar.getLastTripDistance()+" kilometers");
        System.out.println("Current mileage is "+myCar.getMileage()+" kilometers");
        System.out.println("Current fuel level is "+myCar.getFuelLevel()+" liters");
        System.out.println("Last trip distance is "+myCar.getLastTripDistance()+" kilometers");
    }

  */
}
