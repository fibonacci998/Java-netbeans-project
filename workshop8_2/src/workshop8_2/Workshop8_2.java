/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop8_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
class Student{
    String name;
    int age;
    int mark;
    public Student(){}
    public Student(String name,int age,int mark){
        this.name=name;
        this.age=age;
        this.mark=mark;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setAge(int age){
        this.age=age;
    }
    public void setMark(int mark){
        this.mark=mark;
    }
    @Override
    public String toString(){
        return this.name+'\t'+this.age+'\t'+this.mark+'\n';
    }
}
class temp{
    private int n;
    private int k;
    private int j;

    
}
public class Workshop8_2 {

    /**
     * @param args the command line arguments
     */
    static void menu(){
        System.out.println("");
        System.out.println("Menu");
        System.out.println("-----------------------");
        System.out.println("1. Add a list of Student and save to File");
        System.out.println("2. Loading list of Student from a File");
        System.out.println("3. Exit;");
    }
    static void addStudent() throws FileNotFoundException, IOException{
        Scanner sc=new Scanner(System.in);
        FileWriter out=new FileWriter("manageStudents.txt");
        System.out.print("Enter number of students: ");
        int size=Integer.parseInt(sc.nextLine());
        for (int i=0;i<size;i++){
            System.out.println("");
            Student temp=new Student();
            System.out.print("Enter name: ");
            temp.setName(sc.nextLine());
            System.out.print("Enter age: ");
            temp.setAge(Integer.parseInt(sc.nextLine()));
            System.out.print("Enter mark: ");
            temp.setMark(Integer.parseInt(sc.nextLine()));
            out.write(temp.toString());
        }
        out.close();
    }
    static void readStudent() throws FileNotFoundException, IOException{
        FileReader fr=new FileReader("manageStudents.txt");
        BufferedReader br=new BufferedReader(fr);
        String s;
        System.out.println("Name\tAge\tMark");
        while ((s=br.readLine())!=null)
            System.out.println(s);
        br.close();
        fr.close();
    }
    public static void main(String[] args) throws IOException {
        // TODO code application logic here\
        Scanner sc=new Scanner(System.in);
        while(true){
            menu();
            System.out.print("Your choice: ");
            int choice=Integer.parseInt(sc.nextLine());
            switch (choice){
                case 1:
                    addStudent();
                    break;
                case 2:
                    readStudent();
                    break;
                case 3:
                    return;
                default:
                    break;    
            } 
        }
    }
    
}
