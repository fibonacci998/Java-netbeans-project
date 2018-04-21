/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2_d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author tuans
 */

public class Q2_D3 {
    interface Ihanghoa{
        void f1(ArrayList<Hanghoa> a);
        void f2(ArrayList<Hanghoa> a);
    }
    static class Hanghoa implements Comparable{
        String name;
        double price;
        public Hanghoa(){}
        public Hanghoa(String name,double price){
            this.name=name;
            this.price=price;
        }
        public String getName(){
            return this.name;
        }
        public double getPrice(){
            return this.price;
        }
        @Override
        public String toString(){
            return this.name+' '+this.price;
        }

        @Override
        public int compareTo(Object t) {
            Hanghoa temp=(Hanghoa)t;
            if (this.price<temp.getPrice()) return 1;
            else if (this.price==temp.getPrice()) return 0;
            return -1;
        }
    }
    static class QLHanghoa implements Ihanghoa{

        @Override
        public void f1(ArrayList<Hanghoa> a) {
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter number of products: ");
            int size=Integer.parseInt(sc.nextLine());
            for (int i=0;i<size;i++){
                System.out.println("");
                System.out.println("Enter product "+i+": ");
                String name;double price;
                System.out.print("Enter name: ");
                name=sc.nextLine();
                System.out.print("Enter price: ");
                price=Double.parseDouble(sc.nextLine());
                a.add(new Hanghoa(name,price));
            }
            Collections.sort(a);
            System.out.println("------------------");
            System.out.println("Product 3rd price:");
            System.out.println(a.get(2));
            System.out.println("--------------------");
            int count=1;
            int i;
            for (i=1;i<a.size();i++){
                if (a.get(i).getPrice()!=a.get(i-1).getPrice()) count++;
                if (count==3) break;
            }
            System.out.println("Product 3rd value price:");
            System.out.println(a.get(i));
        }

        @Override
        public void f2(ArrayList<Hanghoa> a) {
            System.out.println("-----------------");
            System.out.println("List products name start with 'a' or 'A':");
            for (Hanghoa temp:a){
                String name=temp.getName();
                if (name.charAt(0)=='A' || name.charAt(0)=='a')
                    System.out.println(temp);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        QLHanghoa process=new QLHanghoa();
        ArrayList<Hanghoa> a=new ArrayList<Hanghoa>();
        process.f1(a);
        process.f2(a);
    }
    
}
