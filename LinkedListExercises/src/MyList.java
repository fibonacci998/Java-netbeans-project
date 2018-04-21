public class MyList
 {Node head, tail;
   MyList() {head=tail=null;}
   boolean isEmpty() {return(head==null);}
   void clear() {head=tail=null;}

   // (1) 
   void addLast(Person x)
     {Node q = new Node(x);
       if(isEmpty()) {head=tail=q;return;}
       tail.next = q;
       tail = q;
     }

    void visit(Node p) {if(p!=null) System.out.print(p.info);}
    void traverse()
     {Node p=head;
       while(p!=null)
         {visit(p);
           p=p.next;
         }
      System.out.println();
     }
   void addMany(String [] a, int [] b)
     {int n,i; n=a.length;
       for(i=0;i<n;i++) addLast(new Person(a[i],b[i]));
     }

   // (2)
   Node searchByName(String xName)
     {Node p=head;
       while(p!=null)
        {if(p.info.name.equals(xName)) return(p);
          p=p.next;
        }
       return(null);
     }
   Node searchByAge(int xAge)
     {Node p=head;
       while(p!=null)
        {if(p.info.age == xAge) return(p);
          p=p.next;
        }
       return(null);
     }
   // (3)
   void addFirst(Person x)
     {
         head=new Node(x,head);
         if (tail==null) tail=head;
     }

   // (4)
   void insertAfter(Node q, Person x)
     {
         if (q==null) return;
         Node q1=q.next;
         Node p=new Node(x,q1);
         q.next=p;
         if (tail==q){
             tail=p;
         }
     }

   // (5)
   void insertBefore(Node q, Person x)
     {
         if (q==null) return;
         if (q==head){
             addFirst(x);
             return;
         }
         Node temp=head;
         while (temp!=null && temp.next!=q){
             temp=temp.next;
         }
         if (temp==null) return;
         insertAfter(temp,x); 
     }

   // (6)
   void dele(Node q)
     {
         if (q==null) return;
         Node temp=head;
         while (temp!=null && temp.next!=q){
             temp=temp.next;
         }
         if (temp==null) return;
         temp.next=q.next;
         if (temp.next==null) tail=temp;
     }

   // (7)
   void dele(String xName)
     {
         Node temp=searchByName(xName);
         if (temp==null) return;
         dele(temp);
     }

   // (8)
   void dele(int xAge)
     {
         Node temp=searchByAge(xAge);
         if (temp==null) return;
         dele(temp);
     }

   // (9)
   void deleAll(int xAge)
     {
         while(true){
             Node temp=searchByAge(xAge);
             if (temp==null) return;
             dele(xAge);
         }
     }

   // (10)
   Node pos(int k)
     {
         Node temp=head;
         int i=0;
         while (temp!=null){
             if (i==k) return temp;
             i++;
             temp=temp.next;
         }
         return(null);
     }

   // (11)
   void delePos(int k)
     {
         Node temp=head;
         int i=0;
         while(temp!=null){
             if (i==k) dele(temp);
             i++;
             temp=temp.next;
         }
     }

   // (12)
   void sortByName()
     {
         Node i,j;
         i=head;
         while(i!=null){
             j=i.next;
             while(j!=null){
                 if (i.info.name.compareTo(j.info.name)>0){
                     Person temp=i.info;
                     i.info=j.info;
                     j.info=temp;
                 }
                 j=j.next;
             }
             i=i.next;
         }
     }

   // (13)
   void sortByAge()
     {
         Node i,j;
         i=head;
         while(i!=null){
             j=i.next;
             while(j!=null){
                 if (i.info.age>j.info.age){
                     Person temp=i.info;
                     i.info=j.info;
                     j.info=temp;
                 }
                 j=j.next;
             }
             i=i.next;
         }
     }


   // (14)
   int size()
     {
         int size=0;
         Node temp=head;
         while (temp!=null){
             size++;
             temp=temp.next;
         }
         return(size);
     }

   // (15)
   Person [] toArray()
     {
         int n=size();
         Person[] a=new Person[n];
         Node temp=head;
         int i=0;
         while (temp!=null){
             a[i]=new Person(temp.info.name,temp.info.age);
             i++;
             temp=temp.next;
         }
         return(a);
     }

   // (16)
   void reverse()
     {
         MyList reverseList=new MyList();
         Node temp=head;
         while(temp!=null){
             reverseList.addFirst(new Person(temp.info.name,temp.info.age));
             temp=temp.next;
         }
         head=reverseList.head;
         tail=reverseList.tail;
     }

  // (17) 
  Node findMaxAge()
     {
         if (isEmpty()) return null;
         Node maxAge,temp;
         temp=head;maxAge=head;
         while(temp!=null){
             if (temp.info.age>maxAge.info.age){
                 maxAge=temp;
             }
             temp=temp.next;
         }
         
         return(maxAge);
     }

  // (18) 
  Node findMinAge()
     {if (isEmpty()) return null;
         Node minAge,temp;
         temp=head;minAge=head;
         while(temp!=null){
             if (temp.info.age<minAge.info.age){
                 minAge=temp;
             }
             temp=temp.next;
         }
         
         return(minAge);
     }

  // (19) 
  void setData(Node p, Person x)
     {
         if (p==null) return;
         p.info=x;
     }

  // (20) 
  void sortByAge(int  k, int h)
     {
         int n=size();
         if (k<0 || h>n-1 || k>=h) return;
         Node t1,t2;
         t1=pos(k);
         t2=pos(h+1);
         Node i,j;
         i=t1;
         while(i!=t2){
             j=i.next;
             while(j!=t2){
                 if (i.info.age>j.info.age){
                     Person temp=i.info;
                     i.info=j.info;
                     j.info=temp;
                 }
                 j=j.next;
             }
             i=i.next;
         }
     }

  // (21) 
  void reverse(int k, int h) // reverse from k to h 
     {
        int n=size();
        if (k<0 || h>n-1 || k>=h) return;
        Node t1,t2;
        t1=pos(k);
        t2=pos(h+1);
        Person[] a=toArray();
        int i=k,j=h;
        while (i<j){
            Person temp=a[i];
            a[i]=a[j];
            a[j]=temp;
            i++;j--;
        }
        clear();
        for (i=0;i<a.length;i++) addLast(a[i]);
     }
 }
