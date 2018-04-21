/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop2_2;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author tuans
 */

public class Workshop2_2 {
    public static class manageArray{
        int sizeArray;
        int[] array;
        public manageArray(){}
        public void input(){
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter size of array:");
            this.sizeArray=sc.nextInt();
            sc.nextLine();
            array=new int[sizeArray];
            for (int i=0;i<sizeArray;i++){
                System.out.print("Array["+i+"]=");
                this.array[i]=sc.nextInt();
                sc.nextLine();
            }
        }
        public void display(){
            if (sizeArray==0){
                System.out.println("There is no elements in array");
                return;
            }
            System.out.println("Elements in array:");
            System.out.println(Arrays.toString(array));
        }
        public void sortAscending(){
            if (sizeArray==0){
                System.out.println("There is no elements in array");
                return;
            }
            Arrays.sort(array);
        }
        public void findMax(){
            if (sizeArray==0){
                System.out.println("There is no elements in array");
                return;
            }
            int max=array[0];
            for (int x:array){
                if (x>max){
                    max=x;
                }
            }
            System.out.println("Max value in array:"+max);
        }
    }
    /**
     * @param args the command line arguments
     */
    static void menu(){
        System.out.println("1.Input data (number elements,elements of the arrays)");
        System.out.println("2.Display all elements");
        System.out.println("3.Sort all numbers in ascending order");
        System.out.println("4.Find the maximum value");
        System.out.println("Any other key to exit");
    }
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Array processing");
        manageArray array=new manageArray();
        
        int choice;
        while(true){
            System.out.println("-----------------");
            menu();
            System.out.print("Enter your choice:");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            sc.nextLine();
            switch(choice){
                case 1: array.input();
                        break;
                case 2: array.display();
                        break;
                case 3: array.sortAscending();
                        break;
                case 4: array.findMax();
                        break;
                default:return;
                        
            }
        }
    }
}
