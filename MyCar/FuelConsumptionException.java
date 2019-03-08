public class FuelConsumptionException extends Exception {
    private static final long serialVersionUID = 1L;
    private double fuelConsumption;
    public String toString(){
        return getMessage();
    }
    public FuelConsumptionException(double fuelConsumption) {
        super("Not proper fuelConsumption.");
        this.fuelConsumption = fuelConsumption;
    }
    public FuelConsumptionException(String msg){
        super (msg);
    }
    public FuelConsumptionException(Throwable cause){
        super (cause);
    }
    public FuelConsumptionException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public double getFuelConsumption() {
        return (fuelConsumption);
    }
}
