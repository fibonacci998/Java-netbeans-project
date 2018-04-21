
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class MyQueue {
    LinkedList<Integer>t;
    MyQueue(){
         t=new LinkedList<>();
    }
    void clear(){
        t.clear();
    }
    boolean isEmpty(){
        return t.isEmpty();
    }
    void enqueue(int k){
        t.addLast(k);
    }
    Integer dequeue(){
        if (isEmpty()) 
            return null;
        return t.removeFirst();
        
    }
    Integer front(){
        if (isEmpty())
            return null;
        return t.getFirst();
    }
}
