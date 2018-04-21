/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0011;

import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author tuans
 */
public class P0011 {

    static Scanner sc=new Scanner(System.in);
    static char[] digitInDecimal=new char[]{'0','1','2','3','4','5','6','7','8','9'};
    static char[] digitInBinary=new char[]{'0','1'};
    static char[] digitInHexa=new char[]{'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
    
    static int getValidInt(int min,int max){
        while(true){
            try {
                int temp=Integer.parseInt(sc.nextLine());
                if (temp<min || temp>max)
                    throw new Exception();
                return temp;
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
    
    static String getValidNumberInStringConvert(int base){
        char[] digitCheck = null;
        if (base==2) digitCheck=digitInBinary;
        else if (base==10) digitCheck=digitInDecimal;
        else if (base==16) digitCheck=digitInHexa;
        while(true){
            try {
                String temp=sc.nextLine();
                boolean flag=false;
                for (char ch: temp.toCharArray()){
                    flag=false;
                    
                    for (char cTemp: digitCheck){
                        if (ch == cTemp){
                            flag=true;
                            break;
                        }
                    }
                    if (flag==false) break;
                }
                if (flag==false) throw new Exception();
                return temp;
            } catch (Exception e) {
                System.out.print("Base "+base+" only has digit ");
                for (int i=0;i<digitCheck.length;i++)
                    System.out.print(digitCheck[i]+"| ");
                System.out.print("\nEnter again: ");
            }   
        }
    }
    static String convertDecToHex(String dec){
        String answer=new String();
        //int tempDec=Integer.parseInt(dec);
        BigInteger temp=new BigInteger(dec);
//        while (tempDec!=0){
//            int div=tempDec/16;
//            int mod=tempDec%16;
//            answer=digitInHexa[mod]+answer;
//            tempDec=div;
//        }
        while (temp!=BigInteger.ZERO){
            BigInteger div=temp.divide(BigInteger.valueOf(16));
            int mod=temp.mod(BigInteger.valueOf(16)).intValue();
            answer=digitInHexa[mod]+answer;
            temp=div;
        }
        return answer;
    }
    
    static String convertHexToDec(String hex){
        BigInteger answer=BigInteger.ZERO;
        for (int i=0;i<hex.length();i++){
            char ch=hex.charAt(i);
            int value=0;
            for (int j=0;j<digitInHexa.length;j++){
                if (ch==digitInHexa[j])
                    value=j;
            }
            int pow=(int) Math.pow(16, (hex.length()-1)-i);
            //answer+=value*pow;
            answer=answer.add(BigInteger.valueOf(value).multiply(BigInteger.valueOf(pow)));
        }
        return String.valueOf(answer);
    }
    static String convertDecToBin(String dec){
        String answer=new String();
        //int tempDec=Integer.parseInt(dec);
        BigInteger temp=new BigInteger(dec);
//        while (tempDec!=0){
//            int div=tempDec/2;
//            int mod=tempDec%2;
//            answer=digitInBinary[mod]+answer;
//            tempDec=div;
//        }
        while (temp!=BigInteger.ZERO){
            BigInteger div=temp.divide(BigInteger.valueOf(2));
            int mod=temp.mod(BigInteger.valueOf(2)).intValue();
            answer=digitInBinary[mod]+answer;
            temp=div;
        }
        return answer;
    }
    static String convertBinToDec(String bin){
        //int answer=0;
        BigInteger answer=BigInteger.ZERO;
        for (int i=0;i<bin.length();i++){
            char ch=bin.charAt(i);
            int value=0;
            for (int j=0;j<digitInBinary.length;j++){
                if (ch==digitInBinary[j])
                    value=j;
            }
            int pow=(int) Math.pow(2, (bin.length()-1)-i);
            //answer+=value*pow;
            answer=answer.add(BigInteger.valueOf(value).multiply(BigInteger.valueOf(pow)));
        }
        return String.valueOf(answer);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        System.out.println("Enter 1 to binary, 2 to decimal, 3 to hexa!");
        
        System.out.print("Choose base input: ");
        int inputBase = getValidInt(1, 3);
        inputBase=convertToBase(inputBase);
        
        System.out.print("Choose base output: ");
        int outputBase = getValidInt(1,3);
        outputBase=convertToBase(outputBase);
        
        System.out.print("Enter your inpur number:");
        String input=getValidNumberInStringConvert(inputBase);
        
        String output=convertNumberFromInputBaseToOutputBase(input,inputBase,outputBase);
        
        System.out.println(input+"("+inputBase+") = "+output+"("+outputBase+")");
        
    }

    private static int convertToBase(int input) {
        if (input==1) return 2;
        if (input==2) return 10;
        return 16;
    }

    private static String convertNumberFromInputBaseToOutputBase(String input, int inputBase, int outputBase) {
        if (inputBase==outputBase) 
            return input;
        String temp=new String();
        switch (inputBase){
            case 2:     temp=convertBinToDec(input);
                        if (outputBase==16){
                            temp=convertDecToHex(temp);
                        }
                        break;
            case 10:    if (outputBase==2) temp=convertDecToBin(input);
                        else temp=convertDecToHex(input);
                        break;
            case 16:    temp=convertHexToDec(input);
                        if (outputBase==2){
                            temp=convertDecToBin(temp);
                        }
                        break;
            default:    break;
        }
        return temp;
    }
    
}
