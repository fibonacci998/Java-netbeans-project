
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.basic.BasicButtonListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class MyGUI extends JFrame implements ActionListener{
    JLabel lbName,lbUserName,lbPassword,lbSex,lbTime,lbInfo;
    JTextField txtName,txtUserName;
    JPasswordField txtPassword;
    JRadioButton rbMale,rbFemale;
    JCheckBox ckMorning,ckAfternoon;
    JTextArea taInfor;
    JButton btOk,btCancel,btExit;
    ButtonGroup bt=new ButtonGroup();
    public MyGUI(String title){
        super(title);
        setLayout(new FlowLayout());//default: border layout
        getContentPane().add(lbName = new JLabel("<html><body><h1 style='color:red'>Fullname: </h1></body></html>"));
        getContentPane().add(txtName=new JTextField(20));
        getContentPane().add(lbUserName = new JLabel("UserName: "));
        getContentPane().add(txtUserName=new JTextField(80));
        getContentPane().add(lbPassword=new JLabel("Password: "));
        getContentPane().add(txtPassword=new JPasswordField(30));
        getContentPane().add(lbSex=new JLabel("Sex: "));
        getContentPane().add(rbMale=new JRadioButton("Male"));
        getContentPane().add(rbFemale=new JRadioButton("Female"));
        bt.add(rbMale);
        bt.add(rbFemale);
        getContentPane().add(lbTime=new JLabel("Time"));
        getContentPane().add(ckMorning=new JCheckBox("Morning"));
        getContentPane().add(ckAfternoon=new JCheckBox("Afternoon"));
        getContentPane().add(lbInfo=new JLabel("Infor: "));
        getContentPane().add(taInfor=new JTextArea(10, 30));
        getContentPane().add(btOk=new JButton("OK"));
        getContentPane().add(btCancel=new JButton("Cancel"));
        getContentPane().add(btExit=new JButton("Exit"));
        btOk.addActionListener(this);//this: nghe tren chinh class
        btCancel.addActionListener(this);
        btExit.addActionListener(this);
        btExit.setActionCommand("Cancel");
        //setSize(n,m): manual
        
        //pack(): auto
        pack();
        //display
        setVisible(true);
    }
    public static void main(String[] args) {
        MyGUI frame=new MyGUI("Demo");
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object btac=(Object) btOk;
        //object
        if (ae.getSource()==btac){
            String name=txtUserName.getText();
            char[] pass=txtPassword.getPassword();
            String stPass=new String(pass);
            taInfor.setText(name+"\n"+stPass+"\n"+bt.getSelection().toString());
        }
        //acction command
        if (ae.getActionCommand().equals("Cancel")){
            txtName.setText("");
        }
    }
    
}
