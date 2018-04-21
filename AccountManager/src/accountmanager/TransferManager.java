/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accountmanager;

/**
 *
 * @author tuans
 */
public class TransferManager extends Thread{
    CustomerAccount from,to;
    double money;
    public TransferManager(CustomerAccount from,CustomerAccount to,double money){
        this.from=from;
        this.to=to;
        this.money=money;
    }
    public void run(){
        synchronized(from){
            double moneyFrom=from.getBalaceAmount();
            double moneyTo=to.getBalaceAmount();
            if (money>moneyFrom){
                System.out.println("Error!!");
                return;
            }
            else{
                try{
                    Thread.sleep(100);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            from.subMoney(money);
            to.addMoney(money);
            System.out.println("Transfer successfull!!");
            System.out.println("From money: "+from.toString());
            System.out.println("To money: "+to.toString());
            } 
        }

    }
}
