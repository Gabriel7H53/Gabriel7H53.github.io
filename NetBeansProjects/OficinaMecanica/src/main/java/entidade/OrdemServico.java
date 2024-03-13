/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;

/**
 *
 * @author Gahen
 */
public class OrdemServico {

    public enum MetodoPagamento {
        Dinheiro, Pix, Credito, Debito, Transferencia
    };

    public enum TarefasRealizadas {
        Diagnostico, Reparo, Manutencao
    };

    private int sequencial;
    private Cliente cliente;
    private Servico servico;
    private TarefasRealizadas tarefasRealizadas;
    private MetodoPagamento metodoPagamento;

    public OrdemServico(int sequencial, Cliente cliente, Servico servico, TarefasRealizadas tarefasRealizadas, MetodoPagamento metodoPagamento) {
        this.sequencial = sequencial;
        this.cliente = cliente;
        this.servico = servico;
        this.tarefasRealizadas = tarefasRealizadas;
        this.metodoPagamento = metodoPagamento;
    }

    public OrdemServico(int sequencial, Cliente cliente, Servico servico) {
        this.sequencial = sequencial;
        this.cliente = cliente;
        this.servico = servico;
    }

    public OrdemServico(int sequencial) {
        this.sequencial = sequencial;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Servico getServico() {
        return servico;
    }

    public void setServico(Servico servico) {
        this.servico = servico;
    }

    public TarefasRealizadas getTarefasRealizadas() {
        return tarefasRealizadas;
    }

    public void setTarefasRealizadas(TarefasRealizadas tarefasRealizadas) {
        this.tarefasRealizadas = tarefasRealizadas;
    }

    public MetodoPagamento getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public String toString() {
        return "[" + sequencial + "] - " + cliente.toStringNome()+ " - " + servico.toStringOrdemServico(servico) + " - " + tarefasRealizadas + " - " + metodoPagamento;
    }

    

    public static OrdemServico[] getVisoes() {
        String sql = "SELECT Sequencial, ClienteID, ServicoID, TarefaRealizada, MetodoPagamento From ordemservicos";
        ResultSet lista_resultados = null;
        ArrayList<OrdemServico> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visoes.add(new OrdemServico(lista_resultados.getInt("Sequencial"),
                        Cliente.buscarCliente(lista_resultados.getString("ClienteID")).getVisao(),
                        Servico.buscarServico(lista_resultados.getInt("ServicoID")).getVisao(),
                        TarefasRealizadas.values()[lista_resultados.getInt("TarefaRealizada")],
                        MetodoPagamento.values()[lista_resultados.getInt("MetodoPagamento")]));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return visoes.toArray(new OrdemServico[visoes.size()]);
    }

    public OrdemServico getVisao() {
        return new OrdemServico(sequencial, cliente, servico, tarefasRealizadas, metodoPagamento);
    }

    public static boolean existeOrdemServicoInserir(String chave_cliente, int chave_servico) {
        String sql = "SELECT Sequencial FROM ordemservicos WHERE ClienteID = ? AND ServicoID = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, chave_cliente);
            comando.setInt(2, chave_servico);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return existe;
    }

    public static boolean existeOrdemServico(int sequencial) {
        String sql = "SELECT COUNT(Sequencial) FROM ordemservicos WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                existe = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return existe;
    }

    public static int ultimoSequencial() {
        String sql = "SELECT MAX(Sequencial)FROM ordemservicos";
        ResultSet lista_resultados = null;
        int sequencial = 0;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                sequencial = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return sequencial;
    }

    public static Cliente[] getVisaoClienteSelecionada() {
        String sql = "SELECT Cpf,Nome FROM clientes";
        ResultSet lista_resultados = null;
        ArrayList<Cliente> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String cpf = lista_resultados.getString("Cpf");
                String nome = lista_resultados.getString("Nome");
                visoes.add(new Cliente(cpf, nome));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return visoes.toArray(new Cliente[visoes.size()]);
    }

    public static Servico[] getVisaoServicoSelecionada() {
        String sql = "SELECT Sequencial, Descricao FROM servicos";
        ResultSet lista_resultados = null;
        ArrayList<Servico> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visoes.add(new Servico(lista_resultados.getInt("Sequencial"), lista_resultados.getString("Descricao")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return visoes.toArray(new Servico[visoes.size()]);
    }

    public static OrdemServico getVisaoServicoSelecionado(OrdemServico ordemServico) {

        return ordemServico;
    }

    public static ArrayList<OrdemServico> pesquisarAvaliacoes(String chave_cliente, int chave_servico, int preferenciaContato,
            Servico.Status status_servico, Pneus.marca_pneus marca_pneus,char possuiAjuste ,Suspensao.tipo_suspensao tipo_suspensao,
            MetodoPagamento metodo_pagamento, TarefasRealizadas tarefas_realizadas) {
        String sql = "SELECT Am.Cpf, Am.PreferenciaContato, F.Sequencial, F.Status,"
                + " Av.Sequencial, Av.MetodoPagamento, Av.TarefaRealizada"
                + " FROM clientes Am, servicos F, ordemservicos Av"
                + " WHERE Av.ClienteID = Am.Cpf AND Av.ServicoID = F.Sequencial";
        if (chave_cliente != null) {
            sql += " AND Am.Cpf = ?";
        }
        if (chave_servico > -1) {
            sql += " AND F.Sequencial = ?";
        }
        if (preferenciaContato != '3') {
            sql += " AND Am.PreferenciaContato = ?";
        }
        if (status_servico != null) {
            sql += " AND F.Status = ?";
        }
        if (metodo_pagamento != null) {
            sql += " AND Av.MetodoPagamento = ?";
        }
        if (tarefas_realizadas != null) {
            sql += " AND Av.TarefaRealizada = ?";
        }
        sql += " ORDER BY Av.Sequencial";
        ResultSet lista_resultados = null;
        ArrayList<OrdemServico> ordem_servico_selecionadas = new ArrayList();
        int index = 0;
        int sequencial_servico = -1;

        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            if (chave_cliente != null) {
                comando.setString(++index, chave_cliente);
            }
            if (chave_servico > -1) {
                comando.setInt(++index, chave_servico);
            }
            if (preferenciaContato != '3') {
                comando.setString(++index, preferenciaContato + "");
            }
            if (status_servico != null) {
                comando.setInt(++index, status_servico.ordinal());
            }
            if (metodo_pagamento != null) {
                comando.setInt(++index, metodo_pagamento.ordinal());
            }
            if (tarefas_realizadas != null) {
                comando.setInt(++index, tarefas_realizadas.ordinal());
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                OrdemServico ordem_pesquisada = OrdemServico.buscarOrdemServico(lista_resultados.getInt(5));
                sequencial_servico = lista_resultados.getInt(3);
                if (marca_pneus != null) {
                    if (isOkPesquisaEmServicoPneus(sequencial_servico, marca_pneus)) {
                        ordem_servico_selecionadas.add(ordem_pesquisada);
                    }
                } else if (possuiAjuste != 'X') {
                    if (isOkPesquisaEmServicoMotor(sequencial_servico, possuiAjuste)) {
                        ordem_servico_selecionadas.add(ordem_pesquisada);
                    }
                } else if (tipo_suspensao != null) {
                    if (isOkPesquisaEmServicoSuspensao(sequencial_servico, tipo_suspensao)) {
                        ordem_servico_selecionadas.add(ordem_pesquisada);
                    }
                } 
                else {
                    ordem_servico_selecionadas.add(ordem_pesquisada);
                }
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return ordem_servico_selecionadas;
    }

    private static boolean isOkPesquisaEmServicoMotor(int sequencial_serviço, char possuiAjuste){
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM servicoreparomotor WHERE ServicoID = ?";
        if(possuiAjuste != 'X') sql += " AND AjusteValvula = ?";
        ResultSet lista_resultados = null;
        int index = 1;
       try{
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial_serviço);
            switch(possuiAjuste){
                case 'T': comando.setBoolean(++index, true); break;
                case 'F': comando.setBoolean(++index, false);
            }
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()) pesquisa_ok = true;
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql)
            {exceção_sql.printStackTrace();}
            return pesquisa_ok;
    }

    private static boolean isOkPesquisaEmServicoPneus(int sequencial_servico, Pneus.marca_pneus marca_pneus) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM servicotrocapneus WHERE ServicoID = ?";
        if (marca_pneus != null) {
            sql += " AND MarcaPneu = ? ";
        }
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial_servico);
            if (marca_pneus != null) {
                comando.setInt(++index, marca_pneus.ordinal());
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                pesquisa_ok = true;
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return pesquisa_ok;
    }
    
        private static boolean isOkPesquisaEmServicoSuspensao(int sequencial_serviço, Suspensao.tipo_suspensao tipo_suspensao){
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM servicorevisaosuspensao WHERE ServicoID = ?";
        if(tipo_suspensao != null) sql += " AND TipoSuspensao = ?";
        ResultSet lista_resultados = null;
       try{
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial_serviço);
            comando.setObject(2, tipo_suspensao.ordinal());
            lista_resultados = comando.executeQuery();
            while(lista_resultados.next()) pesquisa_ok = true;
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql)
            {exceção_sql.printStackTrace();}
        return pesquisa_ok;
    }

