package interfaces;

import controle.ControladorCadastroClientes;
import entidade.Cliente;
import entidade.Cliente.preferencia_contato;
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

    Cliente[] visoes = Cliente.getVisoes();
    private void inicializarListaClientes() {
        modelo_lista_clientes = (DefaultListModel) clientes_cadastradosList.getModel();
        for (Cliente visao : visoes) {
            modelo_lista_clientes.addElement(visao);
        }
    }

    private void limparCampos() {
        cpfTextField.setText("");
        telefoneTextField.setText("");
        nomeTextField.setText("");
        emailTextField.setText("");
        preferenciaContatobuttonGroup.clearSelection();

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
        String email = emailTextField.getText();
        if(email.isEmpty()){
            return null;
        }
        preferencia_contato preferencia = null;
        if(preferenciaContatobuttonGroup.getSelection() != null){
            preferencia = preferencia_contato.values()[preferenciaContatobuttonGroup.getSelection().getMnemonic()];
        }
        
        return new Cliente(cpf, telefone, nome, email, preferencia);
    }
    
        public preferencia_contato getSelectedpreferencia_contato(){
        preferencia_contato preferenciaContato = null;
        if (preferenciaContatobuttonGroup.getSelection() != null)
            preferenciaContato = preferencia_contato.values()[preferenciaContatobuttonGroup.getSelection().getMnemonic()];
        return preferenciaContato;
    }
    
    public void setSelectedpreferenciaContato(int indice_preferencia){
        switch(indice_preferencia){
            case 0: emailRadioButton.setSelected(true);break;
            case 1: telefoneRadioButton.setSelected(true);;
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        preferenciaContatobuttonGroup = new javax.swing.ButtonGroup();
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
        emailLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JFormattedTextField();
        preferenciaContatoLabel = new javax.swing.JLabel();
        emailRadioButton = new javax.swing.JRadioButton();
        telefoneRadioButton = new javax.swing.JRadioButton();

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

        emailLabel.setText("E-mail");

        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });

        preferenciaContatoLabel.setText("Preferencia De Contato:");

        preferenciaContatobuttonGroup.add(emailRadioButton);
        emailRadioButton.setText("E-mail");
        emailRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailRadioButtonActionPerformed(evt);
            }
        });

        preferenciaContatobuttonGroup.add(telefoneRadioButton);
        telefoneRadioButton.setMnemonic(1);
        telefoneRadioButton.setText("Telefone");
        telefoneRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telefoneRadioButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(clientes_cadastradosLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(filmes_cadastradosScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(preferenciaContatoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emailRadioButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(telefoneRadioButton))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nomeLabel)
                                        .addComponent(cpfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(22, 22, 22))
                                .addComponent(telefoneLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(telefoneTextField))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(12, 12, 12)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(nomeTextField)
                                        .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
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
                                    .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(emailTextField)))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(filmes_cadastradosScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(clientes_cadastradosLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cpfLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telefoneTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telefoneLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailRadioButton)
                    .addComponent(telefoneRadioButton)
                    .addComponent(preferenciaContatoLabel))
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(comandosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inserir_clienteButton)
                        .addComponent(consultar_clienteButton)
                        .addComponent(alterar_clienteButton)
                        .addComponent(remover_clienteButton)
                        .addComponent(limpar_camposButton)))
                .addContainerGap())
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

        
private Cliente getVisaoAlterada(String cpf){
        for (Cliente visao : visoes){
            if (visao.getCpf().equals(cpf)) return visao;
        }
        return null;
    }
    
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
            emailTextField.setText(cliente.getEmail());
            setSelectedpreferenciaContato(cliente.getPreferencia().ordinal());
        } else {
            informarErro(mensagem_erro);
        }
    }//GEN-LAST:event_consultarCliente
    
    private void alterarCliente(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarCliente
        Cliente cliente = obterClienteInformado();
        String mensagem_erro = null;
        if (cliente != null) mensagem_erro = controlador.alterarCliente(cliente); 
        else mensagem_erro = "Algum atributo do cliente não foi informado";
        if (mensagem_erro == null) {
            Cliente visao = getVisaoAlterada(cliente.getCpf());
            if (visao != null) {
                visao.setNome(cliente.getNome());
                visao.setCpf(cliente.getCpf());
                modelo_lista_clientes.set(modelo_lista_clientes.size() -1, visao);
                clientes_cadastradosList.setSelectedIndex(modelo_lista_clientes.size() -1);
            }
        } else informarErro (mensagem_erro);
        
        /*
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
        */
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

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void emailRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailRadioButtonActionPerformed

    private void telefoneRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telefoneRadioButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telefoneRadioButtonActionPerformed

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
    private javax.swing.JLabel emailLabel;
    private javax.swing.JRadioButton emailRadioButton;
    private javax.swing.JFormattedTextField emailTextField;
    private javax.swing.JScrollPane filmes_cadastradosScrollPane;
    private javax.swing.JButton inserir_clienteButton;
    private javax.swing.JButton limpar_camposButton;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JFormattedTextField nomeTextField;
    private javax.swing.JLabel preferenciaContatoLabel;
    private javax.swing.ButtonGroup preferenciaContatobuttonGroup;
    private javax.swing.JButton remover_clienteButton;
    private javax.swing.JLabel telefoneLabel;
    private javax.swing.JRadioButton telefoneRadioButton;
    private javax.swing.JFormattedTextField telefoneTextField;
    // End of variables declaration//GEN-END:variables
private void informarSucesso(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "informação", JOptionPane.INFORMATION_MESSAGE);
    }

    private void informarErro(String mensagem) {
        JOptionPane.showMessageDialog(this, mensagem, "ERRO", JOptionPane.ERROR_MESSAGE);
    }

}
