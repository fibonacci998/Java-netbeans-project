/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testfe;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tuans
 */
class a extends Thread{
    void x(){
        System.out.println("xxx");
    }
    public void run(){
        System.out.println("ruungu");
    }
}
public class TestFE extends JFrame{
    
    public TestFE(){
        this.setSize(100,100);
        JPanel p=new JPanel(new BorderLayout());
        this.add(p);
        for (int i=0;i<10;i++){
            JButton b=new JButton("b"+i);
            p.add(b);
        }
        this.setVisible(true);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        a t=new a();
        t.x();
        t.start();
    }
    
}
