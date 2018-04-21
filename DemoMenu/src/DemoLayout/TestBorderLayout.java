/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DemoLayout;

import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author tuans
 */
public class TestBorderLayout extends JFrame{
    JButton arr1[]=new JButton[5];
    JButton arr2[]=new JButton[16];
    public TestBorderLayout(){
        super();
        //default border layout
        
        JPanel center=new JPanel();
        center.setLayout(new GridLayout(4,4));
        for (int i=0;i<arr2.length;i++){
           center.add(arr2[i]=new JButton(i+1+""));
        }
        getContentPane().add(center);
        getContentPane().add(arr1[0]=new JButton("East"),BorderLayout.EAST);
        getContentPane().add(arr1[1]=new JButton("West"),BorderLayout.WEST);
        getContentPane().add(arr1[2]=new JButton("South"),BorderLayout.SOUTH);
        getContentPane().add(arr1[3]=new JButton("North"),BorderLayout.NORTH);
        
        setSize(500,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TestBorderLayout();
    }
}
