/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;
import entidade.Suspensao.tipo_suspensao;
/**
 *
 * @author Gahen
 */
public class PainelFiltrosServicoSuspensao extends javax.swing.JPanel {

    
    public PainelFiltrosServicoSuspensao() {
        initComponents();
        limparCampos();
    }
    
    public tipo_suspensao getSelectedtipo_suspensao(){
        tipo_suspensao tipoSuspensao = null;
        if (tipo_suspensaobuttonGroup.getSelection() != null)
            tipoSuspensao = tipo_suspensao.values()[tipo_suspensaobuttonGroup.getSelection().getMnemonic()];
        return tipoSuspensao;
    }
    
    public void setSelectedtipo_suspensao(int indice_suspensao){
        switch(indice_suspensao){
            case 0: dependenteRadioButton.setSelected(true);break;
            case 1: semi_independenteRadioButton.setSelected(true);break;
            case 2: independenteRadioButton.setSelected(true);
        }
    }
    

    public void limparCampos(){
        tipo_suspensaobuttonGroup.clearSelection();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_suspensaobuttonGroup = new javax.swing.ButtonGroup();
        produçãoLabel = new javax.swing.JLabel();
        independenteRadioButton = new javax.swing.JRadioButton();
        semi_independenteRadioButton = new javax.swing.JRadioButton();
        dependenteRadioButton = new javax.swing.JRadioButton();

        produçãoLabel.setText("Tipo de suspensão: ");

        tipo_suspensaobuttonGroup.add(independenteRadioButton);
        independenteRadioButton.setMnemonic('\u0002');
        independenteRadioButton.setText("Independente");
        independenteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                independenteRadioButtonActionPerformed(evt);
            }
        });

        tipo_suspensaobuttonGroup.add(semi_independenteRadioButton);
        semi_independenteRadioButton.setMnemonic('\u0001');
        semi_independenteRadioButton.setText("Semi-dependente");
        semi_independenteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semi_independenteRadioButtonActionPerformed(evt);
            }
        });

        tipo_suspensaobuttonGroup.add(dependenteRadioButton);
        dependenteRadioButton.setText("Dependente");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(produçãoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(independenteRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(semi_independenteRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dependenteRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(independenteRadioButton)
                    .addComponent(semi_independenteRadioButton)
                    .addComponent(dependenteRadioButton)
                    .addComponent(produçãoLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void independenteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_independenteRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_independenteRadioButtonActionPerformed

    private void semi_independenteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semi_independenteRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semi_independenteRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton dependenteRadioButton;
    private javax.swing.JRadioButton independenteRadioButton;
    private javax.swing.JLabel produçãoLabel;
    private javax.swing.JRadioButton semi_independenteRadioButton;
    private javax.swing.ButtonGroup tipo_suspensaobuttonGroup;
    // End of variables declaration//GEN-END:variables
}
