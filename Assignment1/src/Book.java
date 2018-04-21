/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrongDuyDao
 */
public class Book {
    
    String code, name, author;
    double price;

    public Book() {
    }

    public Book(String code, String name, String author, double price) {
        this.code = code;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-20s%-20s%-10.1f\n",code,name,author,price);
    }

    
    
    
}
