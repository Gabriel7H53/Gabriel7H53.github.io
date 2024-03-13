package entidade;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import persistência.BD;

public class Motor {
    
    public enum Fabricante{
         mototech, speedcraft,aeropower;
    }
    private Fabricante fabricante;
    private String nome, modelo, numeroSerie;
    private int sequencial;
    
        public static boolean existeMotorMesmosAtributos(Motor motor) {
        String sql = "SELECT COUNT(Sequencial) FROM motores WHERE Nome = ? AND Modelo = ? AND NumeroSerie = ? AND Fabricante = ?";
        ResultSet lista_resultados = null;
        int n_motores_mesmos_atributos = 0;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, motor.getNome());
            comando.setString(2, motor.getModelo());
            comando.setString(3, motor.getNumeroSerie());
            comando.setInt(4, motor.getFabricante().ordinal());
           
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                n_motores_mesmos_atributos = lista_resultados.getInt(1);
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
        if (n_motores_mesmos_atributos > 0) {
            return true;
        } else {
            return false;
        }
    }
    
    public static int últimoSequencial() {
        String sql = "SELECT MAX(Sequencial)FROM motores";
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

    public Motor(int sequencial, String nome, String modelo, String numeroSerie,Fabricante fabricante) {
        this.sequencial = sequencial;
        this.nome = nome;
        this.modelo = modelo;
        this.numeroSerie = numeroSerie;
        this.fabricante = fabricante;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
    
    
    

    public Motor(int sequencial, String nome) {
        this.sequencial = sequencial;
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public String getModelo() {
        return modelo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public int getSequencial() {
        return sequencial;
    }

    public void setSequencial(int sequencial) {
        this.sequencial = sequencial;
    }
    
    
    public Motor getVisao(){
        return new Motor(sequencial, nome);
    }
    
    public static Motor[] getVisoes(){
        String sql = "SELECT Sequencial,Nome FROM motores";
        ResultSet lista_resultados = null;
        ArrayList<Motor> visoes = new ArrayList();
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                visoes.add(new Motor(lista_resultados.getInt("Sequencial"),
                                     lista_resultados.getString("Nome")));
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException execeção_sql) {
            execeção_sql.printStackTrace();
        }
        return visoes.toArray(new Motor[visoes.size()]);
    }
    
    public static Motor buscarMotor(int sequencial) {
        String sql = "SELECT * FROM motores WHERE Sequencial = ?";
        ResultSet lista_resultados = null;
        Motor motor = null;
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            lista_resultados = comando.executeQuery();
            while (lista_resultados.next()) {
                motor = new Motor(
                        sequencial,
                        lista_resultados.getString("Nome"),
                        lista_resultados.getString("Modelo"),
                        lista_resultados.getString("NumeroSerie"),
                        Fabricante.values()[lista_resultados.getInt("Fabricante")]
                );
            }
            lista_resultados.close();
            comando.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            motor = null;
        }
        return motor;
    }

    public static String inserirMotor(Motor motor) {
        String sql = "INSERT INTO motores (Nome, Modelo, NumeroSerie, Fabricante)" + " Values (?,?,?,?)";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, motor.getNome());
            comando.setString(2, motor.getModelo());
            comando.setString(3, motor.getNumeroSerie());
            comando.setInt(4, motor.getFabricante().ordinal());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na inserçao do motor no BD";
        }
    }

    public static String alterarMotor(Motor motor) {
        String sql = "UPDATE motores SET Nome = ?, Modelo = ?, NumeroSerie = ?, Fabricante = ? " + " WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setString(1, motor.getNome());
            comando.setString(2, motor.getModelo());
            comando.setString(3, motor.getNumeroSerie());
            comando.setInt(4, motor.getFabricante().ordinal());
            comando.setInt(5, motor.getSequencial());
            comando.executeUpdate();
            comando.close();
            return null;
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na alteração do motor no BD";
        }
    }

    public static String removerMotor(int sequencial) {
        String sql = "DELETE FROM motores WHERE Sequencial = ?";
        try {
            PreparedStatement comando = BD.conexao.prepareStatement(sql);
            comando.setInt(1, sequencial);
            comando.executeUpdate();
            comando.close();
            return null;
        }catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
            return "Erro na remoção do motor no BD";
        }
}
    public String toString() {
        return "[" + getSequencial() + "]" + getNome();

    }
}