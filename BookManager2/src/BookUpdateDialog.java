
import java.awt.FlowLayout;
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
public class BookUpdateDialog extends JDialog implements ActionListener{
    JLabel lbBookID, lbBookName,lbQuantity,lbPrice;
    JTextField txtBookID,txtBookName,txtQuantity,txtPrice;
    JButton btUpdate,btClear,btClose;
    BookManage parent;
    public BookUpdateDialog(JFrame parent,boolean modals){
        super(parent,modals);
        setLayout(new FlowLayout());
        this.parent=(BookManage) parent;
        
        getContentPane().add(lbBookID=new JLabel("BookID"));
        getContentPane().add(txtBookID=new JTextField(10));
        txtBookID.setText(this.parent.getSelectedBook().getBookID());
        txtBookID.setEditable(false);
        getContentPane().add(lbBookName=new JLabel("BookName"));
        getContentPane().add(txtBookName=new JTextField(10));
        txtBookName.setText(this.parent.getSelectedBook().getBookName());
        getContentPane().add(lbQuantity=new JLabel("Quantity"));
        getContentPane().add(txtQuantity=new JTextField(10));
        txtQuantity.setText(this.parent.getSelectedBook().getQuantity()+"");
        getContentPane().add(lbPrice=new JLabel("Price"));
        getContentPane().add(txtPrice=new JTextField(10));
        txtPrice.setText(this.parent.getSelectedBook().getPrice()+"");
        getContentPane().add(btClear=new JButton("Clear"));
        btClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtBookName.setText("");
                txtQuantity.setText("");
                txtPrice.setText("");
            }
        });
        
        getContentPane().add(btUpdate=new JButton("Update"));
        btUpdate.addActionListener(this);
        
        getContentPane().add(btClose=new JButton("Close"));
        btClose.addActionListener(this);
        setSize(222,500);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Close")){
            this.dispose();
        }
        if (ae.getActionCommand().equals("Update")){
            //Book temp=(Book) this.parent.getSelectedBook();
            Vector<Book> modelBook = this.parent.getModelBook();
            Book temp=modelBook.get(this.parent.getSelectedIndexBook());
            if (temp.getBookID()!=null){
                Vector<Book> vtTemp=new Vector<>();
                for (Book book:modelBook){
                    if (temp.getBookID()!=book.getBookID()){
                        vtTemp.add(book);
                    }else{
                        vtTemp.add(new Book(txtBookID.getText(),
                    txtBookName.getText(), 
                    Integer.parseInt(txtQuantity.getText()), 
                    Integer.parseInt(txtPrice.getText())));
                    }
                }
                
                this.parent.modelBook=vtTemp;
                this.parent.listBook.setModel(new DefaultComboBoxModel(this.parent.modelBook));
            }
        }
    }
}
