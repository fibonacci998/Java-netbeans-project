/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package q2_ws1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author tuans
 */
public class TestProgress extends javax.swing.JFrame {

    /**
     * Creates new form TestProgress
     */
    Thread a = null;
    ActionListener action;
    Timer tmA,tmB,tmC,tmD,tmE,t;
    public TestProgress() {
        initComponents();
        //pgMon.setOrientation(SwingConstants.VERTICAL);
        pgMon.setOrientation(JProgressBar.VERTICAL);
        pgTue.setOrientation(JProgressBar.VERTICAL);
        pgWed.setOrientation(JProgressBar.VERTICAL);
        pgThu.setOrientation(JProgressBar.VERTICAL);
        pgFri.setOrientation(JProgressBar.VERTICAL);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTue = new javax.swing.JTextField();
        txtWed = new javax.swing.JTextField();
        txtThu = new javax.swing.JTextField();
        txtFri = new javax.swing.JTextField();
        txtMon = new javax.swing.JTextField();
        btnShow = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        pgMon = new javax.swing.JProgressBar();
        pgTue = new javax.swing.JProgressBar();
        pgWed = new javax.swing.JProgressBar();
        pgThu = new javax.swing.JProgressBar();
        pgFri = new javax.swing.JProgressBar();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Mon");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Trading Volumn in 1st week Sep 2008");

        jLabel3.setText("Tue");

        jLabel4.setText("Wed");

        jLabel5.setText("Thu");

        jLabel6.setText("Fri");

        btnShow.setText("Show");
        btnShow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        pgMon.setMaximum(2000);
        pgMon.setOrientation(JProgressBar.VERTICAL);

        pgTue.setMaximum(2000);
        pgTue.setOrientation(JProgressBar.VERTICAL);

        pgWed.setMaximum(2000);

        pgThu.setMaximum(2000);

        pgFri.setMaximum(2000);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(pgMon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(pgTue, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pgWed, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(pgThu, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(pgFri, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pgMon, javax.swing.GroupLayout.DEFAULT_SIZE, 323, Short.MAX_VALUE)
            .addComponent(pgTue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pgWed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pgThu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pgFri, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jLabel7.setText("Mon");

        jLabel8.setText("Tue");

        jLabel9.setText("Wed");

        jLabel10.setText("Thu");

        jLabel11.setText("Fri");

        jLabel12.setText("2000");

        jLabel13.setText("1000");

        jLabel14.setText("500");

        jLabel15.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel15))
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnShow)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtThu, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE)
                            .addComponent(txtFri)
                            .addComponent(txtWed)
                            .addComponent(txtTue)
                            .addComponent(txtMon))
                        .addGap(24, 24, 24))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jLabel7)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel8)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel9)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel10)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel11)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtWed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtThu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btnShow))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel12)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel13)
                        .addGap(56, 56, 56)
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel15))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void changeProgressByThread(JProgressBar pg,int value){         
        a = new Thread(){
            public void run(){
                for (int i=0;i<value;i++){
                    pg.setValue(i);
                    try {
                        sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(TestProgress.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        a.start();
    }
    void changeProgessMon(int value){
        if (tmA!=null) 
            tmA.stop();
       
        
        action=new ActionListener() {
            int i=0;
            @Override
            public void actionPerformed(ActionEvent e) {pgMon.setValue(i);
                i++;
                if (i==value) 
                    tmA.stop();
            }
        };
        tmA=new Timer(1, action);
        tmA.start();
    }
    void changeProgessTue(int value){
        if (tmB!=null) 
            tmB.stop();
       
        
        action=new ActionListener() {
            int i=0;
            @Override
            public void actionPerformed(ActionEvent e) {pgTue.setValue(i);
                i++;
                if (i==value) 
                    tmB.stop();
            }
        };
        tmB=new Timer(1, action);
        tmB.start();
    }
    void changeProgessWed(int value){
        if (tmC!=null) 
            tmC.stop();
       
        
        action=new ActionListener() {
            int i=0;
            @Override
            public void actionPerformed(ActionEvent e) {pgWed.setValue(i);
                i++;
                if (i==value) 
                    tmC.stop();
            }
        };
        tmC=new Timer(1, action);
        tmC.start();
    }
    void changeProgessThu(int value){
        if (tmD!=null) 
            tmD.stop();
       
        
        action=new ActionListener() {
            int i=0;
            @Override
            public void actionPerformed(ActionEvent e) {pgThu.setValue(i);
                i++;
                if (i==value) 
                    tmD.stop();
            }
        };
        tmD=new Timer(1, action);
        tmD.start();
    }
    void changeProgessFri(int value){
        if (tmE!=null) 
            tmE.stop();

        action=new ActionListener() {
            int i=0;
            @Override
            public void actionPerformed(ActionEvent e) {pgFri.setValue(i);
                i++;
                if (i==value) 
                    tmE.stop();
            }
        };
        tmE=new Timer(1, action);
        tmE.start();
    }
    void usingThread(){
        tmA=tmB=tmC=tmD=tmE=null;
        tmB=new Timer(1, null);
        tmC=new Timer(1, null);
        tmD=new Timer(1, null);
        tmE=new Timer(1, null);
        
        if (!txtMon.getText().toString().equals(""))
            changeProgressByThread(pgMon, Integer.parseInt(txtMon.getText().toString()));
        
        if (!txtTue.getText().toString().equals(""))
            changeProgressByThread(pgTue, Integer.parseInt(txtTue.getText().toString()));
            
        if (!txtWed.getText().toString().equals(""))
            changeProgressByThread(pgWed, Integer.parseInt(txtWed.getText().toString()));
            
        if (!txtThu.getText().toString().equals(""))
            changeProgressByThread(pgThu, Integer.parseInt(txtThu.getText().toString()));
            
        if (!txtFri.getText().toString().equals(""))
            changeProgressByThread(pgFri, Integer.parseInt(txtFri.getText().toString()));
            
    }
    void usingTimer(){
        tmA=tmB=tmC=tmD=tmE=null;
        tmB=new Timer(1, null);
        tmC=new Timer(1, null);
        tmD=new Timer(1, null);
        tmE=new Timer(1, null);
        
        if (!txtMon.getText().toString().equals(""))
            changeProgessMon(Integer.parseInt(txtMon.getText().toString()));
        
        if (!txtTue.getText().toString().equals(""))
            changeProgessTue(Integer.parseInt(txtTue.getText().toString()));
            
        if (!txtWed.getText().toString().equals(""))
            changeProgessWed(Integer.parseInt(txtWed.getText().toString()));
            
        if (!txtThu.getText().toString().equals(""))
            changeProgessThu(Integer.parseInt(txtThu.getText().toString()));
            
        if (!txtFri.getText().toString().equals(""))
            changeProgessFri(Integer.parseInt(txtFri.getText().toString()));
            
    }
    private void btnShowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowActionPerformed
        // TODO add your handling code here:
        //usingThread();
        usingTimer();
    }//GEN-LAST:event_btnShowActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TestProgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestProgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestProgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestProgress.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestProgress().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnShow;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar pgFri;
    private javax.swing.JProgressBar pgMon;
    private javax.swing.JProgressBar pgThu;
    private javax.swing.JProgressBar pgTue;
    private javax.swing.JProgressBar pgWed;
    private javax.swing.JTextField txtFri;
    private javax.swing.JTextField txtMon;
    private javax.swing.JTextField txtThu;
    private javax.swing.JTextField txtTue;
    private javax.swing.JTextField txtWed;
    // End of variables declaration//GEN-END:variables
}
