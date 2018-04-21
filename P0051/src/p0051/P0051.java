/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0051;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class P0051 {
    static Scanner input=new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        display_menu();
        int choice=getValidNum();
        switch(choice){
            case 1: calculator();
                    break;
            case 2: bmi();
                    break;
            case 3: break;
        }
    }

    private static void display_menu() {
        System.out.println("========= Calculator Program =========\n" +
        "1. Normal Calculator\n" +
        "2. BMI Calculator\n" +
        "3. Exit\n" +
        "Please choice one option:");
    }

    private static int getValidNum() {
        while (true){
            try {
                int temp=Integer.parseInt(input.nextLine());
                return temp;
            } catch (Exception e) {
                System.out.println("Error format");
            }
        }
    }
    private static double getValidDouble() {
        while (true){
            try {
                double temp=Double.parseDouble(input.nextLine());
                return temp;
            } catch (Exception e) {
                System.out.println("Error format");
            }
        }
    }
    private static char getOperator() {
       while (true){
            try {
                String temp=input.nextLine();
                if (temp.compareToIgnoreCase("+")==0) return '+';
                if (temp.compareToIgnoreCase("-")==0) return '-';
                if (temp.compareToIgnoreCase("*")==0) return '*';
                if (temp.compareToIgnoreCase("/")==0) return '/';
                if (temp.compareToIgnoreCase("^")==0) return '^';
                if (temp.compareToIgnoreCase("=")==0) return '=';
                System.out.println("Please input (+, -, *, /, ^)");
            } catch (Exception e) {
                System.out.println("Error format");
            }
        }}
    private static void calculator() {
        Double ans=new Double(0);
        System.out.print("Enter number: ");
        ans=getValidDouble();
        while (true){
            System.out.print("Enter operator: ");
            char op=getOperator();
            if (op=='=') break;
            System.out.print("Enter number: ");
            double number=getValidDouble();
            ans=calculate(ans, op, number);
            System.out.println("Memory:"+ans);
        }
        if (ans != null){
            System.out.println("Result:"+ans);
        }
    }

    private static void bmi() {
        System.out.println("Enter Weight(kg): ");
        double w=getValidDouble();
        System.out.println("Enter Height(cm): ");
        double h=getValidDouble();
        double temp=w/(h*h/10000);
        System.out.println(temp);
        String calBMI=cal(temp);
        System.out.println(calBMI);
    }

    private static Double calculate(double n1, char op, double n2) {
        switch(op){
            case '+': return n1+n2;
            case '-': return n1-n2;
            case '*': return n1*n2;
            case '^': return Math.pow(n1, n2);
            case '/': if (n2!=0) return n1/n2;
        }
        return null;
    }

    private static String cal(double temp) {
        if (temp<19){
            return "Under-standard";
        }
        if (temp<25){
            return "Standard";
        }
        if (temp<30){
            return "Overweight";
        }
        if (temp<40){
            return "Fat - should lose weight";
        }
        return "Very fat - should lose weight immediately";
    }

    
    
}
