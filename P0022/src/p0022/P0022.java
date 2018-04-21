/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0022;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date ;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
class Candidate {
    private String Id;
    private String firstName;
    private String lastName;
    private int  birth;
    private String address;
    private String phone;
    private String email;
    private int type;
    public Candidate (){};
    public Candidate (String id, String firstName,String lastName,int  birth,
            String address,String phone,String email,int type){
        this.Id=id;
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.phone=phone;
        this.type=type;
        this.birth=birth;
        this.address=address;
    }
    int getType(){
        return this.type;
    }
    public String getName() {
        return this.firstName+" "+this.lastName;
    }
    @Override
    public String toString(){
        return this.firstName+" "+this.lastName+" | "+this.birth+" | "+this.address
                +" | "+this.phone+" | "+this.email+" | "+(this.type-1);
    }
}
class Experience extends Candidate{
    private int ExpInYear;
    private String ProSkill;
    public Experience(){
        super();
    }
    public Experience(String id, String firstName,String lastName,int  birth,
    String address,String phone,String email,int type,int Exp,String Skill){
        super(id, firstName, lastName, birth,
             address, phone, email, type);
        this.ExpInYear=Exp;
        this.ProSkill=Skill;
    }
}
class Fresher extends Candidate {
    int GraduateDate ;
    String Rank;
    String University;
    public Fresher(){
        super();
    }
    public Fresher(String id, String firstName,String lastName,int  birth,
    String address,String phone,String email,int type,int  Graduateint ,
    String Rank,String University){
        super(id, firstName, lastName, birth,
             address, phone, email, type);
        this.GraduateDate = Graduateint ;
        this.Rank=Rank;
        this.University=University;
    }
}
class Internship extends Candidate {
    String Majors;
    String Semester;
    String University;
    public Internship(){
        super();
    }
    public Internship(String id, String firstName,String lastName,int  birth,
    String address,String phone,String email,int type,String Majors,
    String Semester, String University){
        super(id, firstName, lastName, birth,
             address, phone, email, type);
        this.Majors=Majors;
        this.Semester=Semester;
        this.University=University;
    }
}
class validate {
    static public boolean validateEmail(String tempEmail){
        int posSign=-1;
        for (int i=0;i<tempEmail.length();i++){
            if (tempEmail.charAt(i)=='@'){
                if (posSign==-1)
                    posSign=i;
                else return false;
            }
        }
        int posDot=-1;
        for (int i=posSign;i<tempEmail.length();i++){
            if (tempEmail.charAt(i)=='.'){
                posDot=i;
                break;
            }
        }
        for (int i=posSign+1;i<posDot;i++){
            char ch=tempEmail.charAt(i);
            if (!Character.isDigit(ch)){
                if (!Character.isLetter(ch))
                    return false;
            }
        }
        return true;
    }
    static public boolean validatePhone(String tempPhone){
        for (int i=0;i<tempPhone.length();i++){
            if (!Character.isDigit(tempPhone.charAt(i)))
                return false;  
        }
        if (tempPhone.length()<10) return false;
        return true;
    }
    static public boolean validateRank(String tempRank){
        String RankArray[]={"Excellence", "Good", "Fair", "Poor"};
        for (int i=0;i<RankArray.length;i++){
            if (RankArray[i].compareToIgnoreCase(tempRank)==0){
                return true;
            }
        }
        return false;
    }
    static public boolean validateBirth(int tempBirth){
        int CurrentYear = Calendar.getInstance().get(Calendar.YEAR);
        if (1900<=tempBirth && tempBirth<=CurrentYear)
            return true;
        return false;
    }
    static public boolean validateYear(int tempYear){
        if (0<=tempYear && tempYear<=100)
            return true;
        return false;
    }
}
class getValid{
    static Scanner input=new Scanner(System.in);
    static public int getValidInt(int min,int max){
        while (true){
           try {
            int temp=Integer.parseInt(input.nextLine());
            if (min<=temp && temp<=max)
                return temp;
            else throw new Exception();
            } catch (Exception e) {
                System.out.println("Please enter valid interger from "+min+" to "+max);
            } 
        }
    }
    static public String getValidString(int type){
        while(true){
            try {
                String temp=input.nextLine();
                boolean check=false;
                if (type==1) check=validate.validateEmail(temp);
                else if (type==2) check=validate.validatePhone(temp);
                else if (type==3) check=validate.validateRank(temp);
                if (check==false) throw new Exception();
                return temp;
            } catch (Exception e) {
                if (type==1) System.out.println("Please enter valid email form <account name>@<domain>. ");
                else if (type==2) System.out.println("Please enter valid phone has number with minimum 10 characters");
                else if (type==3) System.out.println("Please enter valid rank with one of 4 values (Excellence, Good, Fair, Poor)");
            }
        }
    }
}
public class P0022 {
    public static void printMenu(){
        System.out.println("CANDIDATE MANAGEMENT SYSTEM\n" +
                "1.	Experience\n" +
                "2.	Fresher\n" +
                "3.	Internship\n" +
                "4.	Searching\n" +
                "5.	Exit");
        System.out.print("Enter your choose: ");
    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choose=-1;
        if (validate.validateEmail("iejfb@iubf.com"))
            System.out.println("oueb");
           
        ArrayList<Candidate> Employee=new ArrayList<>();
        while (choose!=5){
            printMenu();
            choose=getValid.getValidInt(1,5);
            switch (choose){
                case 1:
                    addExperience(Employee);
                    break;
                case 2:
                    addFresher(Employee);
                    break;
                case 3:
                    addIntern(Employee);
                    break;
                case 4:
                    searchingFunction(Employee);
                    break;
                case 5:
                    return;
                default:
                    break;
            }
        }
    }

