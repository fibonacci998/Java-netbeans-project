/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multithreadtest;

/**
 *
 * @author tuans
 */
public class Display {
    public void display1(){
        for (int i=0;i<1000;i++){
            System.out.println("i= "+i);
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
               e.printStackTrace();
            }
        }
    }
    public void display2(){
        for (int j=0;j<1000;j++){
            System.out.println("j= "+j);
        }
    }
}
