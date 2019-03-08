public class NameGenderMismatchException extends Exception{
    private static final long serialVersionUID = 1L;
    private Gender gender;
    private String name;
    public String toString(){
        return getGender()+" "+getName()+" "+getMessage();
    }
    public NameGenderMismatchException(String msg){
        super (msg);
    }
    public NameGenderMismatchException(Throwable cause){
        super (cause);
    }
    public NameGenderMismatchException(String msg, Throwable cause){
        super (msg,cause);
    }
    public NameGenderMismatchException(String name, Gender g) {
        super("Name Gender Mismatch");
        this.name=name;
        this.gender=g;
    }
    public Gender getGender() {
        return(gender);
    }
    public String getName() {
        return (name);
    }
}