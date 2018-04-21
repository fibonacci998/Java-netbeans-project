
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    JList<Book> listBook;
    JButton btUpdate,btDelete,btSave,btClose,btLoadData,btdd;
    Vector<Book> modelBook;
    public BookManage(String title){
        super(title);
        setLayout(new FlowLayout());
        
        modelBook=new Vector<Book>();
        listBook=new JList<Book>();
        
        getContentPane().add(btLoadData=new JButton("Load DB"));
        btLoadData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    FileInputStream fos=new FileInputStream("booklist.txt");
                    ObjectInputStream ois=new ObjectInputStream(fos);
                    modelBook=(Vector<Book>) ois.readObject();
                    listBook.setModel(new DefaultComboBoxModel(modelBook));
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
                    oos.writeObject(modelBook);
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
  
        getContentPane().add(btDelete=new JButton("Delete"));
        btDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Book temp=(Book) listBook.getSelectedValue();
                if (temp.getBookID()!=null){
                    Vector<Book> vtTemp=new Vector<>();
                    for (Book book:modelBook){
                        if (temp.getBookID()!=book.getBookID()){
                            vtTemp.add(book);
                        }
                    }
                    modelBook=vtTemp;
                    listBook.setModel(new DefaultComboBoxModel(modelBook));
                }
            }
        });
        
        getContentPane().add(btdd=new JButton("DD"));
        btdd.addActionListener(this);
        
        getContentPane().add(listBook);
        
        listBook.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                  Book temp=(Book) listBook.getSelectedValue();      
            }
        });
        
        getContentPane().add(btUpdate=new JButton("Update"));
        btUpdate.addActionListener(this);

        setSize(222,500);
        setVisible(true);
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
        return listBook.getSelectedIndex();
    }
    
    public Book getSelectedBook(){
        return (Book) listBook.getSelectedValue();
    }
    
    public Vector getModelBook(){
        return modelBook;
    }
    
    public void addBookInfor(Book book){
        modelBook.add(book);
        listBook.setModel(new DefaultComboBoxModel(modelBook));
        
    }
}
