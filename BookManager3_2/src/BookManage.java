
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

public class BookManage extends JFrame implements ActionListener{
    
    JLabel lbNameProgram;
    JButton btUpdate,btDelete,btSave,btClose,btLoadData,btdd;
    JTable tbBook;
    Vector col=new Vector(),data = new Vector();
    public BookManage(String title){
        super(title);
        setLayout(new FlowLayout());
        
        col.add("Book ID");col.add("Book Name");col.add("Quantity");col.add("Price");
        
        getContentPane().add(btLoadData=new JButton("Load DB"));
        btLoadData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    FileInputStream fos=new FileInputStream("booklist.txt");
                    ObjectInputStream ois=new ObjectInputStream(fos);
                    Vector vector=(Vector) ois.readObject();
                    
                    data=vector;
                    
                    updateTable(col, data);
                    ois.close();
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
            }
        });
        getContentPane().add(lbNameProgram=new JLabel("Book manager"));
        

        getContentPane().add(btSave=new JButton("Save"));
        btSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    FileOutputStream fos= new FileOutputStream("booklist.txt");
                    ObjectOutputStream oos=new ObjectOutputStream(fos);
                    oos.writeObject(data);
                    oos.close();
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        getContentPane().add(btClose=new JButton("Close"));
        btClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
  
//        getContentPane().add(btDelete=new JButton("Delete"));
//        btDelete.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent ae) {
//                Book temp=(Book) listBook.getSelectedValue();
//                if (temp.getBookID()!=null){
//                    Vector<Book> vtTemp=new Vector<>();
//                    for (Book book:modelBook){
//                        if (temp.getBookID()!=book.getBookID()){
//                            vtTemp.add(book);
//                        }
//                    }
//                    modelBook=vtTemp;
//                    listBook.setModel(new DefaultComboBoxModel(modelBook));
//                }
//            }
//        });
        
        getContentPane().add(btdd=new JButton("DD"));
        btdd.addActionListener(this);
        
        tbBook=new JTable();
        JScrollPane jsc=new JScrollPane(tbBook);
        getContentPane().add(jsc);
        
        getContentPane().add(btUpdate=new JButton("Update"));
        btUpdate.addActionListener(this);

        
        setSize(600,500);
        setVisible(true);
    }
    
    public void updateTable(Vector col, Vector data){
        col=this.col;
        tbBook.setModel(new DefaultTableModel(data, col));
    }
    
    public static void main(String[] args) {
        BookManage myBookManage=new BookManage("Book manage");
        myBookManage.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("DD")){
            new BookManageChildDialog(this, true);
        }
        if (ae.getActionCommand().equals("Update")){
            new BookUpdateDialog(this, true);
        }
    }
    
    public int getSelectedIndexBook(){
        //return listBook.getSelectedIndex();
        return tbBook.getSelectedRow();
    }
    
    public Book getSelectedBook(){
        //return (Book) listBook.getSelectedValue();
        Vector temp=(Vector) data.get(tbBook.getSelectedRow());
        String BookId=(String) temp.get(0);
        String BookName=(String) temp.get(1);
        int quantity=(int)temp.get(2);
        int price=(int)temp.get(3);
        Book book=new Book(BookId, BookName, quantity, price);
        return book;
    }
    
    public Vector getData(){
        return data;
    }
    
    public void addBookInfor(Book book){
        Vector temp=new Vector();
        temp.add(book.getBookID());
        temp.add(book.getBookName());
        temp.add(book.getQuantity());
        temp.add(book.getPrice());
        data.add(temp);
        updateTable(col, data);
    }
}
