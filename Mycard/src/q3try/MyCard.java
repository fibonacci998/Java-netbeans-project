/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3try;
import static java.lang.Character.isDigit;
public class MyCard {
    private String typeNumber;
    private String cardNumber;

    public MyCard(String typeNumber, String cardNumber) {
        for(int i = 0;i<cardNumber.length();i++){
            if(!Character.isDigit(cardNumber.charAt(i))){
                this.cardNumber = "0000";
            }else{
                this.cardNumber = cardNumber;
            }
        }
        this.typeNumber = typeNumber;
    }

    
    public String getTypeNumber() {
        return typeNumber;
    }

    public void setTypeNumber(String typeNumber) {
        this.typeNumber = typeNumber;
    }

    public String getCardCode() {
        if(cardNumber.length() >4){
            if(typeNumber.equals("credit")){
                cardNumber = cardNumber.substring(0, 4);
            }else
                cardNumber = cardNumber.substring(cardNumber.length()-4);
        }
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public String toString() {
        return "MyCard{" + "typeNumber=" + typeNumber + ", cardNumber=" + cardNumber + '}';
    }
    
    
}

