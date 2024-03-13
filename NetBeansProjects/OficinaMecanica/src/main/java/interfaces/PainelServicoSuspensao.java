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
public class PainelServicoSuspensao extends javax.swing.JPanel {

    
    public PainelServicoSuspensao() {
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
    
    public boolean isTroca_molas() {
        return troca_molasCheckBox.isSelected();
    }

    public void setTroca_molas(boolean troca_molas) {
        troca_molasCheckBox.setSelected(troca_molas);
    }

    public boolean isVazamento_fluido() {
        return vazamento_fluidoCheckBox.isSelected();
    }

    public void setVazamento_fluido(boolean vazamento_fluido) {
        vazamento_fluidoCheckBox.setSelected(vazamento_fluido);
    }
    
    public void limparCampos(){
        tipo_suspensaobuttonGroup.clearSelection();
        troca_molasCheckBox.setSelected(false);
        vazamento_fluidoCheckBox.setSelected(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipo_suspensaobuttonGroup = new javax.swing.ButtonGroup();
        produçãoPanel = new javax.swing.JPanel();
        produçãoLabel = new javax.swing.JLabel();
        independenteRadioButton = new javax.swing.JRadioButton();
        semi_independenteRadioButton = new javax.swing.JRadioButton();
        dependenteRadioButton = new javax.swing.JRadioButton();
        vazamento_fluidoCheckBox = new javax.swing.JCheckBox();
        troca_molasCheckBox = new javax.swing.JCheckBox();

        produçãoPanel.setPreferredSize(new java.awt.Dimension(113, 33));

        javax.swing.GroupLayout produçãoPanelLayout = new javax.swing.GroupLayout(produçãoPanel);
        produçãoPanel.setLayout(produçãoPanelLayout);
        produçãoPanelLayout.setHorizontalGroup(
            produçãoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 132, Short.MAX_VALUE)
        );
        produçãoPanelLayout.setVerticalGroup(
            produçãoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 33, Short.MAX_VALUE)
        );

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

        vazamento_fluidoCheckBox.setText("Vazamento de fluido");
        vazamento_fluidoCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vazamento_fluidoCheckBoxbalanceamentoCheckBox1ActionPerformed(evt);
            }
        });

        troca_molasCheckBox.setText("Troca de molas");
        troca_molasCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                troca_molasCheckBoxbalanceamentoCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(troca_molasCheckBox)
                            .addComponent(vazamento_fluidoCheckBox))
                        .addGap(111, 111, 111)
                        .addComponent(produçãoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(produçãoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(independenteRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(semi_independenteRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(dependenteRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(independenteRadioButton)
                    .addComponent(semi_independenteRadioButton)
                    .addComponent(dependenteRadioButton)
                    .addComponent(produçãoLabel))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(produçãoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(troca_molasCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vazamento_fluidoCheckBox)))
                .addGap(132, 132, 132))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void independenteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_independenteRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_independenteRadioButtonActionPerformed

    private void semi_independenteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semi_independenteRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_semi_independenteRadioButtonActionPerformed

    private void vazamento_fluidoCheckBoxbalanceamentoCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vazamento_fluidoCheckBoxbalanceamentoCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vazamento_fluidoCheckBoxbalanceamentoCheckBox1ActionPerformed

    private void troca_molasCheckBoxbalanceamentoCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_troca_molasCheckBoxbalanceamentoCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_troca_molasCheckBoxbalanceamentoCheckBox1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton dependenteRadioButton;
    private javax.swing.JRadioButton independenteRadioButton;
    private javax.swing.JLabel produçãoLabel;
    private javax.swing.JPanel produçãoPanel;
    private javax.swing.JRadioButton semi_independenteRadioButton;
    private javax.swing.ButtonGroup tipo_suspensaobuttonGroup;
    private javax.swing.JCheckBox troca_molasCheckBox;
    private javax.swing.JCheckBox vazamento_fluidoCheckBox;
    // End of variables declaration//GEN-END:variables
}