    public static OrdemServico buscarOrdemServico(int sequencial) {
        String sql = "SELECT * FROM ordemservicos WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        OrdemServico ordemservico = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                TarefasRealizadas tarefasrealizadas = null;
                if (lista_resultados.getInt("TarefaRealizada") > -1) {
                    tarefasrealizadas = TarefasRealizadas.values()[lista_resultados.getInt("TarefaRealizada")];
                }
                ordemservico = new OrdemServico(sequencial,
                        Cliente.buscarCliente(lista_resultados.getString("ClienteID")),
                        Servico.buscarServico(lista_resultados.getInt("ServicoID")),
                        tarefasrealizadas,
                        MetodoPagamento.values()[lista_resultados.getInt("MetodoPagamento")]);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            ordemservico = null;
        }
        return ordemservico;
    }

    public static String inserirOrdemServico(OrdemServico ordemservico) {
        String sql = "INSERT INTO ordemservicos (ClienteID, ServicoID, TarefaRealizada,"
                + " MetodoPagamento) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, ordemservico.getCliente().getCpf());
            comando.setInt(2, ordemservico.getServico().getSequencial());
            int indice_tarefa = -1;
            if (ordemservico.getTarefasRealizadas() != null) {
                indice_tarefa = ordemservico.getTarefasRealizadas().ordinal();
            }
            comando.setInt(3, indice_tarefa);
            comando.setInt(4, ordemservico.getMetodoPagamento().ordinal());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na insercao da ordem de servico no BD";
        }
    }

    public static String alterarOrdemServico(OrdemServico ordemservico) {
        String sql = "UPDATE ordemservicos SET ClienteID = ?, ServicoID = ?, TarefaRealizada = ?, "
                + "MetodoPagamento = ?"
                + " WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, ordemservico.getCliente().getCpf());
            comando.setInt(2, ordemservico.getServico().getSequencial());
            int indice_tarefa = -1;
            if (ordemservico.getTarefasRealizadas() != null) {
                indice_tarefa = ordemservico.getTarefasRealizadas().ordinal();
            }
            comando.setInt(3, indice_tarefa);
            comando.setInt(4, ordemservico.getMetodoPagamento().ordinal());
            comando.setInt(5, ordemservico.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na Alteração da ordem de servico no BD";
        }
    }

    public static String removerOrdemServico(int sequencial) {

        String sql = "DELETE FROM ordemservicos WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoção da ordem de servico no BD";
        }
        return null;
    }

    public String toStringFull() {
        String str = servico.toStringFull() + " --- " + cliente.toStringFull() + "\n   ";
        if (tarefasRealizadas != null) {
            switch (tarefasRealizadas) {
                case Diagnostico:
                    str += "Tipo de servico - [Diagnostico] --- ";
                    break;
                case Reparo:
                    str += "Tipo de servico - [Reparo] --- ";
                    break;
                case Manutencao:
                    str += "Tipo de servico - [Manutencao] --- ";
            }
        }
        str += "Metodo de Pagamento [" + metodoPagamento + "]";
        return str;
    }
}
