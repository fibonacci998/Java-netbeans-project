
import java.util.Comparator;


public class Student implements Comparable{   
    String name;
    String major;
    public Student(String name, String major) {
        this.name=name;
        this.major=major;
    }

    
    public String getName() {
        return this.name;
    }
    public String getMajor() {
        return this.major;
    }
    //add and complete you other methods (if needed) here   

    @Override
    public int compareTo(Object t) {
        Student temp=(Student)t;
        return this.name.toUpperCase().compareTo(temp.getName().toUpperCase());
    }

}
