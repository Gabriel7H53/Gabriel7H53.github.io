/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import entidade.Pneus.marca_pneus;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Gahen
 */
public class PainelFiltrosServicoPneus extends javax.swing.JPanel {

    public PainelFiltrosServicoPneus() {
        initComponents();
        limparCampos();   
    }
    
     public marca_pneus getSelectedmarcaPneus(){
        Object marcaPneus = pneus_cadastradosComboBox.getSelectedItem();
        if(marcaPneus != null) return (marca_pneus)marcaPneus;
        else return null;
    }
    public void setSelectedmarcaPneus(marca_pneus marcaPneus){
        pneus_cadastradosComboBox.setSelectedItem(marcaPneus);
    }
    
    public void limparCampos(){
        pneus_cadastradosComboBox.setSelectedIndex(-1);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        marca_pneusLabel = new javax.swing.JLabel();
        pneus_cadastradosComboBox = new javax.swing.JComboBox();

        setPreferredSize(new java.awt.Dimension(386, 102));

        marca_pneusLabel.setText("Marca Novos Pneus:");

        pneus_cadastradosComboBox.setModel(new DefaultComboBoxModel (marca_pneus.values()));
        pneus_cadastradosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pneus_cadastradosComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(marca_pneusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pneus_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(marca_pneusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pneus_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pneus_cadastradosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pneus_cadastradosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pneus_cadastradosComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel marca_pneusLabel;
    private javax.swing.JComboBox pneus_cadastradosComboBox;
    // End of variables declaration//GEN-END:variables
}
