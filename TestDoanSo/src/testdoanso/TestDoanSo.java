/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testdoanso;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class TestDoanSo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
class Player1 extends Thread{
    Person person;
    public Player1(Person xPerson){
        this.person=xPerson;
    }
    public void run(){
        while(true){
            person.person1();
        }
    }
}
class Player2 extends Thread{
    Person person;
    public Player2(Person xPerson){
        this.person=xPerson;
    }
    public void run(){
        while(true){
            person.person2();
        }
    }
}
class Person{
    Scanner scan=new Scanner(System.in);
    int turn;
    String numberGuess;
    public Person(int xTurn){
        turn=xTurn;
    }
    public synchronized void person1(){
        if (turn==1){
            try {
                this.wait();
            } catch (Exception e) {

            }
        }
        System.out.print("Turn person 1: ");
        numberGuess=(scan.nextLine());
        if (numberGuess.compareToIgnoreCase("100")==0){
           
        }
    }

    public synchronized void person2(){
        if (turn==2){
            try {
                this.wait();
            } catch (Exception e) {

            }
        }
        System.out.print("Turn person 2: ");
        numberGuess=Integer.parseInt(scan.nextLine());
        int guess=process(numberGuess,ans);
        if (guess==1 || guess==-1){
            turn=1;
            this.notifyAll();
        }
    }

    private int process(int numberGuess,int ans) {
        if (numberGuess<ans){
            System.out.println("Your guess is smaller than answer!");
            return -1;
        }
        if (numberGuess>ans){
            System.out.println("Your guess is greater than answer!");
            return 1;
        }
        System.out.println("Congratulate!! Your guess is true!!");
        return 0;
    }
}