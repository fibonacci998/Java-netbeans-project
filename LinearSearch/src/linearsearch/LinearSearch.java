/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linearsearch;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

/**
 *
 * @author tuans
 */
public class LinearSearch {
    //set constant for INT_MIN and INT_MAX
    final static int INT_MIN=Integer.MIN_VALUE;
    final static int INT_MAX=Integer.MAX_VALUE;
    //set up to read input from screen's user
    final static Scanner input=new Scanner(System.in);
    
    //return valid number from min to max
    static int getValidNum(int min,int max){
        
        //loop run until get valid number
        while(true){
            try {
                int number=Integer.parseInt(input.nextLine());
                if (number<min || number>max){
                    throw new Exception();
                }
                return number;
            } catch (Exception exception) {
                System.out.println("You have entered invalid number!!");
                System.out.print("Please enter a valid number from ");
                System.out.println(min+" to "+max+": ");
            }
        }
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        ArrayList array=new ArrayList();
        int sizeOfArray;
        int searchValue;
        int indexOfSearchValue;
        
        //get size of array from user
        sizeOfArray=getSizeOfArray();
    
        //generate random element in array
        generateArrayWithSize(array,sizeOfArray);
        
        //get search value from user
        searchValue=getSearchValue();
        
        //search value in array
        indexOfSearchValue=findValueInArray(searchValue,array);
        
        //display the array
        displayArray(array);
        
        //display the index of search number in array.
        displayPositionOfSearchValue(searchValue, indexOfSearchValue);
    }
    
    //return a valid size( positive number > 1)
    private static int getSizeOfArray() {
        System.out.println("Enter number of array:");
        return getValidNum(1, INT_MAX);
    }
    
    //generate array with size element
    private static void generateArrayWithSize(ArrayList array, int sizeOfArray){
        
        //generate size element and add to array
        for (int i=0;i<sizeOfArray;i++){
            //use thread to generate random number in range [0-10]
            int randomNum = ThreadLocalRandom.current().nextInt(INT_MIN,INT_MAX);
            array.add(randomNum);
        }
    }

    //return valid search value
    private static int getSearchValue() {
        System.out.println("Enter search value:");
        return getValidNum(INT_MIN, INT_MAX);
    }

    //get position of search value in array
    //return a positive number if found
    //return -1 if not found
    private static int findValueInArray(int searchValue, ArrayList array) {
        for (int i=0;i<array.size();i++){
            if ((int)array.get(i)==searchValue){
                return i;
            }
        }
        return -1;
    }

    //display elements in array
    private static void displayArray(ArrayList array) {
        System.out.println("The array: "+array);
    }
    
    //display position of search value in array
    private static void displayPositionOfSearchValue(int searchValue, int indexSearchValue) {
        if (indexSearchValue!=-1){
            System.out.println("Found "+searchValue+" at index: "+indexSearchValue);
        }else{
            System.out.println("Not found "+ searchValue+" in array!");
        }
    }
}
