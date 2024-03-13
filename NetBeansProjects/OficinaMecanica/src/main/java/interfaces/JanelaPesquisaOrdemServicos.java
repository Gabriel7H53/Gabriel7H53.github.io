package interfaces;

import entidade.Cliente;
import javax.swing.DefaultComboBoxModel;
import entidade.OrdemServico;
import entidade.OrdemServico.MetodoPagamento;
import entidade.OrdemServico.TarefasRealizadas;
import entidade.Pneus.marca_pneus;
import entidade.Servico;
import entidade.Servico.Status;
import entidade.Suspensao.tipo_suspensao;
import java.util.ArrayList;

public class JanelaPesquisaOrdemServicos extends javax.swing.JFrame {

    Cliente[] clientes_cadastrados;
    Servico[] servicos_cadastrados;
    
    PainelFiltrosServicoPneus filtros_servico_pneusPainel;
    PainelFiltrosServicoMotor filtros_servico_motorPainel;
    PainelFiltrosServicoSuspensao filtros_servico_suspensaoPainel;
    
    public JanelaPesquisaOrdemServicos() {
        clientes_cadastrados = Cliente.getVisoes();
        servicos_cadastrados = Servico.getVisoes();
        initComponents();
        filtros_servico_pneusPainel = new PainelFiltrosServicoPneus();
        filtros_servico_motorPainel= new PainelFiltrosServicoMotor();
        filtros_servico_suspensaoPainel = new PainelFiltrosServicoSuspensao();
        filtros_especificos_servicosTabbedPane.addTab("Filtro de pneu",
                filtros_servico_pneusPainel);
        filtros_especificos_servicosTabbedPane.addTab("Filtro de motor",
                filtros_servico_motorPainel);
        filtros_especificos_servicosTabbedPane.addTab("Filtro de suspensao",
                filtros_servico_suspensaoPainel);
        limparFiltros(null);
    }

    private void mostrarOrdemServicosSelecionadas(ArrayList<OrdemServico> ordemServicos) {
        boolean primeira_ordemServico = true;
        for (OrdemServico ordemServico : ordemServicos) {
            if (primeira_ordemServico) {
                pesquisasTextArea.append(ordemServico.toStringFull());
                primeira_ordemServico = false;
            } else {
                pesquisasTextArea.append("\n" + ordemServico.toStringFull());
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preferenciaContatoButtonGroup = new javax.swing.ButtonGroup();
        tarefaRealizadaButtonGroup = new javax.swing.ButtonGroup();
        filtros_clientesPanel = new javax.swing.JPanel();
        clientes_cadastradosComboBox = new javax.swing.JComboBox();
        clientes_cadastradosLabel = new javax.swing.JLabel();
        preferenciaContatoLabel = new javax.swing.JLabel();
        emailRadioButton = new javax.swing.JRadioButton();
        telefoneRadioButton = new javax.swing.JRadioButton();
        filtros_servicosPanel = new javax.swing.JPanel();
        servicos_cadastradosComboBox = new javax.swing.JComboBox();
        servicos_cadastradosLabel = new javax.swing.JLabel();
        statusComboBox = new javax.swing.JComboBox<>();
        statusLabel = new javax.swing.JLabel();
        filtros_especificos_servicosTabbedPane = new javax.swing.JTabbedPane();
        filtros_ordemServicoPanel = new javax.swing.JPanel();
        metodo_pagamentoComboBox = new javax.swing.JComboBox<>();
        metodo_pagamentoLabel = new javax.swing.JLabel();
        tipo_servicoLabel = new javax.swing.JLabel();
        preferenciaPanel = new javax.swing.JPanel();
        diagnosticoRadioButton = new javax.swing.JRadioButton();
        reparoRadioButton = new javax.swing.JRadioButton();
        manutencaoRadioButton = new javax.swing.JRadioButton();
        ordemDeServicos_selecionadasPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pesquisasTextArea = new javax.swing.JTextArea();
        botaoPanel = new javax.swing.JPanel();
        pesquisarAvaliacoes = new javax.swing.JButton();
        limpar_FiltrosButton = new javax.swing.JButton();
        limpar_pesquisaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Pesquisa Ordem de Servico");

        filtros_clientesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros  Clientes"));
        filtros_clientesPanel.setToolTipText("Filtros de Clientes");

        clientes_cadastradosComboBox.setModel(new DefaultComboBoxModel(clientes_cadastrados));

        clientes_cadastradosLabel.setText("Clientes Cadastrados");

        preferenciaContatoLabel.setText("Preferencia de Contato");

        preferenciaContatoButtonGroup.add(emailRadioButton);
        emailRadioButton.setText("E-mail");
        emailRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailRadioButtonActionPerformed(evt);
            }
        });

