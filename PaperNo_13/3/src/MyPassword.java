
public class MyPassword {
    String password;
    boolean admin;
    public MyPassword(String password, boolean admin) {
        this.admin=admin;
        this.password=password;
    }
    
    public String getPassword() {
       
        int numberDigit=0,numberUpper=0;
        for (int i=0;i<this.password.length();i++){
            char ch=this.password.charAt(i);
            if (Character.isDigit(ch)){
                numberDigit++;
            }else if (Character.isUpperCase(ch)){
                numberUpper++;
            }
        }
        if (numberDigit>0 && numberUpper>0){
            String temp="";
            for (int i=0;i<this.password.length();i++){
                char ch=this.password.charAt(i);
                if (Character.isDigit(ch)){
                    temp=temp+ch;
                }else if (Character.isUpperCase(ch)){
                    temp=temp+ch;
                }
            }
            return temp;
        }
        return this.password.substring(0,4);
    }
    @Override
    public String toString(){
        return this.password+' '+this.admin;
    }
   //add and complete your other methods here (if needed)

}
