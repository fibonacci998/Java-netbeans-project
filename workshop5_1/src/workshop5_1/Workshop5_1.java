/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop5_1;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
class PhoneNumber{
    int area;
    String number;
    public PhoneNumber(){}
    public PhoneNumber(int a,String n){
        this.area=a;
        this.number=n;
    }
    public void display(){
        System.out.println(this.area+" - "+this.number);
    }
}

class IntPhoneNumber extends PhoneNumber{
    String countryCode;
    public IntPhoneNumber(){
        super();
    }
    public IntPhoneNumber(String cc,int a,String n){
        super(a,n);
        this.countryCode=cc;
    }
    @Override
    public void display(){
        System.out.println(this.countryCode+" - "+this.area+" - "+this.number);
    }
}
class PhoneList{
    PhoneNumber array[];
    int size=0;
    public PhoneList(){}
    public void input(){
        System.out.println("Enter list of phone numbers");
        System.out.println("--------------------------");
        Scanner sc=new Scanner(System.in);
        array=new PhoneNumber[1000];
        for (int i=0;i<1000;i++){
            int type;
            int area;
            String number,cc;
            System.out.println("");
            System.out.print("Type of phone number ? (1 – local phone, 2 – Inter phone number, 0 - exit):  ");
            type=Integer.parseInt(sc.nextLine());
            if (type==0){
                size=i;
                break;
            }
            if (type==1){
                System.out.print("Enter area code: ");
                area=Integer.parseInt(sc.nextLine());
                System.out.print("Enter number: ");
                number=sc.nextLine();
                PhoneNumber obj=new PhoneNumber(area,number);
                array[i]=obj;
            }
            else{
                System.out.print("Enter country code: ");
                cc=sc.nextLine();
                System.out.print("Enter area code: ");
                area=Integer.parseInt(sc.nextLine());
                System.out.print("Enter number: ");
                number=sc.nextLine();
                IntPhoneNumber obj=new IntPhoneNumber(cc,area,number);
                array[i]=obj;
            }
        }
    }
    public void display(){
        System.out.println("List of phone number:");
        System.out.println("----------------------------");
        for (int i=0;i<size;i++){
            array[i].display();
        }
    }
}
public class Workshop5_1 {
        
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        PhoneList list=new PhoneList();
        list.input();
        list.display();
    }

    
}
