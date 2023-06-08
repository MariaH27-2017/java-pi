/*
Nome do Projeto: Penaltyfootball
Data de Criação: 27/05/2023
Banco de dados: MySQL
Package: Repositorios
JDK: 17
Libraries: mysql-connector-java
Desenvolvedores:
Ana Lucia
Bruno de Oliveira
Giovanna Moreira
Lauriano Carlos
Maria Helena dos Santos
Melissa Gonçalves
Última modificação: 05/06/2023 (Bruno)
Classe SaveRepository
Classe responsável pelo repositório de saves, que gerencia as informações de saves dos usuários.
*/
package Repositorios;
import java.sql.*;
import Database.DbConnection;

public class SaveRepository {

	   DbConnection db = new DbConnection();
	   Connection con = db.getConexaoMySQL();

/**
 * Verifica se um usuário possui um save.
 *
 * @param username O nome de usuário.
 * @return true se o usuário possuir um save, false caso contrário.
 */	   
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
	
/**
 * Salva o progresso de um usuário.
 *
 * @param username     O nome de usuário.
 * @param historiaItem O ID do item de história.
 */	
	public void salvar(String username, int historiaItem)
	{
		// Se o usuário possuir um save, atualiza o registro na tabela tb_save com o novo ID do item 
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
			//  Se o usuário não possuir um save, insere um novo registro na tabela tb_save com o username e o ID do item de história
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
