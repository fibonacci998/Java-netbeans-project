import java.util.*;
public class MyQueue {
  LinkedList<Integer> t;
  void clear() {
    t.clear();  
  }
  MyQueue() {
    t = new LinkedList<Integer>();  
  }
  boolean isEmpty() {
    return(t.isEmpty());  
  }
  void enqueue(int k) {
    t.addLast(k);  
  }
Integer dequeue() {
  if(isEmpty()) return(null);
  return(t.removeFirst());  
}
Integer front() {
  if(isEmpty()) return(null);
  return(t.getFirst());  
}
}
