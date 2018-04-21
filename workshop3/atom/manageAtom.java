/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3_2;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class manageAtom{
    
    atom[] array;
    int sizeArray=0;
    
    public manageAtom(){};
    
    public void input(){
        array=new atom[10];

        while (true){
            atom temp=new atom();
            Boolean ok=temp.accept();
            if (ok==true)
                array[sizeArray++]=temp;
            else return;
            System.out.println("");
        }
    }
    
    public void display(){
        for (int i=0;i<sizeArray;i++){
            array[i].display();
        }
    }
}