/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercise1;

/**
 *
 * @author tuans
 */
class MyCard{
    String typeOfCard;
    String paymentCardNumber;
    public MyCard(){}
    public MyCard(String type,String payment){
        this.typeOfCard=type;
        boolean flag=true;
        for (int i=0;i<payment.length();i++){
            Character ch=payment.charAt(i);
            if (Character.isAlphabetic(ch)){
                flag=false;
                break;
            }
        }
        if (flag==false) payment="9999";
        this.paymentCardNumber=payment;
        
    }
    public String getCardCode(){
        String startString=this.paymentCardNumber.substring(0, 4);
        int sizeString=paymentCardNumber.length();
        if (startString.compareTo("0974")==0){
            String temp=this.paymentCardNumber.substring(sizeString-4);
            return temp;
        }
        return (startString);
    }
    @Override
    public String toString(){
        return this.typeOfCard+"\t\t"+this.paymentCardNumber+"\t\t"+getCardCode();
    }
}
public class Exercise1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MyCard card1=new MyCard("123456","097443");
        MyCard card2=new MyCard("eiuebg","siubv");
        MyCard card3=new MyCard("23423","097483");
        System.out.println("Information of cards:");
        System.out.println("Type\t\tPayment\t\tCardCode");
        
        System.out.println(card1.toString());
        System.out.println(card2.toString());
        System.out.println(card3.toString());
    }
}
