/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbstree1;

import java.util.LinkedList;

/**
 *
 * @author tuans
 */
public class MyQueue {
    LinkedList<Node> l;

    public MyQueue() {
        l=new LinkedList<Node>();
    }
    boolean isEmpty(){
        return l.isEmpty();
    }
    void clear(){
        l.clear();
    }
    void enqueue(Node x){
        l.addLast(x);
    }
    Node dequeue(){
        if (isEmpty()) return null;
        return (l.removeFirst());
    }
    Node front(){
        if (isEmpty()) return null;
        return (l.getFirst());
    }
}
