package interfaces;

import entidade.Amigo;
import entidade.Amigo.EstadoCivil;
import entidade.Avaliacao;
import entidade.Avaliacao.Classificacao;
import entidade.Avaliacao.Preferencia;
import entidade.Filme;
import entidade.Filme.Genero;
import javax.swing.DefaultComboBoxModel;
import entidade.FilmeProvedoraStreaming.Producao;
import java.sql.Timestamp;
import java.util.ArrayList;

public class JanelaPesquisaAvaliacoes extends javax.swing.JFrame {

    Amigo[] amigos_cadastrados;
    Filme[] filmes_cadastrados;
    PainelFiltrosFilmeCompanhiaCinematografica filtros_filme_companhia_cinematograficaPainel;
    PainelFiltrosFilmeProvedoraStreaming filtros_filme_provedora_streamingPainel;

    public JanelaPesquisaAvaliacoes() {
        amigos_cadastrados = Amigo.getVisoes();
        filmes_cadastrados = Filme.getVisoes();
        initComponents();
        filtros_filme_companhia_cinematograficaPainel = new PainelFiltrosFilmeCompanhiaCinematografica();
        filtros_filme_provedora_streamingPainel = new PainelFiltrosFilmeProvedoraStreaming();
        filtros_especificos_filmeTabbedPane.addTab("Filtros de filmes companhia cinematografica",
                filtros_filme_companhia_cinematograficaPainel);
        filtros_especificos_filmeTabbedPane.addTab("Filtros de filmes provedora streaming",
                filtros_filme_provedora_streamingPainel);
        limparFiltros(null);
    }

    private Timestamp getDataMinima() {
        Timestamp data_minima = null;
        String data_minima_str = data_minimaTextField.getText();
        if (!data_minima_str.isEmpty()) {
            String[] data_minima_partes = data_minima_str.toString().split("/");
            String dia = data_minima_partes[0];
            String mes = data_minima_partes[1];
            String ano = data_minima_partes[2];
            if ((dia.length() == 2) && (mes.length() == 2) && (ano.length() == 4)) {
                data_minima_str = ano + "-" + mes + "-" + dia + " 00:00:00";
                data_minima = Timestamp.valueOf(data_minima_str);
            }
        }
        return data_minima;
    }

    private void mostrarAvaliacoesSelecionadas(ArrayList<Avaliacao> avaliacoes) {
        boolean primeira_avaliacao = true;
        for (Avaliacao avaliacao : avaliacoes) {
            if (primeira_avaliacao) {
                pesquisasTextArea.append(avaliacao.toStringFull());
                primeira_avaliacao = false;
            } else {
                pesquisasTextArea.append("\n" + avaliacao.toStringFull());
            }
        }
    }

