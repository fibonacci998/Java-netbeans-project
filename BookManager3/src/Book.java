
import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class Book implements Serializable{
    private String bookID;
    private String bookName;
    private int quantity;
    private int price;
    public Book(){}
    public Book(String xID, String xName, int xQuantity, int xPrice){
        bookID=xID;
        bookName=xName;
        quantity=xQuantity;
        price=xPrice;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        return bookID + "|" + bookName + "|" + quantity + "|" + price;
    }

    public String getBookID() {
        return bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
  
}
