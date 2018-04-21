/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3_1;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class manageMolecule {
    molecule[] array;
    int sizeArray;
    public manageMolecule(){}
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of molecule:");
        sizeArray=sc.nextInt();
        sc.nextLine();
        array=new molecule[sizeArray];
        for (int i=0;i<sizeArray;i++){
            System.out.println("");
            String structure;
            String name;
            double weight;
            System.out.print("Enter structure:");
            structure=sc.nextLine();
            System.out.print("Enter name:");
            name=sc.nextLine();
            System.out.print("Enter weight:");
            weight=sc.nextDouble();
            sc.nextLine();
            
            array[i]=new molecule(structure,name,weight);
        }
    }
    public void display(){
        for (molecule x:array){
            x.display();
        }
    }
}
