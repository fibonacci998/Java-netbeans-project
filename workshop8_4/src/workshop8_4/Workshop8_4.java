/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop8_4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Workshop8_4 {
    public static void main(String[] args) throws FileNotFoundException {
        String src,dest;
        System.out.print("Enter source file: ");
        Scanner sc=new Scanner(System.in);
        src=sc.nextLine();
        System.out.print("Enter destination folder: ");
        dest=sc.nextLine();
        try {
            FileReader fr=new FileReader(src);
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
