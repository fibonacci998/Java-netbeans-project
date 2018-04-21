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
public class Thread1 extends Thread{
    Display dis;
    public Thread1(Display dis){
        this.dis=dis;
    }
    public void run(){
        dis.display1();
    }
}
