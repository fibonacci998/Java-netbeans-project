/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int [][] p={
            {0,1,1,1,0,0},
            {1,0,0,0,1,0},
            {1,0,0,0,1,1},
            {1,0,0,0,0,1},
            {0,1,1,0,0,0},
            {0,0,1,1,0,0}
        };
        Graph g=new Graph();
        g.setData(p);
        g.display();
        System.out.println("");
        System.out.println("Test breadth first traversal:");
        g.bfs(0);
        System.out.println("");
        System.out.println("Test depth first traversal:");
        g.dfs(0);
        System.out.println("");
    }
    
    
}
