/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testbstree1;

/**
 *
 * @author tuans
 */
public class BSTree {
    Node root;
    BSTree(){
        root=null;
    }
    boolean isEmpty(){
        return (root==null);
    }
    void clear(){
        root=null;
    }
    Node search(Node p, int x){
        if (p==null) return null;
        if (p.info==x) return p;
        if (x<p.info) return search(p.left, x);
        else return search(p.right,x);
    }
    void insert(int x){
        if (isEmpty()){
            root=new Node(x);
            return;
        }
        Node f=null,p;
        p=root;
        while (p!=null){
            if (p.info==x){
                System.out.println("This value "+x+" is exits!");
                return;
            }
            f=p;
            if (x<p.info)
                p=p.left;
            else p=p.right;
            
        }
        if (x<f.info) f.left=new Node(x);
        else f.right=new Node(x);
    }
    void insertMany(int[] a){
        for (int i=0;i<a.length;i++){
            insert(a[i]);
        }
    }
    void visit(Node p){
        if (p!=null) System.out.print(p.info+"    ");
    }
    void bfs(Node p){
        if (p==null) return;
        MyQueue q=new MyQueue();
        q.enqueue(p);
        while (!q.isEmpty()){
            Node r =q.dequeue();
            visit(r);
            if (r.left!=null) q.enqueue(r.left);
            if (r.right!=null) q.enqueue(r.right);
        }
    }
    void preOrder(Node p){
        if (p==null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }
    void inOrder(Node p){
        if (p==null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }
    void postOrder(Node p){
        if (p==null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
    void deleteByCopying(int x){
        Node f,p;
        f=null;p=root;
        while (p!=null){
            if (p.info==x) break;
            f=p;
            if (x<p.info) p=p.left;
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
        // This method mainly calls deleteRec()
    void deleteByMerging(int key)
    {
        root = deleteRec(root, key);
    }
 
    /* A recursive function to insert a new key in BST */
    Node deleteRec(Node root, int key)
    {
        /* Base Case: If the tree is empty */
        if (root == null)  return root;
 
        /* Otherwise, recur down the tree */
        if (key < root.info)
            root.left = deleteRec(root.left, key);
        else if (key > root.info)
            root.right = deleteRec(root.right, key);
 
        // if key is same as root's key, then This is the node
        // to be deleted
        else
        {
            // node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
 
            // node with two children: Get the inorder successor (smallest
            // in the right subtree)
            root.info = minValue(root.right);
 
            // Delete the inorder successor
            root.right = deleteRec(root.right, root.info);
        }
 
        return root;
    }
 
    int minValue(Node root)
    {
        int minv = root.info;
        while (root.left != null)
        {
            minv = root.left.info;
            root = root.left;
        }
        return minv;
    }
 
}
