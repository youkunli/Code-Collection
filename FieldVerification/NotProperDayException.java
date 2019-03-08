public class NotProperDayException extends Exception {
    private static final long serialVersionUID = 1L;
    private int day;
    public NotProperDayException(int day) {
        super("Not proper day.");
        this.day = day;
    }
    public String toString(){
        return getMessage();
    }
    public NotProperDayException(String msg){
        super (msg);
    }
    public NotProperDayException(Throwable cause){
        super (cause);
    }
    public NotProperDayException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public int getDay() {
        return (day);
    }
}