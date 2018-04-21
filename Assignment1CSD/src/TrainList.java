/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class TrainList {
    TrainNode tail,head;
    TrainList(){
        tail=head=null;
    }
    boolean isEmpty(){
        return(head==null);
    }
    void clear(){
        head=tail=null;
    }
    void addLast(Train x){
        TrainNode temp=new TrainNode(x);
        if (isEmpty()){
            head=tail=temp;
            return;
        }
        temp.prev=tail;
        tail.next=temp;
        tail=temp;
    }
    void addFirst(Train x){
        head=new TrainNode(x, null, head);
        if (tail==null) tail=head;
    }
    void visit(TrainNode x){
        if (x!=null){
            System.out.println(x.info);
        }
    }
    void traverse(){
        TrainNode temp=head;
        System.out.println("Code | Name | Place | Seat | Booked | Depart ");
        while (temp!=null){
            visit(temp);
            temp=temp.next;
        }
        System.out.println("");
    }
    TrainNode searchByTcode(String xTcode){
        TrainNode temp=head;
        while (temp!=null){
            if (temp.info.tcode.compareToIgnoreCase(xTcode)==0){
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    TrainNode searchByTcodeAndChangToX(String xTcode){
        TrainNode temp=head;
        while (temp!=null){
            if (temp.info.tcode.compareToIgnoreCase(xTcode)==0){
                temp.info.tcode="X";
                return temp;
            }
            temp=temp.next;
        }
        return null;
    }
    void delete(TrainNode x){
        if (x==null) return;
        TrainNode prevNode=x.prev,nextNode=x.next;
        if (x==head){
            head=head.next;
            return;
        }
        prevNode.next=nextNode;
        if (prevNode.next==null) {
            tail=prevNode;
        }
    }
    void delete(String xTcode){
        TrainNode temp=searchByTcode(xTcode);
        if (temp==null) return;
        delete(temp);
    }
    int size(){
        TrainNode temp=head;
        int i=0;
        while (temp!=null){
            temp=temp.next;
            i++;
        }
        return i;
    }
    void addAfterPosition(TrainNode xTrain,int k){
        if (k==0){
            xTrain.prev=null;
            xTrain.next=head;
            head=xTrain;
        }
        else if (k==size()){
            xTrain.prev=tail;
            xTrain.next=null;
            tail=xTrain;
        }
        else{
            if (k>size()) return;
            int i=0;
            TrainNode temp=head;
            while (temp!=null){
                temp=temp.next;
                i++;
                if (i==k) break;
            }
            TrainNode prevNode=temp.prev;
            TrainNode nextNode=temp;
            prevNode.next=xTrain;
            nextNode.prev=xTrain;
            xTrain.next=nextNode;
            xTrain.prev=prevNode;
        }   
    }
    void deleteBeforeTcode(String xTcode){
        TrainNode temp=searchByTcode(xTcode);
        if (temp==null) return;
        TrainNode prevNode=temp.prev;
        if (prevNode==null) return;
        delete(prevNode);
    }
    void sortByTcode(){
        TrainNode i=head;
        while (i!=null){
            TrainNode j=i.next;
            while (j!=null){
                if (i.info.tcode.compareToIgnoreCase(j.info.tcode)>0){
                    Train temp=i.info;
                    i.info=j.info;
                    j.info=temp;
                }
                j=j.next;
            }
            i=i.next;
        }
    }
    void sortByDepart(){
        TrainNode i=head;
        while (i!=null){
            TrainNode j=i.next;
            while (j!=null){
                if (i.info.depart_time>j.info.depart_time){
                    Train temp=i.info;
                    i.info=j.info;
                    j.info=temp;
                }
                j=j.next;
            }
            i=i.next;
        }
    }
}
