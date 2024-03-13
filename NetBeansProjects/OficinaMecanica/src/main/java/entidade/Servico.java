package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;
import entidade.Motor.componente_reparado;
import entidade.Pneus.marca_pneus;
import entidade.Motor;
import entidade.Suspensao.tipo_suspensao;

public class Servico {

    public enum Status {
        andamento, concluido, cancelado;
    }
    protected Status status;
    protected String descricao, custo;
    protected int sequencial;

    public static boolean existeServicoMesmosAtributos(Servico servico) {
        String sql = "SELECT COUNT(Sequencial) FROM servicos WHERE Descricao = ? AND Custo = ? AND Status = ?";
        ResultSet lista_resultados = null;
        int n_servicos_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, servico.getDescricao());
            comando.setString(2, servico.getCusto());
            comando.setInt(3, servico.getStatus().ordinal());

            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                n_servicos_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        if (n_servicos_mesmos_atributos > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int últimoSequencial() {
        String sql = "SELECT MAX(Sequencial)FROM servicos";
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

    public Servico(int sequencial, String descricao, String custo, Status status) {
        this.sequencial = sequencial;
        this.descricao = descricao;
        this.custo = custo;
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Servico(int sequencial, String custo) {
        this.sequencial = sequencial;
        this.custo = custo;
    }

    public Servico(int sequencial) {
        this.sequencial = sequencial;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getCusto() {
        return custo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setCusto(String custo) {
        this.custo = custo;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public Servico getVisao() {
        return new Servico(sequencial);
    }

    /*
        public static Servico[] getVisoes(){
        String sql = "SELECT Sequencial,Descricao FROM servicos";
        ResultSet lista_resultados = null;
        ArrayList<Servico> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visoes.add(new Servico(lista_resultados.getInt("Sequencial"),
                                     lista_resultados.getString("Descricao")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return visoes.toArray(new Servico[visoes.size()]);
    }


     */
    public static Servico[] getVisoes() {

        String sql = "SELECT s.Sequencial, s.Descricao, s.Custo, s.Status, "
                + "r.ComponenteReparado, r.RestauracaoMotor, r.AjusteValvula, r.RelatorioTecnico, "
                + "v.TipoSuspensao, v.TrocaMola, v.VazamentoFluido, "
                + "p.MarcaPneu, p.Quantidade, p.Balanceamento, p.Alinhamento "
                + "FROM servicos s "
                + "LEFT JOIN servicoreparomotor r ON s.Sequencial = r.ServicoID "
                + "LEFT JOIN servicotrocapneus p ON s.Sequencial = p.ServicoID "
                + "LEFT JOIN servicorevisaosuspensao v ON s.Sequencial = v.ServicoID";

        ResultSet resultados = null;
        ArrayList<Servico> Visoes = new ArrayList<>();

        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            resultados = comando.executeQuery();

            while (resultados.next()) {
                int sequencial = resultados.getInt("Sequencial");
                String descricao = resultados.getString("Descricao");
                String custo = resultados.getString("Custo");
                Status status = Status.values()[resultados.getInt("Status")];

                componente_reparado componenteReparado = componente_reparado.values()[resultados.getInt("ComponenteReparado")];
                boolean restauracaoMotor = resultados.getBoolean("RestauracaoMotor");
                boolean ajusteValvula = resultados.getBoolean("AjusteValvula");
                String relatorioTecnico = resultados.getString("RelatorioTecnico");

                tipo_suspensao tipoSuspensao = tipo_suspensao.values()[resultados.getInt("TipoSuspensao")];
                boolean trocaMola = resultados.getBoolean("TrocaMola");
                boolean vazamentoFluido = resultados.getBoolean("VazamentoFluido");

                marca_pneus marcaPneu = marca_pneus.values()[resultados.getInt("MarcaPneu")];
                int quantidadePneu = resultados.getInt("Quantidade");
                boolean balanceamento = resultados.getBoolean("Balanceamento");
                boolean alinhamento = resultados.getBoolean("Alinhamento");

                Servico servico;
                if (relatorioTecnico != null) {
                    servico = new Motor(sequencial, descricao, custo, status,
                            componenteReparado, restauracaoMotor, ajusteValvula, relatorioTecnico);
                } else if (quantidadePneu != 0) {
                    servico = new Pneus(sequencial, descricao, custo, status, marcaPneu, quantidadePneu,
                            balanceamento, alinhamento);
                    
                } else {
                    servico = new Suspensao(sequencial, descricao, custo, status, tipoSuspensao,
                            trocaMola, vazamentoFluido);

                }
                Visoes.add(servico);
            }
            resultados.close();
            comando.close();

        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }

        return Visoes.toArray(new Servico[Visoes.size()]);
    }

    public static Servico buscarServico(int sequencial) {
        String sql = null;
        ResultSet lista_resultados = null;
        sql = "SELECT * FROM servicos WHERE Sequencial = ?";
        String descricao = null;
        String custo = null;
        Status status = null;

        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                descricao = lista_resultados.getString("Descricao");
                custo = lista_resultados.getString("Custo");
                status = Status.values()[lista_resultados.getInt("Status")];
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            if (descricao == null) {
                return null;
            }
        }
        sql = "SELECT ComponenteReparado,RestauracaoMotor,AjusteValvula,RelatorioTecnico"
                + " FROM servicoreparomotor WHERE ServicoID = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new Motor(sequencial, descricao, custo, status,
                        componente_reparado.values()[lista_resultados.getInt("ComponenteReparado")],
                        lista_resultados.getBoolean("RestauracaoMotor"),
                        lista_resultados.getBoolean("AjusteValvula"),
                        lista_resultados.getString("RelatorioTecnico"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

        sql = "SELECT TipoSuspensao, TrocaMola, VazamentoFluido FROM servicorevisaosuspensao "
                + "WHERE ServicoID = ?";

        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return (new Suspensao(sequencial, descricao, custo, status,
                        tipo_suspensao.values()[lista_resultados.getInt("TipoSuspensao")],
                        lista_resultados.getBoolean("TrocaMola"),
                        lista_resultados.getBoolean("VazamentoFluido")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        sql = "SELECT MarcaPneu, Quantidade, Balanceamento, Alinhamento FROM servicotrocapneus "
                + "WHERE ServicoID = ?";

        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return (new Pneus(sequencial, descricao, custo, status,
                        marca_pneus.values()[lista_resultados.getInt("MarcaPneu")],
                        lista_resultados.getInt("Quantidade"),
                        lista_resultados.getBoolean("Balanceamento"),
                        lista_resultados.getBoolean("Alinhamento")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        return null;
    }

    public static String inserirServico(Servico servico) {

        String sql = "INSERT INTO servicos (Descricao, Custo, Status)" + " Values (?,?,?)";

        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, servico.getDescricao());
            comando.setString(2, servico.getCusto());
            comando.setInt(3, servico.getStatus().ordinal());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na inserçao do servico no BD";
        }

        int sequencial = últimoSequencial();

        if (servico instanceof Motor) {
            Motor servico_reparo_motor
                    = (Motor) servico;
            sql = "INSERT INTO servicoreparomotor (ComponenteReparado, RestauracaoMotor,"
                    + " AjusteValvula, RelatorioTecnico, ServicoID) VALUES (?,?,?,?,?)";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, servico_reparo_motor.getComponente().ordinal());
                comando.setBoolean(2, servico_reparo_motor.isRestauracao_motor());
                comando.setBoolean(3, servico_reparo_motor.isAjuste_valvulas());
                comando.setString(4, servico_reparo_motor.getRelatorio_tecnico());
                comando.setInt(5, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Servico Reparo Motor no BD";
            }
        } else if (servico instanceof Suspensao) {
            Suspensao servico_reparo_suspensao = (Suspensao) servico;
            sql = "INSERT INTO servicorevisaosuspensao (TipoSuspensao, TrocaMola, VazamentoFluido,"
                    + " ServicoID) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, servico_reparo_suspensao.getTipo().ordinal());
                comando.setBoolean(2, servico_reparo_suspensao.isTroca_molas());
                comando.setBoolean(3, servico_reparo_suspensao.isVazamento_fluido());
                comando.setInt(4, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Servico Revisao Suspensao no BD";
            }
        } else if (servico instanceof Pneus) {
            Pneus servico_troca_pneus = (Pneus) servico;
            sql = "INSERT INTO servicotrocapneus (MarcaPneu, Quantidade, Balanceamento, Alinhamento,"
                    + " ServicoID) VALUES (?, ?, ?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, servico_troca_pneus.getMarca().ordinal());
                comando.setInt(2, servico_troca_pneus.getQtd());
                comando.setBoolean(3, servico_troca_pneus.isBalanceamento());
                comando.setBoolean(4, servico_troca_pneus.isAlinhamento());
                comando.setInt(5, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Servico Troca Pneus no BD";
            }
        }
        return null;

    }

    public static String alterarServico(Servico servico) {
        String sql = "UPDATE servicos SET Descricao = ?, Custo = ?, Status = ? " + " WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, servico.getDescricao());
            comando.setString(2, servico.getCusto());
            comando.setInt(3, servico.getStatus().ordinal());
            comando.setInt(4, servico.getSequencial());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na alteração do servico no BD";
        }

        if (servico instanceof Motor) {
            Motor servico_reparo_motor = (Motor) servico;

            sql = "UPDATE servicoreparomotor SET ComponenteReparado = ?, RestauracaoMotor = ?,"
                    + " AjusteValvula = ?, RelatorioTecnico = ? WHERE ServicoID = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, servico_reparo_motor.getComponente().ordinal());
                comando.setBoolean(2, servico_reparo_motor.isRestauracao_motor());
                comando.setBoolean(3, servico_reparo_motor.isAjuste_valvulas());
                comando.setString(4, servico_reparo_motor.getRelatorio_tecnico());
                comando.setInt(5, servico_reparo_motor.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Servico Reparo Motor no BD";
            }
        } else if (servico instanceof Suspensao) {
            Suspensao servico_reparo_suspensao = (Suspensao) servico;
            sql = "UPDATE servicorevisaosuspensao SET TipoSuspensao = ?, TrocaMola = ?, VazamentoFluido = ? WHERE ServicoID = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, servico_reparo_suspensao.getTipo().ordinal());
                comando.setBoolean(2, servico_reparo_suspensao.isTroca_molas());
                comando.setBoolean(3, servico_reparo_suspensao.isVazamento_fluido());
                comando.setInt(4, servico_reparo_suspensao.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Servico Revisao Suspensao no BD";
            }
        } else if (servico instanceof Pneus) {
            Pneus servico_troca_pneus = (Pneus) servico;
            sql = "UPDATE servicotrocapneus SET MarcaPneu = ?, Quantidade = ?, Balanceamento = ?, Alinhamento = ?"
                    + " WHERE ServicoID = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, servico_troca_pneus.getMarca().ordinal());
                comando.setInt(2, servico_troca_pneus.getQtd());
                comando.setBoolean(3, servico_troca_pneus.isBalanceamento());
                comando.setBoolean(4, servico_troca_pneus.isAlinhamento());
                comando.setInt(5, servico_troca_pneus.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Inserção do Servico Troca Pneus no BD";
            }
        }
        return null;
    }

    public static String removerServico(Servico servico) {
        int sequencial = servico.getSequencial();
        if (servico instanceof Motor) {
            String sql = "DELETE FROM servicoreparomotor WHERE ServicoID = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Remoção do Servico Reparo Motor no BD";
            }

        } else if (servico instanceof Suspensao) {
            String sql = "DELETE FROM servicorevisaosuspensao WHERE ServicoID = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Remoção do Servico Revisao Suspensao no BD";
            }
        } else if (servico instanceof Pneus) {
            String sql = "DELETE FROM servicotrocapneus WHERE ServicoID = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException exceção_sql) {
                exceção_sql.printStackTrace();
                return "Erro na Remoção do Servico TrocaPneus no BD";
            }
        }
        String sql = "DELETE FROM servicos WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na remoção do servico no BD";
        }
    }
       public String toStringOrdemServico(Servico servico){
        Servico servico1 = buscarServico(sequencial);
        if (servico1 instanceof Motor)
            return "Motor";
        else if(servico1 instanceof Suspensao)
            return "Suspensao";
        else
            return "Pneus";
    }

    public String toString() {

        return "[" + getSequencial() + "]";

    }

    public String toStringFull() {
        return "Tipo ["+ descricao + "] - Valor " + "[" + custo + "] --- ";
    }
}
