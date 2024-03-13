/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package interfaces;
import entidade.Motor.componente_reparado;
import javax.swing.DefaultComboBoxModel;
/**
 *
 * @author Gahen
 */
public class PainelServicoMotor extends javax.swing.JPanel {

    /**
     * Creates new form PainelServicoReparoMotor
     */
    public PainelServicoMotor() {
        initComponents();
        limparCampos();
    }
    
        public componente_reparado getSelectedcomponente_reparado(){
        Object componenteReparado =  componente_reparadoComboBox.getSelectedItem();
        if(componenteReparado != null) return (componente_reparado)componenteReparado;
        else return null;
    }
    public void setSelectedcomponente_reparado(componente_reparado componenteReparado){
        componente_reparadoComboBox.setSelectedItem(componenteReparado);
    }
    
     public boolean isRestauracao_motor() {
        return restauracao_motorCheckBox.isSelected();
    }

    public void setRestauracao_motor(boolean restauracao_motor) {
        restauracao_motorCheckBox.setSelected(restauracao_motor);
    }

    public boolean isAjuste_valvulas() {
        return ajuste_valvulasCheckBox.isSelected();
    }

    public void setAjuste_valvulas(boolean ajuste_valvulas) {
        ajuste_valvulasCheckBox.setSelected(ajuste_valvulas);
    }
    
    public String getRelatorio_tecnico() {
        String relatorio_tecnico = relatorio_tecnicoTextField.getText();
        if(relatorio_tecnico.isEmpty()){
            return null;
        }else{
             return relatorio_tecnico;
        }
    }

    public void setRelatorio_tecnico(String relatorio_tecnico) {
        relatorio_tecnicoTextField.setText(relatorio_tecnico);
    }
    public void limparCampos(){
        componente_reparadoComboBox.setSelectedIndex(-1);
        restauracao_motorCheckBox.setSelected(false);
        ajuste_valvulasCheckBox.setSelected(false);
        relatorio_tecnicoTextField.setText("");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        componente_reparadoLabel = new javax.swing.JLabel();
        componente_reparadoComboBox = new javax.swing.JComboBox();
        restauracao_motorCheckBox = new javax.swing.JCheckBox();
        ajuste_valvulasCheckBox = new javax.swing.JCheckBox();
        relatorio_tecnicoLabel = new javax.swing.JLabel();
        relatorio_tecnicoTextField = new javax.swing.JTextField();

        componente_reparadoLabel.setText("Componente Reparado:");

        componente_reparadoComboBox.setModel(new DefaultComboBoxModel (componente_reparado.values()));
        componente_reparadoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                componente_reparadoComboBoxActionPerformed(evt);
            }
        });

        restauracao_motorCheckBox.setText("Restauração de motor");
        restauracao_motorCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restauracao_motorCheckBox1ActionPerformed(evt);
            }
        });

        ajuste_valvulasCheckBox.setText("Ajuste de válvulas");
        ajuste_valvulasCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ajuste_valvulasCheckBox1ActionPerformed(evt);
            }
        });

        relatorio_tecnicoLabel.setText("Relatorio Tecnico");

        relatorio_tecnicoTextField.setColumns(50);
        relatorio_tecnicoTextField.setToolTipText("");
        relatorio_tecnicoTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        relatorio_tecnicoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorio_tecnicoTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ajuste_valvulasCheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(componente_reparadoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(componente_reparadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(restauracao_motorCheckBox)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(relatorio_tecnicoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(relatorio_tecnicoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(componente_reparadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(componente_reparadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(restauracao_motorCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ajuste_valvulasCheckBox)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(relatorio_tecnicoLabel)
                    .addComponent(relatorio_tecnicoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void restauracao_motorCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restauracao_motorCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_restauracao_motorCheckBox1ActionPerformed

    private void ajuste_valvulasCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ajuste_valvulasCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ajuste_valvulasCheckBox1ActionPerformed

    private void relatorio_tecnicoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorio_tecnicoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_relatorio_tecnicoTextFieldActionPerformed

    private void componente_reparadoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_componente_reparadoComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_componente_reparadoComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ajuste_valvulasCheckBox;
    private javax.swing.JComboBox componente_reparadoComboBox;
    private javax.swing.JLabel componente_reparadoLabel;
    private javax.swing.JLabel relatorio_tecnicoLabel;
    private javax.swing.JTextField relatorio_tecnicoTextField;
    private javax.swing.JCheckBox restauracao_motorCheckBox;
    // End of variables declaration//GEN-END:variables
}
