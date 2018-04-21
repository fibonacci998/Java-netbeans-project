public class MyList {
    Node head,tail;
    MyList(){
        head=tail=null;
    }
    boolean isEmpty(){
        return (head==null);
    }
    void clear(){
        head=tail=null;
    }
    void addLast(Person x){
        Node q=new Node(x);
        if (isEmpty()){
            head=tail=q;
            return;
        }
        tail.next=q;
        tail=q;
    }
    void addMany(String[] a,int[] b){
        for (int i=0;i<a.length;i++){
            addLast(new Person(a[i],b[i]));
        }
    }
    void visit(Node p){
        if (p!=null)
            System.out.println(p.info+" ");
    }
    void traversal(){
        Node p=head;
        while (p!=null){
            visit(p);
            p=p.next;
        }
    }
}
