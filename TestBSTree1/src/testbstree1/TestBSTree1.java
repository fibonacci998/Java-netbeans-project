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
public class TestBSTree1 {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BSTree t=new BSTree();
        int[] a={8,6,9,2,7,1,3,5,4};
        t.insertMany(a);
        
        System.out.println("1. Test bread first travelsal: ");
        t.bfs(t.root);
        System.out.println("");
        System.out.println("2. Test pre order: ");
        t.preOrder(t.root);System.out.println("");
        System.out.println("3. Test in order: ");
        t.inOrder(t.root);
        System.out.println("");
        System.out.println("4. Test post order: ");
        t.postOrder(t.root);
        System.out.println("");
        
        
        System.out.println("5. Test delete by copying: ");
        t.deleteByCopying(6);
        t.bfs(t.root);
        System.out.println("");
        
        System.out.println("6. Test delete by merging: ");
        t.deleteByCopying(9);
        t.bfs(t.root);
        System.out.println("");
    }
    
}
