/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

public class BSTree
  {Node root;
   BSTree() {root=null;}
   boolean isEmpty()
      {return(root==null);
      }
   void clear()
      {root=null;
      }
   void fvisit(Node p, RandomAccessFile f) throws Exception
     {if(p != null) f.writeBytes(p.info + " ");
     }
   void preOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      fvisit(p,f);
      preOrder(p.left,f);
      preOrder(p.right,f);
     }
   void inOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      inOrder(p.left,f);
      fvisit(p,f);
      inOrder(p.right,f);
     }
   void postOrder(Node p, RandomAccessFile f) throws Exception
     {if(p==null) return;
      postOrder(p.left,f);
      postOrder(p.right,f);
      fvisit(p,f);
     }
  void breadth(Node p, RandomAccessFile f) throws Exception
    {if(p==null) return;
     BQueue q = new BQueue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("data.txt", k);
      int [] b = Lib.readLineToIntArray("data.txt", k+1);
      int [] c = Lib.readLineToIntArray("data.txt", k+2);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i],c[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
    Node insertRec(Node root,Lamp lamp){
        if (root==null){
            root=new Node(lamp);
            return root;
        }
        if (lamp.price<root.info.price){
            root.left=insertRec(root.left, lamp);
        }else if (lamp.price>root.info.price){
            root.right=insertRec(root.right, lamp);
        }
        return root;
    }
    
  void insert(String xType, int xColor, int xPrice)
     {//You should insert here statements to complete this function
         if (xType.charAt(0)=='A') return;
         root=insertRec(root, new Lamp(xType, xColor, xPrice));

     }

  void f1() throws Exception
    {/* You do not need to edit this function. Your task is to complete insert  function
        above only.
     */
     clear();
     loadData(1);
     String fname = "f1.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
     inOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
  
//=============================================================
  void breadth2(Node p, RandomAccessFile f) throws Exception
    {if(p==null) return;
        int i=0;
     BQueue q = new BQueue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        i++;
        if (i==5) break;
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }
  void f2() throws Exception
    {clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        breadth2(root, f);



    //------------------------------------------------------------------------------------
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
  Node search(Node p, int x) {
        if(p==null) return(null);
        if(p.info.price == x) return(p);
        if(x < p.info.price)
          return(search(p.left,x));
           else
            return(search(p.right,x));
    }
  void f3() throws Exception
    {clear();
     loadData(9);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node se=search(root, 8);
     Queue queue=new ArrayDeque();
     queue.add(se);
     int k=0;
     while (!queue.isEmpty()){
         Node temp=(Node) queue.poll();
         if (temp.left==null && temp.right==null){
             continue;
         }
         k++;
         if (temp.left!=null){
             queue.add(temp.left);
         }
         if (temp.right!=null){
             queue.add(temp.right);
         }
     }
     se.info.color=100+k;



    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
  void f4() throws Exception
    {clear();
     loadData(13);;
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     breadth(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        Queue queue=new ArrayDeque();
        queue.add(root);
        int min=root.info.color+root.info.price;
        Node save=root;
        while (!queue.isEmpty()){
            Node temp=(Node) queue.poll();
            if (temp.info.color+temp.info.price<min){
                save=temp;
                min=temp.info.color+temp.info.price;
            }
            if (temp.left!=null){
             queue.add(temp.left);
            }
            if (temp.right!=null){
                queue.add(temp.right);
            }
        }
        save.info.type="Z";

    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

 }
