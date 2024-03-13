package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistencia.BD;
import entidade.FilmeCompanhiaCinematografica;
import entidade.FilmeProvedoraStreaming;
import entidade.FilmeProvedoraStreaming.Producao;

public class Filme {

    public enum Genero {
        açao, aventura, comédia, drama, faroente, ficção, guerra, infantil, musical, romance, suspense, terror
    };

    private int sequencial;
    private String titulo;
    private Genero genero;
    private int ano;

    public Filme(int sequencial, String titulo, Genero genero, int ano) {
        this.sequencial = sequencial;
        this.titulo = titulo;
        this.genero = genero;
        this.ano = ano;
    }

    public Filme(int sequencial, String titulo) {
        this.sequencial = sequencial;
        this.titulo = titulo;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String toString() {
        return "[" + sequencial + "] " + titulo;
    }

    public static Filme buscarFilme(int sequencial) {
        String sql = null;
        ResultSet lista_resultados = null;
        sql = "SELECT Titulo, Genero, Ano FROM Filmes WHERE Sequencial = ?";
        String titulo = null;
        Genero genero = null;
        int ano = 0;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                titulo = lista_resultados.getString("Titulo");
                genero = Genero.values()[lista_resultados.getInt("Genero")];
                ano = lista_resultados.getInt("Ano");
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        if (titulo == null) {
            return null;
        }

        sql = "SELECT OscarMelhorFilme, OscarMelhorDiretor, OscarMelhorAtor, OscarMelhorAtriz"
                + " FROM FilmeCompanhiaCinematograficas WHERE FilmeId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return new FilmeCompanhiaCinematografica(sequencial, titulo, genero, ano,
                        lista_resultados.getBoolean("OscarMelhorFilme"),
                        lista_resultados.getString("OscarMelhorDiretor"),
                        lista_resultados.getString("OscarMelhorAtor"),
                        lista_resultados.getString("OscarMelhorAtriz"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }

        sql = "SELECT ProvedoraStreaming, Producao, TotalEpisodios FROM FilmeProvedoraStreaming" + " WHERE FilmeId = ?";
        lista_resultados = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                return (new FilmeProvedoraStreaming(sequencial, titulo, genero, ano,
                        FilmeProvedoraStreaming.ProvedoraStreaming.values()[lista_resultados.getInt("ProvedoraStreaming")],
                        Producao.values()[lista_resultados.getInt("Producao")],
                        lista_resultados.getInt("TotalEpisodios")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return null;

    }

    public static String inserirFilme(Filme filme) {
        String sql = "INSERT INTO Filmes (Titulo, Genero, Ano)" + " Values (?,?,?)";
        
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, filme.getTitulo());
            comando.setInt(2, filme.getGenero().ordinal());
            comando.setInt(3, filme.getAno());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na Inserção do Filme no BD";
        }

        int sequencial = ultimoSequencial();
        if (filme instanceof FilmeCompanhiaCinematografica) {
            FilmeCompanhiaCinematografica filme_companhia_cinematografica = (FilmeCompanhiaCinematografica) filme;
            sql = "INSERT INTO FilmeCompanhiaCinematograficas (OscarMelhorFilme, OscarMelhorDiretor," + " OscarMelhorAtor, OscarMelhorAtriz, FilmeId) VALUES (?, ?, ?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setBoolean(1, filme_companhia_cinematografica.isOscarMelhorFilme());
                comando.setString(2, filme_companhia_cinematografica.getOscarMelhorDiretor());
                comando.setString(3, filme_companhia_cinematografica.getOscarMelhorAtor());
                comando.setString(4, filme_companhia_cinematografica.getOscarMelhorAtriz());
                comando.setInt(5, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException excecao_sql) {
                excecao_sql.printStackTrace();
                return "Erro na Inserção do Filme Companhia Cinematografica no BD";
            }
        } else if (filme instanceof FilmeProvedoraStreaming) {
            FilmeProvedoraStreaming filme_provedora_streaming = (FilmeProvedoraStreaming) filme;
            sql = "INSERT INTO FilmeProvedoraStreaming (ProvedoraStreaming, Producao, TotalEpisodios," + " FilmeId) VALUES (?, ?, ?, ?)";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, filme_provedora_streaming.getProvedora().ordinal());
                comando.setInt(2, filme_provedora_streaming.getProducao().ordinal());
                comando.setInt(3, filme_provedora_streaming.getTotalEpisodios());
                comando.setInt(4, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException excecao_sql) {
                excecao_sql.printStackTrace();
                return "Erro na Inserção do Filme Provedora Streaming no BD";
            }
        }
        return null;
    }

