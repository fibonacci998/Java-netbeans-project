/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2try;
import java.util.*;
/**
 *
 * @author tuans
 */
public class MyInvoice  implements IInvoice{
    public MyInvoice(){}
    //write the definition of method f1 here 
    @Override
    public String f1(ArrayList<Invoice> a) {
        Collections.sort(a);
        return a.get(1).getName();
    }

    //write the definition of method f2 here 
    @Override
    public int f2(ArrayList<Invoice> a) {
        int x=a.get(0).getAmount();
        for (Invoice temp:a){
            x=Math.max(x, temp.getAmount());
        }
        int y=-100;
        for (Invoice temp:a){
            if (temp.getAmount()!=x){
                y=Math.max(y,temp.getAmount());
            }
        }
        int sum=0;
        int n=a.size();
        for (Invoice temp:a){
            if (temp.getAmount()!=x && temp.getAmount()!=y){
                sum+=temp.getAmount();
            }
        }
        return sum;
    }
    //add and complete you other methods (if needed) here   
}
