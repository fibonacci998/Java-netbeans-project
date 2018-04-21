/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adding;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class vdmang {
    public static void main(String []args){
        Scanner sc=new Scanner(System.in);
        float array[];
        int n;
        System.out.print("N = ");
        n=sc.nextInt();
        array=new float[n];
        for (int i=0;i<n;i++){
            System.out.println("A["+i+"] = ");
            //array[i]=sc.nextInt();
            String tg=sc.nextLine();
            array[i]=Float.parseFloat(tg);
        }
        int sum=0;
        for (float x:array){
            sum+=x;
        }
        System.out.println("Sum = "+sum);
    }
}
