public class Node {
    Person info;
    Node next;
    Node(){
    
    }
    Node(Person xinfo,Node xnext){
        this.info=xinfo;
        this.next=xnext;
    }
    Node(Person x){
        this.info=x;
        this.next=null;
        //this(x,null);
    }
}
