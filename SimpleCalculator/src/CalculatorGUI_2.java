/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author tuans
 */
public class CalculatorGUI_2 extends JFrame implements ActionListener{
    JLabel lbNum1,lbNum2,lbResult;
    JTextField txtNum1,txtNum2, txtResult;
    JRadioButton btAdd,btSub,btMul,btDiv;
    JButton btSolve;
    public CalculatorGUI_2(String title){
        super(title);
        //txtResult.setEditable(false);
        setLayout(new FlowLayout());
        getContentPane().add(lbNum1=new JLabel("Num 1"));
        getContentPane().add(txtNum1=new JTextField(30));
        getContentPane().add(lbNum2=new JLabel("Num 2"));
        getContentPane().add(txtNum2=new JTextField(30));
        getContentPane().add(lbResult=new JLabel("Result"));
        getContentPane().add(txtResult=new JTextField(30));
        getContentPane().add(btAdd=new JRadioButton("Add"));
        getContentPane().add(btSub=new JRadioButton("Sub"));
        getContentPane().add(btMul=new JRadioButton("Mul"));
        getContentPane().add(btDiv=new JRadioButton("Div"));
        ButtonGroup bt=new ButtonGroup();
        bt.add(btAdd);bt.add(btSub);bt.add(btMul);bt.add(btDiv);
        btAdd.addActionListener(this);
        btMul.addActionListener(this);
        btDiv.addActionListener(this);
        btSub.addActionListener(this);
        //btSolve.addActionListener(this);
        setSize(400,200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("Add")){
            
            double ans=Double.parseDouble(txtNum1.getText())+Double.parseDouble(txtNum2.getText());
            
            txtResult.setText(ans+" ");
        }
        if (ae.getActionCommand().equals("Sub")){
            double ans=Double.parseDouble(txtNum1.getText())-Double.parseDouble(txtNum2.getText());
            
            txtResult.setText(ans+" ");
        }
        if (ae.getActionCommand().equals("Mul")){
            double ans=Double.parseDouble(txtNum1.getText())*Double.parseDouble(txtNum2.getText());
            
            txtResult.setText(ans+" ");
        }
        if (ae.getActionCommand().equals("Div")){
            double ans=Double.parseDouble(txtNum1.getText())/Double.parseDouble(txtNum2.getText());
            
            txtResult.setText(ans+" ");
        }
    }
    public static void main(String[] args) {
        CalculatorGUI_2 calculator=new CalculatorGUI_2("Calculator_2");
        calculator.setVisible(true);
    }
}
