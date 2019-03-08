public enum Gender {
    MALE,FEMALE;

    public static Gender fromString(String s){
        if(s.equalsIgnoreCase("male")||s.equalsIgnoreCase("m")){
            return Gender.MALE;
        }
        else{
            return Gender.FEMALE;
        }
    }
}