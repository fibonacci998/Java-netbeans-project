
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class Main {
    static Scanner sc=new Scanner(System.in);
    static TrainList trainList=new TrainList();
    static CustomerList customerList=new CustomerList();
    static BookingList bookingList=new BookingList();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
//        displayMenu();
//        while (true){
//            System.out.println("==================================");
//            System.out.print("Enter you choice\n1. Process train list\n2."
//                    + " Process customer list\n3. Process booking list\n4. exit"
//                    + "\nYour choose: ");
//            int choose=getValidNum(1, 4);
//            if (choose==4) break;
//            switch (choose){
//                case 1: Train_List_Function();
//                        break;
//                case 2: Customer_List_Function();
//                        break;
//                case 3: Booking_List_Function();
//                        break;
//                default: break;
//            }
//            System.out.println("==================================");
//        }
        Input_train_list_from_file();
        Input_customer_list_from_file();
        Input_booking_list2("t9", "c1", 1);
        Input_booking_list2("t1", "c1", 3);
        Input_booking_list2("t1", "c2", 1);
        Display_data_in_train_list();
        Display_booking_data();
    }

    private static void Input_train_list_from_file() {
        System.out.println("1.1.      Load data to train list from file");
        if (!trainList.isEmpty()){
            System.out.println("Do you want to keep old data? (Y/N)");
            String request=sc.nextLine();
            if (request.compareToIgnoreCase("N")==0){
                trainList.clear();
            }
        }
        
        String fileTrain="train2.txt";
        System.out.print("Enter your file train list: ");
        
        //fileTrain=sc.nextLine();
        try {
            FileReader fr=new FileReader(fileTrain);
            BufferedReader br=new BufferedReader(fr);
            String current;
            while ((current=br.readLine())!=null){
                //System.out.println(current);
                StringTokenizer st=new StringTokenizer(current,"  |");
                String tcode=st.nextToken();
                String train_name=st.nextToken();
                int seat=Integer.parseInt(st.nextToken());
                int booked=Integer.parseInt(st.nextToken());
                double depart_time=Double.parseDouble(st.nextToken());
                String depart_place=st.nextToken();
                Train train=new Train(tcode, train_name, seat, booked, depart_time, depart_place);
                trainList.addLast(train);
            }
        } catch (Exception e) {
            System.out.println("Error with file you have entered!!");
        }
        trainList.traverse();
    }

    private static void Input_to_head_train_list() {
        System.out.println("1.2.      Input & add to the head");
        String tcode,train_name,depart_place;
        int seat,booked;
        double depart_time;
        System.out.print("Enter tcode: ");
        while(true){
            tcode=sc.nextLine();
            if (trainList.searchByTcode(tcode)!=null){
                System.out.print("Your tcode has exited, enter another tcode: ");
            }
            else break;
        }
        System.out.print("Enter train name: ");train_name=sc.nextLine();
        System.out.print("Enter seat number: ");seat=getValidNum(1,Integer.MAX_VALUE);
        System.out.print("Enter booked number: ");booked=getValidNum(0,seat);
        System.out.print("Enter depart time: ");depart_time=getValidDouble(0,Double.MAX_VALUE);
        System.out.print("Enter depart place: ");depart_place=sc.nextLine();
        trainList.addFirst(new Train(tcode, train_name, seat, booked, depart_time, depart_place));
    }

    private static int getValidNum(int min,int max) {
        while(true){
            try {
                int temp=Integer.parseInt(sc.nextLine());
                if (temp<min || temp>max) throw new Exception();
                return temp;
            } catch (Exception e) {
                System.out.println("Please enter valid number!!");
            } 
        }
        
    }

    private static double getValidDouble(double min,double max) {
        while(true){
            try {
                double temp=Double.parseDouble(sc.nextLine());
                if (temp<min || temp>max) throw new Exception();
                return temp;
            } catch (Exception e) {
                System.out.println("Please enter valid double!!");
            } 
        }
    }

    private static void Display_data_in_train_list() {
        System.out.println("1.3.      Display data");
        System.out.println("tcode  |  train_name  |  seat  |  booked  |  depart_time  |  depart_place  |  available_seat ");
        System.out.println("---------------------------------------------------------------------------------------------");
        TrainNode temp=trainList.head;
        while (temp!=null){
            System.out.println(temp.info.tcode+"  |  "+temp.info.train_name+"  |  "+
                    temp.info.seat+"  |  "+temp.info.booked+"  |  "+temp.info.depart_time+"  |  "+
                    temp.info.depart_place+"  |  "+(temp.info.seat-temp.info.booked));
            temp=temp.next;
        }
    }

    private static void Save_train_list_to_file() throws IOException {
        System.out.println("1.4.      Save train list to file");
        String fileName;
        System.out.print("Enter file name to save train list: ");
        fileName=sc.nextLine();
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw=new FileWriter(fileName);
            bw=new BufferedWriter(fw, 1);
            TrainNode temp=trainList.head;
            while(temp!=null){
                bw.write(temp.info.tcode+"  |  "+temp.info.train_name+"  |  "+
                    temp.info.seat+"  |  "+temp.info.booked+"  |  "+temp.info.depart_time+"  |  "+
                    temp.info.depart_place+"  |  "+(temp.info.seat-temp.info.booked));
                bw.newLine();
                temp=temp.next;
            }
        } catch (Exception e) {
            System.out.println("Error with your save file !!");
        }finally{
            if (bw!=null){
                bw.close();
            }
            System.out.println("Save successfully!!");
        }
    }

    private static void Search_by_tcode_in_train_list() {
        System.out.println("1.5.      Search by tcode");
        System.out.print("Enter tcode you want to search: ");
        String xTcode=sc.nextLine();
        TrainNode temp=trainList.searchByTcode(xTcode);
        if (temp!=null){
            System.out.println(temp.info);
        }
        else System.out.println("Ccode is not exits");
    }
    
    private static void Delete_by_tcode_in_train_list() {
        System.out.println("1.6.      Delete by tcode");
        System.out.print("Enter tcode you want to delete: ");
        String xTcode=sc.nextLine();
        trainList.delete(xTcode);
        trainList.traverse();
    }
    
    private static void Sort_train_list_by_tcode() {
        System.out.println("1.7.      Sort by tcode");
        trainList.sortByTcode();
        trainList.traverse();
    }
    
    private static void Add_train_after_position() {
        System.out.println("1.8.      Add after position  k");
        String tcode,train_name,depart_place;
        int seat,booked;
        double depart_time;
        System.out.print("Enter tcode: ");
        while(true){
            tcode=sc.nextLine();
            if (trainList.searchByTcode(tcode)!=null){
                System.out.print("Your tcode has exited, enter another tcode: ");
            }
            else break;
        }
        System.out.print("Enter train name: ");train_name=sc.nextLine();
        System.out.print("Enter seat number: ");seat=getValidNum(1,Integer.MAX_VALUE);
        System.out.print("Enter booked number: ");booked=getValidNum(0,seat);
        System.out.print("Enter depart time: ");depart_time=getValidDouble(0,Double.MAX_VALUE);
        System.out.print("Enter depart place: ");depart_place=sc.nextLine();
        System.out.print("Enter position to insert after: ");
        int position=getValidNum(0,trainList.size());
        Train temp=new Train(tcode, train_name, seat, booked, depart_time, depart_place);
        trainList.addAfterPosition(new TrainNode(temp),position);
        trainList.traverse();
    }

    private static void Delete_node_before_tcode() {
        System.out.println("1.9.      Delete the node before the node having tcode = xCode");
        String xTcode;
        System.out.print("Enter tcode to delete before: ");
        xTcode=sc.nextLine();
        trainList.deleteBeforeTcode(xTcode);
        trainList.traverse();
    }

    private static void Input_customer_list_from_file() {
        System.out.println("2.1.      Load data from file");
        if (!customerList.isEmpty()){
            System.out.println("Do you want to keep old data? (Y/N)");
            String request=sc.nextLine();
            if (request.compareToIgnoreCase("N")==0){
                customerList.clear();
            }
        }
        
        String fileCustomer="customer2.txt";
        System.out.print("Enter your file customer list: ");
        
        //fileCustomer=sc.nextLine();
        try {
            FileReader fr=new FileReader(fileCustomer);
            BufferedReader br=new BufferedReader(fr);
            String current;
            while ((current=br.readLine())!=null){
                //System.out.println(current);
                StringTokenizer st=new StringTokenizer(current,"  |");
                String ccode=st.nextToken();
                String cus_name=st.nextToken();
                String phone=st.nextToken();
                Customer ct=new Customer(ccode, cus_name, phone);
                customerList.addLast(ct);
            }
        } catch (Exception e) {
            System.out.println("Error with your file input !!");
        }
        customerList.traverse();
    }

    private static void Input_to_end_customer_list() {
        System.out.println("2.2.      Input & add to the end");
        System.out.print("Enter Ccode: ");
        String ccode=sc.nextLine();
        while (true){
            if (customerList.searchByCcode(ccode)!=null){
                System.out.print("This ccode is duplicated! Enter again: ");
            }
            else break;
            ccode=sc.nextLine();
        }
        
        System.out.print("Enter name: ");
        String name=sc.nextLine();
        System.out.print("Enter phone: ");
        String phone=sc.nextLine();
        while (true){
            boolean flag=true;
            for (char ch: phone.toCharArray()){
                if (!Character.isDigit(ch)){
                    flag=false;
                    break;
                }
            }
            if (flag==true) break;
            else System.out.print("Phone only has digit! Enter again: ");
            phone=sc.nextLine();
        }
        customerList.addLast(new Customer(ccode, name, phone));
    }
    
    private static void Display_data_in_customer_list() {
        System.out.println("2.3.      Display data");
        System.out.println("Ccode  |  name  |  phone");
        CustomerNode temp=customerList.head;
        while (temp!=null){
            System.out.println(temp.info.ccode+"  |  "+temp.info.cus_name+
                    "  |  "+temp.info.phone);
            temp=temp.next;
        }
    }
    
    private static void Save_customer_list_to_file() throws IOException {
        System.out.println("2.4.      Save customer list to file");
        String fileName;
        System.out.print("Enter file name to save customer list: ");
        fileName=sc.nextLine();
        FileWriter fw=null;
        BufferedWriter bw=null;
        try {
            fw=new FileWriter(fileName);
            bw=new BufferedWriter(fw, 1);
            CustomerNode temp=customerList.head;
            while(temp!=null){
                bw.write(temp.info.ccode+"  |  "+temp.info.cus_name+
                    "  |  "+temp.info.phone);
                bw.newLine();
                temp=temp.next;
            }
        } catch (Exception e) {
            System.out.println("Error with your save file!!");
        }finally{
            if (bw!=null){
                bw.close();
            }
            System.out.println("Save succesfully!!");
        }
    }

    private static void Search_by_ccode_in_customer_list() {
        System.out.println("2.5.      Search by ccode");
        System.out.print("Enter ccode you want to search: ");
        String xCcode=sc.nextLine();
        CustomerNode temp=customerList.searchByCcode(xCcode);
        if (temp!=null){
            System.out.println(temp.info);
        }
        else System.out.println("Ccode is not exits");
    }

    private static void Delete_by_ccode_in_customer_list() {
        System.out.println("2.6.      Delete by ccode");
        System.out.print("Enter ccode you want to delete: ");
        String xCcode=sc.nextLine();
        customerList.delete(xCcode);
        customerList.traverse();
    }

    private static void Input_booking_list() {
        System.out.println("3.1.      Input data");
        System.out.print("Enter train code: ");
        String trainCode=sc.nextLine();
        System.out.print("Enter customer code: ");
        String customerCode=sc.nextLine();
        System.out.print("Enter number of seats to be booked: ");
        int seat=Integer.parseInt(sc.nextLine());
        
        TrainNode trainSearch=trainList.searchByTcode(trainCode);
        CustomerNode customerSearch=customerList.searchByCcode(customerCode);
        if (trainSearch==null || customerSearch==null){
            System.out.println("Train code or customer code are not found!!");
            return;
        }
        BookingNode trainSearchBooked=bookingList.searchByTcode(trainCode);
        BookingNode customerSearchBooked=bookingList.searchByCcode(customerCode);
        if (trainSearchBooked!=null && customerSearchBooked!=null){
            System.out.println("Someone has owned that book!!");
            return;
        }
        if (trainSearch!=null && customerSearch!=null && trainSearch.info.booked==trainSearch.info.seat){
            System.out.println("The train is exhausted!!");
            return;
        }
        if (trainSearch!=null && customerSearch!=null && 
                trainSearch.info.booked<trainSearch.info.seat &&
                seat<=(trainSearch.info.seat-trainSearch.info.booked)){
            trainList.searchByTcode(trainCode).info.booked=trainList.searchByTcode(trainCode).info.booked+seat;
            System.out.println("Data is accepted!!");
            bookingList.addLast(new Booking(trainCode, customerCode, seat));
            return;
        }
    }
    private static void Input_booking_list2(String trainCode,String customerCode, int seat) {
        
        System.out.println("Inputing "+trainCode+" "+customerCode+" "+seat);
        TrainNode trainSearch=trainList.searchByTcode(trainCode);
        CustomerNode customerSearch=customerList.searchByCcode(customerCode);
        if (trainSearch==null || customerSearch==null){
            System.out.println("Train code or customer code are not found!!");
            return;
        }
        BookingNode trainSearchBooked=bookingList.searchByTcode(trainCode);
        BookingNode customerSearchBooked=bookingList.searchByCcode(customerCode);
        if (trainSearchBooked!=null && customerSearchBooked!=null){
            System.out.println("Someone has owned that book!!");
            return;
        }
        if (trainSearch!=null && customerSearch!=null && trainSearch.info.booked==trainSearch.info.seat){
            System.out.println("The train is exhausted!!");
            return;
        }
        if (trainSearch!=null && customerSearch!=null && 
                trainSearch.info.booked<trainSearch.info.seat &&
                seat<=(trainSearch.info.seat-trainSearch.info.booked)){
            trainList.searchByTcode(trainCode).info.booked=trainList.searchByTcode(trainCode).info.booked+seat;
            System.out.println("Data is accepted!!");
            bookingList.addLast(new Booking(trainCode, customerCode, seat));
            return;
        }
    }

    private static void Display_booking_data() {
        System.out.println("3.2.      Display data width available seats");
        BookingNode temp=bookingList.head;
        System.out.println("Train code | Customer code | Seat");
        while (temp!=null){
            System.out.println(temp.info.tcode+"  |  "+temp.info.ccode+"  |  "+
                    temp.info.seat);
            temp=temp.next;
        }
    }

    private static void Sort_booking_list_by_tcode_and_ccode() {
        System.out.println("3.3.      Sort  by tcode + ccode");
        bookingList.sortByTcodeAndCcode();
        bookingList.traverse();
    }

    private static void displayMenu() {
        System.out.println("Train list:\n" +
        "1.1.      Load data from file\n" +
        "1.2.      Input & add to the head\n" +
        "1.3.      Display data\n" +
        "1.4.      Save train list to file\n" +
        "1.5.      Search by tcode\n" +
        "1.6.      Delete by tcode\n" +
        "1.7.      Sort by tcode\n" +
        "1.8.      Add after position  k\n" +
        "1.9.      Delete the node before the node having tcode = xCode\n" +
        "\n" +
        " \n" +
        "\n" +
        "Customer list:\n" +
        "2.1.      Load data from file\n" +
        "2.2.      Input & add to the end\n" +
        "2.3.      Display data\n" +
        "2.4.      Save customer list to file\n" +
        "2.5.      Search by ccode\n" +
        "2.6.      Delete by ccode\n" +
        "\n" +
        " \n" +
        "\n" +
        "Booking list:\n" +
        "3.1.      Input data\n" +
        "3.2.      Display data width available seats\n" +
        "3.3.      Sort  by tcode + ccode");
    }

    private static void Train_List_Function() throws IOException {
        //---------------Train list------------------//
        while (true){
            
            System.out.println("Train list:\n" +
            "1.      Load data from file\n" +
            "2.      Input & add to the head\n" +
            "3.      Display data\n" +
            "4.      Save train list to file\n" +
            "5.      Search by tcode\n" +
            "6.      Delete by tcode\n" +
            "7.      Sort by tcode\n" +
            "8.      Add after position  k\n" +
            "9.      Delete the node before the node having tcode = xCode\n" +
            "14      Back to main list\n"  );
            System.out.print("Enter your next choose: ");
            int choose=getValidNum(1, 14);
            if (choose==14) break;
            switch (choose){
                case 1: Input_train_list_from_file();
                        break;
                case 2: Input_to_head_train_list();
                        break;
                case 3: Display_data_in_train_list();
                        break;
                case 4: Save_train_list_to_file();
                        break;
                case 5: Search_by_tcode_in_train_list();
                        break;
                case 6: Delete_by_tcode_in_train_list();
                        break;
                case 7: Sort_train_list_by_tcode();
                        break;
                case 8: Add_train_after_position();
                        break;
                case 9: Delete_node_before_tcode();
                        break;
                case 10: Sort_train_list_by_tcode();
                        break;
                case 11: Sort_train_list_by_depart();
                        break;
                case 12: Find_Tcode3_change_to_x();
                        break;
                case 13: Find_Tcode1_delete();
                        break;
                default:break;
            }
        }
    }

    private static void Customer_List_Function() throws IOException {
        while (true){
            
            System.out.println("Customer list:\n" +
            "1.      Load data from file\n" +
            "2.      Input & add to the end\n" +
            "3.      Display data\n" +
            "4.      Save customer list to file\n" +
            "5.      Search by ccode\n" +
            "6.      Delete by ccode\n" +
            "7.      Back to main list");
            System.out.print("Enter your next choose: ");
            int choose=getValidNum(1, 7);
            if (choose==7) break;
            switch (choose){
                case 1: Input_customer_list_from_file();
                        break;
                case 2: Input_to_end_customer_list();
                        break;
                case 3: Display_data_in_customer_list();
                        break;
                case 4: Save_customer_list_to_file();
                        break;
                case 5: Search_by_ccode_in_customer_list();
                        break;
                case 6: Delete_by_ccode_in_customer_list();
                        break;
                default:break;
            }
        }
    }

    private static void Booking_List_Function() {
        while (true){
            
            System.out.println("Booking list:\n" +
            "1.      Input data\n" +
            "2.      Display data width available seats\n" +
            "3.      Sort  by tcode + ccode\n"+
            "4.      Back to main list");
            System.out.println("Enter your next choose: ");
            int choose=getValidNum(1, 4);
            if (choose==4) break;
            switch (choose){
                case 1: Input_booking_list();
                        break;
                case 2: Display_booking_data();
                        break;
                case 3: Sort_booking_list_by_tcode_and_ccode();
                        break;
                default:break;
            }
        }
    }

    private static void Sort_train_list_by_depart() {
        System.out.println("1.11.      Sort by depart");
        trainList.sortByDepart();
        trainList.traverse();
    }

    private static void Find_Tcode3_change_to_x() {
        System.out.println("1.12.      Find tcode=3 and change to X");
        trainList.searchByTcodeAndChangToX("3");
        trainList.traverse();
    }

    private static void Find_Tcode1_delete() {
        System.out.println("1.13.      Find tcode=1 and delete");
        trainList.delete(trainList.searchByTcode("1"));
        trainList.traverse();
    }
    
}
