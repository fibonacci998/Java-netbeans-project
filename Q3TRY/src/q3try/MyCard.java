/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q3try;
import static java.lang.Character.isDigit;
public class MyCard {

    String cardNumber;
    String typeNumber;

    

    public MyCard(String typeNumber,String cardNumber) {
        this.typeNumber=typeNumber;
        boolean flag=true;
        for (int i=0;i<cardNumber.length();i++){
            char ch=cardNumber.charAt(i);
            if (!Character.isDigit(ch))
            {
                flag=false;
                break;
            }
        }
        if (flag==false) cardNumber="0000";
        this.cardNumber=cardNumber;
    }
    public String getCardCode() {
        
        String firstString=this.cardNumber.substring(0, 4);
        String lastString=this.cardNumber.substring(this.cardNumber.length()-4);
        if (this.typeNumber.compareTo("credit")==0)
            return firstString;
        return lastString;
    }
    @Override
    public String toString(){
        return this.typeNumber +' '+ this.cardNumber;
    }
}

