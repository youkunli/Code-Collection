public class TankItException extends Exception {
    private static final long serialVersionUID = 1L;
    private double tankIt;
    public String toString(){
        return getMessage();
    }
    public TankItException(double tankIt) {
        super("Not proper tankIt.");
        this.tankIt = tankIt;
    }
    public TankItException(String msg){
        super (msg);
    }
    public TankItException(Throwable cause){
        super (cause);
    }
    public TankItException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public double getTankIt() {
        return (tankIt);
    }
}