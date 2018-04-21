/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addingmatrix;

import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class Addingmatrix {

    /**
     * @param args the command line arguments
     */
    public static int getSizeMatrix(){
        System.out.println("N = ");
        Scanner sc=new Scanner(System.in);
        return sc.nextInt();
    }
    public static void inputMatrix(double a[][],int n,char c){
        Scanner sc=new Scanner(System.in);
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(c+"["+i+"]["+j+"]=");
                a[i][j]=sc.nextDouble();
            }
        }
    }
    public static double[][] sum(double a[][],double b[][],int n){
        double c[][];
        c=new double[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                c[i][j]=a[i][j]+b[i][j];
            }
        }
        return c;
    }
    public static void displayMatrix(double a[][],int n){
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        int n = 0;
        
        n=getSizeMatrix();
        double[][] a,b,c;
        a=new double[n][n];
        b=new double[n][n];
        c=new double[n][n];
        
        System.out.println("Scanner matrix A:");
        inputMatrix(a,n,'A');
        System.out.println("Scanner matrix B:");
        inputMatrix(b,n,'B');
        c=sum(a,b,n);
        System.out.println("-----------------");
        displayMatrix(c,n);
    }
}
