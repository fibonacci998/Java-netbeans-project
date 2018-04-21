import java.util.*;
public class MyQueue {
  LinkedList<Node> t;
  MyQueue() {
    t = new LinkedList<Node>();  
  }
  boolean isEmpty() {
    return(t.isEmpty());  
  }
  void clear() {
    t.clear();  
  }
  void enqueue(Node x) {
    t.addLast(x);  
  }
  Node dequeue() {
    if(isEmpty()) return(null);
    return(t.removeFirst());
  }
  Node front() {
    if(isEmpty()) return(null);
    return(t.getFirst());
      
  }
}
