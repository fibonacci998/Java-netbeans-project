/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrongDuyDao
 */
public class Node {
    
    Book info;
    Node next;
    
    //make a new node where next = given Node
    public Node(Book info, Node next) {
        this.info = info;
        this.next = next;
    }
    
    //make a new node where next = null
    public Node(Book info) {
        this(info,null);
    }
}
