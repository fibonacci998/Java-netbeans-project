/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2_1;

/**
 *
 * @author tuans
 */
public class Workshop2_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Even number from 2 to 10:");
        System.out.println("A.Use for loop and continue statement:");
        for (int i=2;i<=10;i++)
            if (i%2==0) System.out.print(i+" ");
            else continue;
        System.out.println("");
        System.out.println("B.Use while loop and flag");
        int number=2;
        boolean flag=true;
        while (flag){
            if (number%2==0) System.out.print(number+" ");
            number++;
            if (number>10) flag=false;
        }
    }
    
}
