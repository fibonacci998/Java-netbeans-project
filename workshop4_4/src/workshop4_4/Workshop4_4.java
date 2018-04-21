/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop4_4;

import java.util.Scanner;

class Fraction{
    int ts;
    int ms;
    public Fraction(){}
    public void setTs(int ts){
        this.ts=ts;
    }
    public void setMs(int ms){
        this.ms=ms;
    }
    public Fraction(int ts,int ms){
        this.ts=ts;
        this.ms=ms;
    }
    public int getTs(){return this.ts;}
    public int getMs(){return this.ms;}
    int gcd(int a,int b){
        if (b==0) return a;
        return gcd(b,a%b);
    }
    public void rutgon(){
        int temp=gcd(this.ts,this.ms);
        this.ms/=temp;
        this.ts/=temp;
    }
    public Fraction add(Fraction temp){
        Fraction ans=new Fraction();
        ans.setMs(this.ms*temp.ms);
        ans.setTs(this.ts*temp.ms+this.ms*temp.ts);
        ans.rutgon();
        return ans;
    }
    public Fraction sub(Fraction temp){
        Fraction ans=new Fraction();
        ans.setMs(this.ms*temp.ms);
        ans.setTs(this.ts*temp.ms-this.ms*temp.ts);
        ans.rutgon();
        return ans;
    }
    public Fraction mul(Fraction temp){
        Fraction ans=new Fraction();
        ans.setMs(this.ms*temp.ms);
        ans.setTs(this.ts*temp.ts);
        ans.rutgon();
        return ans;
    }
    public Fraction div(Fraction temp){
        Fraction ans=new Fraction();
        ans.setMs(this.ms*temp.ts);
        ans.setTs(this.ts*temp.ms);
        ans.rutgon();
        return ans;
    }
    public void display(){
        if (this.ts%this.ms==0)
            System.out.println(this.ts/this.ms);
        else System.out.println(this.ts+"/"+this.ms);
    }
}
/**
 *
 * @author tuans
 */
public class Workshop4_4 {

    
    /**
     * @param args the command line arguments
     */
    static void input(Fraction ps1,Fraction ps2){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter fraction in form a/b!!!");
        System.out.print("Enter first fraction: ");
        String temp=sc.nextLine();
        Scanner form=new Scanner(temp).useDelimiter("/");
        ps1.setTs(form.nextInt());
        ps1.setMs(form.nextInt());
        form.reset();
        System.out.print("Enter second fraction: ");
        temp=sc.nextLine();
        form=new Scanner(temp).useDelimiter("/");
        ps2.setTs(form.nextInt());
        ps2.setMs(form.nextInt());
    }
    static void process(Fraction ps1,Fraction ps2){
        int choose=0;
        Fraction temp=new Fraction();
        System.out.print("Enter your choose(1 to add, 2 to sub, 3 to mul, 4 to div:");
        Scanner sc=new Scanner(System.in);
        choose=sc.nextInt();
        switch (choose){
            case 1:
                temp=ps1.add(ps2);
                break;
            case 2:
                temp=ps1.sub(ps2);
                break;
            case 3:
                temp=ps1.mul(ps2);
                break;
            case 4:
                temp=ps1.div(ps2);
                break;
            default:
                break;
        }
        System.out.println("Answer is: ");
        temp.display();
    }
    public static void main(String[] args) {
        // TODO code application logic here
        Fraction ps1=new Fraction();
        Fraction ps2=new Fraction();
        input(ps1,ps2);
        process(ps1,ps2);
    }
    
}
