/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop1_3_namemaker;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Workshop1_3_NameMaker {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter your first name:");
        String firstName=sc.next();
        System.out.print("Enter your middle name:");
        String middleName=sc.next();
        System.out.print("Enter your last name:");
        String lastName=sc.next();
        String fullName=firstName+' '+middleName+' '+lastName;
        System.out.println("Hello "+fullName);
    }
    
}
