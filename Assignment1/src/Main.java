
import java.util.Scanner;


public class Main {
    static Scanner input=new Scanner(System.in);
    static MyList m = new MyList();
    static int getValidInt(int min,int max){
        while(true){
            try {
                int temp=Integer.parseInt(input.nextLine());
                if (temp<min || temp>max) throw new Exception();
                return temp;
            } catch (Exception e) {
                System.out.print("Enter number from "+min+" to "+max+": ");
            }
        }
    }
    public static void main(String[] args) throws Exception {
        while(true){
            printMenu();
            int choose=getValidInt(1,9);
            switch(choose){
                case 1: load_data_from_file_function();
                        break;
                case 2: input_add_to_end_function();
                        break;
                case 3: display_data_function();
                        break;
                case 4: search_by_name_function();
                        break;
                case 5: delete_by_name_function();
                        break;
                case 6: sort_by_code_function();
                        break;
                case 7: add_after_position_function();
                        break;
                case 8: delete_node_after_code_function();
                        break;
                case 9: return;
            }
        }
//        m.load();
//        m.traversal();
    }

    private static void printMenu() {
        System.out.println("1.      Load data from file\n" +
        "2.      Input & add to the end\n" +
        "3.      Display data\n" +
        "4.      Search by Name\n" +
        "5.      Delete by Name\n" +
        "6.      Sort by Code\n" +
        "7.      Add after position  k\n" +
        "8.      Delete the node after the node having code = xCode\n"+
        "9.      Exit.");
    }

    private static void load_data_from_file_function() throws Exception {
        System.out.println("-----------------------");
        System.out.println("1. Load data from file");
        m.load();
    }

    private static void display_data_function() {
        System.out.println("-----------------------");
        System.out.println("3. Display data");
        m.traversal();
    }

    private static void search_by_name_function() {
        System.out.println("-----------------------");
        System.out.println("4. Search by Name");
        System.out.print("Enter name to search: ");
        String name=input.nextLine();
        Node temp=m.search(name);
        if (temp==null) System.out.println("No element has that name");
        else System.out.println(temp.info);
    }

    private static void delete_by_name_function() {
        System.out.println("-----------------------");
        System.out.println("5. Delete by Name");
        System.out.print("Enter name to delete: ");
        String name=input.nextLine();
        int temp=m.searchIndex(name);
        if (temp==-1) System.out.println("No element has that name");
        else {
            m.remove(temp);
            System.out.println("Delete success");
        }
    }

    private static void input_add_to_end_function() {
        System.out.println("-----------------------");
        System.out.println("2. Input & add to the end");
        System.out.print("Enter code: ");String code=input.nextLine();
        System.out.print("Enter name: ");String name=input.nextLine();
        System.out.print("Enter author: ");String author=input.nextLine();
        System.out.print("Enter price: ");double price=Double.parseDouble(input.nextLine());
        m.addLast(new Book(code, name, author, price));
        System.out.println("Add last success");
    }

    private static void sort_by_code_function() {
        System.out.println("------------------------");
        System.out.println("6. Sort by Code");
        m.sort();
        m.traversal();
    }

    private static void add_after_position_function() {
        System.out.println("------------------------");
        System.out.println("6. Add after position k");
        System.out.print("Enter code: ");String code=input.nextLine();
        System.out.print("Enter name: ");String name=input.nextLine();
        System.out.print("Enter author: ");String author=input.nextLine();
        System.out.print("Enter price: ");double price=Double.parseDouble(input.nextLine());
        System.out.println("Enter number k: ");int k=getValidInt(0, m.size());
        Node xNode=new Node(new Book(code, name, author, price));
        m.addAfterPosition(xNode, k);
    }

    private static void delete_node_after_code_function() {
        System.out.println("------------------------");
        System.out.println("7. Delete the node after the node having code = xCode");
        System.out.print("Enter code to delete after: ");
        String code=input.nextLine();
        int temp=m.searchByCodeIndex(code);
        if (temp+1<m.size()){
            m.remove(temp+1);
        }
    }
}
