/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercises3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
class Employee implements Comparable{
    String Name;
    int ID;
    int Age;
    public Employee(){}
    public Employee(String Name,int ID,int Age){
        this.Name=Name;
        this.ID=ID;
        this.Age=Age;
    }

    public int getID() {
        return ID;
    }

    public int getAge() {
        return Age;
    }
    @Override
    public String toString(){
        return this.Name+"\t\t"+this.ID+"\t\t"+this.Age;
    }
    @Override
    public int compareTo(Object t) {
        Employee temp=(Employee)t;
        if (this.ID>temp.getID()) return 1;
        if (this.ID==temp.getID()) return 0;
        return -1;
    }
    
}
public class Exercises3 {
    public static Comparator obj=new Comparator(){
        @Override
        public int compare(Object t, Object t1) {
            Employee p1=(Employee)t;
            Employee p2=(Employee)t1;
            int d=p1.getAge()-p2.getAge();
            if (d>0) return 1;
            if (d==0) return p1.compareTo(p2);
            return -1;
        }
    };
    static void input(ArrayList<Employee> list){
        int size;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of employees: ");
        size=Integer.parseInt(sc.nextLine());
        for (int i=0;i<size;i++){
            String Name;
            int age,ID;
            System.out.print("Enter Name: ");
            Name=sc.nextLine();
            System.out.print("Enter ID: ");
            ID=Integer.parseInt(sc.nextLine());
            System.out.print("Enter age: ");
            age=Integer.parseInt(sc.nextLine());
            Employee temp=new Employee(Name,ID,age);
            list.add(temp);
        }
    }
    
    static void output(ArrayList<Employee> list){
        /*Collections.sort(list);
        System.out.println("Information of list employees:");
        System.out.println("-------------Sort 1-----------");
        for (int i=0;i<list.size();i++){
            System.out.println("Employee "+i+":");
            System.out.println(list.get(i));
        }
        System.out.println("-------------Sort 2-----------");
        Collections.sort(list, obj);
        for (int i=0;i<list.size();i++){
            System.out.println("Employee "+i+":");
            System.out.println(list.get(i));
        }*/
        System.out.println("--------------reverse----------");
        Collections.reverse(list);
        for (int i=0;i<list.size();i++){
            System.out.println("Employee "+i+":");
            System.out.println(list.get(i));
        }
        System.out.println("---------------find max");
        Employee temp=Collections.max(list);
        System.out.println("Employee infomation max: ");
        System.out.println(temp);
    }
    public static void main(String[] args) {
        ArrayList<Employee> list=new ArrayList<Employee>();
        input(list);
        output(list);
    }
}
