/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaApplication1;

import java.util.Scanner;

/**
 *
 * @author Last Hope
 */

public class JavaApplication1 {
  public static class phoneNmber{
        String number;
        public phoneNmber(){}
        public phoneNmber(String number){
            this.number=number;
        }
        public void setNumber(String number){
            this.number=number;
        }
        public String getNumber(){
            return this.number;
        }
    }
  public static class intPhoneNumber extends phoneNmber{
        int area;
        String name;
        public intPhoneNumber(){
            super();
        }
        public intPhoneNumber(String countryCode,int area,String number){
            super(countryCode); 
            this.area=area;
            this.number=number;
        }

        public String getCoutryCode(){
            return this.();
        }
        @Override
        public String getNumber(){
            return this.number;
        }
        public void setCountryCode(String name){
            this.name=name;
        }
        public void setArea(int area){
            this.area = this.area;
        }
        
    }
  static class managePhoneNumber{
        intPhoneNumber[] array;
        int size;
        public managePhoneNumber(){}
        public void input(){
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter number of telephone Number : ");
            size=Integer.parseInt(sc.nextLine());
            array=new intPhoneNumber[size];
            for (int i=0;i<size;i++){
                System.out.println("");
                String countryCode;
                String number;
                int area;
                System.out.print("Enter country code: ");
                countryCode = sc.nextLine();
                System.out.print("Enter area number: ");
                area=Integer.parseInt(sc.nextLine());
                System.out.print("Enter the  Number: ");
                number = sc.nextLine();
                intPhoneNumber sp= new intPhoneNumber(countryCode, area,number);
                array[i]=sp;
            }
        }
        public void display(){
            System.out.println("-------------------");
            System.out.println("List of the phone ");
            for (int i=0;i<size;i++){
                System.out.println(array[i].area+"\t"+array[i].getCoutryCode()+"\t"+array[i].getNumber());
            }
        }
    }
    public static void main(String[] args) {
        // TODO code application logic here
        managePhoneNumber array = new managePhoneNumber();
        array.input();
        array.display();
    }
    
    
  }