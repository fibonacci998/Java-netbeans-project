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
public class CustomerAccount {
    String accountType;
    double balaceAmount;
    public CustomerAccount(){}
    public CustomerAccount(String type,double money){
        this.accountType=type;
        this.balaceAmount=money;
    }

    @Override
    public String toString() {
        return "CustomerAccount{" + "accountType=" + accountType + ", balaceAmount=" + balaceAmount + '}';
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalaceAmount() {
        return balaceAmount;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBalaceAmount(double balaceAmount) {
        this.balaceAmount = balaceAmount;
    }
    public void addMoney(double money){
        this.balaceAmount+=money;
        this.setBalaceAmount(balaceAmount+money);
    }
    public void subMoney(double money){
        this.setBalaceAmount(balaceAmount-money);
    }
}
