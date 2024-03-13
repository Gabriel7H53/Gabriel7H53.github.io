package interfaces;

import controle.ControladorCadastroServicos;
import entidade.Servico;
import entidade.Servico.Status;
import entidade.Motor;
import entidade.Motor.componente_reparado;
import entidade.Suspensao;
import entidade.Suspensao.tipo_suspensao;
import entidade.Pneus;
import entidade.Pneus.marca_pneus;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class JanelaCadastroServicos extends javax.swing.JFrame {

    ControladorCadastroServicos controlador;
    Servico[] servicos_cadastrados;
    PainelServicoMotor servico_reparo_motorPainel;
    PainelServicoSuspensao servico_revisao_suspensaoPainel;
    PainelServicoPneus servico_troca_pneusPainel;
    
    
    public JanelaCadastroServicos(ControladorCadastroServicos controlador) {
        this.controlador = controlador;
        servicos_cadastrados = Servico.getVisoes();
        initComponents();
        servico_reparo_motorPainel = new PainelServicoMotor();
        servico_revisao_suspensaoPainel  = new PainelServicoSuspensao();
        servico_troca_pneusPainel = new PainelServicoPneus();
        especialização_servicoTabbedPane.addTab("Reparo Motor", servico_reparo_motorPainel);
        especialização_servicoTabbedPane.addTab("Revisao Suspensao",servico_revisao_suspensaoPainel);
        especialização_servicoTabbedPane.addTab("Troca Pneus", servico_troca_pneusPainel);
        limparCampos();
    }

    public JanelaCadastroServicos() {
    }

    private void limparCampos() {
        sequencialTextField.setText("");
        descricaoTextField.setText("");
        custoTextField.setText("");
        statusComboBox.setSelectedIndex(-1);
        servico_reparo_motorPainel.limparCampos();
        servico_revisao_suspensaoPainel.limparCampos();
        servico_troca_pneusPainel.limparCampos();
    }

    private Servico obterServicoInformado() {
        String sequencial_str = sequencialTextField.getText();
        int sequencial = 0;
        if (!sequencial_str.isEmpty()) {
            sequencial = Integer.parseInt(sequencial_str);
        }
        String descricao = descricaoTextField.getText();
        if (descricao.isEmpty()) {
            return null;
        }
        String custo = custoTextField.getText();
        if (custo.isEmpty()) {
            return null;
        }
        
        Status status = null;
        if (statusComboBox.getSelectedItem() != null) {
            status = (Status) statusComboBox.getSelectedItem();
        } else {
            return null;
        }
        
        Servico servico = null;
        
        int indice_aba_selecionada = especialização_servicoTabbedPane.getSelectedIndex();
        switch (indice_aba_selecionada) {
            case 0:
                componente_reparado componenteReparado = servico_reparo_motorPainel.getSelectedcomponente_reparado();
                if (componenteReparado == null) {
                    return null;
                }
                boolean restauracaoMotor = servico_reparo_motorPainel.isRestauracao_motor();
                boolean ajusteValvula = servico_reparo_motorPainel.isAjuste_valvulas();
                String relatorioTecnico = servico_reparo_motorPainel.getRelatorio_tecnico();
                servico = new Motor(sequencial, descricao, custo, status, componenteReparado, restauracaoMotor, ajusteValvula, relatorioTecnico);
                break;
            case 1:
                
                tipo_suspensao tipo = servico_revisao_suspensaoPainel.getSelectedtipo_suspensao();
                if (tipo == null) {
                    return null;
                }
                boolean trocaMola = servico_revisao_suspensaoPainel.isTroca_molas();
                boolean vazamentoFluido = servico_revisao_suspensaoPainel.isVazamento_fluido();
                servico = new Suspensao(sequencial, descricao, custo, status, tipo, trocaMola, vazamentoFluido);
                break;
            case 2:
                 marca_pneus marcaPneus = servico_troca_pneusPainel.getSelectedmarcaPneus();
                if (marcaPneus == null) {
                    return null;
                }
                int qtd = servico_troca_pneusPainel.getQtdPneus();
                boolean alinhamento = servico_troca_pneusPainel.isAlinhamento();
                boolean balanceamento = servico_troca_pneusPainel.isBalanceamento();
                servico = new Pneus(sequencial, descricao, custo, status, marcaPneus, qtd, balanceamento, alinhamento);
        }
        return servico;
    }
    
    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "Erro", JOptionPane.INFORMATION_MESSAGE);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        descricaoLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        descricaoTextField = new javax.swing.JTextField();
        comandosPanel = new javax.swing.JPanel();
        inserirButton = new javax.swing.JButton();
        consultarButton = new javax.swing.JButton();
        alterarButton = new javax.swing.JButton();
        removerButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();
        servicosCadastradosLabel = new javax.swing.JLabel();
        servicos_cadastradosComboBox = new javax.swing.JComboBox();
        sequencialTextField = new javax.swing.JTextField();
        fabricanteLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox();
        custoLabel = new javax.swing.JLabel();
        custoTextField = new javax.swing.JTextField();
        especialização_servicoTabbedPane = new javax.swing.JTabbedPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Servicos");

        descricaoLabel.setText("Descrição");

        statusLabel.setText("Status");

        descricaoTextField.setColumns(50);
        descricaoTextField.setToolTipText("");
        descricaoTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        descricaoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descricaoTextFieldActionPerformed(evt);
            }
        });

        comandosPanel.setLayout(new java.awt.GridBagLayout());

        inserirButton.setText("Inserir");
        inserirButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirServico(evt);
            }
        });

        consultarButton.setText("Consultar");
        consultarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarServico(evt);
            }
        });

        alterarButton.setText("Alterar");
        alterarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarServico(evt);
            }
        });

        removerButton.setText("Remover");
        removerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerServico(evt);
            }
        });

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        servicosCadastradosLabel.setText("Serviços Cadastrados");

        servicos_cadastradosComboBox.setModel(new DefaultComboBoxModel (servicos_cadastrados));
        servicos_cadastradosComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                servicos_cadastradosComboBoxActionPerformed(evt);
            }
        });

        sequencialTextField.setEditable(false);
        sequencialTextField.setColumns(50);
        sequencialTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sequencialTextFieldActionPerformed(evt);
            }
        });

        fabricanteLabel.setText("Identificador Sequencial");

        statusComboBox.setModel(new DefaultComboBoxModel (Status.values()));
        statusComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusComboBoxActionPerformed(evt);
            }
        });

        custoLabel.setText("Custo");

        custoTextField.setColumns(50);
        custoTextField.setToolTipText("");
        custoTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        custoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                custoTextFieldActionPerformed(evt);
            }
        });

        especialização_servicoTabbedPane.setPreferredSize(new java.awt.Dimension(600, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(fabricanteLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(servicosCadastradosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(servicos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 342, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(custoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(custoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(descricaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(descricaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(183, 183, 183)
                        .addComponent(inserirButton)
                        .addGap(7, 7, 7)
                        .addComponent(consultarButton)
                        .addGap(7, 7, 7)
                        .addComponent(alterarButton)
                        .addGap(7, 7, 7)
                        .addComponent(removerButton)
                        .addGap(7, 7, 7)
                        .addComponent(limparButton))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(especialização_servicoTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicosCadastradosLabel)
                    .addComponent(servicos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sequencialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fabricanteLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descricaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descricaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(custoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(especialização_servicoTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(inserirButton)
                    .addComponent(consultarButton)
                    .addComponent(alterarButton)
                    .addComponent(removerButton)
                    .addComponent(limparButton))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void consultarServico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarServico
        Servico visao = (Servico) servicos_cadastradosComboBox.getSelectedItem();
        String mensagem_erro = null;
        Servico servico = null;
        if (visao != null) {
            servico = Servico.buscarServico(visao.getSequencial());
            if (servico == null) {
                mensagem_erro = "Servico não cadastrado";
            }
        } else {
            mensagem_erro = "Servico não identificado";
        }
        if (mensagem_erro == null) {
            String descricao = servico.getDescricao();
            if (descricao == null) {
                descricao = "";
            }
            descricaoTextField.setText(descricao);
            custoTextField.setText(servico.getCusto());
            statusComboBox.setSelectedItem(servico.getStatus());
            sequencialTextField.setText(servico.getSequencial() + "");
        } else{
            informarErro(mensagem_erro);
        
    }
        if (servico instanceof Motor ) {
            especialização_servicoTabbedPane.setSelectedIndex(0);
            Motor servico_reparo_motor = (Motor) servico;
            servico_reparo_motorPainel.setSelectedcomponente_reparado(servico_reparo_motor.getComponente());
            servico_reparo_motorPainel.setRestauracao_motor(servico_reparo_motor.isRestauracao_motor());
            servico_reparo_motorPainel.setAjuste_valvulas(servico_reparo_motor.isAjuste_valvulas());
            servico_reparo_motorPainel.setRelatorio_tecnico(servico_reparo_motor.getRelatorio_tecnico());
            
        } else if (servico instanceof Suspensao) {
            especialização_servicoTabbedPane.setSelectedIndex(1);
            Suspensao servico_revisao_suspensao = (Suspensao) servico;
            servico_revisao_suspensaoPainel.setSelectedtipo_suspensao(servico_revisao_suspensao.getTipo().ordinal());
            servico_revisao_suspensaoPainel.setTroca_molas(servico_revisao_suspensao.isTroca_molas());
            servico_revisao_suspensaoPainel.setVazamento_fluido(servico_revisao_suspensao.isVazamento_fluido());
        }else if(servico instanceof Pneus){
            especialização_servicoTabbedPane.setSelectedIndex(2);
            Pneus servico_troca_pneus = (Pneus) servico;
            servico_troca_pneusPainel.setSelectedmarcaPneus(servico_troca_pneus.getMarca());
            servico_troca_pneusPainel.setQtdPneus(servico_troca_pneus.getQtd());
            servico_troca_pneusPainel.setBalanceamento(servico_troca_pneus.isBalanceamento());
            servico_troca_pneusPainel.setAlinhamento(servico_troca_pneus.isAlinhamento());
        }
    }//GEN-LAST:event_consultarServico

    
    private void removerServico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerServico
        Servico visao = (Servico) servicos_cadastradosComboBox.getSelectedItem();
        String mensagem_erro = null;
        if (visao != null) {
            mensagem_erro = controlador.removerServico(visao.getSequencial());
        } else {
            mensagem_erro = "Nenhum servico selecionado";
        }
        if (mensagem_erro == null) {
            servicos_cadastradosComboBox.removeItem(visao);
            if (servicos_cadastrados.length >= 1) {
                servicos_cadastradosComboBox.setSelectedIndex(0);
            } else {
                servicos_cadastradosComboBox.setSelectedIndex(-1);
            }
        } else
            informarErro(mensagem_erro);
    }//GEN-LAST:event_removerServico


    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        limparCampos();
    }//GEN-LAST:event_limparCampos

    private void inserirServico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirServico
        Servico servico = obterServicoInformado();
        String mensagem_erro = null;
        if (servico != null) {
            mensagem_erro = controlador.inserirServico(servico);
        } else {
            mensagem_erro = "Algum atributo do servico não foi informado";
        }
        if (mensagem_erro == null) {
            int sequencial = Servico.últimoSequencial();
            servico.setSequencial(sequencial);
            servicos_cadastradosComboBox.addItem(servico.getVisao());
            servicos_cadastradosComboBox.setSelectedItem(servico.getVisao());
        }
    }//GEN-LAST:event_inserirServico

    private void alterarServico(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarServico
        Servico novoServico = obterServicoInformado();
        String mensagem_erro = null;
        if (novoServico != null) mensagem_erro = controlador.alterarServico(novoServico);
        else mensagem_erro = "Algum atributo não foi informado";
        if (mensagem_erro == null) {
           Servico visao = (Servico)servicos_cadastradosComboBox.getSelectedItem();      
           if(visao != null){
               visao.setCusto(visao.getCusto()); 
               servicos_cadastradosComboBox.setSelectedItem(visao);
               servicos_cadastradosComboBox.updateUI();
           }
        }else informarErro(mensagem_erro);
        
    }//GEN-LAST:event_alterarServico

    private void descricaoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descricaoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_descricaoTextFieldActionPerformed

    private void servicos_cadastradosComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_servicos_cadastradosComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_servicos_cadastradosComboBoxActionPerformed

    private void sequencialTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sequencialTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sequencialTextFieldActionPerformed

    private void statusComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusComboBoxActionPerformed

    private void custoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_custoTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_custoTextFieldActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaCadastroServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaCadastroServicos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaCadastroServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterarButton;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultarButton;
    private javax.swing.JLabel custoLabel;
    private javax.swing.JTextField custoTextField;
    private javax.swing.JLabel descricaoLabel;
    private javax.swing.JTextField descricaoTextField;
    private javax.swing.JTabbedPane especialização_servicoTabbedPane;
    private javax.swing.JLabel fabricanteLabel;
    private javax.swing.JButton inserirButton;
    private javax.swing.JButton limparButton;
    private javax.swing.JButton removerButton;
    private javax.swing.JTextField sequencialTextField;
    private javax.swing.JLabel servicosCadastradosLabel;
    private javax.swing.JComboBox servicos_cadastradosComboBox;
    private javax.swing.JComboBox statusComboBox;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
