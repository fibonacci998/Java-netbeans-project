/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import static java.lang.Integer.max;
import java.util.*;
import javafx.util.Pair;

class BSTree
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

  void fvisitBal(Node p, RandomAccessFile f) throws Exception
    {if(p != null) 
      f.writeBytes("("+p.info.name+","+p.info.age+","+p.bal+") ");
    }

  void fvisitLevel(Node p, RandomAccessFile f) throws Exception
    {if(p != null) 
      f.writeBytes("("+p.info.name+","+p.info.age+","+p.level+") ");
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
     MyQueue q = new MyQueue();
     q.enqueue(p);Node r;
     while(!q.isEmpty())
       {r = q.dequeue();
        fvisit(r,f);
        if(r.left!=null) q.enqueue(r.left);
        if(r.right!=null) q.enqueue(r.right);
       }
    }

  void breadthBal(Node  p, RandomAccessFile f) throws Exception
   {if(p==null) return;
    MyQueue q = new MyQueue();
    q.enqueue(p); Node r;
    boolean isAVL=true;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisitBal(r,f);
      if (r.bal>=2 || r.bal<=-2) isAVL=false;
      if(r.left != null) q.enqueue(r.left);
      if(r.right != null) q.enqueue(r.right);
     }
    if (!isAVL) f.writeBytes("\nThe tree is not an AVL tree\n");
   }

  void breadthLevel(Node  p, RandomAccessFile f) throws Exception
   {if(p==null) return;
    MyQueue q = new MyQueue();
    q.enqueue(p); Node r;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisitLevel(r,f);
      if(r.left != null) q.enqueue(r.left);
      if(r.right != null) q.enqueue(r.right);
     }
   }

   void loadData(int k)  //do not edit this function
     {String [] a = Lib.readLineToStrArray("person.txt", k);
      int [] b = Lib.readLineToIntArray("person.txt", k+1);
      int n = a.length;
      for(int i=0;i<n;i++) insert(a[i],b[i]);
     }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