        preferenciaContatoButtonGroup.add(telefoneRadioButton);
        telefoneRadioButton.setMnemonic('\u0001');
        telefoneRadioButton.setText("Telefone");
        telefoneRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filtros_clientesPanelLayout = new javax.swing.GroupLayout(filtros_clientesPanel);
        filtros_clientesPanel.setLayout(filtros_clientesPanelLayout);
        filtros_clientesPanelLayout.setHorizontalGroup(
            filtros_clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_clientesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(clientes_cadastradosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(clientes_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(preferenciaContatoLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(telefoneRadioButton)
                .addGap(0, 308, Short.MAX_VALUE))
        );
        filtros_clientesPanelLayout.setVerticalGroup(
            filtros_clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_clientesPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(filtros_clientesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clientes_cadastradosLabel)
                    .addComponent(clientes_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailRadioButton)
                    .addComponent(preferenciaContatoLabel)
                    .addComponent(telefoneRadioButton))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        filtros_servicosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Servicos"));
        filtros_servicosPanel.setToolTipText("Filtros de Servicos");

        servicos_cadastradosComboBox.setModel(new DefaultComboBoxModel(servicos_cadastrados));

        servicos_cadastradosLabel.setText("Servicos Cadastrados");

        statusComboBox.setModel(new DefaultComboBoxModel (Status.values()));

        statusLabel.setText("Status");

        filtros_especificos_servicosTabbedPane.setPreferredSize(new java.awt.Dimension(600, 200));

        javax.swing.GroupLayout filtros_servicosPanelLayout = new javax.swing.GroupLayout(filtros_servicosPanel);
        filtros_servicosPanel.setLayout(filtros_servicosPanelLayout);
        filtros_servicosPanelLayout.setHorizontalGroup(
            filtros_servicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_servicosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(servicos_cadastradosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(servicos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(filtros_especificos_servicosTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        filtros_servicosPanelLayout.setVerticalGroup(
            filtros_servicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_servicosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtros_servicosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(servicos_cadastradosLabel)
                    .addComponent(servicos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusLabel)
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtros_servicosPanelLayout.createSequentialGroup()
                .addComponent(filtros_especificos_servicosTabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        filtros_ordemServicoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro Ordem de Servicos"));

        metodo_pagamentoComboBox.setModel(new DefaultComboBoxModel (MetodoPagamento.values()));

        metodo_pagamentoLabel.setText("Metodo de Pagamento");

        tipo_servicoLabel.setText("Tipo Servico:");

        tarefaRealizadaButtonGroup.add(diagnosticoRadioButton);
        diagnosticoRadioButton.setText("Diagnostico");
        diagnosticoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diagnosticoRadioButtonActionPerformed(evt);
            }
        });

        tarefaRealizadaButtonGroup.add(reparoRadioButton);
        reparoRadioButton.setMnemonic('\u0001');
        reparoRadioButton.setText("Reparo");

        tarefaRealizadaButtonGroup.add(manutencaoRadioButton);
        manutencaoRadioButton.setMnemonic('\u0002');
        manutencaoRadioButton.setText("Manutencao");
        manutencaoRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manutencaoRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout filtros_ordemServicoPanelLayout = new javax.swing.GroupLayout(filtros_ordemServicoPanel);
        filtros_ordemServicoPanel.setLayout(filtros_ordemServicoPanelLayout);
        filtros_ordemServicoPanelLayout.setHorizontalGroup(
            filtros_ordemServicoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_ordemServicoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(metodo_pagamentoLabel)
                .addGap(18, 18, 18)
                .addComponent(metodo_pagamentoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(tipo_servicoLabel)
                .addGap(15, 15, 15)
                .addComponent(diagnosticoRadioButton)
                .addGap(18, 18, 18)
                .addComponent(reparoRadioButton)
                .addGap(18, 18, 18)
                .addComponent(manutencaoRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(preferenciaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(194, Short.MAX_VALUE))
        );
        filtros_ordemServicoPanelLayout.setVerticalGroup(
            filtros_ordemServicoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_ordemServicoPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(filtros_ordemServicoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(preferenciaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(filtros_ordemServicoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(metodo_pagamentoLabel)
                        .addComponent(metodo_pagamentoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tipo_servicoLabel)
                        .addComponent(diagnosticoRadioButton)
                        .addComponent(reparoRadioButton)
                        .addComponent(manutencaoRadioButton)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        ordemDeServicos_selecionadasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Ordem de Servico Selecionadas"));

        pesquisasTextArea.setColumns(20);
        pesquisasTextArea.setRows(5);
        jScrollPane1.setViewportView(pesquisasTextArea);

        javax.swing.GroupLayout ordemDeServicos_selecionadasPanelLayout = new javax.swing.GroupLayout(ordemDeServicos_selecionadasPanel);
        ordemDeServicos_selecionadasPanel.setLayout(ordemDeServicos_selecionadasPanelLayout);
        ordemDeServicos_selecionadasPanelLayout.setHorizontalGroup(
            ordemDeServicos_selecionadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        ordemDeServicos_selecionadasPanelLayout.setVerticalGroup(
            ordemDeServicos_selecionadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
        );

        pesquisarAvaliacoes.setText("Pesquisar");
        pesquisarAvaliacoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pesquisarAvaliacoes(evt);
            }
        });

        limpar_FiltrosButton.setText("Limpar Filtros");
        limpar_FiltrosButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparFiltros(evt);
            }
        });

        limpar_pesquisaButton.setText("LimparPesquisa");
        limpar_pesquisaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparAvaliacoesSelecionadas(evt);
            }
        });

        javax.swing.GroupLayout botaoPanelLayout = new javax.swing.GroupLayout(botaoPanel);
        botaoPanel.setLayout(botaoPanelLayout);
        botaoPanelLayout.setHorizontalGroup(
            botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botaoPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(pesquisarAvaliacoes)
                .addGap(18, 18, 18)
                .addComponent(limpar_FiltrosButton)
                .addGap(18, 18, 18)
                .addComponent(limpar_pesquisaButton)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        botaoPanelLayout.setVerticalGroup(
            botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, botaoPanelLayout.createSequentialGroup()
                .addGap(0, 11, Short.MAX_VALUE)
                .addGroup(botaoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisarAvaliacoes)
                    .addComponent(limpar_FiltrosButton)
                    .addComponent(limpar_pesquisaButton)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filtros_servicosPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(167, 167, 167)
                        .addComponent(botaoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(filtros_clientesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(filtros_ordemServicoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ordemDeServicos_selecionadasPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(filtros_clientesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filtros_servicosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filtros_ordemServicoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ordemDeServicos_selecionadasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(botaoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarAvaliacoes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarAvaliacoes
        String chave_cliente = null;
        if (clientes_cadastradosComboBox.getSelectedItem() != null) {
            chave_cliente = ((Cliente) clientes_cadastradosComboBox.getSelectedItem()).getCpf();
        }
        int chave_servico = -1;
        if (servicos_cadastradosComboBox.getSelectedItem() != null) {
            chave_servico = ((Servico) servicos_cadastradosComboBox.getSelectedItem()).getSequencial();
        }
        char preferenciaContato = '3';
        if (preferenciaContatoButtonGroup.getSelection() != null) {
            preferenciaContato = (char) preferenciaContatoButtonGroup.getSelection().getMnemonic();
        }
        Status status_servico = null;
        if (statusComboBox.getSelectedItem() != null) {
            status_servico = (Status) statusComboBox.getSelectedItem();
        }
        marca_pneus marca_pneus = null;
        char possuiAjuste = 'X';
        tipo_suspensao tipo_suspensao = null;
        
        int indice_aba_selecionada = filtros_especificos_servicosTabbedPane.getSelectedIndex();
        if (indice_aba_selecionada == 0) {
            marca_pneus = filtros_servico_pneusPainel.getSelectedmarcaPneus();
        } else if (indice_aba_selecionada == 1) {
            possuiAjuste = filtros_servico_motorPainel.getAjuste();
        }else if (indice_aba_selecionada == 2) {
            tipo_suspensao = filtros_servico_suspensaoPainel.getSelectedtipo_suspensao();
        }
        MetodoPagamento metodo_pagamento = (MetodoPagamento) metodo_pagamentoComboBox.getSelectedItem();
        TarefasRealizadas tarefas_realizadas = null;
        if (tarefaRealizadaButtonGroup.getSelection() != null) {
            tarefas_realizadas = TarefasRealizadas.values()[tarefaRealizadaButtonGroup.getSelection().getMnemonic()];
        }
        ArrayList<OrdemServico> ordem_servicos = OrdemServico.pesquisarAvaliacoes(chave_cliente, chave_servico,
                preferenciaContato, status_servico, marca_pneus, possuiAjuste, tipo_suspensao,
                metodo_pagamento, tarefas_realizadas);
        mostrarOrdemServicosSelecionadas(ordem_servicos);
    }//GEN-LAST:event_pesquisarAvaliacoes

    private void limparFiltros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFiltros
        clientes_cadastradosComboBox.setSelectedIndex(-1);
        servicos_cadastradosComboBox.setSelectedIndex(-1);
        preferenciaContatoButtonGroup.clearSelection();
        statusComboBox.setSelectedIndex(-1);
        metodo_pagamentoComboBox.setSelectedIndex(-1);
        tarefaRealizadaButtonGroup.clearSelection();
        filtros_servico_motorPainel.limparCampos();
        filtros_servico_pneusPainel.limparCampos();
    }//GEN-LAST:event_limparFiltros

    private void limparAvaliacoesSelecionadas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparAvaliacoesSelecionadas
        pesquisasTextArea.setText("");
    }//GEN-LAST:event_limparAvaliacoesSelecionadas

    private void emailRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailRadioButtonActionPerformed

    private void telefoneRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneRadioButtonActionPerformed

    private void diagnosticoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diagnosticoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diagnosticoRadioButtonActionPerformed

    private void manutencaoRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manutencaoRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_manutencaoRadioButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPesquisaOrdemServicos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel botaoPanel;
    private javax.swing.JComboBox clientes_cadastradosComboBox;
    private javax.swing.JLabel clientes_cadastradosLabel;
    private javax.swing.JRadioButton diagnosticoRadioButton;
    private javax.swing.JRadioButton emailRadioButton;
    private javax.swing.JPanel filtros_clientesPanel;
    private javax.swing.JTabbedPane filtros_especificos_servicosTabbedPane;
    private javax.swing.JPanel filtros_ordemServicoPanel;
    private javax.swing.JPanel filtros_servicosPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpar_FiltrosButton;
    private javax.swing.JButton limpar_pesquisaButton;
    private javax.swing.JRadioButton manutencaoRadioButton;
    private javax.swing.JComboBox<String> metodo_pagamentoComboBox;
    private javax.swing.JLabel metodo_pagamentoLabel;
    private javax.swing.JPanel ordemDeServicos_selecionadasPanel;
    private javax.swing.JButton pesquisarAvaliacoes;
    private javax.swing.JTextArea pesquisasTextArea;
    private javax.swing.ButtonGroup preferenciaContatoButtonGroup;
    private javax.swing.JLabel preferenciaContatoLabel;
    private javax.swing.JPanel preferenciaPanel;
    private javax.swing.JRadioButton reparoRadioButton;
    private javax.swing.JComboBox servicos_cadastradosComboBox;
    private javax.swing.JLabel servicos_cadastradosLabel;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusLabel;
    private javax.swing.ButtonGroup tarefaRealizadaButtonGroup;
    private javax.swing.JRadioButton telefoneRadioButton;
    private javax.swing.JLabel tipo_servicoLabel;
    // End of variables declaration//GEN-END:variables
}
