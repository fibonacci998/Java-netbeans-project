/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.util.*;
import java.io.*;

public class MyList
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

  void loadData(int k)  //do not edit this function
   {String [] a = Lib.readLineToStrArray("data.txt", k);
    int [] b = Lib.readLineToIntArray("data.txt", k+1);
    int [] c = Lib.readLineToIntArray("data.txt", k+2);
    int n = a.length;
    for(int i=0;i<n;i++) addLast(a[i],b[i],c[i]);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//==================================================================
  void addLast(String xType, int xColor, int xPrice)
   {//You should write here appropriate statements to complete this function.
       if (xType.charAt(0)=='B') return;
       Node temp=new Node(new Lamp(xType, xColor, xPrice));
        if (isEmpty()){
            head=tail=temp;
            return;
        }
        tail.next=temp;
        tail=temp;
   }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete the addLast  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void insert(Node node, int position){
      int i=0;
      Node pi=head;
      while (pi!=null){
          if (i==position-1){
              node.next=pi.next;
              pi.next=node;
          }
          pi=pi.next;
          i++;
      }
  }
  void f2() throws Exception
    {clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     ftraverse(f);
     Lamp x, y;
     x = new Lamp("X",1,2);
     y = new Lamp("Y",2,3);
     //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        insert(new Node(x),1);
        insert(new Node(y),3);


    //------------------------------------------------------------------------------------
     ftraverse(f);
     f.close();
    }  

//==================================================================
  void dele(Node q)
     {
         if (q==null) return;
         if (q==head) {
             head=head.next;
             return;
         }
         Node temp=head;
         while (temp!=null && temp.next!=q){
             temp=temp.next;
         }
         if (temp==null) return;
         temp.next=q.next;
         if (temp.next==null) tail=temp;
     }
  void f3() throws Exception
   {clear();
    loadData(9);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        dele(head);
        Node pi=head,pj=null;
        while (pi!=null){
            
            pj=pi;
            pi=pi.next;
            if (pi.next==null) break;
        }
        dele(pj);


    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

//==================================================================
  void f4() throws Exception
   {clear();
    loadData(13);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    ftraverse(f);
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Node pi,pj;
        pi=head;
        pi=pi.next;pi=pi.next;
        while (pi!=null){
            pj=pi.next;
            while (pj!=null){
                if (pi.info.color<pj.info.color){
                    Lamp temp=pi.info;
                    pi.info=pj.info;
                    pj.info=temp;
                }
                pj=pj.next;
            }
            pi=pi.next;
        }



    //------------------------------------------------------------------------------------
    ftraverse(f);
    f.close();
   }

 }
