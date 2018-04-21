/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai3;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Bai3 {

    /**
     * @param args the command line arguments
     */
    public static class employee{
        String name;
        String nameOld;
        String type;
        public employee(){}
        public employee(String name,String type){
            this.name=name;
            this.type=type;
            int flag=0;
            for (int i=0;i<type.length();i++){
                if (Character.isAlphabetic(type.charAt(i))==false)
                    flag=1;
            }
            this.nameOld=this.name;
            if (flag==1)
                this.name="BBB"+this.name;
            else this.name="AA"+this.name;
        }
        public String getFixName(){
            if (name.length()>4)
                return name;
            else return "0000"; 
        }
        public String getCurrentName(){
            return nameOld;
        }
        public String getNewName(){
            return name;
        }
    }
    public static class manageEmployee{
        employee[] array;
        int sizeArray=0;
        public manageEmployee(){}
        public void input(){
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter number of employees:");
            sizeArray=sc.nextInt();
            sc.nextLine();
            array=new employee[sizeArray];
            for (int i=0;i<sizeArray;i++){
                String name;
                String type;
                System.out.print("Name of employee "+i+": ");
                name=sc.nextLine();
                System.out.print("Type of employee "+i+": ");
                type=sc.nextLine();
                employee person=new employee(name,type);
                array[i]=person;
            }
        }
        public void display(){
            System.out.println("------------------");
            for (employee x:array){
                System.out.println(x.getCurrentName()+"\t\t"+x.getFixName()+"\t\t"+x.getNewName());
            }
        }
    }
    public static void main(String[] args) {
        manageEmployee array=new manageEmployee();
        array.input();
        array.display();
    } 
}
