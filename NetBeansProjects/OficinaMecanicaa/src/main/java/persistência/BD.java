package persistência;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BD {

    static final String URL_BD = "jdbc:mysql://localhost:3306/motor";
    static final String USUARIO = "root";
    static final String SENHA = "admin";
    public static Connection conexao = null;

    public static void criarConexao() {
        try {
            conexao = DriverManager.getConnection(URL_BD, USUARIO, SENHA);
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }

    }

    public static void fechaConexao() {

        try {
            conexao.close();
        } catch (SQLException exceção_sql) {
            exceção_sql.printStackTrace();
        }
    }
}