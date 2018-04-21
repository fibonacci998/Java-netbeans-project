// ======= DO NOT EDIT MAIN FUNCTION ============
import java.io.*;
import java.util.*;
public class Main {
    
   public static void OutputList(List<Room> r) {
       for(Room x : r) {
           System.out.println(x.getName());
       }
   }  
    
   public static void main(String args[]) throws Exception {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.print("Enter number of Room: ");
       int n = Integer.parseInt(in.readLine());
       List<Room> a = new ArrayList();
       for(int i = 0; i < n; i++){
           System.out.println("");
           System.out.print("Room name: ");
           String name = in.readLine();           
           System.out.print("Room size: ");
           int size = Integer.parseInt(in.readLine());          
           a.add(new Room(name, size));
       }
       System.out.println("");
       System.out.print("Enter test function (1-f1;2-f2): ");
       int c = Integer.parseInt(in.readLine());
       IRoom i = new MyRoom();
       int givenSize = 0;
       if(c == 1) {
           System.out.print("Enter given size: ");
           givenSize = Integer.parseInt(in.readLine());
       }
       System.out.println("");
       System.out.println("OUTPUT:");    
       if(c == 1) {
           OutputList(i.f1(a, givenSize));
       }
       else if(c == 2) {
          i.f2(a); OutputList(a);
       }
   }
 }
