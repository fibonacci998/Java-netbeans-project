/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package input;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Input {

    
    public static int getInput(){
       int number=0;
       Scanner sc=new Scanner(System.in);
       System.out.print("Enter your number: ");
       while(true){
           try {
               number=Integer.parseInt(sc.nextLine());
               return number;
           } catch (Exception e) {
               System.out.print("Just enter valid number: ");
           }
       }
    }
    public static void main(String[] args) {
        int number;
        number=getInput();
        System.out.println("------------------");
        System.out.println(number);
    }
    
}
