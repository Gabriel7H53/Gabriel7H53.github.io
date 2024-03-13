/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;

/**
 *
 * @author Gahen
 */
public class PainelFiltrosServicoMotor extends javax.swing.JPanel {

    /**
     * Creates new form PainelServicoReparoMotor
     */
    public PainelFiltrosServicoMotor() {
        initComponents();
        limparCampos();
    }
        public char getAjuste(){
        char ajuste = 'X';
        if(ajuste_valvulasbuttonGroup.getSelection() != null){
            switch(ajuste_valvulasbuttonGroup.getSelection().getMnemonic()){
                case 0: ajuste = 'T';break;
                case 1: ajuste = 'F';
            }
        }
        return ajuste;
    }
        
    public void limparCampos() {
      ajuste_valvulasbuttonGroup.clearSelection();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ajuste_valvulasbuttonGroup = new javax.swing.ButtonGroup();
        grupoPanel = new javax.swing.JPanel();
        simRadioButton = new javax.swing.JRadioButton();
        nãoRadioButton = new javax.swing.JRadioButton();

        grupoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ajuste de Valvulas"));

        ajuste_valvulasbuttonGroup.add(simRadioButton);
        simRadioButton.setText("Sim");
        simRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simRadioButtonActionPerformed(evt);
            }
        });
        grupoPanel.add(simRadioButton);

        ajuste_valvulasbuttonGroup.add(nãoRadioButton);
        nãoRadioButton.setMnemonic('\u0001');
        nãoRadioButton.setText("Não");
        nãoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nãoRadioButtonActionPerformed(evt);
            }
        });
        grupoPanel.add(nãoRadioButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(grupoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(grupoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nãoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nãoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nãoRadioButtonActionPerformed

    private void simRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_simRadioButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ajuste_valvulasbuttonGroup;
    private javax.swing.JPanel grupoPanel;
    private javax.swing.JRadioButton nãoRadioButton;
    private javax.swing.JRadioButton simRadioButton;
    // End of variables declaration//GEN-END:variables
}
