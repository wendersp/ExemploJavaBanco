
package modelo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author wender
 */
public class ConexaoDB {
    
    private final String NOME_DB = "dbbanco";
    private final String USER_DB = "root";
    private final String SENHA_DB = "saoluis";
    private final String SERVIDOR_DB = "localhost";
    
    public Connection getConexaoDB() { 
        Connection con =  null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Drive JDBC não existe.");
            return null;
        }      
        try {
            con = DriverManager.getConnection("jdbc:mysql://" + SERVIDOR_DB + ":3306/" + NOME_DB, USER_DB, SENHA_DB);
        } catch (SQLException ex) {
            System.out.println("Error ao conectar com o banco de dados. " + ex.getMessage());
            return null;
        }
        return con;
    }
    
    
}
