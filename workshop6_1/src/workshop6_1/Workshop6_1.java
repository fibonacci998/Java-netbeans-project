/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop6_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Workshop6_1 {
    static String getString(int number){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter string "+number+": ");
        return sc.nextLine();
    }
    static void output(String s1,String s2){
        System.out.println(s1);
        System.out.println(s2);
    }
    static String process(String s){
        String temp="";
        for (int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if (Character.isLetter(c)){
                temp+=Character.toLowerCase(c);
            }
        }
        char array[]=temp.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }
    public static void main(String[] args) {
        // TODO code application logic here
        String s1=null,s2=null;
        s1=getString(1);
        s2=getString(2);
        s1=process(s1);
        s2=process(s2);
        if (s1.compareTo(s2)==0)
            System.out.println("Your 2 strings are anagram");
        else System.out.println("Your 2 strings are not anagram");
    }
    
}
