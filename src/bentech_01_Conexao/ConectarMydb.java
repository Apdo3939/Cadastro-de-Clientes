package bentech_01_Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConectarMydb {
    
    //atributos estaticos para a conexão
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "";
    
    //metodo estatico para conectar
    public static Connection getconectar(){
        
        try{
            Class.forName(DRIVER);
            return (Connection) DriverManager.getConnection(URL, USER, PASS);
        }
        catch(ClassNotFoundException | SQLException ex){
            
            throw new RuntimeException("Banco não conectado!" + ex);
        }
    }//fim do metodo estatico para conectar
    
    
    //metodo estatico para fechar a conexão
    public static void fecharConectar(Connection conn){
        
        if(conn != null){
            try{
                conn.close();
            }
            catch(SQLException ex){
                throw new RuntimeException("Banco não fechado!" + ex);
            }
        }
    }//fim do metodo estatico para fechar conexão
    
    
    //metodo estatico para fechar a conexão e inserção ou deleção
    public static void fecharConectar(Connection conn, PreparedStatement stmt){
        if(stmt != null){
            try{
                stmt.close();
            }
            catch(SQLException ex){
                throw new RuntimeException("Banco não fechado!" + ex);
            }
        }
        fecharConectar(conn);
    }//fim do metodo estatico para fechar a conexão e stmt
    
    
    //metodo estatico para fechar a conexão e inserção ou deleção e busca
    public static void fecharConectar(Connection conn, PreparedStatement stmt, ResultSet rs){
        if(rs != null){
            try{
                rs.close();
            }
            catch(SQLException ex){
                throw new RuntimeException("Banco não fechado!" + ex);
            }
        }
        fecharConectar(conn, stmt);
    }//fim do metodo estatico para fechar a conexão e inserção ou deleção e busca
}
