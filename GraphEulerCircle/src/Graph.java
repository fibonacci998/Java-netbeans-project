/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class Graph {
    int[][] a;
    int n;
    char [] label;
    Graph(){
        label="abcdefghijklm".toCharArray();
    }
    void setData(int[][] p){
        n=p.length;
        a=new int [n][n];
        for (int i=0;i<n;i++)
            for (int j=0;j<n;j++)
                a[i][j]=p[i][j];
    }
    void display(){
        for (int i=0;i<n;i++){
            System.out.println("");
            for (int j=0;j<n;j++)
                System.out.printf("%d ",a[i][j]);
        } 
    }
    void visit(int i){
        System.out.print(label[i]+" ");
    }
    void breadth(Boolean[] dd, int k){
        MyQueue q=new MyQueue();
        q.enqueue(k);dd[k]=true;
        while (!q.isEmpty()){
            int r=q.dequeue();
            visit(r);
            for (int i=0;i<n;i++){
                if (!dd[i] && a[r][i]>0){
                    q.enqueue(i);
                    dd[i]=true;
                }
            }
        }
    }
    void bfs(int k){
        Boolean[] dd=new Boolean[n];
        for (int i=0;i<n;i++) dd[i]=false;
        breadth(dd,k);
        for (int i=0;i<n;i++){
            if (!dd[i]) breadth(dd,i);
        }
    }
    void dfs(int k){
        Boolean[] dd=new Boolean[n];
        for (int i=0;i<n;i++) dd[i]=false;
        depth(dd,k);
        for (int i=0;i<n;i++){
            if (!dd[i]) depth(dd,i);
        }
    }

    private void depth(Boolean[] dd, int k) {
        dd[k]=true;
        visit(k);
        for (int i=0;i<n;i++){
            if (!dd[i] && a[k][i]>0){
                depth(dd,i);
            }
        }
    }
    
    void dijkstra(int fro, int to) {
        boolean [] S = new boolean[n];
        int [] d = new int[n];
        int [] p = new int[n];
        int i,j,k, t;
        int INF = 99;
        for(i=0;i<n;i++) {
            S[i] = false;
            d[i] = a[fro][i];
            p[i] = fro;
        }
        S[fro] = true;
        while(true) {
            k = -1; t = INF;
            for(i=0;i<n;i++) {
                if(S[i]) continue;
                if(d[i] < t) {
                    t = d[i];
                    k = i;
                }
                if(k==-1) {
                    System.out.println("No solution");
                    return;
                }
            }
            // add k to S
            S[k] = true;
            if(k==to) break;
            // Recalculate d[i];
            for(i=0;i<n;i++) {
                if(S[i]) continue;
                if(d[i] > d[k] + a[k][i]) {
                    d[i] = d[k] + a[k][i];
                    p[i] = k;
                }
            }
        }
        System.out.println("The shortest distance is " + d[to]);
        MyStack s = new MyStack();
        s.push(to);
        i = to;
        while(true) {
            if(i==fro) break;
            i = p[i];
            s.push(i);
        }
        i = s.pop();
        System.out.print("The shortest path is: ");
        System.out.print(i);
        while(!s.isEmpty()) {
            i = s.pop();
            System.out.print(" -> " + i);
        }
    }
}
