/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop5_2;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
abstract class Person{
    String name;
    public Person(){}
    public Person(String n){
        this.name=n;
    }
    public void display(){
        System.out.println(this.name);
    }
    abstract int compare(Officer temp);
    abstract int compare(Worker temp);
    abstract double getSalary();
    abstract void sort(Person[] e,int n);
}
class Officer extends Person{
    double bSalary;
    public Officer(){}
    public Officer(String n,double s){
        super(n);
        this.bSalary=s;
    }
    @Override
    public void display(){
        System.out.println("Infomation of officer");
        System.out.println(this.name+" "+getSalary());
    }
    @Override
    double getSalary() {
        return this.bSalary;
    }
    @Override
    int compare(Officer temp) {
        if (this.bSalary>temp.getSalary()) return 1;
        if (this.bSalary==temp.getSalary()) return 0;
        return -1;
    }

    @Override
    int compare(Worker temp) {
        return -10;
    }

    @Override
    public void sort(Person[] e, int n) {
        for (int i=0;i<n;i++)
            for (int j=i+1;j<n;j++)
                if (e[i] instanceof Officer && e[j] instanceof Officer && (e[i].compare((Officer) e[j])==1)){
                    Person temp=e[i];
                    e[i]=e[j];
                    e[j]=temp;
                }}
}
class Worker extends Person{

    double hrs;
    final double rate=5.5;
    public Worker(){}
    public Worker(String n,double hrs){
        super(n);
        this.hrs=hrs;
    }
    @Override
    public void display(){
        System.out.println("Infomation of worker");
        System.out.println(this.name+" "+getSalary());
    }
    @Override
    double getSalary() {
       return hrs*rate;
    }

    @Override
    int compare(Officer temp) {
        return -10;
    }

    @Override
    int compare(Worker temp) {
        if (this.getSalary()>temp.getSalary()) return 1;
        if (this.getSalary()==temp.getSalary()) return 0;
        return -1;
    }

    @Override
    public void sort(Person[] e, int n) {for (int i=0;i<n;i++)
            for (int j=i+1;j<n;j++)
                if (e[i] instanceof Worker && e[j] instanceof Worker && (e[i].compare((Worker) e[j])==1)){
                    Person temp=e[i];
                    e[i]=e[j];
                    e[j]=temp;
                }
    }

}
public class Workshop5_2 {

    /**
     * @param args the command line arguments
     */
    public static void sortOfficer(Person [] e,int n){
         for (int i=0;i<n;i++)
            for (int j=i+1;j<n;j++)
                if (e[i] instanceof Officer && e[j] instanceof Officer && (e[i].compare((Officer) e[j])==1)){
                    Person temp=e[i];
                    e[i]=e[j];
                    e[j]=temp;
                }
    }
    public static void sortWorker(Person [] e,int n){
         for (int i=0;i<n;i++)
            for (int j=i+1;j<n;j++)
                if (e[i] instanceof Worker && e[j] instanceof Worker && (e[i].compare((Worker) e[j])==1)){
                    Person temp=e[i];
                    e[i]=e[j];
                    e[j]=temp;
                }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Person [] e = new Person[10];
        int n = 0, c = 0;
        do{
            System.out.println("Worker (1); Officer(2): ");
            Scanner in = new Scanner(System.in);
            c = in.nextInt();
            if(c == 1){
                //accept information of worker
                System.out.print("Enter worker name: ");
                String name = in.next();
                System.out.print("Enter worker working hours: ");
                int hrs = in.nextInt();
                e[n] = new Worker(name, hrs);

                n++;
            }else if(c == 2){
                //accept information of Officer
                System.out.print("Enter Officer name: ");
                String name = in.next();
                System.out.print("Enter officer salary: ");
                double salary = in.nextDouble();
                e[n] = new Officer(name, salary);
                n++;
            }
        }while(c != 0);
        //print all objects of e
        //sortOfficer(e, n);
        //sortWorker(e, n);
       
        System.out.println("Worker: ");
        for(int i = 0; i < n; i++){
            //print the instance of Worker only
            if(e[i] instanceof Worker)
                e[i].display();
        }
        System.out.println("Officer: ");
        for(int i = 0; i < n; i++){
            //print the instance of Worker only
            if(e[i] instanceof Officer)
                e[i].display();
        }

    }
    
}
