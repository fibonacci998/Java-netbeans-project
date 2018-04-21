public class Main {

    public static void main(String[] args) {
        MyList t=new MyList();
        String[] s={"Hoa","La","Canh","Cay"};
        int[] b={19,20,25,18};
        t.addMany(s, b);
        t.traversal();
        System.out.println("");
    }
    
}
