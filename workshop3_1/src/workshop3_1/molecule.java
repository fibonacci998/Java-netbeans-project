/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3_1;

/**
 *
 * @author tuans
 */
public class molecule {
    String structure;
    String name;
    double weight;
    public molecule(){}
    public molecule(String structure,String name,double weight){
        this.structure=structure;
        this.name=name;
        this.weight=weight;
    }
    public void display(){
        System.out.println(structure+"\t"+name+"\t"+weight);
    }
}
