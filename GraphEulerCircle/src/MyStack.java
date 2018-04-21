/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
import java.util.*;
public class MyStack {
    LinkedList<Integer> t;
    void clear() {
      t.clear();  
    }
    MyStack() {
      t = new LinkedList<Integer>();  
    }
    boolean isEmpty() {
      return(t.isEmpty());  
    }
    void push(int k) {
      t.addLast(k);  
    }
    Integer pop() {
      if(isEmpty()) return(null);
      return(t.removeLast());  
    }
    Integer top() {
        if(isEmpty()) return(null);
        return(t.getLast());  
    } 
}

