/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p0001;

import java.awt.Canvas;

/**
 *
 * @author tuans
 */
public class P0001 extends javax.swing.JFrame {

    /**
     * Creates new form P0001
     */
    Graph graph;
    public P0001() {
        initComponents();
        analizeGraph();
    }
    void analizeGraph(){
        graph=new Graph();
        
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        btnVisualize = new javax.swing.JButton();
        pnGraph = new javax.swing.JPanel();
        txtLabelGraph = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newOptionInMenu = new javax.swing.JCheckBoxMenuItem();
        openOptionInMenu = new javax.swing.JCheckBoxMenuItem();
        saveOptionInMenu = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtInput.setColumns(20);
        txtInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtInput.setRows(5);
        txtInput.setText("TrafficLight{\n\t//vertices\n\tR [label=\"RED\",color=\"red\"]\n\tG [label=\"GREEN\",color=\"green\"]\n\tY [label=\"YELLOW\",color=\"yellow\"]\n\t\n\t//edges\n\tR->G [label=\"45\"]\n\tG->Y [label=\"65\"]\n\tY->R [label=\"5\"]\n}");
        jScrollPane1.setViewportView(txtInput);

        btnVisualize.setText("Visualize");
        btnVisualize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizeActionPerformed(evt);
            }
        });

        pnGraph.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnGraph.setMaximumSize(new java.awt.Dimension(300, 300));
        pnGraph.setMinimumSize(new java.awt.Dimension(300, 300));

        javax.swing.GroupLayout pnGraphLayout = new javax.swing.GroupLayout(pnGraph);
        pnGraph.setLayout(pnGraphLayout);
        pnGraphLayout.setHorizontalGroup(
            pnGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );
        pnGraphLayout.setVerticalGroup(
            pnGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 296, Short.MAX_VALUE)
        );

        txtLabelGraph.setText("Graph");

        btnSave.setText("Save graph as image");

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        newOptionInMenu.setSelected(true);
        newOptionInMenu.setText("New");
        newOptionInMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOptionInMenuActionPerformed(evt);
            }
        });
        jMenu1.add(newOptionInMenu);

        openOptionInMenu.setSelected(true);
        openOptionInMenu.setText("Open");
        jMenu1.add(openOptionInMenu);

        saveOptionInMenu.setSelected(true);
        saveOptionInMenu.setText("Save");
        jMenu1.add(saveOptionInMenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnVisualize, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(84, 84, 84)
                        .addComponent(btnClose))
                    .addComponent(pnGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLabelGraph))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnVisualize)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtLabelGraph)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addComponent(btnSave))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newOptionInMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOptionInMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newOptionInMenuActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnVisualizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizeActionPerformed
        // TODO add your handling code here
        pnGraph.removeAll();
        
        AnalizeGraphInput analize=new AnalizeGraphInput(txtInput.getText().toString());
        String name=analize.getNameGraph();
        txtLabelGraph.setText("Graph - "+name);
        analize.analize();
        graph=analize.createGraph();
        
        DrawGraph draw=new DrawGraph(graph);
        Canvas canvas=draw.getCanvas();
        pnGraph.add(canvas);
    }//GEN-LAST:event_btnVisualizeActionPerformed

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
            java.util.logging.Logger.getLogger(P0001.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(P0001.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(P0001.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(P0001.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new P0001().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnVisualize;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBoxMenuItem newOptionInMenu;
    private javax.swing.JCheckBoxMenuItem openOptionInMenu;
    private javax.swing.JPanel pnGraph;
    private javax.swing.JCheckBoxMenuItem saveOptionInMenu;
    private javax.swing.JTextArea txtInput;
    private javax.swing.JLabel txtLabelGraph;
    // End of variables declaration//GEN-END:variables
}
