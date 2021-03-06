// ======= DO NOT EDIT THIS FILE ============
import java.io.*;
class Main {
   public static void main(String args[]) throws Exception {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.print("Enter Printer name: ");
       String name = in.readLine();
       System.out.print("Enter Printer speed: ");
       int speed = Integer.parseInt(in.readLine());
       System.out.print("Enter Printer color: ");
       String color = in.readLine();
       System.out.print("Enter Printer price: ");
       double price = Double.parseDouble(in.readLine()); 
       System.out.print("Enter Test Case: ");
       int tc = Integer.parseInt(in.readLine());
       System.out.println("OUTPUT:");      
       if(tc == 1) {
            Printer p = new Printer(speed, name);
            System.out.println(p);
            p = new ColorPrinter(name, price, speed, color);
            System.out.println(p);
       }
       else if(tc == 2) {
           ColorPrinter p = new ColorPrinter(name, price, speed, color);
           System.out.println(p.getSalePrice());
       }
   }
 }
