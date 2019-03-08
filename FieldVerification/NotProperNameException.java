public class NotProperNameException extends Exception {
    private static final long serialVersionUID = 1L;
    private String name;
    public String toString(){
        return getMessage();
    }
    public NotProperNameException(String name){
        super ("Not proper name.");
        this.name = name;
    }
    public NotProperNameException(Throwable cause){
        super (cause);
    }
    public NotProperNameException(String msg, Throwable cause){
        super (msg,cause);
    }
    public String getName() {
        return (name);
    }
}