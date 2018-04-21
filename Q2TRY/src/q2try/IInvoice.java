/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package q2try;
import java.util.ArrayList;
/**
 *
 * @author tuans
 */
public interface IInvoice {
    /*
      Firstly, sort the list of invoice “a” ascending by customer name (alphabet order),
     *finally, return the customer name of second invoice in the list “a”. 
     */
    public String f1(ArrayList<Invoice> a);        
   
    /*
      Firstly, remove 2 invoices which are highest amount in the list “a”, 
     *finally calculate and return the sum of amount of all other invoices in the list “a”. 
     */
    public int f2(ArrayList<Invoice> a);
}
