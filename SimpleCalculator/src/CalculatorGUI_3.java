
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author tuans
 */
public class CalculatorGUI_3 extends JFrame{
    JLabel lbNum1,lbNum2,lbResult;
    JTextField txtNum1,txtNum2, txtResult;
    JRadioButton btAdd,btSub,btMul,btDiv;
    JComboBox<String> cbTest=new JComboBox<>(new String[]{"Add","Sub","Mul","Div"});
    public CalculatorGUI_3(String title){
        super(title);
        //txtResult.setEditable(false);
        setLayout(new FlowLayout());
        getContentPane().add(lbNum1=new JLabel("Num 1"));
        getContentPane().add(txtNum1=new JTextField(30));
        getContentPane().add(lbNum2=new JLabel("Num 2"));
        getContentPane().add(txtNum2=new JTextField(30));
        getContentPane().add(lbResult=new JLabel("Result"));
        getContentPane().add(txtResult=new JTextField(30));
        txtResult.setEditable(false);
//        getContentPane().add(btAdd=new JRadioButton("Add"));
//        getContentPane().add(btSub=new JRadioButton("Sub"));
//        getContentPane().add(btMul=new JRadioButton("Mul"));
//        getContentPane().add(btDiv=new JRadioButton("Div"));
        getContentPane().add(cbTest);
        cbTest.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                if ( ie.getStateChange() == ItemEvent.SELECTED && 
                        "Add".equals( ie.getItem() ) ){
                      double ans=Double.parseDouble(txtNum1.getText())+Double.parseDouble(txtNum2.getText());
            
                         txtResult.setText(ans+" ");
                }
                if ( ie.getStateChange() == ItemEvent.SELECTED && 
                        "Sub".equals( ie.getItem() ) ){
                      double ans=Double.parseDouble(txtNum1.getText())-Double.parseDouble(txtNum2.getText());
            
                         txtResult.setText(ans+" ");
                }
                if ( ie.getStateChange() == ItemEvent.SELECTED && 
                        "Mul".equals( ie.getItem() ) ){
                      double ans=Double.parseDouble(txtNum1.getText())*Double.parseDouble(txtNum2.getText());
            
                         txtResult.setText(ans+" ");
                }
                if ( ie.getStateChange() == ItemEvent.SELECTED && 
                        "Div".equals( ie.getItem() ) ){
                      double ans=Double.parseDouble(txtNum1.getText())/Double.parseDouble(txtNum2.getText());
            
                         txtResult.setText(ans+" ");
                }
            
            }
        });
//        ButtonGroup bt=new ButtonGroup();
//        bt.add(btAdd);bt.add(btSub);bt.add(btMul);bt.add(btDiv);
//        btAdd.addActionListener(this);
//        btMul.addActionListener(this);
//        btDiv.addActionListener(this);
//        btSub.addActionListener(this);
        //btSolve.addActionListener(this);
        setSize(400,200);
        setVisible(true);
    }

    public static void main(String[] args) {
        CalculatorGUI_3 calculator=new CalculatorGUI_3("Calculator_3");
        calculator.setVisible(true);
    }
}
