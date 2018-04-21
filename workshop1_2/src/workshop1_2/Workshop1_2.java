/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1_2;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Workshop1_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter start hour:");
        int hour=sc.nextInt();
        System.out.print("Enter start minute:");
        int minute=sc.nextInt();
        System.out.print("Enter duration minute:");
        int during=sc.nextInt();
        minute+=during;
        //hour=((hour+11)%12)+1;
        while (minute>=60){
            hour++;
            minute-=60;
        }
        while (hour>=24){
            hour-=24;
        }
        System.out.println("Time end: "+hour+":"+minute);
    }
    
}
