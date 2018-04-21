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
public class MultiThreadTest {

    /**
     * @param args the command line arguments
     */
    public static void main3(String[] args) {
        // TODO code application logic here
        Thread th=Thread.currentThread();
        System.out.println("Name: "+th.getName());
        System.out.println("Priority: "+th.getPriority());
        System.out.println("Group: "+th.getThreadGroup().getName());
        System.out.println("Normal priority: "+Thread.NORM_PRIORITY);
        System.out.println("Max priority: "+Thread.MAX_PRIORITY);
        System.out.println("Min priority: "+Thread.MIN_PRIORITY);
        MyThread thread=new MyThread();
        thread.start();//ready
        Display obj=new Display();
        //obj.display1();
        //obj.display2();
        Thread1 t1=new Thread1(obj);
        Thread2 t2=new Thread2(obj);
        t1.start();
        t2.start();
        System.out.println("Main Thread end!!!");
    }
    
}
