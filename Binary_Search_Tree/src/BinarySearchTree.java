
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class BinarySearchTree {
    Node root;

    public BinarySearchTree() {
        root=null;
    }
    Node search(Node p, int x) {
        if(p==null) return(null);
        if(p.key == x) return(p);
        if(x < p.key)
          return(search(p.left,x));
           else
            return(search(p.right,x));
    }
    void insert(int key){
        root=insertRec(root,key);
    }
    Node insertRec(Node root,int key){
        if (root==null){
            root=new Node(key);
            return root;
        }
        if (key<root.key){
            root.left=insertRec(root.left, key);
        }else if (key>root.key){
            root.right=insertRec(root.right, key);
        }
        return root;
    }
    void inorder()  {
       inorderRec(root);
    }
 
    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key+" ");
            inorderRec(root.right);
        }
    }
    void deleteKey(int key){
        root=deleteRec(root, key);
    }
    Node deleteRec(Node root,int key){
        if (root==null) return root;
        if (key<root.key)
            root.left=deleteRec(root.left,key);
        else if (key>root.key)
            root.right=deleteRec(root.right,key);
        else{
            if (root.left==null)
                return root.right;
            else if (root.right==null)
                return root.left;
            root.key=minValue(root.right);
            root.right=deleteRec(root.right, root.key);
        }
        return root;
    }
    int minValue(Node root){
        int minv=root.key;
        while (root.left!=null){
            minv=root.left.key;
            root=root.left;
        }
        return minv;
    }
    void inOrder(ArrayList<Integer> t, Node p) {
        if(p==null) return;
        inOrder(t,p.left);
        t.add(p.key);
        inOrder(t,p.right);
    }
    void balance(ArrayList<Integer> t,int i, int j) {
        if(i>j) return;
        int k = (i+j)/2;
        int x = t.get(k);
        insert(x);
        balance(t,i,k-1);
        balance(t,k+1,j);
    }
    void clear() {
        root = null;  
    }
    void balance() {
        ArrayList<Integer> t = new ArrayList<Integer>();
        inOrder(t,root);
        clear();
        int n = t.size();
        balance(t,0,n-1);
    }
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
}
