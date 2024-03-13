/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidade.FilmeProvedoraStreaming;
import entidade.FilmeProvedoraStreaming.ProvedoraStreaming;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author felip
 */
public class PainelFilmesProvedoraStreaming extends javax.swing.JPanel {

    /**
     * Creates new form PainelFilmesProvedoraStreaming
     */
    public PainelFilmesProvedoraStreaming() {
        initComponents();
    }

    public FilmeProvedoraStreaming.ProvedoraStreaming getSelectedProvedoraStreaming() {
        Object provedora_streaming = provedoraComboBox.getSelectedItem();
        if (provedora_streaming != null) {
            return (FilmeProvedoraStreaming.ProvedoraStreaming) provedora_streaming;
        } else {
            return null;
        }
    }

    public void setSelectedProvedoraStreaming(FilmeProvedoraStreaming.ProvedoraStreaming provedora_streaming) {
        provedoraComboBox.setSelectedItem(provedora_streaming);
    }

    public FilmeProvedoraStreaming.Producao getSelectedProducao() {
        FilmeProvedoraStreaming.Producao producao = null;
        if (producaoButtonGroup.getSelection() != null) {
            producao = FilmeProvedoraStreaming.Producao.values()[producaoButtonGroup.getSelection().getMnemonic()];
        }
        return producao;
    }

    public void setSelectedProducao(int indice_producao) {
        switch (indice_producao) {
            case 0:
                filmeRadioButton.setSelected(true);
                break;
            case 1:
                serieRadioButton.setSelected(true);
        }
    }

    public int getTotalEpisodios() {
        String total_episodios_str = total_episodiosTextField.getText();
        if (!total_episodios_str.isEmpty()) {
            return Integer.parseInt(total_episodios_str);
        } else {
            return -1;
        }
    }

    public void setTotalEpisodios(int total_episodios) {
        total_episodiosTextField.setText(total_episodios + "");
    }

    public void limparCampos() {
        provedoraComboBox.setSelectedIndex(-1);
        producaoButtonGroup.clearSelection();
        total_episodiosTextField.setText("");
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        producaoButtonGroup = new javax.swing.ButtonGroup();
        total_episodiosTextField = new javax.swing.JTextField();
        provedoraComboBox = new javax.swing.JComboBox();
        produtoralabel = new java.awt.Label();
        producaolabel = new java.awt.Label();
        total_epsodoslabel = new java.awt.Label();
        producaoPanel = new java.awt.Panel();
        serieRadioButton = new javax.swing.JRadioButton();
        filmeRadioButton = new javax.swing.JRadioButton();

        setPreferredSize(new java.awt.Dimension(400, 200));

        total_episodiosTextField.setColumns(30);
        total_episodiosTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        total_episodiosTextField.setPreferredSize(new java.awt.Dimension(246, 20));

        provedoraComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        provedoraComboBox.setModel( new DefaultComboBoxModel (ProvedoraStreaming.values()));
        provedoraComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                provedoraComboBoxActionPerformed(evt);
            }
        });

        produtoralabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        produtoralabel.setText("Provedora de Streaming");

        producaolabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        producaolabel.setText("Produção");

        total_epsodoslabel.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        total_epsodoslabel.setText("Total de Epsódios");

        producaoPanel.setPreferredSize(new java.awt.Dimension(113, 33));

        producaoButtonGroup.add(serieRadioButton);
        serieRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        serieRadioButton.setText("Série");
        producaoPanel.add(serieRadioButton);

        producaoButtonGroup.add(filmeRadioButton);
        filmeRadioButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        filmeRadioButton.setMnemonic('\u0001');
        filmeRadioButton.setText("Filme");
        producaoPanel.add(filmeRadioButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(produtoralabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_epsodoslabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(producaolabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(provedoraComboBox, 0, 400, Short.MAX_VALUE)
                    .addComponent(producaoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_episodiosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(357, 357, 357))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(produtoralabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(provedoraComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(producaolabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(producaoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 59, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(total_epsodoslabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(total_episodiosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(100, 100, 100))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void provedoraComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_provedoraComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_provedoraComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton filmeRadioButton;
    private javax.swing.ButtonGroup producaoButtonGroup;
    private java.awt.Panel producaoPanel;
    private java.awt.Label producaolabel;
    private java.awt.Label produtoralabel;
    private javax.swing.JComboBox provedoraComboBox;
    private javax.swing.JRadioButton serieRadioButton;
    private javax.swing.JTextField total_episodiosTextField;
    private java.awt.Label total_epsodoslabel;
    // End of variables declaration//GEN-END:variables
}
