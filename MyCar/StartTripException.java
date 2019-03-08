public class StartTripException extends Exception {
    private static final long serialVersionUID = 1L;
    private double startTrip;
    public String toString(){
        return getMessage();
    }
    public StartTripException(double startTrip) {
        super("Not proper startTrip.");
        this.startTrip = startTrip;
    }
    public StartTripException(String msg){
        super (msg);
    }
    public StartTripException(Throwable cause){
        super (cause);
    }
    public StartTripException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public double getStartTrip() {
        return (startTrip);
    }
}
