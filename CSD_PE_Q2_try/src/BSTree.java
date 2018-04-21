/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;
import javafx.util.Pair;

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
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
  void insert(String xOwner, int xPrice)
     {//You should insert here statements to complete this function
         if (xOwner.charAt(0)=='B'|| xPrice>100){
             return;
         }
         if (isEmpty()){
             root=new Node(new Car(xOwner, xPrice));
             return;
         }
         Node f=null,p=root;
         while (p!=null){
             if (p.info.price==xPrice)
                 return;
             f=p;
             if (p.info.price<xPrice)
                 p=p.right;
             else p=p.left;
         }
         if (f.info.price>xPrice) f.left=new Node(new Car(xOwner, xPrice));
         else f.right=new Node(new Car(xOwner, xPrice));
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
     preOrder(root,f);
     f.writeBytes("\r\n");
     inOrder(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  
  
//=============================================================
  void preOrder2(Node p, RandomAccessFile f,int minn,int maxx) throws Exception
     {if(p==null) return;
      if (minn<=p.info.price&&p.info.price<=maxx) fvisit(p,f);
      preOrder2(p.left,f,minn,maxx);
      preOrder2(p.right,f,minn,maxx);
     }
  void f2() throws Exception
    {clear();
     loadData(4);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f);
     f.writeBytes("\r\n");
    //------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        preOrder2(root, f, 3, 5);


    //------------------------------------------------------------------------------------
     f.writeBytes("\r\n");
     f.close();
    }  

// f.writeBytes(" k = " + k + "\r\n");
//=============================================================
    void deleteByCopying(int xPrice){
        Node f,p;
        f=null;p=root;
        while (p!=null){
            if (p.info.price==xPrice) break;
            f=p;
            if (p.info.price>xPrice) p=p.left;
            else p=p.right;
        }
        if (p==null) return;
        //p is leaf
        if (p.left==null && p.right==null){
            if (f==null) root=null;//p is a root
            else {
                if (p==f.left)
                    f.left=null;
                else f.right=null;
            }
        }
        //p has left leaf only
        if (p.left!=null && p.right==null){
            if (f==null) root=p.left;//p is a root
            else {
                if (p==f.left)
                    f.left=p.left;
                else f.right=p.left;
            }
        }
        //p has right leaf only
        if (p.left==null && p.right!=null){
            if (f==null) root=p.right;//p is a root
            else {
                if (p==f.left)
                    f.left=p.right;
                else f.right=p.right;
            }
        }
        
        //p has both 2 sons
        if (p.left!=null && p.right!=null){
            //find the right node on the left sub tree
            Node q=p.left;
            Node frp,rp;
            frp=null; rp=q;
            while (rp.right!=null){
                frp=rp;
                rp=rp.right;
            }
            //rp is the right node
            p.info=rp.info;
            //delete rp;
            if (frp==null){
                p.left=q.left;
            }else{
                frp.right=rp.left;
            }
        }
    }
  void f3() throws Exception
    {clear();
     loadData(7);
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
        Queue queue=new ArrayDeque();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp=(Node) queue.poll();
            if (temp.left!=null&&temp.right!=null&&temp.info.price<7){
                deleteByCopying(temp.info.price);
                break;
            }
            if (temp.left!=null) queue.add(temp.left);
            if (temp.right!=null) queue.add(temp.right);
        }


    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

//=============================================================
  Node findFather(int xPrice){
      Node f,p;
      f=null;p=root;
      while (p!=null){
          if (p.info.price==xPrice) break;
          f=p;
          if (xPrice<p.info.price)
              p=p.left;
          else p=p.right;
      }
      return f;
  }
   Node rotateRight(Node p) {
        if(p==null || p.left==null) return(p);
        Node q = p.left;
        p.left = q.right;
        q.right = p;
        return(q);
    }
   //not used
  Node rotateLeft(Node p) {
   if(p==null || p.right==null) return(p);
   Node q = p.right;
   p.right = q.left;
   q.left = p;
   return(q);
 }
  void f4() throws Exception
    {clear();
     loadData(10);
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
        //Pair tempP=new Pair(root, null);
        Node save=null;
        queue.add(root);
        while (!queue.isEmpty()){
            //Pair tt=(Pair) queue.poll();
            Node temp=(Node) queue.poll();
            if (temp.left!=null&&temp.info.price<7){
                save=temp;
                break;
            }
            if (temp.left!=null) queue.add(temp.left);
            if (temp.right!=null) queue.add(temp.right);
        }
        int xPrice=save.info.price;
        Node r=rotateRight(save);
        Node q=findFather(xPrice);
        if (q==null){
            root=r;
        }else{
            if (q.left==save) q.left=r;
            else q.right=r;
        }

    //------------------------------------------------------------------------------------
     breadth(root,f);
     f.writeBytes("\r\n");
     f.close();
    }  

 }
