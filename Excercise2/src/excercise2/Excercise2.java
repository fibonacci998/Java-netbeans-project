/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercise2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
class Student{
    String MSSV;
    String Name;
    public Student(){}
    public Student(String MSSV,String name){
        this.Name=name;
        boolean flag=true;
        for (int i=0;i<MSSV.length();i++){
            Character ch=MSSV.charAt(i);
            if (!Character.isAlphabetic(ch)){
                flag=false;
                break;
            }
        }
        if (flag==false) MSSV="0000";
        this.MSSV=MSSV;
    }
    void input(String MSSV,String name){
        this.Name=name;
        boolean flag=true;
        for (int i=0;i<MSSV.length();i++){
            Character ch=MSSV.charAt(i);
            if (!Character.isAlphabetic(ch)){
                flag=false;
                break;
            }
        }
        if (flag==false) MSSV="0000";
        this.MSSV=MSSV;
    }
    public String getName(){
        String startString=this.Name.substring(0, 4);
        int sizeString=Name.length();
        if (startString.compareTo("phan")==0){
            this.Name=this.Name.substring(sizeString-4);
            return this.Name;
        }
        this.Name=startString;
        return this.Name;
    }
    @Override
    public String toString(){
        return this.MSSV+"\t\t"+this.Name;
    }
}
public class Excercise2 {

    static void input(ArrayList<Student> list){
        int size;
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of students: ");
        size=Integer.parseInt(sc.nextLine());
        for (int i=0;i<size;i++){
            String MSSV,Name;
            System.out.print("Enter MSSV: ");
            MSSV=sc.nextLine();
            System.out.print("Enter name: ");
            Name=sc.nextLine();
            Student temp=new Student(MSSV,Name);
            list.add(temp);
        }
    }
    static void output(ArrayList<Student> list){
        System.out.println("Information of list students");
        for (int i=0;i<list.size();i++){
            System.out.println("Student "+i+":");
            System.out.println(list.get(i));
            System.out.println(list.get(i).getName());
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        ArrayList<Student> list=new ArrayList<Student>();
        input(list);
        output(list);
    }
}
