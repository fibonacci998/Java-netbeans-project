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
//        Graph a=new Graph(6);
//        initGraph1(a);
//        a.dijkstra(0, 4);
        Graph a=new Graph(4);
        initGraph2(a);
        a.testEuler();
    }
    //dijkstra
    private static void initGraph1(Graph a) {
        a.addEdge(0, 1, 7);
        a.addEdge(0, 2, 9);
        a.addEdge(0, 3, 99);
        a.addEdge(0, 4, 99);
        a.addEdge(0, 5, 14);
        a.addEdge(1, 2, 10);
        a.addEdge(1, 3, 15);
        a.addEdge(1, 4, 99);
        a.addEdge(1, 5, 99);
        a.addEdge(2, 3, 11);
        a.addEdge(2, 4, 99);
        a.addEdge(2, 5, 2);
        a.addEdge(3, 4, 6);
        a.addEdge(3, 5, 99);
        a.addEdge(4, 5, 9);
    }

    private static void initGraph2(Graph a) {
        a.addEdge(0, 1, 1);
        a.addEdge(0, 2, 2);
        a.addEdge(0, 3, 1);
        a.addEdge(1, 2, 1);
        a.addEdge(2, 3, 1);
    }
    
}
