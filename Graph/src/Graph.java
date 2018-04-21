
import java.util.Stack;

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
    int [][] a;
    int n;
    Graph(int n){
        this.n=n;
        a=new int[n][n];
    }
    void addEdge(int u,int v,int value){
        a[u][v]=value;
        a[v][u]=value;
    }
    void displayGraph(){
        for (int i=0;i<n;i++){
            System.out.println("");
            for (int j=0;j<n;j++){
                System.out.println(a[i][j]+"\t");
            }
        }
    }
    void visit(int u){
        System.out.print(u+" ");
    }
    int minDistance(int dist[], Boolean sptSet[]){
        int min=Integer.MAX_VALUE, min_index=-1;
        for (int i=0;i<n;i++){
            if (sptSet[i]==false && dist[i]<=min){
                min=dist[i];
                min_index=i;
            }
        }
        return min_index;
    }
    void dijkstra(int src,int to){
        int dist[]=new int[n];
        Boolean sptSet[]=new Boolean[n];
        int pre[]=new int[n];
        for (int i=0;i<n;i++){
            dist[i]=Integer.MAX_VALUE;
            sptSet[i]=false;
            pre[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        pre[src]=-1;
        for (int count=0;count<n-1;count++){
            int u=minDistance(dist, sptSet);
            sptSet[u]=true;
            for (int v=0;v<n;v++){
                if (!sptSet[v] && a[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u] + a[u][v]< dist[v]){
                    dist[v]=dist[u]+a[u][v];
                    pre[v]=u;
                }
            }
        }
        System.out.println("Shortest path from "+src+":");
        for (int i=0;i<n;i++) System.out.println(i+": "+dist[i]);
        Stack<Integer> st=new Stack();
        System.out.println("Shortest path from "+src+" to "+to+":");
        while (to!=-1){
            st.push(to);
            to=pre[to];
        }
        
        while (!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
        System.out.println("");
    }
    void dfsUtil(int u, boolean visited[]){
        visited[u]=true;
        for (int v=0;v<n;v++){
            if (a[u][v]!=0 && !visited[v]){
                dfsUtil(v, visited);
            }
        }
    }
    int deg(int u){
        int count=0;
        for (int i=0;i<n;i++)
            count+=a[u][i];
        return count;
    }
    boolean isConnected(){
        boolean visited[]=new boolean[n];
        int i=0;
        for (i=0;i<n;i++){
            visited[i]=false;
        }
        for (i=0;i<n;i++){
            int countDeg=deg(i);
            if (countDeg!=0) break;
        }
        if (i==n){
            return true;
        }
        dfsUtil(i, visited);
        for (i=0;i<n;i++){
            if (visited[i]==false && deg(i)>0){
                return false;
            }
        }
        return true;
    }
    int isEulerian(){
        if (isConnected()==false) return 0;
        int odd=0;
        for (int i=0;i<n;i++){
            if (deg(i)%2!=0){
                odd++;
            }
        }
        if (odd>2) return 0;
        return (odd==2)?1:2;
    }
    void testEuler()
    {
        int res = isEulerian();
        if (res == 0)
            System.out.println("graph is not Eulerian");
        else if (res == 1)
            System.out.println("graph has a Euler path");
        else{
            System.out.println("graph has a Euler cycle");
            preEuler();
        }
    }

    private void preEuler() {
        int eu[]=new int[100];
        int temp[][]=a;
        int m=0;
        int i,r;
        Stack<Integer> st=new Stack<>();
        st.push(0);
        while (!st.isEmpty()){
            r=st.peek();
            for (i=0;i<n;i++){
                if (a[r][i]>0) break;
            }
            if (i==n){
                eu[m++]=r;
                st.pop();
            }else{
                st.push(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        a=temp;
        System.out.print("The Euler's cycle is ");
        System.out.print(eu[0]);
        for(i=1;i<m;i++) System.out.print(" -> " + eu[i]);
    }
}