    public static String alterarFilme(Filme filme) {
        String sql = "UPDATE Filmes SET Titulo = ?, Genero = ?, Ano = ? WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);

            comando.setString(1, filme.getTitulo());
            comando.setInt(2, filme.getGenero().ordinal());
            comando.setInt(3, filme.getAno());
            comando.setInt(4, filme.getSequencial());
            comando.executeUpdate();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na Alteração do filme no banco de dados";
        }
        if (filme instanceof FilmeCompanhiaCinematografica) {
            FilmeCompanhiaCinematografica filme_companhia_cinematografica = (FilmeCompanhiaCinematografica) filme;
            sql = "UPDATE FilmeCompanhiaCinematograficas SET OscarMelhorFilme = ?, OscarMelhorDiretor = ?, OscarMelhorAtor = ?, OscarMelhorAtriz = ? WHERE FilmeId = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setBoolean(1, filme_companhia_cinematografica.isOscarMelhorFilme());
                comando.setString(2, filme_companhia_cinematografica.getOscarMelhorDiretor());
                comando.setString(3, filme_companhia_cinematografica.getOscarMelhorAtor());
                comando.setString(4, filme_companhia_cinematografica.getOscarMelhorAtriz());
                comando.setInt(5, filme_companhia_cinematografica.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException excecao_sql) {
                excecao_sql.printStackTrace();
                return "Erro na Alteração do filme comanhia cinematografica no banco de dados";
            }
        } else if (filme instanceof FilmeProvedoraStreaming) {
            FilmeProvedoraStreaming filme_provedora_streaming = (FilmeProvedoraStreaming) filme;
            sql = "UPDATE FilmeProvedoraStreaming SET ProvedoraStreaming = ?, Producao = ?, TotalEpisodios = ? WHERE FilmeId = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, filme_provedora_streaming.getProvedora().ordinal());
                comando.setInt(2, filme_provedora_streaming.getProducao().ordinal());
                comando.setInt(3, filme_provedora_streaming.getTotalEpisodios());
                comando.setInt(4, filme_provedora_streaming.getSequencial());
                comando.executeUpdate();
                comando.close();
            } catch (SQLException excecao_sql) {
                excecao_sql.printStackTrace();
                return "Erro na Alteração do Filme Provedora Streaming no banco de dados";
            }
        }
        return null;
    }

    public static String removerFilme(Filme filme) {
        int sequencial = filme.getSequencial();
        if (filme instanceof FilmeCompanhiaCinematografica) {
            String sql = "DELETE FROM FilmeCompanhiaCinematograficas WHERE FilmeId = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException excecao_sql) {
                excecao_sql.printStackTrace();
                return "Erro na Remoção do FilmeOriginal do BD";
            }
        } else if (filme instanceof FilmeProvedoraStreaming) {
            String sql = "DELETE FROM FilmeProvedoraStreaming WHERE FilmeId = ?";
            try {
                PreparedStatement comando = BD.conexao.prepareStatement(sql);
                comando.setInt(1, sequencial);
                comando.executeUpdate();
                comando.close();
            } catch (SQLException excecao_sql) {
                excecao_sql.printStackTrace();
                return "Erro na Remoção do FilmeOriginal do BD";
            }
        }
        String sql = "DELETE FROM Filmes WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na Remoção do Filme do BD";
        }
        return null;
    }

    public static Filme[] getVisoes() {
        String sql = "SELECT Sequencial, Titulo FROM Filmes";
        ResultSet lista_resultados = null;
        ArrayList<Filme> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                int sequencial = lista_resultados.getInt("Sequencial");
                String titulo = lista_resultados.getString("Titulo");
                visoes.add(new Filme(sequencial, titulo));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return visoes.toArray(new Filme[visoes.size()]);
    }

    public Filme getVisao() {
        return new Filme(sequencial, titulo);
    }

    public static int ultimoSequencial() {
        String sql = "SELECT MAX(Sequencial) FROM Filmes";
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
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return sequencial;
    }

    public static boolean existeFilmeMesmosAtributos(Filme filme) {
        String sql = "SELECT COUNT(Sequencial) FROM Filmes WHERE Titulo = ? AND Genero = ? and Ano = ?";
        ResultSet lista_resultados = null;
        int n_filmes_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, filme.getTitulo());
            comando.setInt(2, filme.getGenero().ordinal());
            comando.setInt(3, filme.getAno());
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                n_filmes_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        if (n_filmes_mesmos_atributos > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toStringFull() {
        return ano + " - " + titulo + " [" + genero + "]";
    }
}
