public class Graph {
  int [][] a; int n;
  char [] v;
  Graph() {
    v = "ABCDEFGHIJKLMN".toCharArray();  
  }
  void setData(int [][] b) {
    n = b.length;
    int i,j;
    a = new int[n][n];
    for(i=0;i<n;i++)
      for(j=0;j<n;j++) a[i][j] = b[i][j];  
  }
  void dispAdj() {
    int i,j;
    for(i=0;i<n;i++) {
      System.out.println();
      for(j=0;j<n;j++)
        System.out.printf("%5d",a[i][j]);  
    }
  }
  void visit(int i) {
     System.out.print(v[i] + " "); 
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
