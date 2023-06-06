package Repositorios;

import java.sql.*;
import com.mysql.jdbc.PreparedStatement;

import Database.DbConnection;
import Models.Ranking;
import Models.Usuario;

public class UsuarioRepository {
	
    DbConnection db = new DbConnection();
    Connection con = db.getConexaoMySQL();

    public void salvarUsuario(Usuario usuario) {
        String query = new StringBuilder()
                .append("insert into tb_user (Username, `Password`)")
                .append(" values (?,?)").toString();        
    	try {
    		java.sql.PreparedStatement pst = con.prepareStatement(query);
    		pst.setString(1, usuario.getUsername());
    		pst.setString(2, usuario.getPassword());
    		pst.execute();
    	}
    	 catch (SQLException ex) {
             System.out.println("SQL Exception: " + ex.getMessage());
             System.out.println("Código do erro: " + ex.getErrorCode());
         }
    }

    public boolean verificarCredenciais(Usuario usuario){
        String query = new StringBuilder()
                .append("select Username, `Password` ")
                .append("from tb_user ")
                .append("where Username = '" + usuario.getUsername() + "' ")
                .append("and `Password` = '" + usuario.getPassword() + "';").toString();
        
        try (Statement stmt = con.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	return true;
            }
            return false;

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            System.out.println("Código do erro: " + ex.getErrorCode());
        }
        
        return false;

    }
        
    public boolean verificarUsuarioExistente(String username){
        String query = new StringBuilder()
                .append("select Username, `Password` ")
                .append("from tb_user ")
                .append("where Username = '" + username + "' ")
                .toString();
        
        try (Statement stmt = con.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	return true;
            }
            return false;

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            System.out.println("Código do erro: " + ex.getErrorCode());
        }     
        return false;

    }    

    public void alterarUsuario(Usuario usuario) {
        String query = new StringBuilder()
                .append("UPDATE tb_user ")
                .append("SET Username = ?, `Password` = ? ")
                .append("WHERE username = ?")
                .toString();    
    	try {
    		java.sql.PreparedStatement pst = con.prepareStatement(query);
    		pst.setString(1, usuario.getUsername());
    		pst.setString(2, usuario.getPassword());
    		pst.setString(3, usuario.getUsername());
    		pst.execute();
    	}
    	 catch (SQLException ex) {
             System.out.println("SQL Exception: " + ex.getMessage());
             System.out.println("Código do erro: " + ex.getErrorCode());
         }
    }
    
}
