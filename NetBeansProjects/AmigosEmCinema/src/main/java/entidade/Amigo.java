/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import persistencia.BD;
import interfaces.JanelaAmigosCinema;
import interfaces.JanelaCadastrarAmigos;
import java.util.ArrayList;

/**
 *
 * @author felip
 */
public class Amigo {

    public enum EstadoCivil {
        solteiro, casado, divorsiado, viuvo
    };

    private String nome;
    private String apelido;
    private char sexo;
    private EstadoCivil estadocivil;
    private String cidade;
    private String email;
    private String whatsapp;
    private String instagram;

    public Amigo(String nome, String apelido, char sexo, EstadoCivil estadocivil, String cidade, String email, String whatsapp, String instagram) {
        this.nome = nome;
        this.apelido = apelido;
        this.sexo = sexo;
        this.estadocivil = estadocivil;
        this.cidade = cidade;
        this.email = email;
        this.whatsapp = whatsapp;
        this.instagram = instagram;
    }

    public Amigo(String nome, String apelido) {
        this.nome = nome;
        this.apelido = apelido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getApelido() {
        return apelido;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public EstadoCivil getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(EstadoCivil estadocivil) {
        this.estadocivil = estadocivil;
    }

    public void setApelido(String apelido) {
        this.apelido = apelido;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public static Amigo buscarAmigo(String nome) {
        String sql = "SELECT * FROM Amigos WHERE Nome = ?";
        ResultSet lista_resultados = null;
        Amigo amigo = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, nome);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                amigo = new Amigo(nome,
                        lista_resultados.getString("Apelido"),
                        lista_resultados.getString("Sexo").toCharArray()[0],
                        EstadoCivil.values()[lista_resultados.getInt("EstadoCivil")],
                        lista_resultados.getString("Cidade"),
                        lista_resultados.getString("Email"),
                        lista_resultados.getString("Whatsapp"),
                        lista_resultados.getString("instagram")
                );
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            amigo = null;
        }
        return amigo;
    }

    public static String inserirAmigo(Amigo amigo) {
        String sql = "INSERT INTO amigos(Nome,Apelido,Sexo,EstadoCivil,Cidade,Email,Whatsapp,Instagram)"
                + " Values(?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, amigo.getNome());
            comando.setString(2, amigo.getApelido());
            comando.setString(3, (amigo.getSexo() + ""));
            comando.setInt(4, amigo.getEstadocivil().ordinal());
            comando.setString(5, amigo.getCidade());
            comando.setString(6, amigo.getEmail());
            comando.setString(7, amigo.getWhatsapp());
            comando.setString(8, amigo.getInstagram());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção do Amigo no BD";
        }
    }

    public static String alterarAmigo(Amigo amigo) {
        String sql = "UPDATE amigos SET Apelido = ?,Sexo = ?,EstadoCivil = ?,Cidade = ?,Email = ?, Whatsapp = ?,"
                + "Instagram = ?"
                + " WHERE Nome = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, amigo.getApelido());
            comando.setString(2, (amigo.getSexo() + ""));
            comando.setInt(3, amigo.getEstadocivil().ordinal());
            comando.setString(4, amigo.getCidade());
            comando.setString(5, amigo.getEmail());
            comando.setString(6, amigo.getWhatsapp());
            comando.setString(7, amigo.getInstagram());
            comando.setString(8, amigo.getNome());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Alteração do Amigo no BD";
        }
    }

    public static String removerAmigo(String nome) {
        String sql = "DELETE FROM Amigos WHERE Nome = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, nome);
            comando.executeUpdate();
            comando.close();
            return null;

        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
            return "Erro na Alteração do amigo no banco de dados";
        }
    }

    public String toString() {
        if (apelido != null) {
            return nome + " {" + apelido + "} ";
        } else {
            return nome;
        }
    }

    public static Amigo[] getVisoes() {
        String sql = "SELECT Nome, Apelido FROM Amigos";
        ResultSet lista_resultados = null;
        ArrayList<Amigo> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                String nome = lista_resultados.getString("Nome");
                String apelido = lista_resultados.getString("Apelido");
                visoes.add(new Amigo(nome, apelido));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return visoes.toArray(new Amigo[visoes.size()]);
    }

    public Amigo getVisao() {
        return new Amigo(nome, apelido);
    }
    
    public String toStringFull() {
        String str = nome;
        if (apelido != null) {
            str += " [" + apelido + "]";
        }
        str += " - " + estadocivil + " - " + cidade;
        return str;
    }
}
