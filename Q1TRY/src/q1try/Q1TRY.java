/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1try;
import java.io.*;
/**
 *
 * @author tuans
 */
public class Q1TRY {

    public static void main(String args[]) throws Exception {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.print("Enter dessert name: ");
       String name = in.readLine();
       System.out.print("Enter candy price: ");
       double price = Double.parseDouble(in.readLine());       
       System.out.print("Enter candy weight: ");
       double weight = Double.parseDouble(in.readLine());
       System.out.print("Enter TC: ");
       int tc = Integer.parseInt(in.readLine());
       System.out.println("OUTPUT:");      
       if(tc == 1) {
            DessertItem b = new DessertItem(name);
            System.out.println(b);
            b = new Candy(name, price, weight);
            System.out.println(b);
       }
       else if(tc == 2) {
           Candy b = new Candy(name, price, weight);
           System.out.println(b.getCost());
       }
   }
    
}
