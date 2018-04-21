/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3_2;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class atom {
    int number;
    String symbol;
    String name;
    double weight;
    public atom(){}
    public atom(int number,String symbol,String name,double weight){
        this.number=number;
        this.symbol=symbol;
        this.name=name;
        this.weight=weight;
    }
    public boolean accept(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter atomic number:");
        this.number=sc.nextInt();
        if (this.number==0) return false;
        sc.nextLine();
        System.out.print("Enter symbol:");
        this.symbol=sc.nextLine();
        System.out.print("Enter full name:");
        this.name=sc.nextLine();
        System.out.print("Enter atomic weight:");
        this.weight=sc.nextDouble();
        sc.nextLine();
        
        return true;
    }
    public void display(){
        System.out.println(number+"\t"+symbol+"\t"+name+"\t"+weight);
    }
}
