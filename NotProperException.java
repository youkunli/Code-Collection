public class NotProperException extends Exception {
    private static final long serialVersionUID = 1L;
    private String name;
    public String toString(){
        return getMessage();
    }
    public NotProperException(String name){
        super ("Not proper name.");
        this.name = name;
    }
    public NotProperException(Throwable cause){
        super (cause);
    }
    public NotProperException(String msg, Throwable cause) {
        super(msg, cause);
    }
    public String getName() {
        return (name);
    }
}