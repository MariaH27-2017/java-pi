package Repositorios;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import com.mysql.jdbc.PreparedStatement;

import Database.DbConnection;
import Models.Usuario;

public class UsuarioRepository {
	// LEMBRAR DE: fazer um finally fechando as conexoes 
	
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

    public void verificarUsuarioSenha(Usuario usuario) {
        String query = new StringBuilder()
                .append("select Username, `Password`")
                .append("from tb_user")
                .append("where Username = '" + usuario.getUsername() + "'")
                .append("and `Password` = '" + usuario.getPassword() + "';").toString();
    }

    public void verificarSeUsuarioExiste(String username) {
        String query = new StringBuilder()
                .append("select count(*)")
                .append("from tb_user")
                .append("where Username = '" + username + "';").toString();
    }

    public void alterarUsuario(Usuario usuario) {
        String query = new StringBuilder()
                .append("UPDATE tb_user")
                .append("Username = '" + usuario.getUsername() + " ', `Password` = " + usuario.getPassword() + "),")
                .toString();
    }
}
