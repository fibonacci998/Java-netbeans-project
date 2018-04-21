
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
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
public class BookManage extends JFrame{
    JLabel lbNameProgram, lbBookID, lbBookName,lbQuantity,lbPrice;
    JTextField txtBookID,txtBookName,txtQuantity,txtPrice;
    JList<Book> listBook;
    JButton btAdd,btUpdate,btDelete,btSave,btClear,btClose,btLoadData;
    Vector<Book> modelBook;
    public BookManage(String title){
        super(title);
        setLayout(new FlowLayout());
        
        modelBook=new Vector<>();
        listBook=new JList<Book>();
        
        getContentPane().add(btLoadData=new JButton("Load DB"));
        btLoadData.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                try {
//                    FileReader fr=new FileReader("Book.txt");
//                    BufferedReader br=new BufferedReader(fr);
//                    String current;
//                    while ((current=br.readLine())!=null){
//                        StringTokenizer st=new StringTokenizer(current," |");
//                        String xID=st.nextToken();
//                        String xName=st.nextToken();
//                        int xQuantity=Integer.parseInt(st.nextToken());
//                        int xPrice=Integer.parseInt(st.nextToken());
//                        modelBook.add(new Book(xID, xName, xQuantity, xPrice));
//                    }
//                    br.close();
//                    fr.close();
//                    listBook.setModel(new DefaultComboBoxModel(modelBook));
//                } catch (FileNotFoundException ex) {
//                    
//                } catch (IOException ex) {
//                    
//                }
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
        
        getContentPane().add(lbBookID=new JLabel("BookID"));
        getContentPane().add(txtBookID=new JTextField(10));
        getContentPane().add(lbBookName=new JLabel("BookName"));
        getContentPane().add(txtBookName=new JTextField(10));
        
        getContentPane().add(lbQuantity=new JLabel("Quantity"));
        getContentPane().add(txtQuantity=new JTextField(10));
        getContentPane().add(lbPrice=new JLabel("Price"));
        getContentPane().add(txtPrice=new JTextField(10));
        
        getContentPane().add(btSave=new JButton("Save"));
        btSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
//                try {
//                    FileWriter fw=new FileWriter("Book.txt");
//                    BufferedWriter bw=new BufferedWriter(fw);
//                    for (Book temp:modelBook){
//                        bw.write(temp.bookID+"|"+temp.bookName+
//                                "|"+temp.quantity+"|"+temp.price);
//                        bw.newLine();
//                    }
//                    bw.close();
//                    fw.close();
//                } catch (Exception e) {
//                }
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
        
        getContentPane().add(btClose=new JButton("Close"));
        btClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        });
        
        getContentPane().add(btAdd=new JButton("Add"));
        btAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                boolean flag=false;
                for (int i=0;i<modelBook.size();i++){
                    if (modelBook.get(i).bookID.compareToIgnoreCase(txtBookID.getText())==0){
                        flag=true;
                    }
                }
                if (!flag){
                    modelBook.add(new Book(txtBookID.getText(),
                        txtBookName.getText(), 
                        Integer.parseInt(txtQuantity.getText()), 
                        Integer.parseInt(txtPrice.getText())));
                    listBook.setModel(new DefaultComboBoxModel(modelBook));
                }
                else JOptionPane.showMessageDialog(new Frame(), "Your code BookID is exited");
            }
        });
        
        getContentPane().add(btUpdate=new JButton("Update"));
        btUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Book temp=(Book) listBook.getSelectedValue();
                if (temp.bookID!=null){
                    Vector<Book> vtTemp=new Vector<>();
                    for (Book book:modelBook){
                        if (temp.bookID!=book.bookID){
                            vtTemp.add(book);
                        }else{
                            vtTemp.add(new Book(txtBookID.getText(),
                        txtBookName.getText(), 
                        Integer.parseInt(txtQuantity.getText()), 
                        Integer.parseInt(txtPrice.getText())));
                        }
                    }
                    modelBook=vtTemp;
                    listBook.setModel(new DefaultComboBoxModel(modelBook));
                }
            }
        });
        
        getContentPane().add(btDelete=new JButton("Delete"));
        btDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Book temp=(Book) listBook.getSelectedValue();
                if (temp.bookID!=null){
                    Vector<Book> vtTemp=new Vector<>();
                    for (Book book:modelBook){
                        if (temp.bookID!=book.bookID){
                            vtTemp.add(book);
                        }
                    }
                    modelBook=vtTemp;
                    listBook.setModel(new DefaultComboBoxModel(modelBook));
                }
            }
        });
        
        getContentPane().add(listBook);
        
        listBook.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                  Book temp=(Book) listBook.getSelectedValue();
                  txtBookID.setText(temp.bookID);
                  txtBookName.setText(temp.bookName);
                  txtPrice.setText(temp.price+"");
                  txtQuantity.setText(temp.quantity+"");
            }
        });
        setSize(222,500);
        setVisible(true);
    }
    public static void main(String[] args) {
        BookManage myBookManage=new BookManage("Book manage");
        myBookManage.setVisible(true);
    }
}
