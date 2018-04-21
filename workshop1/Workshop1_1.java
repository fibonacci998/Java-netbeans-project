/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1_1;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Workshop1_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter hour:");
        int hour=sc.nextInt();
        System.out.print("Enter minute:");
        int minute=sc.nextInt();
        System.out.println("Total minutes:"+(int)(hour*60+minute));
    }
}
