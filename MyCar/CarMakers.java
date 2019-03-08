public enum CarMakers {
    FIAT,FORD,VOLVO,BMW,CHRYSLER,GM,OTHER;

    //int flag;

    public static CarMakers convertString(String s){
        s = s.trim();
        for(CarMakers cname : CarMakers.values()){
            if(cname.toString().equalsIgnoreCase(s)){
                return cname;
            }
        }
        return CarMakers.OTHER;
    }

    public String getString() {
        String nameString;
        if(this.toString().equalsIgnoreCase("FIAT")||
                this.toString().equalsIgnoreCase("BMW")||
                this.toString().equalsIgnoreCase("GM")){
            nameString = this.toString().toUpperCase();
        }
        else {
            //nameString = this.toString().substring(0,1).toUpperCase().concat(this.toString().substring(1).toLowerCase());
            nameString = this.toString().toLowerCase();
            char ns[] = nameString.toCharArray();
            ns[0] = (char)(ns[0]-32);
            nameString = new String(ns);
        }
        return nameString;
        //
    }
}
