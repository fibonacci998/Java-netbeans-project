/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fibonacci;

/**
 *
 * @author tuans
 */
public class Fibonacci {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int sizeArray=45;
        
        int[] arrayFibonacci=new int[sizeArray];
        
        //fill up array fibonacci
        findFibonacci(arrayFibonacci,sizeArray-1);
        
        //display first-size array fibonacci
        display(arrayFibonacci,sizeArray);
    }

    //return fibonacci and fill up arrayFibonacci at position
    private static int findFibonacci(int[] arrayFibonacci, int position) {
        //fibonacci at 1-position is 1
        if (position==1){
            return(arrayFibonacci[position]=1);
        }
        
        //fibonacci at 0-position is 0
        if (position==0){
            return(arrayFibonacci[position]=0);
        }
        
        //if fibonacci prev (position-1) is not found, found it
        if (arrayFibonacci[position-1]==0){
            findFibonacci(arrayFibonacci, position-1);
        }
        
        //if fibonacci prev (position-2) is not found, found it
        if (arrayFibonacci[position-2]==0){
            findFibonacci(arrayFibonacci, position-2);
        }
        
        //fibonacci at i-position = fibonacci at (i-1)position +
        //fibonacci at i-2 position
        return (arrayFibonacci[position]=arrayFibonacci[position-1]+
                arrayFibonacci[position-2]);
    }

    //display array
    private static void display(int[] arrayFibonacci, int sizeArray) {
        for (int i=0;i<sizeArray;i++){
            System.out.println(i+" "+arrayFibonacci[i]);
        }
    }
    
}
