public class Main {

    public static void main(String[] args) {
      BSTree t = new BSTree();
      int [] a = {6,4,7,2,5,8,1,3};
      t.insertMany(a);
      System.out.println("1.Test breadth-first traversal:");
      t.breadth(t.root);
      System.out.println();

      System.out.println("2.Test simple balance traversal:");
      t.balance();
      t.breadth(t.root);
      System.out.println();

      System.out.println("3.Test rotate to right:");
      t.clear();
      t.insertMany(a);
      t.root = t.rotateRight(t.root);
      t.breadth(t.root);
      System.out.println();

      System.out.println();
    }
    
}
