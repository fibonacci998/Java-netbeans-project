
import static java.lang.Math.min;

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
    //sum number from 1 to n
    static int sum(int n){
        if (n==1) return 1;
        return n+sum(n-1);
    }
    
    //find min in array
    public static int findMin(int[] numbers, int startIndex, int endIndex) {

        if (startIndex==endIndex)
            return numbers[startIndex];
        return min(findMin(numbers,0,endIndex-1),numbers[endIndex]);
    }
    
    //find sum of array
    public static int findSum(int[] numbers, int startIndex, int endIndex) {

        if (startIndex==endIndex)
            return numbers[startIndex];
        return (findSum(numbers,0,endIndex-1)+numbers[endIndex]);
    }
    
    //check palindrome
    public static int isPalindrome(String st,int startIndex,int endIndex){
        if (startIndex==endIndex) return 1;
        if (startIndex > endIndex) return 1;
        char ch1=st.charAt(startIndex);
        char ch2=st.charAt(endIndex);
        if (ch1==ch2){
            return isPalindrome(st, startIndex+1, endIndex-1);
        }
        return 0;
    }
    
    //find GCD
    public static int gcd(int num1,int num2){
        if (num2==0) return num1;
        return (gcd(num2,num1%num2));
    }
    
    //find power
    public static int power(int x,int n){
        if (n==0) return 1;
        return x*power(x,n-1);
    }
    
    //find factorial number
    public static int fact(int n){
        if (n<=1) return 1;
        return n*fact(n-1);
    }
    //find fibonacci n-th
    public static int fib(int n){
        if (n<=2) return 1;
        return fib(n-1)+fib(n-2);
    }
    //find reciprocals
    public static double addReciprocal(int n){
        if (n==1) return 1.0;
        return (1.0/n +addReciprocal(n-1));
    }
    static int ss[][]=new int[10][10];
    //find stirling number
    public static int stirnum(int n,int k){
        if (n==0 && k==0) return (ss[0][0]=1);
        if (k==0) return (ss[n][0]=0);
        if (n>0 && k>0)
            return (ss[n][k]=stirnum(n-1, k-1)-(n-1)*stirnum(n-1, k));
        return 0;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Sum from 1 to 10: "+sum(10));
        
        int a[]={7,4,2,5,6,3};
        int min=findMin(a,0, a.length-1);
        System.out.println("Min: "+min);
        
        int sum=findSum(a,0,a.length-1);
        System.out.println("Sum: "+sum);
    
        String st="aabbaa";
        if (isPalindrome(st, 0, st.length()-1)==1){
            System.out.println(st+" is palindrome!");
        }else System.out.println(st+" is not palindrome!");
        
        System.out.println("GCD(20,25) = "+gcd(20, 25));
        
        System.out.println("2^5 = "+power(2, 5));
        
        System.out.println("5! = "+fact(5));
        
        System.out.println("Fib(5) = "+fib(5));
    
        System.out.println("Sum of 4 reciprocals: "+addReciprocal(4));
        
    }
    
    
}
