/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai1;

import java.util.Scanner;

/**
 *
 * @author tuans
 */

public class Bai1 {
    public static class hanghoa{
        String name;
        public hanghoa(){}
        public hanghoa(String name){
            this.name=name;
        }
        public void setName(String name){
            this.name=name;
        }
        public String getName(){
            return this.name;
        }
    }
    public static class banhanghoa extends hanghoa{
        double cost;
        int number;
        public banhanghoa(){
            super();
        }
        public banhanghoa(String name,double cost,int number){
            super(name); 
            this.cost=cost;
            this.number=number;
        }
        public double getCost(){
            double money=cost*number;
            int sizeName=name.length();
            if (this.name.charAt(sizeName-1)=='B' || this.name.charAt(sizeName-1)=='b')
                return Math.ceil(money);
            return Math.round(money);
        }
        @Override
        public String getName(){
            return this.name;
        }
        public int getNumber(){
            return this.number;
        }
        @Override
        public void setName(String name){
            this.name=name;
        }
        public void setCost(double money){
            this.cost=money;
        }
        public void setNumber(int number){
            this.number=number;
        }
    }

    static class manageProduct{
        banhanghoa[] array;
        int size;
        public manageProduct(){}
        public void input(){
            Scanner sc=new Scanner(System.in);
            System.out.print("Enter number of product: ");
            size=Integer.parseInt(sc.nextLine());
            array=new banhanghoa[size];
            for (int i=0;i<size;i++){
                System.out.println("");
                String name;
                Double money;
                int number;
                System.out.print("Enter name: ");
                name=sc.nextLine();
                System.out.print("Enter money: ");
                money=Double.parseDouble(sc.nextLine());
                System.out.print("Enter number: ");
                number=Integer.parseInt(sc.nextLine());
                banhanghoa sp=new banhanghoa(name,money,number);
                array[i]=sp;
            }
        }
        public void display(){
            System.out.println("");
            System.out.println("Information of all product: ");
            for (int i=0;i<size;i++){
                System.out.println(array[i].getName()+"\t"+array[i].getCost());
            }
        }
            
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        manageProduct array=new manageProduct();
        array.input();
        array.display();
    }
}
