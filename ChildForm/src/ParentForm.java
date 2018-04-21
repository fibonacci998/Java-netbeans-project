
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class ParentForm extends JFrame implements ActionListener{
    JLabel lb;
    JTextField txt;
    JButton bt;

    public ParentForm() {
        super("Parent form");
        setLayout(new FlowLayout());
        getContentPane().add(lb=new JLabel("input value "));
        getContentPane().add(txt=new JTextField(20));
        getContentPane().add(bt=new JButton("open child"));
        bt.setActionCommand("Open");
        bt.addActionListener(this);
        getContentPane().add(bt=new JButton("Close"));
       // bt.setActionCommand("Open");
        bt.addActionListener(this);
        pack();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Close")){
            System.exit(0);
        }
        if (ae.getActionCommand().equals("Open")){
            new ChildForm(this,true,txt.getText());
        }
    }
    public void getChildValue(String st){
        txt.setText(st);
    }
    public static void main(String[] args) {
        new ParentForm().setVisible(true);
    }
}
