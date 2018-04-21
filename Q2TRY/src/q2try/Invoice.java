/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2try;

import java.util.Comparator;

/**
 *
 * @author tuans
 */
public class Invoice  implements Comparable{
    String name;
    int amount;
    public Invoice(){}
    public Invoice(String name,int amount){
        this.name=name;
        this.amount=amount;
    }
    public String getName(){
        return this.name;
    }
    public int getAmount(){
        return this.amount;
    }
    @Override
    public int compareTo(Object t) {
        Invoice temp=(Invoice)t;
        return this.name.toLowerCase().compareTo(temp.getName().toLowerCase());
    }
}
