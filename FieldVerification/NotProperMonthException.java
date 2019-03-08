public class NotProperMonthException extends Exception {
    private static final long serialVersionUID = 1L;
    private int month;
    public String toString(){
        return getMessage();
    }
    public NotProperMonthException(int month) {
        super("Not proper month.");
        this.month = month;
    }
    public NotProperMonthException(String msg){
        super (msg);
    }
    public NotProperMonthException(Throwable cause){
        super (cause);
    }
    public NotProperMonthException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public int getMonth() {
        return (month);
    }
}