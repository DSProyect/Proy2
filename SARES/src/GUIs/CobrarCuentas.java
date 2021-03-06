/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIs;

import TDAs.DB.Consult;
import TDAs.DB.IngresosDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Carmina
 */
public class CobrarCuentas extends javax.swing.JFrame {

    /**
     * Creates new form CobrarCuentas
     */
    public CobrarCuentas() {
        initComponents();
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
        txtCuenta = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtCedula = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        btnCobrar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtDescuento = new javax.swing.JTextField();
        btnTotal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("IdCuenta:");

        txtCuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCuentaActionPerformed(evt);
            }
        });

        jLabel2.setText("Descuento:");

        jLabel3.setText("Cedula:");

        txtCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCedulaActionPerformed(evt);
            }
        });

        jLabel4.setText("TipoDePago:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });

        btnCobrar.setText("Cobrar");
        btnCobrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCobrarActionPerformed(evt);
            }
        });

        jLabel5.setText("TOTAL:");

        txtTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTotalActionPerformed(evt);
            }
        });

        btnTotal.setText("ObtenerTotal");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCuenta, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                            .addComponent(txtCedula)
                            .addComponent(cmbTipo, 0, 237, Short.MAX_VALUE)
                            .addComponent(txtTotal)
                            .addComponent(txtDescuento)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnCobrar, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(btnTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCuenta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescuento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCobrar)
                    .addComponent(btnTotal))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCobrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCobrarActionPerformed
        if(txtCuenta.getText().equals("") || txtCedula.getText().equals("") || txtDescuento.getText().equals("") || txtTotal.getText().equals(""))
            JOptionPane.showMessageDialog(null,"LLENE LOS CAMPOS");
        else{
            if(Integer.parseInt(txtDescuento.getText())>=0 && Integer.parseInt(txtDescuento.getText())<=10 ){
                if(Consult.getInstancia().cuentaDisponible(txtCuenta.getText())){
                    if(Consult.getInstancia().existeCliente(txtCedula.getText())){
                        IngresosDB.getInstancia().aggCuenta(txtCuenta.getText(), txtCedula.getText(), Integer.parseInt(txtDescuento.getText()), Double.parseDouble(txtTotal.getText()),cmbTipo.getSelectedItem().toString());
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Ingrese Usuario Nuevo");
                        new InformacionCliente().setVisible(true);
                    }                       
                }    
                else
                    JOptionPane.showMessageDialog(null, "Cuenta pagada o no existe");
                
            }
            else
                JOptionPane.showMessageDialog(null, "No puede pasar de 10%");
        }
    }//GEN-LAST:event_btnCobrarActionPerformed

    private void txtCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCedulaActionPerformed

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        
        ResultSet rs = Consult.getInstancia().ObtenerTipoPago();
        cmbTipo.removeAllItems();
        try{
            cmbTipo.addItem(rs.getString(1));
            while(rs.next()){
                cmbTipo.addItem(rs.getString(1));
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        if(txtCuenta.getText().length()>0 && Consult.getInstancia().existeCuenta(txtCuenta.getText())){
            ResultSet rs = Consult.getInstancia().totalCuenta(txtCuenta.getText());
            try {
                    txtTotal.setText(Double.toString(rs.getDouble(1)));
                
            } catch (SQLException ex) {
                Logger.getLogger(CobrarCuentas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnTotalActionPerformed

    private void txtTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTotalActionPerformed

    private void txtCuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCuentaActionPerformed

    }//GEN-LAST:event_txtCuentaActionPerformed

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
            java.util.logging.Logger.getLogger(CobrarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CobrarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CobrarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CobrarCuentas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CobrarCuentas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCobrar;
    private javax.swing.JButton btnTotal;
    private javax.swing.JComboBox<String> cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txtCedula;
    private javax.swing.JTextField txtCuenta;
    private javax.swing.JTextField txtDescuento;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
