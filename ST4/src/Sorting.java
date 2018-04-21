/* This program contains 2 parts: (1) and (2)
   YOUR TASK IS TO COMPLETE THE PART  (2)  ONLY
 */
//(1)==============================================================
import java.io.*;
import java.util.*;

class Sorting
 {int [] a;
  void setToZero()
   {if(a != null)
      for(int i=0;i<a.length; i++)  a[i]=0;
   }
    
  void fdisplay(RandomAccessFile f) throws Exception
   {if(a != null)
      for(int i=0;i<a.length; i++)  f.writeBytes(a[i] + " ");
    f.writeBytes("\r\n");
   }

  void fdisplayArray(int [] b, RandomAccessFile f) throws Exception
   {if(a != null)
      for(int i=0;i<b.length; i++)  f.writeBytes(b[i] + " ");
    f.writeBytes("\r\n");
   }

  void loadData(int k)  //do not edit this function
   {a = Lib.readLineToIntArray("data.txt", k);
   }

//===========================================================================
//(2)===YOU CAN EDIT OR EVEN ADD NEW FUNCTIONS IN THE FOLLOWING PART========
//===========================================================================

//=================================================================
//selection sort
/*
The following is the pseudocode of the selection sort :
    for i := 0 to n-2 
      {select the smallest element  a[k] among  a[i], . . . , a[n-1];
        swap  a[i] with a[k];
      }
*/
  void f1() throws Exception
   {loadData(1);
    String fname = "f1.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdisplay(f123);
    f123.writeBytes("\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     int n=a.length;
     //selection sort
     for (int i=0;i<=n-2;i++){
         int min=a[i],pos=i;
         for (int j=i+1;j<=n-1;j++){
             if (a[j]<min){
                 min=a[j];
                 pos=j;
             }
         }
         int temp=a[i];a[i]=min;a[pos]=temp;
         if (i==0||i==1||i==2)
             fdisplay(f123);
     }
     

    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    fdisplay(f123);
    f123.close();
   }

//=================================================================
//insertion sort
/*
The following is the pseudocode of the insertion sort :
    for i := 1 to n-1 
      { x = a[i];
        move to right all elements a[j] > x  by one position;
        place x in its proper position;
      }
*/
  void f2() throws Exception
   {loadData(1);
    String fname = "f2.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdisplay(f123);
    f123.writeBytes("\r\n");

    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     //insertion sort
     int n=a.length;
     for (int i=1;i<=n-1;i++){
         int x=a[i];
         int j=i-1;
         while (j>=0 && a[j]>x){
             a[j+1]=a[j];
             j=j-1;
         }
         a[j+1]=x;
         if (i==3||i==1||i==2)
             fdisplay(f123);
     }

    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    fdisplay(f123);
    f123.close();
   }

//=================================================================
//bubble sort
/*
The following is the pseudocode of the bubble sort :
  do
    swapped := false
    for i := 0 to n-2 
      if a[i] > a[i+1] then
        swap(a[i],a[i+1])
        swapped := true
      end if
    end for
  while swapped
*/
  void f3() throws Exception
   {loadData(1);
    String fname = "f3.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdisplay(f123);
    f123.writeBytes("\r\n");

    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     //buble sort
     int n=a.length;
     int count=0;
     boolean swapped=false;
     do{
         swapped=false;
         for (int i=0;i<=n-2;i++){
            if (a[i]>a[i+1]){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
                swapped=true;
            }
        }
         if (count==0||count==1)
             fdisplay(f123);
         count++;
     } while (swapped);
     

    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    fdisplay(f123);
    f123.close();
   }


//=================================================================
//merge sort
/*
The following is the pseudocode of the merge sort of  2 arrays b and c to the array  a :
 r=i=j=0
 while(i<nb && j<nc)
   if(b[i]<c[j])  a[r++] = b[i++]  else a[r++] = c[j++] 
 while(i<nb) a[r++] = b[i++]
 while(j<nc) a[r++] = c[j++]
*/
boolean isSorted(int b[])
  {int m = b.length;
   for(int i=0;i<m-1;i++)
     if(b[i]>b[i+1]) return(false);
   return(true);
  }
  void f4() throws Exception
   {loadData(1);
    String fname = "f4.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 

     int b[], c[]; 
     int k, h, n;
     b = Lib.readLineToIntArray("data.txt", 3);// Read numbers in line 3 to the array b
     c = Lib.readLineToIntArray("data.txt", 4);// Read numbers in line 4 to the array c
     k = b.length;
     h = c.length;
     n = k+h;
     a = new int[n];
     f123.writeBytes("\nThe array b:\r\n");
     fdisplayArray(b,f123);
     f123.writeBytes("\nThe array c:\r\n");
     fdisplayArray(c,f123);
     n = k + h; // n  will  be the size of the array a
     setToZero(); // set all elements of the array  a  to  0 
     f123.writeBytes("\nThe array a:\r\n");
    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
     int r,i,j;
     r=i=j=0;
     int nb=b.length,nc=c.length;
     while (i<nb && j<nc){
         if (b[i]<c[j])
             a[r++]=b[i++];
         else a[r++]=c[j++];
     }
       fdisplayArray(a, f123);
     while (i<nb) a[r++]=b[i++];
     while (j<nc) a[r++]=c[j++];
    //-------------------------------------------------------------------------------------
    fdisplay(f123);
    f123.close();
   }


//=================================================================
//quick sort
/*
Partitioning is a technique used in quicksort. The following is a partition pseudocode for sorting from smallest to largest: 
partition the array  a  from index low to index up
   x := a[low], i=low, j=up
   do 
    increase i and stop at i, where  a[i]>x 
    decrease j and stop at j, where  a[j]<=x 
    if(i<j) swap a[i] with a[j]
   while(i<j)
   swap  a[low] with a[j]
*/
 //-----------------------------------------------------
  int partition(int arr[], int low, int up,RandomAccessFile f) throws Exception{
      int pivot = arr[up]; 
    int i = (low-1); 
    for (int j=low; j<up; j++)
    {
        if (arr[j] <= pivot)
        {
            i++;
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            fdisplay(f);
        }
    }
    int temp = arr[i+1];
    arr[i+1] = arr[up];
    arr[up] = temp;
    return i+1;
  }
  int partition2(int arr[], int low, int up,RandomAccessFile f) throws Exception{
      int x=a[low],i=low,j=up;
      do{
            while(a[i]<=x && i<up) i++;
            while(a[j]>x && j>low) j--;
            if (i<j){
                fdisplay(f);
                int temp=a[i];a[i]=a[j];a[j]=temp;
                 fdisplay(f);
            }
            //fdisplay(f);
      }while (i<j);
      int temp=a[low];a[low]=a[j];a[j]=temp;
      return j;
  }
  void quicksort(int arr[],int low,int up, RandomAccessFile f) throws Exception{
      if (low<up){
          int pivot=partition2(arr,low,up,f);
          quicksort(arr, low, pivot-1,f);
          quicksort(arr, pivot+1,up,f);
      }
  }
  void f5() throws Exception
   {loadData(2);
    String fname = "f5.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdisplay(f123);
    f123.writeBytes("\r\n");

    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        quicksort(a, 0, a.length-1,f123);

    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    fdisplay(f123);
    f123.close();
   }


//=================================================================
//Heap sort
/*
 (1)  transform data into a heap:
  (2) for i = n-1 downto 1
       swap the root with the element in position i;
      restore the heap property for the tree 	a[0], . . . , a[i-1];
*/
  public void sort(int arr[],RandomAccessFile f) throws Exception
    {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i,f);
        fdisplay(f);
        for (int i=n-1; i>=0; i--)
        {

            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0,f);
            if (i==n-1||i==n-2||i==n-3)
            fdisplay(f);
        }
    }
 
    void heapify(int arr[], int n, int i,RandomAccessFile f)
    {
        int largest = i;  
        int l = 2*i + 1;  
        int r = 2*i + 2;  

        if (l < n && arr[l] > arr[largest])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;
 
        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest,f);
        }
    }
  void f6() throws Exception
   {loadData(1);
    String fname = "f6.txt";
    File g123 = new File(fname);
    if(g123.exists()) g123.delete();
    RandomAccessFile  f123 = new RandomAccessFile(fname, "rw"); 
    fdisplay(f123);
    f123.writeBytes("\r\n");

    //-------------------------------------------------------------------------------------
     /*You must keep statements pre-given in this function.
       Your task is to insert statements here, just after this comment,
       to complete the question in the exam paper.*/
        sort(a,f123);

    //-------------------------------------------------------------------------------------
    f123.writeBytes("\r\n");
    fdisplay(f123);
    f123.close();
   }


 }
