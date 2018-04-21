/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop8_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Workshop8_3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        String s;
        System.out.print("Enter file name: ");
        Scanner sc=new Scanner(System.in);
        s=sc.nextLine();
        try {
            FileReader fr=new FileReader(s);
            BufferedReader br=new BufferedReader(fr);
            String temp;
            System.out.println("Content in file:");
            while ((temp=br.readLine())!=null){
                System.out.println(temp);
            }
        } catch (Exception e) {
            System.out.println("File not found!!!");
        }
    }
    
}
