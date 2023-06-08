/*
Nome do Projeto: Penaltyfootball
Data de Criação: 28/05/2023
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
Última modificação: 07/06/2023 (Maria Helena)
Classe UsuarioRepository
Essa classe representa o repositório de usuários, responsável por realizar operações relacionadas aos usuários na tabela "tb_user" do banco de dados.
*/
package Repositorios;

import java.sql.*;
import Database.DbConnection;
import Models.Usuario;

public class UsuarioRepository {
	
    DbConnection db = new DbConnection();
    Connection con = db.getConexaoMySQL();


/**
     * Salva um usuário no banco de dados.
     *
     * @param usuario O usuário a ser salvo.
     */
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

/**
     * Verifica as credenciais de um usuário.
     *
     * @param usuario O usuário a ser verificado.
     * @return true se as credenciais forem válidas, false caso contrário.
     */
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

/**
     * Verifica se um usuário existe no banco de dados.
     *
     * @param username O nome de usuário a ser verificado.
     * @return true se o usuário existir, false caso contrário.
     */
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

}
