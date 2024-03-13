package interfaces;

import controle.ControladorCadastroMotores;
import entidade.Motor;
import entidade.Motor.Fabricante;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class JanelaCadastroMotores extends javax.swing.JFrame {

    ControladorCadastroMotores controlador;
    Motor[] motores_cadastrados;

    public JanelaCadastroMotores(ControladorCadastroMotores controlador) {
        this.controlador = controlador;
        motores_cadastrados = Motor.getVisoes();
        initComponents();
        limparCampos();
    }

    public JanelaCadastroMotores() {
    }

    private void limparCampos() {
        SequencialTextField.setText("");
        nomeTextField.setText("");
        modeloTextField.setText("");
        numeroSerieTextField.setText("");
        fabricanteComboBox.setSelectedIndex(-1);
    }

    private Motor obterMotorInformado() {
        String sequencial_str = SequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) {
            sequencial = Integer.parseInt(sequencial_str);
        }
        String nome = nomeTextField.getText();
        if (nome.isEmpty()) {
            return null;
        }
        String modelo = modeloTextField.getText();
        if (modelo.isEmpty()) {
            return null;
        }
        String numeroSerie = numeroSerieTextField.getText();
        if (numeroSerie.isEmpty()) {
            return null;
        }
        Fabricante fabricante = null;
        if (fabricanteComboBox.getSelectedItem() != null) {
            fabricante = (Fabricante) fabricanteComboBox.getSelectedItem();
        } else {
            return null;
        }
        return new Motor(sequencial, nome, modelo, numeroSerie, fabricante);
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        nomeLabel = new javax.swing.JLabel();
        modeloLabel = new javax.swing.JLabel();
        numeroSerieLabel = new javax.swing.JLabel();
        fabricanteLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        modeloTextField = new javax.swing.JTextField();
        numeroSerieTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        motores_cadastradosComboBox = new javax.swing.JComboBox();
        SequencialTextField = new javax.swing.JTextField();
        fabricanteLabel1 = new javax.swing.JLabel();
        fabricanteComboBox = new javax.swing.JComboBox();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Motores");

        nomeLabel.setText("Nome");

        modeloLabel.setText("Modelo");

        numeroSerieLabel.setText("N.Serie");

        fabricanteLabel.setText("Fabricante");

        nomeTextField.setColumns(50);
        nomeTextField.setToolTipText("");
        nomeTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextFieldActionPerformed(evt);
            }
        });

        modeloTextField.setColumns(50);
        modeloTextField.setPreferredSize(new java.awt.Dimension(400, 20));

        numeroSerieTextField.setColumns(50);
        numeroSerieTextField.setPreferredSize(new java.awt.Dimension(400, 20));

        comandosPanel.setLayout(new java.awt.GridBagLayout());

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirMotor(evt);
            }
        });

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarMotor(evt);
            }
        });

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarMotor(evt);
            }
        });

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerMotor(evt);
            }
        });

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        jLabel1.setText("Motores Cadastrados");

        motores_cadastradosComboBox.setModel(new DefaultComboBoxModel (motores_cadastrados));
        motores_cadastradosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                motores_cadastradosComboBoxActionPerformed(evt);
            }
        });

        SequencialTextField.setEditable(false);
        SequencialTextField.setColumns(50);
        SequencialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SequencialTextFieldActionPerformed(evt);
            }
        });

        fabricanteLabel1.setText("Identificador Sequencial");

        fabricanteComboBox.setModel(new DefaultComboBoxModel (Fabricante.values()));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(inserirButton)
                        .addGap(7, 7, 7)
                        .addComponent(consultarButton)
                        .addGap(7, 7, 7)
                        .addComponent(alterarButton)
                        .addGap(7, 7, 7)
                        .addComponent(removerButton)
                        .addGap(7, 7, 7)
                        .addComponent(limparButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(fabricanteLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(modeloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(modeloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(motores_cadastradosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(numeroSerieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numeroSerieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(fabricanteLabel)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(fabricanteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(motores_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(modeloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modeloTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numeroSerieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(numeroSerieTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fabricanteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fabricanteComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(fabricanteLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(SequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inserirButton)
                    .addComponent(consultarButton)
                    .addComponent(alterarButton)
                    .addComponent(removerButton)
                    .addComponent(limparButton))
                .addGap(35, 35, 35))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarMotor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarMotor
        Motor visao = (Motor) motores_cadastradosComboBox.getSelectedItem();
        String mensagem_erro = null;
        Motor motor = null;
        if (visao != null) {
            motor = Motor.buscarMotor(visao.getSequencial());
            if (motor == null) {
                mensagem_erro = "Motor não cadastrado";
            }
        } else {
            mensagem_erro = "Nome de motor não identificado";
        }
        if (mensagem_erro == null) {
            String modelo = motor.getModelo();
            if (modelo == null) {
                modelo = "";
            }
            modeloTextField.setText(modelo);
            numeroSerieTextField.setText(motor.getNumeroSerie());
            fabricanteComboBox.setSelectedItem(motor.getFabricante());
            String nome = motor.getNome();
            nomeTextField.setText(nome);
            SequencialTextField.setText(motor.getSequencial() + "");
        } else
            informarErro(mensagem_erro);
    }//GEN-LAST:event_consultarMotor

    private void removerMotor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerMotor
        Motor visao = (Motor) motores_cadastradosComboBox.getSelectedItem();
        String mensagem_erro = null;
        if (visao != null) {
            mensagem_erro = controlador.removerMotor(visao.getSequencial());
        } else {
            mensagem_erro = "Nenhum motor selecionado";
        }
        if (mensagem_erro == null) {
            motores_cadastradosComboBox.removeItem(visao);
            if (motores_cadastrados.length >= 1) {
                motores_cadastradosComboBox.setSelectedIndex(0);
            } else {
                motores_cadastradosComboBox.setSelectedIndex(-1);
            }
        } else
            informarErro(mensagem_erro);
    }//GEN-LAST:event_removerMotor


    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        limparCampos();
    }//GEN-LAST:event_limparCampos

    private void inserirMotor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirMotor
        Motor motor = obterMotorInformado();
        String mensagem_erro = null;
        if (motor != null) {
            mensagem_erro = controlador.inserirMotor(motor);
        } else {
            mensagem_erro = "Algum atributo do motor não foi informado";
        }
        if (mensagem_erro == null) {
            int sequencial = Motor.últimoSequencial();
            motor.setSequencial(sequencial);
            motores_cadastradosComboBox.addItem(motor.getVisao());
            motores_cadastradosComboBox.setSelectedItem(motor.getVisao());
        }
    }//GEN-LAST:event_inserirMotor

    private Motor getVisaoAlterada(int sequencial) {
        motores_cadastrados = Motor.getVisoes();
        for (Motor visao : motores_cadastrados) {
            if (visao.getSequencial() == sequencial) {
                return visao;
            }
        }
        return null;
    }

    private void alterarMotor(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarMotor
        Motor motor = obterMotorInformado();
        String mensagem_erro = null;
        if (motor != null) {
            mensagem_erro = controlador.alterarMotor(motor);
        } else {
            mensagem_erro = "Algum atributo do motor não informado";
        }
        if (mensagem_erro == null) {
            Motor visao = getVisaoAlterada(motor.getSequencial());
            if (visao != null) {
                visao.setNome(motor.getNome()); 
                motores_cadastradosComboBox.setModel(new DefaultComboBoxModel(motores_cadastrados));
                motores_cadastradosComboBox.updateUI();
                motores_cadastradosComboBox.setSelectedItem(visao);
            }
        } else
            informarErro(mensagem_erro);
    }//GEN-LAST:event_alterarMotor

    private void nomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTextFieldActionPerformed

    private void motores_cadastradosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_motores_cadastradosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_motores_cadastradosComboBoxActionPerformed

    private void SequencialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SequencialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SequencialTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaCadastroMotores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroMotores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroMotores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroMotores.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastroMotores().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField SequencialTextField;
    private javax.swing.JButton alterarButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JComboBox fabricanteComboBox;
    private javax.swing.JLabel fabricanteLabel;
    private javax.swing.JLabel fabricanteLabel1;
    private javax.swing.JButton inserirButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton limparButton;
    private javax.swing.JLabel modeloLabel;
    private javax.swing.JTextField modeloTextField;
    private javax.swing.JComboBox motores_cadastradosComboBox;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel numeroSerieLabel;
    private javax.swing.JTextField numeroSerieTextField;
    private javax.swing.JButton removerButton;
    // End of variables declaration//GEN-END:variables
}
