/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop4_2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author tuans
 */
public class Workshop4_2 {

    static class Student{
        String name;
        String studentId;
        Date birthDate;
        String address;
        String major;
        double mark;
        public Student(){}
        public void setName(String name){
            this.name=name;
        }
        public void setStudentID(String ID){
            this.studentId=ID;
        }
        public void setDOB(Date birthDate){
            this.birthDate=birthDate;
        }
        public void setAddress(String address){
            this.address=address;
        }
        public void setMajor(String major){
            this.major=major;
        }
        public void setMark(double mark){
            this.mark=mark;
        }
        public String getName(){
            return this.name;
        }
        public String getStudentID(){
            return this.studentId;
        }
        public Date getDate(){
            return this.birthDate;
        }
        public String getAddress(){
            return this.address;
        }
        public String getMajor(){
            return this.major;
        }
        public double getMark(){
            return this.mark;
        }
        public void printAllAttributes(){
            System.out.println("-------------------");
            System.out.println("Student Name: "+getName());
            System.out.println("Student ID: "+getStudentID());
            DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Date of birth: "+format.format(getDate()));
            System.out.println("Address: "+getAddress());
            System.out.println("Major: "+getMajor());
            System.out.println("Mark: "+getMark());
        }
    }
    static class manageStudent{
        Student[] array;
        int size;
        public void input(){
            System.out.print("Enter number of students: ");
            Scanner sc=new Scanner(System.in);
            size=Integer.parseInt(sc.nextLine());
            array=new Student[size];
            DateFormat format=new SimpleDateFormat("dd/MM/yyyy");
            for (int i=0;i<size;i++){
                System.out.println("");
                Student obj=new Student();
                System.out.print("Enter name: ");
                obj.setName(sc.nextLine());
                System.out.print("Enter ID: ");
                obj.setStudentID(sc.nextLine());
                System.out.print("Enter birthdate(dd/mm/yyyy): ");
                try {
                    obj.setDOB(format.parse(sc.nextLine()));
                } catch (Exception e) {
                    System.out.println("Error input birthdate");
                }
                System.out.print("Enter address: ");
                obj.setAddress(sc.nextLine());
                System.out.print("Enter major: ");
                obj.setMajor(sc.nextLine());
                System.out.print("Enter mark: ");
                obj.setMark(Double.parseDouble(sc.nextLine()));
                array[i]=obj;
            }
        }
        public void display(){
            for (int i=0;i<size;i++){
                System.out.println("Information of student "+(i+1));
                array[i].printAllAttributes();
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        manageStudent array=new manageStudent();
        array.input();
        array.display();
    }
    
}
