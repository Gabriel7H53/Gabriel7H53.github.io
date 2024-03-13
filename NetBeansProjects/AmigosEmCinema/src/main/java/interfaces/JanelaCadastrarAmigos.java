/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import controle.controladorCadastroAmigo;
import entidade.Amigo;
import entidade.Amigo.EstadoCivil;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author felip
 */
public class JanelaCadastrarAmigos extends javax.swing.JFrame {

    controladorCadastroAmigo controlador;
    Amigo[] amigos_cadastrados;

    public JanelaCadastrarAmigos(controladorCadastroAmigo controlador) {
        this.controlador = controlador;
        amigos_cadastrados = Amigo.getVisoes();
        initComponents();
        limparCampos();
    }

    private void limparCampos() {
        nomeTextField.setText("");
        apelidoTextField.setText("");
        sexoButtonGroup.clearSelection();
        estado_civilButtonGroup.clearSelection();
        cidadeTextField.setText("");
        emailTextField.setText("");
        whatsappTextField.setText("");
        instagramTextField.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sexoButtonGroup = new javax.swing.ButtonGroup();
        estado_civilButtonGroup = new javax.swing.ButtonGroup();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        apelidoLabel = new javax.swing.JLabel();
        apelidoTextField = new javax.swing.JTextField();
        cidadeLabel = new javax.swing.JLabel();
        cidadeTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        whatsappLabel = new javax.swing.JLabel();
        whatsappTextField = new javax.swing.JTextField();
        instagramLabel = new javax.swing.JLabel();
        instagramTextField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparCampos = new javax.swing.JButton();
        inserirButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        amigos_cadastradosComboBox = new javax.swing.JComboBox();
        sexoLabel = new javax.swing.JLabel();
        estado_civilLabel = new javax.swing.JLabel();
        sexoPanel = new javax.swing.JPanel();
        masculinoRadioButton = new javax.swing.JRadioButton();
        femininoRadioButton = new javax.swing.JRadioButton();
        estado_civilPanel = new javax.swing.JPanel();
        solteiroRadioButton = new javax.swing.JRadioButton();
        casadoRadioButton = new javax.swing.JRadioButton();
        divorsiadoRadioButton = new javax.swing.JRadioButton();
        viuvoRadioButton = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Amgos");

        nomeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        nomeLabel.setText("Nome");

        nomeTextField.setColumns(50);
        nomeTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        apelidoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        apelidoLabel.setText("Apelido");

        apelidoTextField.setColumns(50);
        apelidoTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        cidadeLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cidadeLabel.setText("Cidade");

        cidadeTextField.setColumns(50);
        cidadeTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        emailLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        emailLabel.setText("Email");

        emailTextField.setColumns(50);
        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        whatsappLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        whatsappLabel.setText("WhatsApp");

        whatsappTextField.setColumns(50);
        whatsappTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        instagramLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        instagramLabel.setText("Instagram");

        instagramTextField.setColumns(50);
        instagramTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        consultarButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarButtonActionPerformed(evt);
            }
        });

        alterarButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarButtonActionPerformed(evt);
            }
        });

        removerButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerButtonActionPerformed(evt);
            }
        });

        limparCampos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        limparCampos.setText("Limpar");
        limparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCamposActionPerformed(evt);
            }
        });

        inserirButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(inserirButton)
                .addGap(18, 18, 18)
                .addComponent(consultarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(alterarButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(removerButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(limparCampos)
                .addGap(0, 89, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultarButton)
                    .addComponent(alterarButton)
                    .addComponent(removerButton)
                    .addComponent(limparCampos)
                    .addComponent(inserirButton))
                .addGap(0, 13, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Amigos Cadastrados");

        amigos_cadastradosComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        amigos_cadastradosComboBox.setModel(new DefaultComboBoxModel (amigos_cadastrados)
        );

        sexoLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        sexoLabel.setText("Sexo");

        estado_civilLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        estado_civilLabel.setText("Estado CIvil");

        sexoButtonGroup.add(masculinoRadioButton);
        masculinoRadioButton.setMnemonic('M');
        masculinoRadioButton.setText("Masculino");
        sexoPanel.add(masculinoRadioButton);

        sexoButtonGroup.add(femininoRadioButton);
        femininoRadioButton.setMnemonic('F');
        femininoRadioButton.setText("Feminino");
        sexoPanel.add(femininoRadioButton);

        estado_civilButtonGroup.add(solteiroRadioButton);
        solteiroRadioButton.setText("Solteiro");
        solteiroRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                solteiroRadioButtonActionPerformed(evt);
            }
        });
        estado_civilPanel.add(solteiroRadioButton);

        estado_civilButtonGroup.add(casadoRadioButton);
        casadoRadioButton.setMnemonic('\u0001');
        casadoRadioButton.setText("Casado");
        estado_civilPanel.add(casadoRadioButton);

        estado_civilButtonGroup.add(divorsiadoRadioButton);
        divorsiadoRadioButton.setMnemonic('\u0002');
        divorsiadoRadioButton.setText("Divorsiado");
        estado_civilPanel.add(divorsiadoRadioButton);

        estado_civilButtonGroup.add(viuvoRadioButton);
        viuvoRadioButton.setMnemonic('\u0003');
        viuvoRadioButton.setText("Viúvo");
        estado_civilPanel.add(viuvoRadioButton);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apelidoLabel)
                            .addComponent(cidadeLabel)
                            .addComponent(emailLabel)
                            .addComponent(nomeLabel)
                            .addComponent(whatsappLabel)
                            .addComponent(instagramLabel)
                            .addComponent(jLabel1)
                            .addComponent(sexoLabel)
                            .addComponent(estado_civilLabel))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(whatsappTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addComponent(amigos_cadastradosComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(nomeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
                                .addComponent(instagramTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                                .addComponent(apelidoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 391, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(sexoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(estado_civilPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(amigos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apelidoLabel)
                    .addComponent(apelidoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sexoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(sexoLabel)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(estado_civilLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(estado_civilPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cidadeLabel)
                    .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(whatsappTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(instagramTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(instagramLabel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(emailLabel)
                        .addGap(18, 18, 18)
                        .addComponent(whatsappLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void limparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparCamposActionPerformed

    private void consultarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarButtonActionPerformed
        Amigo visao = (Amigo) amigos_cadastradosComboBox.getSelectedItem();
        Amigo amigo = null;
        String mensagem_erro = null;
        if (visao != null) {
            amigo = Amigo.buscarAmigo(visao.getNome());
            if (amigo == null) {
                mensagem_erro = "Amigo não cadastrado";
            }
        } else {
            mensagem_erro = "Nenhum amigo selecionado";
        }
        if (mensagem_erro == null) {
            String apelido = amigo.getApelido();
            if (apelido == null) {
                apelido = "";
            }
            nomeTextField.setText(amigo.getNome());
            apelidoTextField.setText(apelido);
            selecionarSexoRadioButton(amigo.getSexo());
            selecioneEstadoCivilRadioButton(amigo.getEstadocivil().ordinal());
            cidadeTextField.setText(amigo.getCidade());
            emailTextField.setText(amigo.getEmail());
            String whatsapp = amigo.getWhatsapp();
            if (whatsapp == null) {
                whatsapp = "";
            }
            whatsappTextField.setText(whatsapp);
            String instagram = amigo.getInstagram();
            if (instagram == null) {
                instagram = "";
            }
            instagramTextField.setText(instagram);
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarButtonActionPerformed

    private void alterarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarButtonActionPerformed
        Amigo amigo = obterAmigoInformado();
        String mensagem_erro = null;
        if (amigo != null) {
            mensagem_erro = controlador.alterarAmigo(amigo);
        } else {
            mensagem_erro = "Algum atributo do amigo não foi informado";
        }
        if (mensagem_erro == null) {
            Amigo visao = getVisaoAlterada(amigo.getNome());
            if (visao != null) {
                visao.setApelido(amigo.getApelido());
                amigos_cadastradosComboBox.updateUI();
                amigos_cadastradosComboBox.setSelectedItem(visao);
            }
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_alterarButtonActionPerformed

    private void removerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerButtonActionPerformed
        Amigo visao = (Amigo) amigos_cadastradosComboBox.getSelectedItem();
        Amigo amigo = null;
        String mensagem_erro = null;
        if (amigo == null) {
            mensagem_erro = controlador.removerAmigo(visao.getNome());
        } else {
            mensagem_erro = "Nenhum amigo selecionado";
        }
        if (mensagem_erro == null) {
            amigos_cadastradosComboBox.removeItem(visao);
            if (amigos_cadastrados.length >= 1) {
                amigos_cadastradosComboBox.setSelectedIndex(0);
            } else {
                amigos_cadastradosComboBox.setSelectedIndex(-1);
            }
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_removerButtonActionPerformed

    private void inserirButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirButtonActionPerformed
        Amigo amigo = obterAmigoInformado();
        String mensagem_erro = null;
        if (amigo != null) {
            mensagem_erro = controlador.inserirAmigo(amigo);
        } else {
            mensagem_erro = "Algum atributo do amigo não foi informado";
        }
        if (mensagem_erro == null) {
            Amigo visao = amigo.getVisao();
            amigos_cadastradosComboBox.addItem(visao);//-----------------------------------------------------------------------------------------------------
            amigos_cadastradosComboBox.setSelectedItem(visao);
        }

    }//GEN-LAST:event_inserirButtonActionPerformed

    private void solteiroRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_solteiroRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_solteiroRadioButtonActionPerformed

    private Amigo obterAmigoInformado() {
        String nome = nomeTextField.getText();
        if (nome.isEmpty()) {
            return null;
        }
        String apelido = apelidoTextField.getText();
        if (apelido.isEmpty()) {
            return null;
        }
        char sexo = 'X';
        if (sexoButtonGroup.getSelection() != null) {
            sexo = (char) sexoButtonGroup.getSelection().getMnemonic();
        } else {
            return null;
        }

        EstadoCivil estado_civil = null;
        if (estado_civilButtonGroup.getSelection() != null) {
            estado_civil = EstadoCivil.values()[estado_civilButtonGroup.getSelection().getMnemonic()];
        } else {
            return null;
        }

        String cidade = cidadeTextField.getText();
        if (cidade.isEmpty()) {
            return null;
        }
        String email = emailTextField.getText();
        if (email.isEmpty()) {
            return null;
        }
        String whatsapp = whatsappTextField.getText();
        if (whatsapp.isEmpty()) {
            whatsapp = null;
        }
        String instagram = instagramTextField.getText();
        if (instagram.isEmpty()) {
            instagram = null;
        }

        return new Amigo(nome, apelido, sexo, estado_civil, cidade, email, whatsapp, instagram);
    }

    private void selecionarSexoRadioButton(char sexo) {
        switch (sexo) {
            case 'F':
                femininoRadioButton.setSelected(true);
                break;
            case 'M':
                masculinoRadioButton.setSelected(true);
        }
    }

    private void selecioneEstadoCivilRadioButton(int indice_estado_civil) {
        switch (indice_estado_civil) {
            case 0:
                solteiroRadioButton.setSelected(true);
                break;
            case 1:
                casadoRadioButton.setSelected(true);
                break;
            case 2:
                divorsiadoRadioButton.setSelected(true);
                break;
            case 3:
                viuvoRadioButton.setSelected(true);
        }
    }

    private void informarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private Amigo getVisaoAlterada(String nome) {
        for (Amigo visao : amigos_cadastrados) {
            if (visao.getNome().equals(nome)) {
                return visao;
            }
        }
        return null;
    }

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
            java.util.logging.Logger.getLogger(JanelaCadastrarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastrarAmigos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new controladorCadastroAmigo();
                //new JanelaCadastrarAmigos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButton;
    private javax.swing.JComboBox amigos_cadastradosComboBox;
    private javax.swing.JLabel apelidoLabel;
    private javax.swing.JTextField apelidoTextField;
    private javax.swing.JRadioButton casadoRadioButton;
    private javax.swing.JLabel cidadeLabel;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JButton consultarButton;
    private javax.swing.JRadioButton divorsiadoRadioButton;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.ButtonGroup estado_civilButtonGroup;
    private javax.swing.JLabel estado_civilLabel;
    private javax.swing.JPanel estado_civilPanel;
    private javax.swing.JRadioButton femininoRadioButton;
    private javax.swing.JButton inserirButton;
    private javax.swing.JLabel instagramLabel;
    private javax.swing.JTextField instagramTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton limparCampos;
    private javax.swing.JRadioButton masculinoRadioButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JButton removerButton;
    private javax.swing.ButtonGroup sexoButtonGroup;
    private javax.swing.JLabel sexoLabel;
    private javax.swing.JPanel sexoPanel;
    private javax.swing.JRadioButton solteiroRadioButton;
    private javax.swing.JRadioButton viuvoRadioButton;
    private javax.swing.JLabel whatsappLabel;
    private javax.swing.JTextField whatsappTextField;
    // End of variables declaration//GEN-END:variables
}
