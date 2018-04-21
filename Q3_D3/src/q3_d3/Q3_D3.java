/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3_d3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Q3_D3 {
    static class Canbo implements Comparable{
        String name;
        String type;
        public Canbo(){}
        public Canbo(String name,String type){
            this.name=name;
            this.type=type;
            boolean flag=true;
            for (int i=0;i<type.length();i++){
                char ch=type.charAt(i);
                if (Character.isDigit(ch)){
                    flag=false;
                    break;
                }
            }
            if (flag==true) this.name="AA"+this.name;
            else this.name=this.name+"BBB";
        }
        public String getName(){
            if (this.name.length()>4)
                return this.name;
            return "000";
        }

        @Override
        public int compareTo(Object t) {
            Canbo temp=(Canbo)t;
            return this.name.compareTo(temp.getName());
        }
        @Override
        public String toString(){
            return this.name+"\t"+this.type;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Canbo> a=new ArrayList<Canbo>();
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<3;i++){
            System.out.println("");
            System.out.println("Enter person "+i+": ");
            String name;
            String type;
            System.out.print("Enter name: ");
            name=sc.nextLine();
            System.out.print("Enter type: ");
            type=sc.nextLine();
            a.add(new Canbo(name,type));
        }
        System.out.println("----------------------");
        System.out.println("Information of 3 people: ");
        for (Canbo temp:a){
            System.out.println(temp.getName());
        }
        Collections.sort(a);
        System.out.println("----------------------");
        System.out.println("Person on 3rd list order: ");
        System.out.println(a.get(2));
        int count=1;
        for (int i=0;i<a.size();i++){
            Canbo temp=a.get(i);
        }
    }
    
}
