// ======= DO NOT EDIT MAIN FUNCTION ============
import java.io.*;
import java.util.*;
public class Main {
    
   public static void OutputList(List<Student> r) {
       for(Student x : r) {
           System.out.println(x.getName());
       }
   }  
    
   public static void main(String args[]) throws Exception {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.print("Enter number of Student: ");
       int n = Integer.parseInt(in.readLine());
       List<Student> a = new ArrayList();
       for(int i = 0; i < n; i++){
           System.out.println("");
           System.out.print("Student name: ");
           String name = in.readLine();           
           System.out.print("Student major: ");
           String major = in.readLine();           
           a.add(new Student(name, major));
       }
       System.out.println("");
       System.out.print("Enter test function (1-f1;2-f2): ");
       int c = Integer.parseInt(in.readLine());
       IStudent i = new MyStudent();
       System.out.println("");
       System.out.println("OUTPUT:");    
       if(c == 1) {
           OutputList(i.f1(a));
       }
       else if(c == 2) {
           System.out.println(i.f2(a));
       }
   }
 }
