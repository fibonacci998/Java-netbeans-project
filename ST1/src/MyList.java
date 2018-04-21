/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class MyList
 {Node head,tail;
  MyList() {head=tail=null;}
  boolean isEmpty()
   {return(head==null);
   }
  void clear() {head=tail=null;}

  void fvisit(Node p, RandomAccessFile f) throws Exception
   {if(p != null) f.writeBytes(p.info + " ");
   }

  void ftraverse(RandomAccessFile f) throws Exception
   {Node p = head;
    while(p!=null)
      {fvisit(p,f); // You will use this statement to write information of the node p to the file
       p=p.next;
      }
    f.writeBytes("\r\n");
   }

  void loadDataToLast(int k)  //do not edit this function
   {
    String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i]);
   }

  void loadDataToFirst(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("person.txt", k);
    int [] b = Lib.readLineToIntArray("person.txt", k+1);
    int n = a.length;
    for(int i=0;i<n;i++) addFirst(a[i],b[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void addLast(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
       if (xName.charAt(0)=='B'){
           return;
       }
       Node temp=new Node(new Person(xName, xAge));
       if (isEmpty()){
           head=tail=temp;
           return;
       }
       tail.next=temp;
       tail=temp;
   }

  void addFirst(String xName, int xAge)
   {//You should write here appropriate statements to complete this function.
       if (xName.charAt(0)=='B'){
           return;
       }
       head=new Node(new Person(xName, xAge), head);
       if (tail==null){
           tail=head;
       }
   }

//=================================================================
  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadDataToLast(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  void f2() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addFirst  function
        above only.
     */
     clear();
     loadDataToFirst(1);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     ftraverse(f123);
     f123.close();
    }  

//=================================================================
  void f3() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);

    MyList  h = new MyList();
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node temp=head;
        while (temp!=null){
            if (temp.info.age>4){
                h.addLast(temp.info.name, temp.info.age);
            }
            temp=temp.next;
        }

    //-------------------------------------------------------------------------------------
    h.ftraverse(f123);
    f123.close();
   }

//=================================================================
  void dele(Node x){
    if (x==null) return;
    Node temp=head;
    while (temp!=null && temp.next!=x){
        if (temp.next!=x) break;
        temp=temp.next;
    }
    if (temp==null) return;
    temp.next=x.next;
    if (temp.next==null) tail=temp;
  }
  void f4() throws Exception
   {clear();
    loadDataToLast(4);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node temp=head;
        while (temp!=null){
            if (temp.info.age<6){
                dele(temp);
                break;
            }
            temp=temp.next;
        }

    //-------------------------------------------------------------------------------------
     ftraverse(f123);
     f123.close();
   }

//=================================================================
  void f5() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node i=head;
        while (i!=null){
            Node j=i.next;
            while (j!=null){
                if (i.info.name.compareToIgnoreCase(j.info.name)>0){
                    Person temp=i.info;
                    i.info=j.info;
                    j.info=temp;                
                }
                j=j.next;
            }
            i=i.next;
        }

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }


//=================================================================
  void f6() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        MyList reList=new MyList();
        Node temp=head;
        while (temp!=null){
            reList.addFirst(temp.info.name, temp.info.age);
            temp=temp.next;
        }
        head=reList.head;
        tail=reList.tail;
    //--------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f7() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f7.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    MyList h = new MyList();
    h.loadDataToLast(7);
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node temp=h.head;
        while (temp!=null){
            addLast(temp.info.name, temp.info.age);
            temp=temp.next;
        }

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f8() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f8.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    int k = 3;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        int i=0;
        Node temp=head;
        while (temp!=null){
            if (i==k) {
                dele(temp);
                break;
            }
            temp=temp.next;
            i++;
        }

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

//=================================================================
  void f9() throws Exception // sort by name
   {clear();
    loadDataToLast(4);
    String fname = "f9.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    ftraverse(f123);
    String xName = "C6";
    String yName = "CX";
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node temp=head;
        while (temp!=null){
            if (temp.info.name.compareToIgnoreCase(xName)==0){
                temp.info.name=yName;
                break;
            }
            temp=temp.next;
        }

    //-------------------------------------------------------------------------------------
    ftraverse(f123);
    f123.close();
   }

 }
