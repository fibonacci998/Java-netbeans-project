/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class CustomerNode {
    Customer info;
    CustomerNode prev,next;
    public CustomerNode(Customer info) {
        this.info = info;
        prev=next=null;
    }

    public CustomerNode(Customer info, CustomerNode prev, CustomerNode next) {
        this.info = info;
        this.prev = prev;
        this.next = next;
    }
    
    public CustomerNode() {}
}
