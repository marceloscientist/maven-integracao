package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoMySql {
	private static String URL = "jdbc:mysql://localhost/mercado";  
    private static String USER = "root"; 
    private static String PASS = "12345678";  

    public static Connection iniciarConexao() {
        try { //TENTATIVA DE LOCALIZAÇÃO DA CLASSE DE CONEXÃO
            return DriverManager.getConnection(URL, USER, PASS); //retorna conexao
        } catch (SQLException e) { //CASO NÃO ENCONTRE A CLASSE
            throw new RuntimeException("Erro na conexão: " + e); //Impressão do erro
        }
    }

    public static void encerrarConexao(Connection connection) {
        if (connection != null) { //SE CONEXÃO FOR DIFERENTE DE NULO
            try {
                connection.close(); //finaliza conexão
            } catch (SQLException e) { //SE TENTAR FINALIZAR CONEXÃO INEXISTENTE
                e.printStackTrace();//exibe a mensagem de erro
            }
        }
    }
    
    public static void encerrarConexao(Connection connection, PreparedStatement stmt) {
        encerrarConexao(connection);
        try {
            stmt.close();
        } catch (SQLException e) { //SE TENTAR FINALIZAR PREPAREDSTATEMENT INEXISTENTE
            e.printStackTrace();//exibe a mensagem de erro
        }
    }
    
    public static void encerrarConexao(Connection connection, PreparedStatement stmt, ResultSet rs) {
        encerrarConexao(connection, stmt);
        try {
            rs.close();
        } catch (SQLException e) { //SE TENTAR FINALIZAR RESULTSET INEXISTENTE
            e.printStackTrace();//exibe a mensagem de erro
        }
    }
}
