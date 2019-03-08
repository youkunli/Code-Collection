import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class FirstNames {
    private Set<String> boyName = new HashSet<>();
    private Set<String> girlName = new HashSet<>();

    public FirstNames (String fileName)throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fileName));
        if(sc.nextLine().trim().equalsIgnoreCase("###Boys'")){
            while(sc.hasNext()){
                String name = sc.nextLine().trim();
                if(name.equalsIgnoreCase("#### Girls'")){
                    break;
                }
                boyName.add(name);
            }
        }
        while(sc.hasNext()){
            String name = sc.nextLine().trim();
            girlName.add(name);
        }
        sc.close();
    }

    public void checkName(String name, Gender gender) throws NotProperNameException,NameGenderMismatchException{
        if(!boyName.contains(name) && !girlName.contains(name)){
            throw new NotProperNameException(name);
        }
        else{
            if(gender == Gender.MALE){
                if(!boyName.contains(name)){
                    throw new NameGenderMismatchException(name,gender);
                }
            }
            else if(gender == Gender.FEMALE){
                if(!girlName.contains(name)){
                    throw new NameGenderMismatchException(name,gender);
                }
            }
        }
    }

}

