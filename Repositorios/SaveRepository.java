package Repositorios;
import Models.*;
import java.sql.*;
import Database.DbConnection;

public class SaveRepository {

	   DbConnection db = new DbConnection();
	   Connection con = db.getConexaoMySQL();
	
	   public boolean usuarioPossuiSave(String username)
	{
		String query = new StringBuilder()
                .append("SELECT COUNT(1) as count")
                .append(" FROM tb_save")
                .append(" WHERE username = '" + username + "'")
                .toString();
   	 
   	 int count = 0;
   	 try (Statement stmt = con.createStatement()) {
   		 
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
            	count = rs.getInt("count");
            }                     

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            System.out.println("Código do erro: " + ex.getErrorCode());
            return false;
        }
   	 return count > 0;
	}
	
	public void salvar(String username, int historiaItem)
	{
		if(usuarioPossuiSave(username))
		{
			  String query = new StringBuilder()
		                .append("UPDATE tb_save SET id_history_item = ?")
		                .append(" where username = ?")
		                .toString();
		        
		        try {
		    		java.sql.PreparedStatement pst = con.prepareStatement(query);
		    		pst.setInt(1, historiaItem);
		    		pst.setString(2, username);
		    		pst.execute();
		    	}
		    	 catch (SQLException ex) {
		             System.out.println("SQL Exception: " + ex.getMessage());
		             System.out.println("Código do erro: " + ex.getErrorCode());
		         }
		}
		else
		{
			 String query = new StringBuilder()
		                .append("insert into tb_save (username, id_history_item)")
		                .append(" values (?,?)").toString();
		        
		        try {
		    		java.sql.PreparedStatement pst = con.prepareStatement(query);
		    		pst.setString(1, username);
		    		pst.setInt(2, historiaItem);
		    		pst.execute();
		    	}
		    	 catch (SQLException ex) {
		             System.out.println("SQL Exception: " + ex.getMessage());
		             System.out.println("Código do erro: " + ex.getErrorCode());
		         }
		}
	}
}
