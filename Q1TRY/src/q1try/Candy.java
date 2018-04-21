/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q1try;

/**
 *
 * @author tuans
 */
public class Candy extends DessertItem{
    Double price;
    Double weight;

    public Candy(String name) {
        super(name);
    }
    public Candy(String name,Double price,Double weight){
        super(name);
        this.price=price;
        this.weight=weight;
    }
    public Double getCost(){
        Double cost=this.price*this.weight;
        char ch=this.name.charAt(0);
        if (ch=='c' || ch=='C'){
            return Math.ceil(cost);
        }
        return Math.floor(cost);
    }
    @Override
    public String toString(){
        return this.name+' '+this.price+' '+this.weight;
    }
}
