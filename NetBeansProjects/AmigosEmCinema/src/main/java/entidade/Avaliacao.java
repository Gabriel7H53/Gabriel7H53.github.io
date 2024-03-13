package entidade;

import entidade.FilmeProvedoraStreaming.Producao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import persistencia.BD;

public class Avaliacao {

    public enum Classificacao {
        pessima, fraca, regular, boa, exelente
    };

    public enum Preferencia {
        entre_dez_mais, entre_dez_menos
    };

    private int sequencial;
    private Amigo amigo;
    private Filme filme;
    private Classificacao classificacaoTrama, classificacaoDirecao, classificacaoAtuacao;
    private Preferencia preferencia;
    private Timestamp dataHora;

    public Avaliacao(int sequencial, Amigo amigo, Filme filme, Classificacao classificacaoTrama, Classificacao classificacaoDirecao, Classificacao classificacaoAtuacao, Preferencia preferencia, Timestamp dataHora) {
        this.sequencial = sequencial;
        this.amigo = amigo;
        this.filme = filme;
        this.classificacaoTrama = classificacaoTrama;
        this.classificacaoDirecao = classificacaoDirecao;
        this.classificacaoAtuacao = classificacaoAtuacao;
        this.preferencia = preferencia;
        this.dataHora = dataHora;
    }

    public Avaliacao(int sequencial, Amigo amigo, Filme filme) {
        this.sequencial = sequencial;
        this.amigo = amigo;
        this.filme = filme;
    }

