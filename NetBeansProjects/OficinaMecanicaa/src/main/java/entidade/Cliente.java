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
public class Cliente {
    

    private String cpf;
    private String nome, telefone;


   
    public static Cliente[] getVisoes() {
        String sql = "SELECT Cpf,Nome FROM clientes";
        ResultSet lista_resultados = null;
        ArrayList<Cliente> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visoes.add(new Cliente(lista_resultados.getString("Nome"),
                                     lista_resultados.getString("Cpf")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return visoes.toArray(new Cliente[visoes.size()]);
    }
    
    public static boolean existeClientesMesmosAtributos(Cliente cliente) {
        String sql = "SELECT Cpf FROM clientes WHERE Cpf = ? AND Telefone = ? AND Nome = ?";
        ResultSet lista_resultados = null;
        int n_clientes_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, cliente.getCpf());
            comando.setString(2, cliente.getTelefone());
            comando.setString(3, cliente.getNome());
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                n_clientes_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        if (n_clientes_mesmos_atributos > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static String inserirCliente(Cliente cliente) {
        String sql = "INSERT INTO clientes(Cpf,Telefone,Nome)" + " Values(?,?,?)";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, cliente.getCpf());
            comando.setString(2, cliente.getTelefone());
            comando.setString(3, cliente.getNome());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Inserção do Cliente no BD";
        }
    }
    
    public static String alterarCliente(Cliente cliente) {
        String sql = "UPDATE clientes SET Telefone = ?, Nome = ? " + " WHERE Cpf = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, cliente.getTelefone());
            comando.setString(2, cliente.getNome());
            comando.setString(3, cliente.getCpf());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Alteração do Cliente no BD";
        }
    }
    
    public static String removerCliente(String cpf) {
        String sql = "DELETE FROM clientes WHERE Cpf = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, cpf);
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na Remoçaõ do Cliente no BD";
        }
    }
    
    public static Cliente buscarCliente(String cpf) {
        String sql = "SELECT * FROM clientes WHERE Cpf = ?";
        ResultSet lista_resultados = null;
        Cliente cliente = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, cpf);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                cliente = new Cliente(cpf,
                        lista_resultados.getString("Telefone"),
                        lista_resultados.getString("Nome"));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
        return cliente;
    }
    
    public Cliente getVisao() {
        return new Cliente(nome, cpf);
    }

    public String toString() {
        return "[" + getCpf() + "]" + getNome();

    }
    
    public Cliente(String cpf, String telefone, String nome) {
        this.cpf = cpf;
        this.telefone = telefone;
        this.nome = nome;
    }

    public Cliente(String nome, String cpf) {
        this.cpf = cpf;
        this.nome = nome;
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
