/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class CustomerList {
    CustomerNode head,tail;

    public CustomerList() {
        head=tail=null;
    }
    boolean isEmpty(){
        return(head==null);
    }
    void clear(){
        head=tail=null;
    }
    void visit(CustomerNode x){
        if (x!=null){
            System.out.println(x.info);
        }
    }
    void traverse(){
        CustomerNode temp=head;
        while (temp!=null){
            visit(temp);
            temp=temp.next;
        }
        System.out.println("");
    }
    void addLast(Customer x){
        CustomerNode temp=new CustomerNode(x);
        if (isEmpty()){
            head=tail=temp;
            return;
        }
        temp.prev=tail;
        tail.next=temp;
        tail=temp;
    }
    void addFirst(Customer x){
        head=new CustomerNode(x, null, head);
        if (tail==null) tail=head;
    }
    CustomerNode searchByCcode(String xCcode){
        CustomerNode temp=head;
        while (temp!=null){
            if (temp.info.ccode.compareToIgnoreCase(xCcode)==0){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    void delete(CustomerNode x){
        if (x==null) return;
        CustomerNode prevNode=x.prev,nextNode=x.next;
        if (x==head){
            head=head.next;
            return;
        }
        prevNode.next=nextNode;
        if (prevNode.next==null) {
            tail=prevNode;
        }
    }
    void delete(String xCcode){
        CustomerNode temp=searchByCcode(xCcode);
        if (temp==null) return;
        delete(temp);
    }
}
