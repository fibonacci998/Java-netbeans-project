/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithread1;

import java.util.Scanner;

class adding implements Runnable{ 
    int number;
    public adding(){
        Scanner sc=new Scanner(System.in);
        int number;
        number=sc.nextInt();
        this.number=number;
    }
    public int info(){
        return this.number;
    }
    public void run() {
        //add(a,b);
        
    }
    public void add(int a, int b){
        int sum=0;
        synchronized (this) {
            for(int i=a;i<=b;i++){
                sum = sum+ i;
            }
            System.out.println("Sum of "+a+" to "+ b+" numbers = "+sum);    
        }
    }
}

public class multithread1 {
    public static void main(String[] args) {
        /*Thread t1 = new Thread(new adding(1));
        Thread t2 = new Thread(new adding(2));
        Thread t3 = new Thread(new adding(3));
        Thread t4 = new Thread(new adding(4));
        Thread t5 = new Thread(new adding(5));
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();*/
        int n=5;
        for (int i=1;i<=5;i++){
            Thread t=new Thread(new adding());
            t.start();
        }
        
    }
}
