/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadtest;

import java.util.logging.Logger;

/**
 *
 * @author tuans
 */
public class SynMethod {
    public synchronized void display(String name){
        System.out.println(name+" start");
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            
        }
        System.out.println(name+" end");
    }
}
class MySynMethod extends Thread{
    SynMethod obj;
    public MySynMethod(SynMethod obj){
        this.obj=obj;
    }
    public void run(){
        obj.display(this.getName());
    }
}
class TestSyn{
    public static void main(String[] args){
        SynMethod obj=new SynMethod();
        MySynMethod t1=new MySynMethod(obj);
        
        MySynMethod t2=new MySynMethod(obj);
        t1.start();
        t2.start();
    }
}