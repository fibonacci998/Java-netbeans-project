

 
import java.util.*;

public class MyStudent implements IStudent { 

    @Override
    public List<Student> f1(List<Student> s) {
        Collections.sort(s);
        List<Student> temp=new ArrayList<Student>();
        temp.add(s.get(0));
        temp.add(s.get(1));
        return temp;
    }

    @Override
    public int f2(List<Student> s) {
        int count=0;
        for (int i=0;i<s.size();i++){
            String temp=s.get(i).getMajor();
            if (temp.compareTo("SE")==0){
                count++;
            }
        }
        return count;
    }
     
}
