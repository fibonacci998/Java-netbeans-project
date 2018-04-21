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
  int calDeg(int u){
      int ans=0;
      for (int i=0;i<n;i++){
          ans+=a[u][i];
      }
      return ans;
  } 
  void depth2(boolean [] visited,int k, RandomAccessFile f) throws Exception
   {
    
    visited[k]=true;
    deg[k]=calDeg(k);
    if (deg[k]>2) fvisit(k,f);
    for(int i=0;i<n;i++)
      {if(!visited[i] && a[k][i]>0) depth2(visited,i,f);
      }
   }
  void depth2(int k, RandomAccessFile f) throws Exception
   {boolean [] visited = new boolean[20];
    int i;
    for(i=0;i<n;i++) visited[i]=false;
    
    depth2(visited,k,f);
    for(i=0;i<n;i++) 
       if(!visited[i]) depth2(visited,i,f);
   }
  void f5() throws Exception
   {loadData(17);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    depth(0,f);
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        depth2(0, f);

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
  private void preEuler(int start, RandomAccessFile f) throws IOException {
        int eu[]=new int[100];
        int temp[][]=a;
        int m=0;
        int i,r;
        Stack<Integer> st=new Stack<>();
        Vector<Integer> vt=new Vector<>();
        st.push(start);
        vt.add(start);
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
                if (vt.size()<4) vt.add(i);
                a[r][i]--;
                a[i][r]--;
            }
        }
        a=temp;
        f.writeBytes(v[eu[0]]+"");
        for(i=1;i<m;i++) f.writeBytes(" " + v[eu[i]]);
        f.writeBytes("\n");
        for(Integer tempp:vt) f.writeBytes(v[tempp]+" ");
    }
  
  void f6() throws Exception
   {loadData(28);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f = new RandomAccessFile(fname, "rw"); 
    f.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
      // You can use the statement fvisit(i,f); i = 0, 1, 2,...,n-1 to display the vertex i to file f6.txt 
      //  and statement f.writeBytes(" " + k); to write  variable k to the file f6.txt  
      preEuler(3,f);



    //-------------------------------------------------------------------------------------
    f.writeBytes("\r\n");
    f.close();
   }

}
//=================================================================
