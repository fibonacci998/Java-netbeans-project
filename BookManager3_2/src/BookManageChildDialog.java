
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
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
public class BookManageChildDialog extends JDialog implements ActionListener{
    JLabel lbBookID, lbBookName,lbQuantity,lbPrice;
    JTextField txtBookID,txtBookName,txtQuantity,txtPrice;
    JButton btAdd,btClear,btClose;
    BookManage parent;
    public BookManageChildDialog(JFrame parent, boolean modals) {
        super(parent,modals);
        setLayout(new FlowLayout());
        this.parent=(BookManage) parent;
        
        getContentPane().add(lbBookID=new JLabel("BookID"));
        getContentPane().add(txtBookID=new JTextField(10));
        getContentPane().add(lbBookName=new JLabel("BookName"));
        getContentPane().add(txtBookName=new JTextField(10));
        
        getContentPane().add(lbQuantity=new JLabel("Quantity"));
        getContentPane().add(txtQuantity=new JTextField(10));
        getContentPane().add(lbPrice=new JLabel("Price"));
        getContentPane().add(txtPrice=new JTextField(10));
        
        getContentPane().add(btClear=new JButton("Clear"));
        btClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtBookID.setText("");
                txtBookName.setText("");
                txtQuantity.setText("");
                txtPrice.setText("");
            }
        });
        
        getContentPane().add(btAdd=new JButton("Add"));
        btAdd.addActionListener(this);
        
        getContentPane().add(btClose=new JButton("Close"));
        btClose.addActionListener(this);
        
        
        
        setSize(222,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Add")){
            Vector modelBook=this.parent.getData();
            boolean flag=false;
            for (int i=0;i<modelBook.size();i++){
                Vector temp=(Vector) modelBook.get(i);
                if (((String)temp.get(0)).compareToIgnoreCase(txtBookID.getText())==0){
                    flag=true;
                }
            }
            if (!flag){
                Book book=new Book(txtBookID.getText(),
                    txtBookName.getText(), 
                    Integer.parseInt(txtQuantity.getText()), 
                    Integer.parseInt(txtPrice.getText()));
                this.parent.addBookInfor(book);

            }
            else JOptionPane.showMessageDialog(new Frame(), "Your code BookID is exited");
        }
        if (ae.getActionCommand().equals("Close")){
            this.dispose();
        }
    }
    
}
