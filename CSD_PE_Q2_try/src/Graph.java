/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)============================================
import java.io.*;
import java.util.*;
//-------------------------------------------------------------------------------
public class Graph
 {int [][] a; int n;
  char v[];
  int deg[];
  Graph()
    {v = "ABCDEFGHIJKLMNOP".toCharArray();
     deg = new int[20];
     a = new int[20][20];
     n = 0;
    }

  void loadData(int k)  //do not edit this function
   {RandomAccessFile f;int i,j,x;
    String s;StringTokenizer t;
    a = new int[20][20];
    try {
     f = new RandomAccessFile("data.txt","r");
     for(i=0;i<k;i++) f.readLine();
     s = f.readLine();s = s.trim();
     n = Integer.parseInt(s);
     for(i=0;i<n;i++)
       {s = f.readLine();s = s.trim();
        t = new StringTokenizer(s);
        for(j=0;j<n;j++) 
          {x = Integer.parseInt(t.nextToken().trim());
           a[i][j] = x;
          }
       }
     f.close();
     }
    catch(Exception e) {}

   }

  void dispAdj()
   {int i,j;
    for(i=0;i<n;i++)
     {System.out.println();
      for(j=0;j<n;j++)
        System.out.printf("%4d",a[i][j]);
     }
   }

  void fvisit(int i, RandomAccessFile f) throws Exception
   {f.writeBytes(" "+v[i]);
   }

 void fdispAdj(RandomAccessFile f) throws Exception 
   {int i,j;
    f.writeBytes("n = "+n+"\r\n");
    for(i=0;i<n;i++)
     {f.writeBytes("\r\n");
      for(j=0;j<n;j++)  f.writeBytes("  " + a[i][j]);
     }
    f.writeBytes("\r\n");
   }

  void breadth(boolean [] en, int i, RandomAccessFile f) throws Exception
   {GQueue q = new GQueue();
    int r,j;
    q.enqueue(i); en[i]=true;
    while(!q.isEmpty())
     {r = q.dequeue();
      fvisit(r,f);
      for(j=0;j<n;j++)
       {if(!en[j] && a[r][j]>0) {q.enqueue(j);en[j]=true;}
       }
     }
   }

  void breadth(int  k, RandomAccessFile f) throws Exception
   {boolean [] en = new boolean[20];
    int i;
    for(i=0;i<n;i++) en[i]=false;
    breadth(en,k,f);
    for(i=0;i<n;i++) if(!en[i]) breadth(en,i,f);
   }

 void depth(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {fvisit(k,f);visited[k]=true;
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depth(visited,i,f);
      }
   }
  void depth(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    depth(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth(visited,i,f);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================
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
  void dijkstra(int src, int to, RandomAccessFile f) throws IOException{
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
        
        //System.out.println("Shortest path from "+src+":");
        //for (int i=0;i<n;i++) System.out.println(i+": "+dist[i]);
        Stack<Integer> st=new Stack();
        //System.out.println("Shortest path from "+src+" to "+to+":");
        while (to!=-1){
            st.push(to);
            to=pre[to];
        }
        ArrayList<Integer> kk=new ArrayList();
        while (!st.isEmpty()){
            int top=st.pop();
            f.writeBytes(v[top]+" ");
            kk.add(dist[top]);
            //System.out.print(st.pop()+" ");
        }
        f.writeBytes("\r\n");
        for (int temp: kk){
            f.writeBytes(temp+" ");
        }
        //System.out.println("");
    }
  void f5() throws Exception
   {loadData(13);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        dijkstra(0, 4,f);

    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }

//=================================================================
/*
Algorithm for finding an Euler cycle from the vertex X using stack 
//Input: Connected graph G with all vertices having even degrees
//Output: Euler cycle
declare a stack S of characters
declare empty array E (which will contain Euler cycle)
push the vertex X to S
while(S is not empty)
 {r = top element of the stack S 
  if r is isolated then remove it from the stack and put it to E
   else
   select the first vertex Y (by alphabet order), which is adjacent
   to r, push  Y  to  S and remove the edge (r,Y) from the graph   
 }
 the last array E obtained is an Euler cycle of the graph
*/
  private void preEuler(RandomAccessFile f) throws IOException {
        int eu[]=new int[100];
        int temp[][]=a;
        int m=0;
        int i,r;
        Stack<Integer> st=new Stack<>();
        st.push(1);
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
        //System.out.print("The Euler's cycle is ");
        //System.out.print(eu[0]);
        f.writeBytes(v[eu[0]]+" ");
        for(i=1;i<m;i++){
            f.writeBytes(v[eu[i]]+" ");
            //System.out.print(" -> " + eu[i]);
        }
    }
  void f6() throws Exception
   {loadData(21);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f5.txt 
      //  and statement f.writeBytes(" " + k); to write  variable k to the file f5.txt  
      preEuler(f);


    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }

}
//=================================================================
