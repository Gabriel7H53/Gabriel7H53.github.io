package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    static final String URL_BD = "jdbc:mysql://localhost/motor";
    static final String USUARIO = "root";
    static final String SENHA = "admin";
    public static Connection conexao = null;
    public static Statement comando = null;

    public static void criaConexaoComando() {
        try {
            conexao = DriverManager.getConnection(URL_BD, USUARIO, SENHA);
            comando = conexao.createStatement();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
    }

    public static void fechaComandoConexao() {
        try {
            comando.close();
            conexao.close();
        } catch (SQLException excecao_sql) {
            excecao_sql.printStackTrace();
        }
    }
}