    public Avaliacao(int sequencial) {
        this.sequencial = sequencial;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public Amigo getAmigo() {
        return amigo;
    }

    public void setAmigo(Amigo amigo) {
        this.amigo = amigo;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public Classificacao getClassificacaoTrama() {
        return classificacaoTrama;
    }

    public void setClassificacaoTrama(Classificacao classificacaoTrama) {
        this.classificacaoTrama = classificacaoTrama;
    }

    public Classificacao getClassificacaoDirecao() {
        return classificacaoDirecao;
    }

    public void setClassificacaoDirecao(Classificacao classificacaoDirecao) {
        this.classificacaoDirecao = classificacaoDirecao;
    }

    public Classificacao getClassificacaoAtuacao() {
        return classificacaoAtuacao;
    }

    public void setClassificacaoAtuacao(Classificacao classificacaoAtuacao) {
        this.classificacaoAtuacao = classificacaoAtuacao;
    }

    public Preferencia getPreferencia() {
        return preferencia;
    }

    public void setPreferencia(Preferencia preferencia) {
        this.preferencia = preferencia;
    }

    public Timestamp getDataHora() {
        return dataHora;
    }

    public void setDataHora(Timestamp dataHora) {
        this.dataHora = dataHora;
    }

    public String toString() {
        return "[" + sequencial + "] Filme: " + filme + ", Amigo: " + amigo;
    }

    public static Avaliacao[] getVisoes() {
        String sql = "SELECT Sequencial, AmigoId, FilmeId From Avaliacoes";
        ResultSet lista_resultados = null;
        ArrayList<Avaliacao> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visoes.add(new Avaliacao(lista_resultados.getInt("Sequencial"),
                        Amigo.buscarAmigo(lista_resultados.getString("AmigoId")).getVisao(),
                        Filme.buscarFilme(lista_resultados.getInt("FilmeId")).getVisao()));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return visoes.toArray(new Avaliacao[visoes.size()]);
    }

    public Avaliacao getVisao() {
        return new Avaliacao(sequencial);
    }

    public static boolean existeAvaliacaoInserir(String chave_amigo, int chave_filme) {
        String sql = "SELECT Sequencial FROM Avaliacoes WHERE AmigoId = ? AND FilmeId = ?";
        ResultSet lista_resultados = null;
        boolean existe = false;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, chave_amigo);
            comando.setInt(2, chave_filme);
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

    public static boolean existeAvaliacao(int sequencial) {
        String sql = "SELECT COUNT(Sequencial) FROM Avaliacoes WHERE Sequencial = ?";
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
        String sql = "SELECT MAX(Sequencial)FROM Avaliacoes";
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

    /*public static Amigo getVisaoAmigoSelecionada(Avaliacao avaliacao) {
        String sql = "SELECT Nome,Apelido FROM amigos";
        ResultSet lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, avaliacao.amigo.getNome());
            comando.setString(2, avaliacao.amigo.getApelido());
            lista_resultados = comando.executeQuery();
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();

        }
        return null;
    }*/

    public static Amigo[] getVisaoAmigoSelecionada() {
        String sql = "SELECT Nome,Apelido FROM amigos";
        ResultSet lista_resultados = null;
        ArrayList<Amigo> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String nome = lista_resultados.getString("Nome");
                String apelido = lista_resultados.getString("Apelido");
                visões.add(new Amigo(nome, apelido));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return visões.toArray(new Amigo[visões.size()]);
    }
    public static Filme[] getVisaoFilmeSelecionada() {
        String sql = "SELECT Sequencial, Titulo FROM filmes";
        ResultSet lista_resultados = null;
        ArrayList<Filme> visões = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visões.add(new Filme(lista_resultados.getInt("Sequencial"), lista_resultados.getString("Titulo")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return visões.toArray(new Filme[visões.size()]);
    }

    public static Avaliacao getVisaoFilmeSelecionado(Avaliacao avaliacao) {

        return avaliacao;
    }

    public static String formatarDataHora(String data_hora_bd) {
        String[] data_hora = data_hora_bd.split(" ");
        String[] ano_mes_dia = data_hora[0].split("-");
        String[] hora_minuto_resto = data_hora[1].split(":");
        String data_hora_formatada = ano_mes_dia[2] + "/" + ano_mes_dia[1] + "/"
                + ano_mes_dia[0] + " " + hora_minuto_resto[0]
                + ":" + hora_minuto_resto[1] + "hs";
        return data_hora_formatada;
    }

    public static ArrayList<Avaliacao> pesquisarAvaliacoes(String chave_amigo, int chave_filme, char sexo_amigo, Amigo.EstadoCivil estado_civil_amigo,
            Filme.Genero genero_filme, int ano_filme, char oscar_melhor_filme, Producao producao_filme,
            Classificacao classificacao_trama, Preferencia preferencia, Timestamp data_minima) {
        String sql = "SELECT Am.Nome, Am.Sexo, Am.EstadoCivil, F.Sequencial, F.Genero, F.Ano,"
                + " Av.Sequencial, Av.ClassificacaoTrama, Av.Preferencia, Av.DataHora"
                + " FROM Amigos Am, Filmes F, Avaliacoes Av"
                + " WHERE Av.AmigoId = Am.Nome AND Av.FilmeId = F.Sequencial";
        if (chave_amigo != null) {
            sql += " AND Am.Nome = ?";
        }
        if (chave_filme > -1) {
            sql += " AND F.Sequencial = ?";
        }
        if (sexo_amigo != 'X') {
            sql += " AND Am.Sexo = ?";
        }
        if (estado_civil_amigo != null) {
            sql += " AND Am.EstadoCivil = ?";
        }
        if (genero_filme != null) {
            sql += " AND F.Genero = ?";
        }
        if (ano_filme > - 1) {
            sql += " AND F.Ano >= ?";
        }
        if (classificacao_trama != null) {
            sql += " AND Av.ClassificacaoTrama = ?";
        }
        if (preferencia != null) {
            sql += " AND Av.Preferencia = ?";
        }
        if (data_minima != null) {
            sql += " AND Av.DataHora >= ? ";
        }
        sql += " ORDER BY Av.Sequencial";
        ResultSet lista_resultados = null;
        ArrayList<Avaliacao> avaliacoes_selecionadas = new ArrayList();
        int index = 0;
        int sequencial_filme = -1;

        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            if (chave_amigo != null) {
                comando.setString(++index, chave_amigo);
            }
            if (chave_filme > -1) {
                comando.setInt(++index, chave_filme);
            }
            if (sexo_amigo != 'X') {
                comando.setString(++index, sexo_amigo + "");
            }
            if (estado_civil_amigo != null) {
                comando.setInt(++index, estado_civil_amigo.ordinal());
            }
            if (genero_filme != null) {
                comando.setInt(++index, genero_filme.ordinal());
            }
            if (ano_filme > -1) {
                comando.setInt(++index, ano_filme);
            }
            if (classificacao_trama != null) {
                comando.setInt(++index, classificacao_trama.ordinal());
            }
            if (preferencia != null) {
                comando.setInt(++index, preferencia.ordinal());
            }
            if (data_minima != null) {
                comando.setTimestamp(++index, data_minima);
            }
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                Avaliacao avaliacao_pesquisada = Avaliacao.buscarAvaliacao(lista_resultados.getInt(7));
                sequencial_filme = lista_resultados.getInt(4);
                if (oscar_melhor_filme != 'X') {
                    if (isOkPesquisaEmFilmesCompanhiasCinematograficas(sequencial_filme, oscar_melhor_filme)) {
                        avaliacoes_selecionadas.add(avaliacao_pesquisada);
                    }
                } else if (producao_filme != null) {
                    if (isOkPesquisaEmFilmesProvedorasStreaming(sequencial_filme, producao_filme)) {
                        avaliacoes_selecionadas.add(avaliacao_pesquisada);
                    }
                } else {
                    avaliacoes_selecionadas.add(avaliacao_pesquisada);
                }
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return avaliacoes_selecionadas;
    }

    private static boolean isOkPesquisaEmFilmesCompanhiasCinematograficas(int sequencial_filme, char oscar_melhor_filme) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM FilmeCompanhiaCinematograficas WHERE FilmeId = ?";
        if (oscar_melhor_filme != 'X') {
            sql += " AND OscarMelhorFilme = ?";
        }
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial_filme);
            switch (oscar_melhor_filme) {
                case 'T':
                    comando.setBoolean(++index, true);
                    break;
                case 'F':
                    comando.setBoolean(++index, false);
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

    private static boolean isOkPesquisaEmFilmesProvedorasStreaming(int sequencial_filme, Producao producao_filme) {
        boolean pesquisa_ok = false;
        String sql = "SELECT * FROM FilmeProvedoraStreaming WHERE FilmeId = ?";
        if (producao_filme != null) {
            sql += " AND Producao = ? ";
        }
        ResultSet lista_resultados = null;
        int index = 1;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial_filme);
            if (producao_filme != null) {
                comando.setInt(++index, producao_filme.ordinal());
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

    public static Avaliacao buscarAvaliacao(int sequencial) {
        String sql = "SELECT * FROM Avaliacoes WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        Avaliacao avaliacao = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                Preferencia preferencia = null;
                if (lista_resultados.getInt("Preferencia") > -1) {
                    preferencia = Preferencia.values()[lista_resultados.getInt("Preferencia")];
                }
                avaliacao = new Avaliacao(sequencial,
                        Amigo.buscarAmigo(lista_resultados.getString("AmigoId")),
                        Filme.buscarFilme(lista_resultados.getInt("FilmeId")),
                        Classificacao.values()[lista_resultados.getInt("ClassificacaoTrama")],
                        Classificacao.values()[lista_resultados.getInt("ClassificacaoDirecao")],
                        Classificacao.values()[lista_resultados.getInt("ClassificacaoAtuacao")],
                        preferencia,
                        lista_resultados.getTimestamp("DataHora"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            avaliacao = null;
        }
        return avaliacao;
    }

    public static String inserirAvaliacao(Avaliacao avaliacao) {
        String sql = "INSERT INTO Avaliacoes(AmigoId, FilmeId,  ClassificacaoTrama,ClassificacaoDirecao,"
                + " ClassificacaoAtuacao, Preferencia, DataHora) VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, avaliacao.getAmigo().getNome());
            comando.setInt(2, avaliacao.getFilme().getSequencial());
            comando.setInt(3, avaliacao.getClassificacaoTrama().ordinal());
            comando.setInt(4, avaliacao.getClassificacaoDirecao().ordinal());
            comando.setInt(5, avaliacao.getClassificacaoAtuacao().ordinal());
            int indice_preferencia = -1;
            if (avaliacao.getPreferencia() != null) {
                indice_preferencia = avaliacao.getPreferencia().ordinal();
            }
            comando.setInt(6, indice_preferencia);
            comando.setTimestamp(7, avaliacao.getDataHora());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na insercao da avaliacao no BD";
        }
    }

    public static String alterarAvaliacao(Avaliacao avaliacao) {
        String sql = "UPDATE Avaliacoes SET AmigoId = ?, FilmeId = ?, ClassificacaoTrama = ?, ClassificacaoDirecao = ?, "
                + "ClassificacaoAtuacao= ?, Preferencia = ?, DataHora = ?"
                + "WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, avaliacao.getAmigo().getNome());
            comando.setInt(2, avaliacao.getFilme().getSequencial());
            comando.setInt(3, avaliacao.getClassificacaoTrama().ordinal());
            comando.setInt(4, avaliacao.getClassificacaoDirecao().ordinal());
            comando.setInt(5, avaliacao.getClassificacaoAtuacao().ordinal());
            int indice_preferencia = -1;
            if (avaliacao.getPreferencia() != null) {
                indice_preferencia = avaliacao.getPreferencia().ordinal();
            }
            comando.setInt(6, indice_preferencia);
            comando.setTimestamp(7, avaliacao.getDataHora());
            comando.setInt(8, avaliacao.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na Alteração da avaliacao no BD";
        }
    }

    public static String removerAvaliacao(int sequencial) {

        String sql = "DELETE FROM Avaliacoes WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoção do FilmeOriginal no BD";
        }
        return null;
    }

    public String toStringFull() {//toStringFull entidade avaliacao
        String str = filme.toStringFull() + " --- " + amigo.toStringFull() + "\n   ";
        if (preferencia != null) {
            switch (preferencia) {
                case entre_dez_mais:
                    str += "entre os 10 melhores -";
                    break;
                case entre_dez_menos:
                    str += "entre os 10 piores - ";
            }
        }
        str += "trama [" + classificacaoTrama + "] - direcao [" + classificacaoDirecao
                + "] - atuacao [" + classificacaoAtuacao + "] - " + formatarDataHora(dataHora.toString());
        return str;
    }

}
