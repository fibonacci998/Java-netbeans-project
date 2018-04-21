/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1_d3;

import java.util.Scanner;

public class Q1_D3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int a, b;  b = 0;  
            a = 5 / b;
            System.out.print("A");
        }
        catch(ArithmeticException e) {
       System.out.print("B");         
    }
    finally {
        System.out.print("C");
    }
    }
}