    public static String formatarDataHora(String data_hora_bd) {
        String[] data_hora = data_hora_bd.split(" ");
        String[] ano_mes_dia = data_hora[0].split("-");
        String[] hora_minuto_resto = data_hora[1].split(":");
        String data_hora_formatada = ano_mes_dia[2] + "/" + ano_mes_dia[1] + "/" + ano_mes_dia[0] + " " + hora_minuto_resto[0] + ":" + hora_minuto_resto[1] + "hs";
        return data_hora_formatada;
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        sexoButtonGroup = new javax.swing.ButtonGroup();
        estado_civilButtonGroup = new javax.swing.ButtonGroup();
        preferenciaButtonGroup = new javax.swing.ButtonGroup();
        filtros_amigosPanel = new javax.swing.JPanel();
        amigos_cadastradosComboBox = new javax.swing.JComboBox();
        amigos_cadastradosLabel = new javax.swing.JLabel();
        sexoPanel1 = new javax.swing.JPanel();
        sexoLabel = new javax.swing.JLabel();
        masculinoRadioButton1 = new javax.swing.JRadioButton();
        femininoRadioButton1 = new javax.swing.JRadioButton();
        estado_civilPanel1 = new javax.swing.JPanel();
        casadoRadioButton1 = new javax.swing.JRadioButton();
        solteiroRadioButton1 = new javax.swing.JRadioButton();
        divorciadoRadioButton1 = new javax.swing.JRadioButton();
        viuvoRadioButton1 = new javax.swing.JRadioButton();
        estado_civilLabel = new javax.swing.JLabel();
        filtros_filmesPanel = new javax.swing.JPanel();
        filmes_cadastradosComboBox = new javax.swing.JComboBox();
        filmes_cadastradosLabel = new javax.swing.JLabel();
        generoComboBox = new javax.swing.JComboBox<>();
        gêneroLabel = new javax.swing.JLabel();
        anoTextField = new javax.swing.JFormattedTextField();
        anoLabel = new javax.swing.JLabel();
        filtros_especificos_filmeTabbedPane = new javax.swing.JTabbedPane();
        filtros_avaliacoesPanel = new javax.swing.JPanel();
        classificacao_tramaComboBox = new javax.swing.JComboBox<>();
        classificacao_tramaLabel = new javax.swing.JLabel();
        preferenciaLabel = new javax.swing.JLabel();
        preferenciaPanel = new javax.swing.JPanel();
        pioresRadioButton = new javax.swing.JRadioButton();
        melhoresRadioButton = new javax.swing.JRadioButton();
        data_minimaTextField = new javax.swing.JTextField();
        data_minimaLabel = new javax.swing.JLabel();
        avaliacacao_selecionadasPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pesquisasTextArea = new javax.swing.JTextArea();
        botaoPanel = new javax.swing.JPanel();
        pesquisarAvaliacoes = new javax.swing.JButton();
        limpar_FiltrosButton = new javax.swing.JButton();
        limpar_pesquisaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        filtros_amigosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros  Amigos"));
        filtros_amigosPanel.setToolTipText("Filtros de Amigos");

        amigos_cadastradosComboBox.setModel(new DefaultComboBoxModel(amigos_cadastrados));

        amigos_cadastradosLabel.setText("Amigos Cadastrados");

        sexoLabel.setText("Sexo");

        sexoButtonGroup.add(masculinoRadioButton1);
        masculinoRadioButton1.setMnemonic('M');
        masculinoRadioButton1.setText("masculino");

        sexoButtonGroup.add(femininoRadioButton1);
        femininoRadioButton1.setMnemonic('F');
        femininoRadioButton1.setText("feminino");

        estado_civilButtonGroup.add(casadoRadioButton1);
        casadoRadioButton1.setMnemonic('\u0001');
        casadoRadioButton1.setText("casado");

        estado_civilButtonGroup.add(solteiroRadioButton1);
        solteiroRadioButton1.setText("solteiro");

        estado_civilButtonGroup.add(divorciadoRadioButton1);
        divorciadoRadioButton1.setMnemonic('\u0002');
        divorciadoRadioButton1.setText("divorciado");

        estado_civilButtonGroup.add(viuvoRadioButton1);
        viuvoRadioButton1.setMnemonic('\u0003');
        viuvoRadioButton1.setText("viuvo");

        estado_civilLabel.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        estado_civilLabel.setText("Estado Civil");

        javax.swing.GroupLayout filtros_amigosPanelLayout = new javax.swing.GroupLayout(filtros_amigosPanel);
        filtros_amigosPanel.setLayout(filtros_amigosPanelLayout);
        filtros_amigosPanelLayout.setHorizontalGroup(
            filtros_amigosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_amigosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(amigos_cadastradosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(amigos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(filtros_amigosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filtros_amigosPanelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(estado_civilPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(filtros_amigosPanelLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(sexoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(masculinoRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(femininoRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(filtros_amigosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(filtros_amigosPanelLayout.createSequentialGroup()
                                .addComponent(sexoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, filtros_amigosPanelLayout.createSequentialGroup()
                                .addComponent(estado_civilLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(solteiroRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(casadoRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(divorciadoRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(viuvoRadioButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        filtros_amigosPanelLayout.setVerticalGroup(
            filtros_amigosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_amigosPanelLayout.createSequentialGroup()
                .addGroup(filtros_amigosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(filtros_amigosPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(filtros_amigosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amigos_cadastradosLabel)
                            .addComponent(amigos_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(masculinoRadioButton1)
                            .addComponent(femininoRadioButton1)
                            .addComponent(sexoLabel)
                            .addComponent(estado_civilLabel)
                            .addComponent(solteiroRadioButton1)
                            .addComponent(casadoRadioButton1)
                            .addComponent(divorciadoRadioButton1)
                            .addComponent(viuvoRadioButton1)))
                    .addGroup(filtros_amigosPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(sexoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(estado_civilPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipady = -56;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 12, 0, 12);
        getContentPane().add(filtros_amigosPanel, gridBagConstraints);

        filtros_filmesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtros de Clientes"));
        filtros_filmesPanel.setToolTipText("Filtros de Filmes");

        filmes_cadastradosComboBox.setModel(new DefaultComboBoxModel(filmes_cadastrados));

        filmes_cadastradosLabel.setText("Filmes Cadastrados");

        generoComboBox.setModel(new DefaultComboBoxModel (Genero.values()));

        gêneroLabel.setText("Gênero");

        anoLabel.setText("Ano");

        filtros_especificos_filmeTabbedPane.setPreferredSize(new java.awt.Dimension(600, 200));

        javax.swing.GroupLayout filtros_filmesPanelLayout = new javax.swing.GroupLayout(filtros_filmesPanel);
        filtros_filmesPanel.setLayout(filtros_filmesPanelLayout);
        filtros_filmesPanelLayout.setHorizontalGroup(
            filtros_filmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_filmesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filmes_cadastradosLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(filmes_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(gêneroLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(anoLabel)
                .addGap(18, 18, 18)
                .addComponent(anoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(filtros_especificos_filmeTabbedPane, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE))
        );
        filtros_filmesPanelLayout.setVerticalGroup(
            filtros_filmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_filmesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(filtros_filmesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filmes_cadastradosLabel)
                    .addComponent(filmes_cadastradosComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(gêneroLabel)
                    .addComponent(generoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anoLabel)
                    .addComponent(anoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
            .addComponent(filtros_especificos_filmeTabbedPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 392;
        gridBagConstraints.ipady = 35;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 12);
        getContentPane().add(filtros_filmesPanel, gridBagConstraints);

        filtros_avaliacoesPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Filtro Avaliações"));

        classificacao_tramaComboBox.setModel(new DefaultComboBoxModel (Classificacao.values()));

        classificacao_tramaLabel.setText("Classificação da Trama");

        preferenciaLabel.setText("Preferencia");

        preferenciaButtonGroup.add(pioresRadioButton);
        pioresRadioButton.setMnemonic('\u0001');
        pioresRadioButton.setText("10 Piores");
        preferenciaPanel.add(pioresRadioButton);

        preferenciaButtonGroup.add(melhoresRadioButton);
        melhoresRadioButton.setText("10 Melhores");
        preferenciaPanel.add(melhoresRadioButton);

        data_minimaTextField.setColumns(50);

        data_minimaLabel.setText("Data Minima");

        javax.swing.GroupLayout filtros_avaliacoesPanelLayout = new javax.swing.GroupLayout(filtros_avaliacoesPanel);
        filtros_avaliacoesPanel.setLayout(filtros_avaliacoesPanelLayout);
        filtros_avaliacoesPanelLayout.setHorizontalGroup(
            filtros_avaliacoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_avaliacoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(classificacao_tramaLabel)
                .addGap(18, 18, 18)
                .addComponent(classificacao_tramaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(preferenciaLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(preferenciaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(data_minimaLabel)
                .addGap(18, 18, 18)
                .addComponent(data_minimaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        filtros_avaliacoesPanelLayout.setVerticalGroup(
            filtros_avaliacoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(filtros_avaliacoesPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(filtros_avaliacoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(filtros_avaliacoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(data_minimaLabel)
                        .addComponent(data_minimaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(preferenciaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(filtros_avaliacoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(classificacao_tramaLabel)
                        .addComponent(classificacao_tramaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(preferenciaLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 29;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 12);
        getContentPane().add(filtros_avaliacoesPanel, gridBagConstraints);

        avaliacacao_selecionadasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Avaliações Selecionadas"));

        pesquisasTextArea.setColumns(20);
        pesquisasTextArea.setRows(5);
        jScrollPane1.setViewportView(pesquisasTextArea);

        javax.swing.GroupLayout avaliacacao_selecionadasPanelLayout = new javax.swing.GroupLayout(avaliacacao_selecionadasPanel);
        avaliacacao_selecionadasPanel.setLayout(avaliacacao_selecionadasPanelLayout);
        avaliacacao_selecionadasPanelLayout.setHorizontalGroup(
            avaliacacao_selecionadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
        );
        avaliacacao_selecionadasPanelLayout.setVerticalGroup(
            avaliacacao_selecionadasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 749;
        gridBagConstraints.ipady = 172;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 12, 0, 12);
        getContentPane().add(avaliacacao_selecionadasPanel, gridBagConstraints);

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

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 38;
        gridBagConstraints.ipady = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 179, 13, 0);
        getContentPane().add(botaoPanel, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pesquisarAvaliacoes(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pesquisarAvaliacoes
        String chave_amigo = null;
        if (amigos_cadastradosComboBox.getSelectedItem() != null) {
            chave_amigo = ((Amigo) amigos_cadastradosComboBox.getSelectedItem()).getNome();
        }
        int chave_filme = -1;
        if (filmes_cadastradosComboBox.getSelectedItem() != null) {
            chave_filme = ((Filme) filmes_cadastradosComboBox.getSelectedItem()).getSequencial();
        }
        char sexo_amigo = 'X';
        if (sexoButtonGroup.getSelection() != null) {
            sexo_amigo = (char) sexoButtonGroup.getSelection().getMnemonic();
        }
        EstadoCivil estado_civil_amigo = null;
        if (estado_civilButtonGroup.getSelection() != null) {
            estado_civil_amigo = EstadoCivil.values()[estado_civilButtonGroup.getSelection().getMnemonic()];
        }
        Genero genero_filme = null;
        if (generoComboBox.getSelectedItem() != null) {
            genero_filme = (Genero) generoComboBox.getSelectedItem();
        }
        int ano_filme = -1;
        if (!anoTextField.getText().isEmpty()) {
            ano_filme = Integer.parseInt(anoTextField.getText());
        }
        char oscar_melhor_filme = 'X';
        Producao producao_filme = null;
        int indice_aba_selecionada = filtros_especificos_filmeTabbedPane.getSelectedIndex();
        if (indice_aba_selecionada == 0) {
            oscar_melhor_filme = filtros_filme_companhia_cinematograficaPainel.getOscarMelhorFilme();
        } else if (indice_aba_selecionada == 1) {
            producao_filme = filtros_filme_provedora_streamingPainel.getSelectedProducao();
        }
        Classificacao classificacao_trama = (Classificacao) classificacao_tramaComboBox.getSelectedItem();
        Preferencia preferencia = null;
        if (preferenciaButtonGroup.getSelection() != null) {
            preferencia = Preferencia.values()[preferenciaButtonGroup.getSelection().getMnemonic()];
        }
        Timestamp data_minima = getDataMinima();
        ArrayList<Avaliacao> avaliacoes = Avaliacao.pesquisarAvaliacoes(chave_amigo, chave_filme,
                sexo_amigo, estado_civil_amigo, genero_filme, ano_filme, oscar_melhor_filme, producao_filme,
                classificacao_trama, preferencia, data_minima);
        mostrarAvaliacoesSelecionadas(avaliacoes);
    }//GEN-LAST:event_pesquisarAvaliacoes

    private void limparFiltros(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparFiltros
        amigos_cadastradosComboBox.setSelectedIndex(-1);
        filmes_cadastradosComboBox.setSelectedIndex(-1);
        sexoButtonGroup.clearSelection();
        estado_civilButtonGroup.clearSelection();
        generoComboBox.setSelectedIndex(-1);
        anoTextField.setText("");
        classificacao_tramaComboBox.setSelectedIndex(-1);
        preferenciaButtonGroup.clearSelection();
        data_minimaTextField.setText("");
        filtros_filme_companhia_cinematograficaPainel.limparFiltros();
        filtros_filme_provedora_streamingPainel.limparFiltros();
    }//GEN-LAST:event_limparFiltros

    private void limparAvaliacoesSelecionadas(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparAvaliacoesSelecionadas
        pesquisasTextArea.setText("");
    }//GEN-LAST:event_limparAvaliacoesSelecionadas

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPesquisaAvaliacoes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox amigos_cadastradosComboBox;
    private javax.swing.JLabel amigos_cadastradosLabel;
    private javax.swing.JLabel anoLabel;
    private javax.swing.JFormattedTextField anoTextField;
    private javax.swing.JPanel avaliacacao_selecionadasPanel;
    private javax.swing.JPanel botaoPanel;
    private javax.swing.JRadioButton casadoRadioButton1;
    private javax.swing.JComboBox<String> classificacao_tramaComboBox;
    private javax.swing.JLabel classificacao_tramaLabel;
    private javax.swing.JLabel data_minimaLabel;
    private javax.swing.JTextField data_minimaTextField;
    private javax.swing.JRadioButton divorciadoRadioButton1;
    private javax.swing.ButtonGroup estado_civilButtonGroup;
    private javax.swing.JLabel estado_civilLabel;
    private javax.swing.JPanel estado_civilPanel1;
    private javax.swing.JRadioButton femininoRadioButton1;
    private javax.swing.JComboBox filmes_cadastradosComboBox;
    private javax.swing.JLabel filmes_cadastradosLabel;
    private javax.swing.JPanel filtros_amigosPanel;
    private javax.swing.JPanel filtros_avaliacoesPanel;
    private javax.swing.JTabbedPane filtros_especificos_filmeTabbedPane;
    private javax.swing.JPanel filtros_filmesPanel;
    private javax.swing.JComboBox<String> generoComboBox;
    private javax.swing.JLabel gêneroLabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limpar_FiltrosButton;
    private javax.swing.JButton limpar_pesquisaButton;
    private javax.swing.JRadioButton masculinoRadioButton1;
    private javax.swing.JRadioButton melhoresRadioButton;
    private javax.swing.JButton pesquisarAvaliacoes;
    private javax.swing.JTextArea pesquisasTextArea;
    private javax.swing.JRadioButton pioresRadioButton;
    private javax.swing.ButtonGroup preferenciaButtonGroup;
    private javax.swing.JLabel preferenciaLabel;
    private javax.swing.JPanel preferenciaPanel;
    private javax.swing.ButtonGroup sexoButtonGroup;
    private javax.swing.JLabel sexoLabel;
    private javax.swing.JPanel sexoPanel1;
    private javax.swing.JRadioButton solteiroRadioButton1;
    private javax.swing.JRadioButton viuvoRadioButton1;
    // End of variables declaration//GEN-END:variables
}