//===========================================================================
  void insert(String xName, int xAge)
     {
         if (xName.charAt(0)=='B') return;
         if (isEmpty()){
             root=new Node(new Person(xName, xAge));
             return;
         }
         Node f,p;
         f=null;p=root;
         while (p!=null){
             if (p.info.name.compareToIgnoreCase(xName)==0){
                 return;
             }
             f=p;
             if (p.info.name.compareToIgnoreCase(xName)>0)
                 p=p.left;
             else p=p.right;
         }
         if (f.info.name.compareToIgnoreCase(xName)>0)
                 f.left=new Node(new Person(xName, xAge));
             else f.right=new Node(new Person(xName, xAge));
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
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f123);
     f123.writeBytes("\r\n");
     inOrder(root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  
  
//===============================================================
  void f2() throws Exception
    {clear();
     loadData(5);
     String fname = "f2.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f123);
     f123.writeBytes("\r\n");
     BSTree h = new BSTree();
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     Node temp=root;
     Deque<Node> q=new ArrayDeque<Node>();
     q.addLast(temp);
     while (!q.isEmpty()){
         Node t=q.removeFirst();
         if (t.info.age>4)
         h.insert(t.info.name, t.info.age);
         if (t.left!=null) q.addLast(t.left);
         if (t.right!=null) q.addLast(t.right);
     }

    //-------------------------------------------------------------------------------------
     h.preOrder(h.root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  
//===============================================================
  int dfsWithHeight(Node temp){
      int left=0,right=0;
      if (temp.left!=null)
          left=dfsWithHeight(temp.left);
      if (temp.right!=null)
          right=dfsWithHeight(temp.right);
      if (temp.left==null && temp.right==null) return 1;
      return (max(left,right)+1);
  }
  void f3() throws Exception
    {clear();
     loadData(5);
     String fname = "f3.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     int k = 0;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     k=dfsWithHeight(root);

    //-------------------------------------------------------------------------------------
     f123.writeBytes(" k = " + k + "\r\n");
     f123.close();
    }  

//===============================================================
  int dfsWithSize(Node temp){
      int left=0,right=0;
      if (temp.left!=null)
          left=dfsWithSize(temp.left);
      if (temp.right!=null)
          right=dfsWithSize(temp.right);
      if (temp.left==null && temp.right==null) return 1;
      return (left+right+1);
  }
  void f4() throws Exception
    {clear();
     loadData(5);
     String fname = "f4.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     int k = 0;
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     k=dfsWithSize(root);

    //-------------------------------------------------------------------------------------
     f123.writeBytes(" k = " + k + "\r\n");
     f123.close();
    }  

//===============================================================
  void deleteByCopying(String xName){
      Node f,p;
      f=null;p=root;
      while (p!=null){
            if (p.info.name.compareToIgnoreCase(xName)==0){
                break;
            }
            f=p;
            if (p.info.name.compareToIgnoreCase(xName)>0)
                p=p.left;
            else p=p.right;
        }
      if (p==null) return;
      //p is leaf
      if (p.left==null && p.right==null){
          if (f==null) root=null;//p is root
          else{
              if (p.info.name.compareToIgnoreCase(f.left.info.name)==0)
                  f.left=null;
              else f.right=null;
          }
      }
      //p has left leaf only
      if (p.left!=null && p.right==null){
          if (f==null) root=p.left;//p is root
          else{
              if (p.info.name.compareToIgnoreCase(f.left.info.name)==0)
                  f.left=p.left;
              else f.right=p.left;
          }
      }
      //p has right leaf only
      if (p.left==null && p.right!=null){
          if (f==null) root=p.right;//p is root
          else{
              if (p.info.name.compareToIgnoreCase(f.left.info.name)==0)
                  f.left=p.right;
              else f.right=p.right;
          }
      }
      //p has 2 sons
      if (p.left!=null && p.right!=null){
          //find right most on left sub tree
          Node q=p.left;
          Node frp=null,rp=q;
          while (rp.right!=null){
              frp=rp;
              rp=rp.right;
          }
          //rp is right most node
          p.info=rp.info;
          //delete rp;
          if (frp==null)
              p.left=q.left;
          else
              frp.right=rp.left;
      }
  }
  void f5() throws Exception
    {clear();
     loadData(5);
     String fname = "f5.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     preOrder(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        deleteByCopying(root.info.name);

    //-------------------------------------------------------------------------------------
     preOrder(root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
   Node rotateRight(Node p) {
   if(p==null || p.left==null) return(p);
   Node q = p.left;
   p.left = q.right;
   q.right = p;
   return(q);
 }
 Node rotateLeft(Node p) {
   if(p==null || p.right==null) return(p);
   Node q = p.right;
   p.right = q.left;
   q.left = p;
   return(q);
 }
  void f6() throws Exception
    {clear();
     loadData(5);
     String fname = "f6.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        if (root.left!=null){
            root=rotateRight(root);
        }

    //-------------------------------------------------------------------------------------
     breadth(root,f123);
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void findBal(Node r){
      if (r==null) return;
      
      int left=0,right=0;
      if (r.left!=null){
          findBal(r.left);
          left=dfsWithHeight(r.left);
      }
      if (r.right!=null){
          findBal(r.right);
          right=dfsWithHeight(r.right);
      }
      r.bal=right-left;
  }
  void f7() throws Exception
    {clear();
     loadData(5);
     String fname = "f7.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        findBal(root);
        breadthBal(root, f123);
    //-------------------------------------------------------------------------------------
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void f8() throws Exception
    {clear();
     loadData(5);
     String fname = "f8.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
    Node temp=root;
     Deque<Pair<Node,Integer>> q=new ArrayDeque<Pair<Node,Integer>>();
     q.addLast(new Pair<>(temp,1));
     while (!q.isEmpty()){
         Pair t=q.removeFirst();
         Node tt=(Node) t.getKey();
         
         int level=(int) t.getValue();
         tt.level=level;
         if (tt.left!=null) q.addLast(new Pair<>(tt.left,level+1));
         if (tt.right!=null) q.addLast(new Pair<>(tt.right,level+1));
     }
        breadthLevel(root, f123);
    //-------------------------------------------------------------------------------------
     f123.writeBytes("\r\n");
     f123.close();
    }  

//===============================================================
  void inOrder(ArrayList<Person> t, Node p) {
     if(p==null) return;
     inOrder(t,p.left);
     t.add(p.info);
     inOrder(t,p.right);
 }
  void balance(ArrayList<Person> t,int i, int j) {
     if(i>j) return;
     int k = (i+j)/2;
     Person x = t.get(k);
     insert(x.name,x.age);
     balance(t,i,k-1);
     balance(t,k+1,j);
  }
  void balance() {
    ArrayList<Person> t = new ArrayList<Person>();
    inOrder(t, root);
    clear();
    int n = t.size();
    balance(t,0,n-1);
  }
  void f9() throws Exception
    {clear();
     loadData(5);
     String fname = "f9.txt";
     File g123 = new File(fname);
     if(g123.exists()) g123.delete();
     RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
     breadth(root,f123);
     f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     
     balance();
     breadth(root, f123);
   

    //-------------------------------------------------------------------------------------
     f123.writeBytes("\r\n");
     f123.close();
    }  

 }
