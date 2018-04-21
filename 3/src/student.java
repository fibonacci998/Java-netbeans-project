
import java.util.StringTokenizer;

public class student {
    String ID;
    String name;
    int age;
    public student(String ID, String name, int age) {
        this.ID=ID;
        this.name=name;
        this.age=age;
        try {
            int i=1/0;
        } catch (Exception e) {
            System.out.println("error");
        }
    }
  
    /*Complete the below function for second test case*/
    public String getname() {
        StringTokenizer st=new StringTokenizer(this.name);
        String lastName="";
        
        while(st.hasMoreTokens()){
            lastName=st.nextToken();
        }
        return lastName;
    }
/*Complete the below function for second test case*/
    public String getLastID() {
        StringTokenizer st;
        st = new StringTokenizer(this.ID," _+-][{}';:,./?><!@#$%^&*()");
        String firstID="";
        while(st.hasMoreTokens()){
            firstID=st.nextToken();
        }
        return firstID;
    }
  
   //add and complete your other methods here (if needed)
    public String toString(){
        return this.ID+' '+this.name+' '+this.age;
    }
   
}
