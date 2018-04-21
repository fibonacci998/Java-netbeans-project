
import java.util.StringTokenizer;

public class Flight {
    String route;
    int fare;
    public Flight(String route, int fare) {
        this.route=route;
        this.fare=fare;
    }
  
    /*Complete the below function for second test case*/
    public String getDeparture() {
        StringTokenizer st=new StringTokenizer(this.route,"-");
        String temp="";
        while (st.hasMoreTokens())
        {
            temp = st.nextToken();
            break;
        }
        return temp;
    }
    public String toString(){
        return this.route+' '+this.fare;
    }
   //add and complete your other methods here (if needed)

   
}
