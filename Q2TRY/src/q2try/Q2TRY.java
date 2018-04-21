/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2try;

/**
 *
 * @author tuans
 */
import java.io.*;
import java.util.*;
public class Q2TRY {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws Exception{
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.print("Enter number of Invoice: ");
       int n = Integer.parseInt(in.readLine());
       ArrayList<Invoice> a = new ArrayList(); 
       for(int i = 0; i < n; i++){
           System.out.println("");
           System.out.print("Issue to customer: ");
           String customer = in.readLine();           
           System.out.print("Total amount: ");
           int amount = Integer.parseInt(in.readLine());          
           a.add(new Invoice(customer, amount));
       }
       System.out.println("");
       System.out.print("Enter test function (1-f1;2-f2): ");
       int c = Integer.parseInt(in.readLine());
       IInvoice i = new MyInvoice();
       System.out.println("OUTPUT:");    
       if(c == 1)
          System.out.println(i.f1(a));       
       else if(c == 2)
          System.out.println(i.f2(a));
   }
    
}
