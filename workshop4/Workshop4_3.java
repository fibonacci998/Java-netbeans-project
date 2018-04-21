/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop4_3;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
class Rectangle{
    double width;
    double height;
    public Rectangle(){}
    public Rectangle(double width,double height){
        this.height=height;
        this.width=width;
    }
    public void display(){
        System.out.println("Width: "+getWidth());
        System.out.println("Height: "+getHeight());
        System.out.println("Area: "+calculateArea());
        System.out.println("Perimeter: "+calculatePerimeter());
    }
    public void setWidth(double width){
        this.width=width;
    }
    public void setHeight(double height){
        this.height=height;
    }
    public double getWidth(){
        return this.width;
    }
    public double getHeight(){
        return this.height;
    }
    public double calculateArea(){
        return this.width*this.height;
    }
    public double calculatePerimeter(){
        return (this.width+this.height)*2;
    }
}
class manageRectangle{
    Rectangle[] array;
    int size=0;
    public void input(){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number of rectangle: ");
        size=Integer.parseInt(sc.nextLine());
        array=new Rectangle[size];
        for (int i=0;i<size;i++){
            Rectangle obj=new Rectangle();
            System.out.println("");
            System.out.print("Enter width: ");
            obj.setWidth(Double.parseDouble(sc.nextLine()));
            System.out.print("Enter height: ");
            obj.setHeight(Double.parseDouble(sc.nextLine()));
            array[i]=obj;
        }
    }
    public void display(){
        for (int i=0;i<size;i++){
            System.out.println("-----------------------");
            System.out.println("Information of rectangle "+(i+1));
            array[i].display();
        }
    }
}
public class Workshop4_3 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        manageRectangle array=new manageRectangle();
        array.input();
        array.display();
    }
    
}
