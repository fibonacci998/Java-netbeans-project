
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
public class ChildForm extends JDialog implements ActionListener{
    JLabel lb;
    JTextField txt;
    JButton bt;
    ParentForm parent;
    public ChildForm(JFrame parent, boolean modals, String st){
        super(parent, modals);
        setLayout(new FlowLayout());
        this.parent=(ParentForm) parent;
        getContentPane().add(lb=new JLabel("input value "));
        getContentPane().add(txt=new JTextField(20));
        txt.setText(st);
        getContentPane().add(bt=new JButton("update parent"));
        bt.setActionCommand("update");
        bt.addActionListener(this);
        getContentPane().add(bt=new JButton("Close"));
       // bt.setActionCommand("Open");
        bt.addActionListener(this);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Close")){
            this.dispose();
        }
        if (ae.getActionCommand().equals("update")){
            parent.getChildValue(txt.getText());
        }
    }
}
