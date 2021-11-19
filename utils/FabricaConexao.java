package utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {
    /* Atributos ---------------------------------- */
    private static Connection conexao = null;
    private static final String DATABASE_NAME = "dados_torneios";
    private static final String URL_CONNECTION = "jdbc:mysql://localhost/"+DATABASE_NAME+"?useTimezone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "admin";

    /* Construtores ---------------------------------- */
    private FabricaConexao(){}

    /* Métodos ---------------------------------- */
    public static Connection getInstance() {
        // verifica se a conexão ainda não foi criada
        if(conexao == null){
            // tenta criar uma nova conexão com o Mysql
            try{
                Class.forName("com.mysql.cj.jdbc.Driver"); // nome do driver Mysql do Java
                // tenta estabelecer a conexão
                conexao = DriverManager.getConnection(URL_CONNECTION, USER, PASSWORD);
            }catch(ClassNotFoundException e){
                e.printStackTrace();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return conexao;
    }
}
