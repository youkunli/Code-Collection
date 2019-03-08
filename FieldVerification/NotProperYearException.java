public class NotProperYearException extends Exception {
    private static final long serialVersionUID = 1L;
    private int year;
    public NotProperYearException(int year) {
        super("Not proper year.");
        this.year = year;
    }
    public String toString(){
        return getMessage();
    }
    public NotProperYearException(String msg){
        super (msg);
    }
    public NotProperYearException(Throwable cause){
        super (cause);
    }
    public NotProperYearException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public int getYear() {
        return (year);
    }
}