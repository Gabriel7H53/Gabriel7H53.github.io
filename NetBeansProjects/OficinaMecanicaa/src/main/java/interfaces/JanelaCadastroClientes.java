package interfaces;

import controle.ControladorCadastroClientes;
import entidade.Cliente;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class JanelaCadastroClientes extends javax.swing.JFrame {

    ControladorCadastroClientes controlador;
    DefaultListModel modelo_lista_clientes;

    public JanelaCadastroClientes(ControladorCadastroClientes controlador) {
        this.controlador = controlador;
        initComponents();
        inicializarListaClientes();
        limparCampos();
    }

    private void inicializarListaClientes() {
        modelo_lista_clientes = (DefaultListModel) clientes_cadastradosList.getModel();
        Cliente[] visoes = Cliente.getVisoes();
        for (Cliente visao : visoes) {
            modelo_lista_clientes.addElement(visao);
        }
    }

    private void limparCampos() {
        cpfTextField.setText("");
        telefoneTextField.setText("");
        nomeTextField.setText("");

    }

    private Cliente obterClienteInformado() {
        String cpf = cpfTextField.getText();
        if (cpf.isEmpty()) {
            return null;
        }
        String telefone = telefoneTextField.getText();
        if (telefone.isEmpty()) {
            return null;
        }
        String nome = nomeTextField.getText();
        if (nome.isEmpty()) {
            return null;
        }
        return new Cliente(cpf, telefone, nome);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filmes_cadastradosScrollPane = new javax.swing.JScrollPane();
        clientes_cadastradosList = new javax.swing.JList();
        clientes_cadastradosLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        cpfTextField = new javax.swing.JTextField();
        telefoneLabel = new javax.swing.JLabel();
        comandosPanel = new javax.swing.JPanel();
        nomeLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JFormattedTextField();
        inserir_clienteButton = new javax.swing.JButton();
        consultar_clienteButton = new javax.swing.JButton();
        alterar_clienteButton = new javax.swing.JButton();
        remover_clienteButton = new javax.swing.JButton();
        limpar_camposButton = new javax.swing.JButton();
        telefoneTextField = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastrar Clientes");

        filmes_cadastradosScrollPane.setPreferredSize(new java.awt.Dimension(400, 20));

        clientes_cadastradosList.setModel(new DefaultListModel());
        clientes_cadastradosList.setToolTipText("");
        filmes_cadastradosScrollPane.setViewportView(clientes_cadastradosList);

        clientes_cadastradosLabel.setText("Clientes Cadastrados");

        cpfLabel.setText("Cpf");

        cpfTextField.setColumns(50);
        cpfTextField.setPreferredSize(new java.awt.Dimension(400, 20));
        cpfTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpfTextFieldActionPerformed(evt);
            }
        });

        telefoneLabel.setText("Telefone");

        nomeLabel.setText("Nome");

        nomeTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTextFieldActionPerformed(evt);
            }
        });

        inserir_clienteButton.setText("Inserir");
        inserir_clienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inserirCliente(evt);
            }
        });

        consultar_clienteButton.setText("Consultar");
        consultar_clienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarCliente(evt);
            }
        });

        alterar_clienteButton.setText("Alterar");
        alterar_clienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarCliente(evt);
            }
        });

        remover_clienteButton.setText("Remover");
        remover_clienteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerCliente(evt);
            }
        });

        limpar_camposButton.setText("Limpar");
        limpar_camposButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparCampos(evt);
            }
        });

        telefoneTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(78, 78, 78)
                .addComponent(inserir_clienteButton)
                .addGap(29, 29, 29)
                .addComponent(consultar_clienteButton)
                .addGap(29, 29, 29)
                .addComponent(alterar_clienteButton)
                .addGap(21, 21, 21)
                .addComponent(remover_clienteButton)
                .addGap(29, 29, 29)
                .addComponent(limpar_camposButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(167, 167, 167))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientes_cadastradosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filmes_cadastradosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nomeLabel)
                                    .addComponent(cpfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22))
                            .addComponent(telefoneLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nomeTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(telefoneTextField)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filmes_cadastradosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(clientes_cadastradosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cpfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(cpfTextField, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                    .addComponent(nomeTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inserir_clienteButton)
                        .addComponent(consultar_clienteButton)
                        .addComponent(alterar_clienteButton)
                        .addComponent(remover_clienteButton)
                        .addComponent(limpar_camposButton)))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inserirCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inserirCliente
        Cliente cliente = obterClienteInformado();
        String mensagem_erro = null;
        if (cliente != null) {
            mensagem_erro = controlador.inserirCliente(cliente);
        } else {
            mensagem_erro = "Algum atributo do cliente nao foi informado";
        }
        if (mensagem_erro == null) {;
            modelo_lista_clientes.addElement(cliente.getVisao());
            clientes_cadastradosList.setSelectedIndex(modelo_lista_clientes.size() - 1);
        } else {
            informarErro(mensagem_erro);
        }

    }//GEN-LAST:event_inserirCliente

    private void consultarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarCliente
        Cliente visao = (Cliente) clientes_cadastradosList.getSelectedValue();
        Cliente cliente = null;
        String mensagem_erro = null;
        if (visao != null) {
            cliente = Cliente.buscarCliente(visao.getCpf());
            if (cliente == null) {
                mensagem_erro = "Cliente não cadastrado";
            }
        } else {
            mensagem_erro = "Nenhum cliente selecionado";
        }
        if (mensagem_erro == null) {
            cpfTextField.setText(cliente.getCpf());
            telefoneTextField.setText(cliente.getTelefone());
            nomeTextField.setText(cliente.getNome());
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarCliente
    
    private void alterarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarCliente
        Cliente cliente = obterClienteInformado();
        String mensagem_erro = null;
        if (cliente != null) {
            mensagem_erro = controlador.alterarCliente(cliente);
        } else {
            mensagem_erro = "Algum atributo do cliente nao foi informado";
        }
        if (mensagem_erro == null) {
            Cliente visao = (Cliente) clientes_cadastradosList.getSelectedValue();
            if (cliente != null) {
                visao.setNome(cliente.getNome());
                clientes_cadastradosList.updateUI();
            }
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_alterarCliente

    private void removerCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerCliente
        Cliente visao = (Cliente) clientes_cadastradosList.getSelectedValue();
        String mensagem_erro = null;
        if (visao != null) {
            mensagem_erro = controlador.removerCliente(visao.getCpf());
        } else {
            mensagem_erro = "Nenhum cliente selecionado";
        }
        if (mensagem_erro == null) {
            modelo_lista_clientes.removeElement(visao);
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_removerCliente

    private void limparCampos(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparCampos
        limparCampos();
    }//GEN-LAST:event_limparCampos

    private void cpfTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpfTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpfTextFieldActionPerformed

    private void nomeTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTextFieldActionPerformed

    private void telefoneTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneTextFieldActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar_clienteButton;
    private javax.swing.JLabel clientes_cadastradosLabel;
    private javax.swing.JList clientes_cadastradosList;
    private javax.swing.JPanel comandosPanel;
    private javax.swing.JButton consultar_clienteButton;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JScrollPane filmes_cadastradosScrollPane;
    private javax.swing.JButton inserir_clienteButton;
    private javax.swing.JButton limpar_camposButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JFormattedTextField nomeTextField;
    private javax.swing.JButton remover_clienteButton;
    private javax.swing.JLabel telefoneLabel;
    private javax.swing.JFormattedTextField telefoneTextField;
    // End of variables declaration//GEN-END:variables
private void informarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
    }

}
