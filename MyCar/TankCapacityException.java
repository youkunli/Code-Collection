public class TankCapacityException extends Exception {
    private static final long serialVersionUID = 1L;
    private double tankCapacity;
    public String toString(){
        return getMessage();
    }
    public TankCapacityException(double tankCapacity) {
        super("Not proper tankCapacity.");
        this.tankCapacity = tankCapacity;
    }
    public TankCapacityException(String msg){
        super (msg);
    }
    public TankCapacityException(Throwable cause){
        super (cause);
    }
    public TankCapacityException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public double getTankCapacity() {
        return (tankCapacity);
    }
}
