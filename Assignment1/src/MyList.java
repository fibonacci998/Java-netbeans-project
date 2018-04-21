
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrongDuyDao
 */
public class MyList {
    //a list of Nodes
    Node head, tail;
    
    //ctor
    public MyList() {
        head = tail = null;
    }
    //1. return true if list is empty otherwise return false
    public boolean isEmpty() {
        return head == null;
    }
    //2. insertion: insert a Color to the end of list
    //O(1)
    public void addLast(Book c) {
        //make a new Node where next = null
        Node p = new Node(c);
        if(isEmpty()) head = tail = p;
        else {
            tail.next = p;
            tail = p;
        }
    }
     //3. insertion: insert a Color to the beginning of list
    //O(1)
    public void addFirst(Book c) {
        //make a new Node where next = null
        Node p = new Node(c);
        if(isEmpty()) head = tail = p;
        else {
            p.next = head;
            head = p;
        }
    }
    //4. traversal a list
    public void traversal() {
        Node p = head;
        while(p != null) {
            System.out.println(p.info);
            p = p.next;
        }
    }
    //5. remove a Node at position k, starting position is 0
    //O(n)
    public void remove(int k) {
        if(isEmpty()) return;
        //remove head
        if(k == 0) {
            Node p = head;
            head = head.next;
            p.next = null;
        }else {
            Node p = getNode(k);
            if(p == null) return;
            Node q = getNode(k - 1);
            //remove p
            q.next = p.next;
            p.next = null;
            if(p == tail) tail = q;
        }
    }
    //6. get a Node at position k
    //O(n)
    public Node getNode(int k) {
        int c = 0;
        Node p = head;
        while(p != null && c < k) {
            p = p.next;
            c ++;
        }
        return p;
    }
    //7. count number of nodes in the list
    public int size() {
        int c = 0;
        Node p = head;
        while(p != null) {
            p = p.next;
            c ++;
        }
        return c;
    }
    //8. reverse the list
    public void reverse() {
        int n = size(), i , j;
        for(i = 0, j = n - 1; i < j; i++, j--) {
            Node pi = getNode(i);
            Node pj = getNode(j);
            Book temp = pi.info;
            pi.info = pj.info;
            pj.info = temp;
        }
    }
    //9. sort the list ascending by color value
    public void sort() {
        Node pi, pj;
        pi = head;
        while(pi != null) {
            pj = pi.next;
            while(pj != null) {
                if(pi.info.code.compareToIgnoreCase(pj.info.code) > 0) {
                    Book t = pi.info; pi.info = pj.info;pj.info = t;
                }
                pj = pj.next;
            }
            pi = pi.next;
        }
    }
    //10. remove the second biggest book price in the list
    public void removeSecond() {
        Book firstMax = getMaxPrice();
        if(firstMax == null) return;
        int n = size();
        if(n <= 1) return;
        int imax = 0;
        Node p = head;
        while(p != null && p.info.price == firstMax.price) {
            imax ++;
            p = p.next;
        }
        //find second max starting from imax
        Book secondMax = (p != null)? p.info : null;
        for (int i = imax + 1; i < n; i++) {
            Node pi = getNode(i);
            if(pi.info.price > secondMax.price && 
                    pi.info.price != firstMax.price) {
                imax = i;
                secondMax = pi.info;
            }
        }
        if(imax < n) remove(imax);
    }
    //11. return the first Node which color name = given color name
    //return null if given color name does not exists in the list
    public Node search(String colorName) {
        Node p = head;
        while(p != null) {
            if(p.info.name.equalsIgnoreCase(colorName)) break;
            p = p.next;
        }
        return p;
    }
    public int searchByCodeIndex(String xcode){
        Node p = head;
        int index=0;
        while(p != null) {
            if(p.info.code.equalsIgnoreCase(xcode)) break;
            p = p.next;
            index++;
        }
        if (p==null) return -1;
        return index;
    }
    public int searchIndex(String colorName){
        Node p = head;
        int index=0;
        while(p != null) {
            if(p.info.name.equalsIgnoreCase(colorName)) break;
            index++;
            p = p.next;
        }
        if (p==null) return -1;
        return index;
    }
    void addAfterPosition(Node xNode,int k){
        if (k==0){
            xNode.next=head;
            head=xNode;
        }
        else if (k==size()){
            xNode.next=null;
            tail=xNode;
        }
        else{
            if (k>size()) return;
            int i=0;
            Node temp=head;
            while (temp!=null){
                if (i==k) break;
                temp=temp.next;
                i++;
            }
            
            Node nextNode=temp.next;
            temp.next=xNode;
            xNode.next=nextNode;

        }   
    }
    //0. helper: return the first biggest Book price in the list
    public Book getMaxPrice() {
        if(isEmpty()) return null;
        Book max = head.info;
        Node p = head;
        while(p != null) {
            if(p.info.price > max.price) max = p.info;
            p = p.next;
        }
        return max;
    }
    
    //load books to the list
    public void load() throws Exception {
        LineNumberReader lnr = null;
        lnr = new LineNumberReader(new FileReader("book.txt"));
        String s;
        while((s = lnr.readLine()) != null) {
            if(s.equals("")) continue;
//            String [] st = s.trim().split("#");
//            String code = st[0].trim();
//            String name = st[1].trim();
//            String author = st[2].trim();
//            name=name.replaceAll("^\\s+", "");
//            double price = Double.valueOf(st[3].trim());
            StringTokenizer token=new StringTokenizer(s,"#");
            String code = token.nextToken();
            String name = token.nextToken();
            String author = token.nextToken();
            double price=Double.parseDouble(token.nextToken());
            Book b = new Book(code, name, author, price);
            addLast(b);
        }
        if(lnr != null) lnr.close();
    }
    
}
