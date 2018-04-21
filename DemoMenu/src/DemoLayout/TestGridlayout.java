/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoLayout;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author tuans
 */
public class TestGridlayout extends JFrame{
    JButton[] bt=new JButton[16];

    public TestGridlayout(){
        super();
        setLayout(new GridLayout(2,8));
        for (int i=0;i<bt.length;i++){
           getContentPane().add(bt[i]=new JButton("BT"));
        }
        pack();
        setVisible(true);
    }
    public static void main(String[] args) {
        new TestGridlayout();
    }
}
