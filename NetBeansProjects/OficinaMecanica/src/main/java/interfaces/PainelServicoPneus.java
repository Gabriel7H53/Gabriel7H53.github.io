/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

import entidade.Pneus;
import entidade.Pneus.marca_pneus;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Gahen
 */
public class PainelServicoPneus extends javax.swing.JPanel {

    public PainelServicoPneus() {
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
    
    public int getQtdPneus(){
        String num_pneus_str = qtd_pneusTextField.getText();
        if(!num_pneus_str.isEmpty()) return Integer.parseInt(num_pneus_str);
        else return -1;
    }
    public void setQtdPneus(int num_fotos){
        qtd_pneusTextField.setText(num_fotos + "");
    }
      
    public boolean isBalanceamento() {
        return balanceamentoCheckBox.isSelected();
    }

    public void setBalanceamento(boolean balanceamento) {
        balanceamentoCheckBox.setSelected(balanceamento);
    }

    public boolean isAlinhamento() {
        return alinhamentoCheckBox.isSelected();
    }

    public void setAlinhamento(boolean alinhamento) {
        alinhamentoCheckBox.setSelected(alinhamento);
    }
    
    
    public void limparCampos(){
        balanceamentoCheckBox.setSelected(false);
        alinhamentoCheckBox.setSelected(false);
        pneus_cadastradosComboBox.setSelectedIndex(-1);
        qtd_pneusTextField.setText("");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        marca_pneusLabel = new javax.swing.JLabel();
        alinhamentoCheckBox = new javax.swing.JCheckBox();
        balanceamentoCheckBox = new javax.swing.JCheckBox();
        pneus_cadastradosComboBox = new javax.swing.JComboBox();
        quantidadeLabel = new javax.swing.JLabel();
        qtd_pneusTextField = new javax.swing.JTextField();

        marca_pneusLabel.setText("Marca Novos Pneus:");

        alinhamentoCheckBox.setText("Alinhamento");
        alinhamentoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alinhamentoCheckBoxActionPerformed(evt);
            }
        });

        balanceamentoCheckBox.setText("Balanceamento");
        balanceamentoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                balanceamentoCheckBox1ActionPerformed(evt);
            }
        });

        pneus_cadastradosComboBox.setModel(new DefaultComboBoxModel (marca_pneus.values()));

        quantidadeLabel.setText("Quantidade");

        qtd_pneusTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(quantidadeLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(qtd_pneusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(alinhamentoCheckBox)
                    .addComponent(balanceamentoCheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(marca_pneusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pneus_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(marca_pneusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pneus_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantidadeLabel)
                    .addComponent(qtd_pneusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addComponent(balanceamentoCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alinhamentoCheckBox)
                .addContainerGap(123, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void alinhamentoCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alinhamentoCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alinhamentoCheckBoxActionPerformed

    private void balanceamentoCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_balanceamentoCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_balanceamentoCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox alinhamentoCheckBox;
    private javax.swing.JCheckBox balanceamentoCheckBox;
    private javax.swing.JLabel marca_pneusLabel;
    private javax.swing.JComboBox pneus_cadastradosComboBox;
    private javax.swing.JTextField qtd_pneusTextField;
    private javax.swing.JLabel quantidadeLabel;
    // End of variables declaration//GEN-END:variables
}
