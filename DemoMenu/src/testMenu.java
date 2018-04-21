
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class testMenu extends JFrame implements ActionListener{

    JMenuBar mBar;
    JMenu menu,subMenu;
    JMenuItem mItem;
    public testMenu(){
        super();
        setLayout(new FlowLayout());
        setJMenuBar(mBar=new JMenuBar());
        //add item
        mBar.add(menu=new JMenu("File"));
        menu.add(mItem=new JMenuItem("Open"));
        mItem.addActionListener(this);
        menu.add(mItem=new JMenuItem("Save"));
        mItem.addActionListener(this);
        menu.add(subMenu=new JMenu("List"));
        subMenu.add(mItem=new JMenuItem("Print"));
        mItem.addActionListener(this);
        menu.add(mItem=new JMenuItem("Exit"));
        mItem.addActionListener(this);
        
        mBar.add(menu=new JMenu("Edit"));
        setSize(500,200);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Exit")){
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new testMenu();
    }
}
