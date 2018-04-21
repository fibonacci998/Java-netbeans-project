/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6_2;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
class hexaException extends Exception{
    public hexaException(){
        super();
    }
    public hexaException(String message){
        super(message);
    }
}
public class Workshop6_2 {
    
    /**
     * @param args the command line arguments
     */
    static int hexValue(char ch) throws hexaException{
        switch (ch){
            case '0': return 0;
            case '1': return 1;
            case '2': return 2;
            case '3': return 3;
            case '4': return 4;
            case '5': return 5;
            case '6': return 6;
            case '7': return 7;
            case '8': return 8;
            case '9': return 9;
            case 'A': return 11;
            case 'B': return 12;
            case 'C': return 13;
            case 'D': return 14;
            case 'E': return 15;
            case 'F': return 16;
        }
        throw new hexaException();   
    }
    public static void main(String[] args) {
        /*int n=0;
        try {
           
            Scanner sc=new Scanner(System.in);
            String temp=sc.nextLine();
            n=Integer.parseInt(temp, 16);
        } catch (Exception e) {
            System.out.println("Your hexadecimal input is error!!!!!!!!!!!!");
        }
        System.out.println("Convert to decimal: "+n);*/
        int value=0;
        String temp;
        Scanner sc=new Scanner(System.in);
        try {
           temp=sc.nextLine();
           temp=temp.toUpperCase();
           for (int i=0;i<temp.length();i++){
               value=value*16+hexValue(temp.charAt(i));
           }
            System.out.println("Convert to decimal: "+value);
        } catch (hexaException e) {
            System.out.println("Your hexadecimal input is error!!!!!!!!!!!!");
        }
    }
}
