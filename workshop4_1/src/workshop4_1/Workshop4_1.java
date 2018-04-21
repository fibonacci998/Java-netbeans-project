/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop4_1;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
class Book{
    String author;
    String title;
    int noOfPages;
    boolean fiction;
    public Book(){}
    public void setAuthor(String author){
        this.author=author;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setNoOfPages(int pages){
        this.noOfPages=pages;
    }
    public void setFiction(boolean fiction){
        this.fiction=fiction;
    }
    public String getAuthor(){
        return this.author;
    }
    public String getTitle(){
        return this.title;
    }
    public int getNoOfPages(){
        return this.noOfPages;
    }
    public boolean getFiction(){
        return this.fiction;
    }
}
class manageBook{
    int size=0;
    Book[] array;
    public manageBook(){}
    public void input(){
        System.out.print("Enter number of books: ");
        Scanner sc=new Scanner(System.in);
        size=Integer.parseInt(sc.nextLine());
        array=new Book[size];

        for (int i=0;i<size;i++){
            Book a=new Book();
            System.out.println("");
            System.out.print("Enter name of book: ");
            a.setTitle(sc.nextLine());
            System.out.print("Enter author of book: ");
            a.setAuthor(sc.nextLine());
            System.out.print("Enter number of pages: ");
            a.setNoOfPages(Integer.parseInt(sc.nextLine()));
            System.out.print("Is this book fiction(y or n)? ");
            String temp=sc.nextLine();
            if ("y".equals(temp)) a.setFiction(true);
            else a.setFiction(false);
            array[i]=a;
        }
    }
    public void display(){
        for (int i=0;i<size;i++){
            System.out.println("-------------------");
            System.out.println("Infomation of "+" book "+(i+1));
            System.out.println("Name: "+array[i].getTitle());
            System.out.println("Author: "+array[i].getAuthor());
            System.out.println("No of pages: "+array[i].getNoOfPages());
            System.out.println("Is fiction? "+array[i].getFiction());
        }
    }
}
public class Workshop4_1 {
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        manageBook array=new manageBook();
        array.input();
        array.display();
    }
    
}
