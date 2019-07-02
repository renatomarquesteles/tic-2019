package unifacef.main;
import java.sql.*;

public class BancoDados {
    
    public static Connection conecta(){
        Connection conexao;
        String url = "jdbc:postgresql://localhost:5432/academico";
        String user = "usuario";
        String senha = "123456";
        try{
            conexao = DriverManager.getConnection(url, user, senha);
            return conexao;
        }
        catch(SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
