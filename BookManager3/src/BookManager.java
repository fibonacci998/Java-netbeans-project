
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class BookManager extends JFrame implements ActionListener{
    JLabel lb;
    JTextField txtSearch;
    JButton bt;
    JTable tbBook;
    Vector col=new Vector(),data = new Vector();
    public BookManager(){
        super("Book manager");
        setLayout(new FlowLayout());
        getContentPane().add(bt=new JButton("Load Data"));
        bt.setActionCommand("Load");
        bt.addActionListener(this);
        getContentPane().add(lb=new JLabel("Search book"));
        getContentPane().add(txtSearch=new JTextField(50));
        getContentPane().add(bt=new JButton("Search"));
        bt.addActionListener(this);
        //getContentPane().add(tbBook=new JTable());
        tbBook=new JTable();
        JScrollPane jsc=new JScrollPane(tbBook);
        getContentPane().add(jsc);
        
        getContentPane().add(bt=new JButton("getData"));
        bt.addActionListener(this);
        
        getContentPane().add(bt=new JButton("Close"));
        bt.addActionListener(this);
        
        pack();
    }

    public void updateTable(Vector col, Vector data){
        tbBook.setModel(new DefaultTableModel(data, col));
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Close")){
            System.exit(0);
        }
        if (ae.getActionCommand().equals("Load")){
            String fileName;
            col.add("Book ID");col.add("Book Name");col.add("Quantity");col.add("Price");
            fileName=JOptionPane.showInputDialog("Input file name");
            try {
                    FileInputStream fos=new FileInputStream("booklist.txt");
                    ObjectInputStream ois=new ObjectInputStream(fos);
                    Vector<Book> vector=(Vector) ois.readObject();
                    
                    Iterator<Book> it=vector.iterator();
                    while (it.hasNext()){
                        Book book=it.next();
                        Vector temp=new Vector();
                        temp.add(book.getBookID());
                        temp.add(book.getBookName());
                        temp.add(book.getQuantity());
                        temp.add(book.getPrice());
                        data.add(temp);
                    }
                    updateTable(col, data);
                    ois.close();
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
        if (ae.getActionCommand().equals("getData")){
            int n=tbBook.getSelectedRow();
            if (n<0){
                JOptionPane.showMessageDialog(this, "Select one row");
            }
            String id=tbBook.getValueAt(n, 0).toString();
            int quantity=Integer.parseInt(tbBook.getValueAt(n, 2).toString());
            JOptionPane.showMessageDialog(this, id+" "+quantity);
            
        }
    }
    public static void main(String[] args) {
        BookManager frame = new BookManager();
        frame.setVisible(true);
    }
}
