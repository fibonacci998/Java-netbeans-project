
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
    String bookID,bookName;
    int quantity,price;
    public Book(){}
    public Book(String xID, String xName, int xQuantity, int xPrice){
        bookID=xID;
        bookName=xName;
        quantity=xQuantity;
        price=xPrice;
    }

    @Override
    public String toString() {
        return bookID + "|" + bookName + "|" + quantity + "|" + price;
    }
    
}
