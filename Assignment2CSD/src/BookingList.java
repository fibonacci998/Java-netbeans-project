/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class BookingList {
    BookingNode tail,head;
    BookingList(){
        tail=head=null;
    }
    boolean isEmpty(){
        return(head==null);
    }
    void clear(){
        head=tail=null;
    }
    void addLast(Booking x){
        BookingNode temp=new BookingNode(x);
        if (isEmpty()){
            head=tail=temp;
            return;
        }
        temp.prev=tail;
        tail.next=temp;
        tail=temp;
    }
    void addFirst(Booking x){
        head=new BookingNode(x, null, head);
        if (tail==null) tail=head;
    }
    void visit(BookingNode x){
        if (x!=null){
            System.out.println(x.info);
        }
    }
    void traverse(){
        BookingNode temp=head;
        while (temp!=null){
            visit(temp);
            temp=temp.next;
        }
        System.out.println("");
    }
    BookingNode searchByTcode(String xTcode){
        BookingNode temp=head;
        while (temp!=null){
            if (temp.info.tcode.compareToIgnoreCase(xTcode)==0){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    BookingNode searchByCcode(String xCcode){
        BookingNode temp=head;
        while (temp!=null){
            if (temp.info.ccode.compareToIgnoreCase(xCcode)==0){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    void sortByTcodeAndCcode(){
        BookingNode i=head;
        while(i!=null){
            BookingNode j=i.next;
            while(j!=null){
                if ((i.info.tcode.compareToIgnoreCase(j.info.tcode)>0) || 
                    (i.info.tcode.compareToIgnoreCase(j.info.tcode)==0 &&
                    i.info.ccode.compareTo(j.info.ccode)>0)){
                    Booking temp=i.info;
                    i.info=j.info;
                    j.info=temp;
                }
                j=j.next;
            }
            i=i.next;
        }
    }
}
