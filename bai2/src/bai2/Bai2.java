/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bai2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Bai2 {

    interface IHOADON {

        void f1(ArrayList<Hoadon> a);

        void f2(ArrayList<Hoadon> a);
    }

    public static class Hoadon implements Comparable {

        String name;
        double money;

        public Hoadon() {
        }

        public Hoadon(String name, double money) {
            this.name = name;
            this.money = money;
        }

        public String getName() {
            return this.name;
        }

        public double getMoney() {
            return this.money;
        }

        @Override
        public int compareTo(Object t) {
            Hoadon temp = (Hoadon) t;
            if (this.money > temp.getMoney()) {
                return -1;
            }
            if (this.money == temp.getMoney()) {
                return 0;
            }
            return 1;
        }

        @Override
        public String toString() {
            return this.name + "\t\t" + this.money;
        }
    }

    public static class QLHoadon implements IHOADON {

        public QLHoadon() {
        }

        @Override
        public void f1(ArrayList<Hoadon> a) {
            Hoadon object;
            Scanner sc = new Scanner(System.in);
            int size;
            System.out.print("Enter number of elements: ");
            size = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < size; i++) {
                System.out.println("");
                String name;
                double money;
                System.out.print("Enter name: ");
                name = sc.nextLine();
                System.out.print("Enter money: ");
                money = Double.parseDouble(sc.nextLine());
                object = new Hoadon(name, money);
                a.add(object);
            }
        }

        @Override
        public void f2(ArrayList<Hoadon> a) {
            System.out.println("---------------------------");
            System.out.println("Information with 'a' or 'A' at first in name of your input:");
            for (int i = 0; i < a.size(); i++) {
                String tg = a.get(i).name;
            }
            for (Hoadon x : a) {
                if (x.getName().charAt(0) == 'a' || x.getName().charAt(0) == 'A') {
                    System.out.println(x.name + "\t\t" + x.money);
                }
            }
        }

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        QLHoadon process = new QLHoadon();
        ArrayList<Hoadon> a = new ArrayList<>();
        process.f1(a);
        process.f2(a);
        Collections.sort(a);
        System.out.println("--------------");
        System.out.println("------------1st person:");
        System.out.println(a.get(0));
        System.out.println("------------4st person:");
        System.out.println(a.size());
        System.out.println(a.get(3));
    }

}
