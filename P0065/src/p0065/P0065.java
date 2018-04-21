/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0065;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class P0065 {
    
    //set up input from screen default
    final static Scanner sc=new Scanner(System.in);
    
    //return a valid number from min and max
    static int getValidNum(int min,int max,String error){
        while(true){
            try {
                int temp=Integer.parseInt(sc.nextLine());
                if (temp<min || temp>max)
                    throw new Exception();
                return temp;
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList studentList=new ArrayList();
        Mark manage = new Mark();
        System.out.println("====== Management Student Program ======");
        while(true){
            Enter_Student_Function(studentList);
            System.out.print("Do you want continue: ");
            String choose=sc.nextLine();
            if (choose.compareToIgnoreCase("N")==0)
                break;
        }
        studentList=(ArrayList) manage.averageStudent(studentList);
        HashMap<String,Double> classified= manage.getPercentTypeStudent(studentList);
        for (int i=0;i<studentList.size();i++){
            Student temp=(Student) studentList.get(i);
            System.out.println("----Student "+i+" info----");
            System.out.println("Name: "+temp.getName());
            System.out.println("Class: "+temp.getClasses());
            System.out.println("AVG: "+temp.getAve());
            System.out.println("Type: "+temp.getType());
        }
        System.out.println("--------Classification Info -----");
        System.out.println("A: "+classified.get("A")+"%");
        System.out.println("B: "+classified.get("B")+"%");
        System.out.println("C: "+classified.get("C")+"%");
        System.out.println("D: "+classified.get("D")+"%");
    }

    private static void Enter_Student_Function(ArrayList studentList) {
        Mark manage = new Mark();
        System.out.print("Name: ");
        String name=sc.nextLine();
        System.out.print("Class: ");
        String classs=sc.nextLine();
        System.out.print("Maths: ");
        double math=getValidNum(0, 10,"Math");
        System.out.print("Chemistry: ");
        double che=getValidNum(0, 10, "Chemistry");
        System.out.print("Physic: ");
        double phy=getValidNum(0, 10, "Physics");
        studentList.add(manage.creatStudent(name, classs, math, che, phy));
    }
    
}
