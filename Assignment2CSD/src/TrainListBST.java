
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class TrainListBST {
    TrainNode root;
    TrainListBST(){
        root=null;
    }
    boolean isEmpty(){
        return (root==null);
    }
    void clear(){
        root=null;
    }
    TrainNode search(TrainNode p,String x){
        if (p==null) return null;
        if (p.info.tcode.compareToIgnoreCase(x)==0) return p;
        if (p.info.tcode.compareToIgnoreCase(x)>0) return search(p.left,x);
        return search(p.right,x);
    }
    void insert(String xTcode,String xTrain_Name,int xSeat,int xBooked,
            double xDepart_Time,String xDepart_Place){
        if (isEmpty()){
            root=new TrainNode(new Train(xTcode, xTrain_Name, xSeat, xBooked, xDepart_Time, xDepart_Place));
            return;
        }
        TrainNode f=null,p=root;
        while (p!=null){
            if (p.info.tcode.compareToIgnoreCase(xTcode)==0){
                System.out.println("This value Tcode is exited");
                return;
            }
            f=p;
            if (p.info.tcode.compareToIgnoreCase(xTcode)>0)
                p=p.left;
            else p=p.right;
        }
        if (f.info.tcode.compareToIgnoreCase(xTcode)>0) f.left=new TrainNode(new Train(xTcode, xTrain_Name, xSeat, xBooked, xDepart_Time, xDepart_Place));
        else f.right=new TrainNode(new Train(xTcode, xTrain_Name, xSeat, xBooked, xDepart_Time, xDepart_Place));
    }
    void insertMany(Train[] a){
        for (int i=0;i<a.length;i++){
            insert(a[i].tcode, a[i].train_name, a[i].seat, a[i].booked,
                    a[i].depart_time, a[i].depart_place);
        }
    }
    void visit(TrainNode p){
        if (p!=null) System.out.println(p.info+"    ");
    }
    void bfs(){
        Deque<TrainNode> q=new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()){
            TrainNode temp=q.removeFirst();
            visit(temp);
            if (temp.left!=null) q.add(temp.left);
            if (temp.right!=null) q.add(temp.right);
        }
    }
    void dfsInOrder(TrainNode p){
        if (p==null) return;
        dfsInOrder(p.left);
        visit(p);
        dfsInOrder(p.right);
    }
    void deleteByCopying(String x){
        TrainNode f,p;
        f=null;p=root;
        while (p!=null){
            if (p.info.tcode.compareToIgnoreCase(x)==0) break;
            f=p;
            if (p.info.tcode.compareToIgnoreCase(x)>0) p=p.left;
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
            TrainNode q=p.left;
            TrainNode frp,rp;
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
    int countTrains(TrainNode p){
        if (p==null) return 0;
        return (1+countTrains(p.left)+countTrains(p.right));
    }
    void inOrderToArray(ArrayList<Train> t,TrainNode p){
        if (p==null) return;
        inOrderToArray(t, p.left);
        t.add(p.info);
        inOrderToArray(t, p.right);
    }
    void balance(ArrayList<Train> t,int i,int j){
        if (i>j) return;
        int k=(i+j)/2;
        Train x=t.get(k);
        insert(x.tcode,x.train_name,x.seat,
                x.booked, x.depart_time, x.depart_place);
        balance(t,i,k-1);
        balance(t,k+1,j);
    }
    void balance(){
        ArrayList<Train> t=new ArrayList<Train>();
        inOrderToArray(t, root);
        clear();
        int n=t.size();
        balance(t, 0, n-1);
    }
    TrainNode findFather(TrainListBST tree, TrainNode node){
      TrainNode f,p;
      f=null;p=node;
      Queue queue=new ArrayDeque();
      queue.add(tree.root);
      while (!queue.isEmpty()){
            TrainNode temp=(TrainNode) queue.poll();
            if (temp.left!=null){
                if (temp.left.info==node.info){
                return temp;
                }
            }
                
            if (temp.right!=null){
                if (temp.right.info==node.info){
                return temp;
            }
            }
            
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
      }
      return null;
  }

    void insert1(String xTcode,String xTrain_Name,int xSeat,int xBooked,
            double xDepart_Time,String xDepart_Place, TrainListBST tree){
        if (tree.isEmpty()){
            tree.root=new TrainNode(new Train(xTcode, xTrain_Name, xSeat, xBooked, xDepart_Time, xDepart_Place));
            return;
        }
        TrainNode f=null,p=root;
        while (p!=null){
            if (p.info.tcode.compareToIgnoreCase(xTcode)==0){
                System.out.println("This value Tcode is exited");
                return;
            }
            f=p;
            if (p.info.tcode.compareToIgnoreCase(xTcode)>0)
                p=p.left;
            else p=p.right;
        }
        if (f.info.tcode.compareToIgnoreCase(xTcode)>0) f.left=new TrainNode(new Train(xTcode, xTrain_Name, xSeat, xBooked, xDepart_Time, xDepart_Place));
        else f.right=new TrainNode(new Train(xTcode, xTrain_Name, xSeat, xBooked, xDepart_Time, xDepart_Place));
    }
    void balance1(ArrayList<Train> t,int i,int j, TrainListBST tree){
        if (i>j) return;
        int k=(i+j)/2;
        Train x=t.get(k);
        insert1(x.tcode,x.train_name,x.seat,
                x.booked, x.depart_time, x.depart_place,tree);
        balance1(t,i,k-1,tree);
        balance1(t,k+1,j,tree);
    }
    void balance1(){
        ArrayList<Train> t=new ArrayList<Train>();
        
        TrainNode x=null;
        TrainListBST tempTree=this;
        Queue queue=new ArrayDeque();
        queue.add(tempTree.root);
        while (!queue.isEmpty()){
            TrainNode temp=(TrainNode) queue.poll();
            if (temp.info.tcode.compareToIgnoreCase("3")==0) {
                x=temp;
                break;
            }
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }
        TrainNode father=findFather(tempTree,x);
        boolean left=true;
        if (father.left.info!=x.info){
            left=false;
        }
        
        
        inOrderToArray(t, x);
        queue.add(x);
        int count=0;
        while (!queue.isEmpty()){
            TrainNode temp=(TrainNode) queue.poll();
            count++;
            if (temp.left!=null)
                queue.add(temp.left);
            if (temp.right!=null)
                queue.add(temp.right);
        }
        
        
        clear();
        
        int n=t.size();
        balance1(t, 0, count-1,this);
        
        TrainListBST tempTree2=this;
        
        root=tempTree.root;
        if (left==true){
            father.left=tempTree2.root;
        }
        else 
            father.right=tempTree2.root;
        
        
    }
}