    private static void addExperience(ArrayList<Candidate> Employee) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter ID: ");
        String Id=input.nextLine();
        System.out.print("Enter first name: ");
        String firstName=input.nextLine();
        System.out.print("Enter last name: ");
        String lastName=input.nextLine();
        System.out.print("Enter birth(year): ");
        int birth=getValid.getValidInt(1900, Calendar.getInstance().get(Calendar.YEAR));
        System.out.print("Enter address: ");
        String address=input.nextLine();
        System.out.print("Enter phone(minimun 10 digit): ");
        String phone=getValid.getValidString(2);
        System.out.print("Enter email: ");
        String email=getValid.getValidString(1);
        int type=1;
        System.out.print("Enter year experiences: ");
        int year=getValid.getValidInt(0, 100);
        System.out.print("Enter special skill: ");
        String skill=input.nextLine();
        Employee.add(new Experience(Id,firstName,lastName,birth,address,phone,email,type,year,skill));
    }

    private static void addFresher(ArrayList<Candidate> Employee) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter ID: ");
        String Id=input.nextLine();
        System.out.print("Enter first name: ");
        String firstName=input.nextLine();
        System.out.print("Enter last name: ");
        String lastName=input.nextLine();
        System.out.print("Enter birth(year): ");
        int birth=getValid.getValidInt(1900, Calendar.getInstance().get(Calendar.YEAR));
        System.out.print("Enter address: ");
        String address=input.nextLine();
        System.out.print("Enter phone(minimun 10 digit): ");
        String phone=getValid.getValidString(2);
        System.out.print("Enter email: ");
        String email=getValid.getValidString(1);
        int type=2;
        System.out.print("Enter date graduate(year): ");
        int GraduateDate=getValid.getValidInt(1900, Calendar.getInstance().get(Calendar.YEAR));
        System.out.print("Enter rank: ");
        String Rank=getValid.getValidString(3);
        System.out.print("Enter university: ");
        String University=input.nextLine();
        Employee.add(new Fresher(Id,firstName,lastName,birth,address,phone,email,type,GraduateDate,Rank,University));
    }

    private static void addIntern(ArrayList<Candidate> Employee) {
        Scanner input=new Scanner(System.in);
        System.out.print("Enter ID: ");
        String Id=input.nextLine();
        System.out.print("Enter first name: ");
        String firstName=input.nextLine();
        System.out.print("Enter last name: ");
        String lastName=input.nextLine();
        System.out.print("Enter birth(year): ");
        int birth=getValid.getValidInt(1900, Calendar.getInstance().get(Calendar.YEAR));
        System.out.print("Enter address: ");
        String address=input.nextLine();
        System.out.print("Enter phone(minimun 10 digit): ");
        String phone=getValid.getValidString(2);
        System.out.print("Enter email: ");
        String email=getValid.getValidString(1);
        int type=3;
        System.out.print("Enter majors: ");
        String Majors=input.nextLine();
        System.out.println("Enter semester: ");
        String Semester=input.nextLine();
        System.out.print("Enter university: ");
        String University=input.nextLine();
        Employee.add(new Internship(Id,firstName,lastName,birth,address,phone,email,type,Majors,Semester,University));
    }
    
    private static void searchingFunction(ArrayList<Candidate> Employee) {
        Scanner input=new Scanner(System.in);
        printListEmployee(Employee);
        System.out.println("Input Candidate name (First name or Last name): ");
        String name=input.nextLine();
        System.out.println("Input type of candidate: ");
        int type=getValid.getValidInt(1, 3);
        for (Candidate temp:Employee){
            if (temp.getType()==type){
                if (temp.getName().toLowerCase().contains(name.toLowerCase()))
                    System.out.println(temp);
            }
        }
    }

    private static void printListEmployee(ArrayList<Candidate> Employee) {
        System.out.println("\nList of Candidate:");
        System.out.println("===========EXPERIENCE CANDIDATE============");
        for (Candidate temp:Employee){
            if (temp instanceof Experience)
                System.out.println(temp.getName());
        }
        System.out.println("==========FRESHER CANDIDATE==============");
        for (Candidate temp:Employee){
            if (temp instanceof Fresher)
                System.out.println(temp.getName());
        }
        System.out.println("===========INTERN CANDIDATE==============");
        for (Candidate temp:Employee){
            if (temp instanceof Internship)
                System.out.println(temp.getName());
        }}
    
}
