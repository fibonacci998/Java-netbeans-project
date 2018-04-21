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
public class AccountManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CustomerAccount a=new CustomerAccount("a",100.0);
        CustomerAccount b=new CustomerAccount("b",500.0);
        CustomerAccount c=new CustomerAccount("c",400.0);
        //test1
        //TransferManager tf1=new TransferManager(a, b, 90.0);
        //tf1.start(); 
        //test2
        //TransferManager tf1=new TransferManager(a, b, 20000.0);
        //tf1.start();
        TransferManager tf1=new TransferManager(a, b, 90.0);
        TransferManager tf2=new TransferManager(a, c, 20.0);
        tf1.start();
        tf2.start();
    }
    
}
