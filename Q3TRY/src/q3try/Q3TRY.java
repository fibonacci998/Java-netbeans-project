/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3try;
import java.io.*;
/**
 *
 * @author tuans
 */
public class Q3TRY {

    public static void main(String args[]) throws Exception
   {
       BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
       System.out.print("Enter card type: ");
       String type = in.readLine();
       System.out.print("Enter card number: ");
       String number = in.readLine();
       System.out.print("Enter TC: ");
       int tc = Integer.parseInt(in.readLine());
       System.out.println("OUTPUT:");
       MyCard s = new MyCard(type, number);
       if(tc == 1) 
           System.out.println(s);
       else if(tc == 2)
            System.out.println(s.getCardCode());      
   }
}
