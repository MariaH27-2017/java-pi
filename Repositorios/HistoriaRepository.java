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
Última modificação: 28/05/2023 (Bruno)
Classe HistoriaRepository
Essa classe representa o repositório de histórias, responsável por acessar o banco de dados e obter informações sobre as histórias da tabela "tb_history" e "tb_history_item".
Ela possui métodos para buscar histórias por usuário, por nome, por ID e para obter a próxima parte de uma história.
Além disso, contém um método para obter a lista de todas as histórias disponíveis no banco de dados.
*/
package Repositorios;

import java.util.*;
import Models.Historia;
import Models.HistoriaItem;
import java.sql.*;
import Database.DbConnection;

public class HistoriaRepository {

    DbConnection db = new DbConnection();
    Connection con = db.getConexaoMySQL();

/**
 * Obtém a história de um usuário pelo nome de usuário.
 * @param username o nome de usuário.
 * @return o item de história encontrado ou null se não encontrado.
 */
    public HistoriaItem getHistoryByUsername(String username) {
    	
    	HistoriaItem result = null;
    	
        String query = new StringBuilder()
        .append("select h.id, h.Nm_History as Nome, h.Part as Parte, h.Title as Titulo, h.description as Descricao ")
        .append("from tb_save s ")
        .append("inner join tb_history_item h ")
        .append("on s.id_history_item = h.id ")
        .append("where s.username = '" + username + "'").toString();
        
        result = executeQuery(query);

        return result;
    }

 /**
 * Obtém a história pelo nome.
 * @param nome o nome da história.
 * @return o item de história encontrado ou null se não encontrado.
 */
    public HistoriaItem getHistoryByName(String nome)
    {
    	HistoriaItem result = null;
    
    	String query = new StringBuilder()
    	        .append("select h.id, h_item.Nm_History as Nome, h_item.Part as Parte, h_item.Title as Titulo, h_item.description as Descricao ")
    	        .append("from tb_history h ")
    	        .append("inner join tb_history_item h_item ")
    	        .append("on h_item.Nm_History = h.nm_History ")
    	        .append("where h.Nm_History = '"+ nome + "' ")
    	        .append("and h_item.Part = 1").toString();
    	
    	result = executeQuery(query);
    	
    	return result;
    }
/**
 * Obtém a história pelo ID.
 * @param id o ID da história.
 * @return o item de história encontrado ou null se não encontrado.
 */
    public HistoriaItem getHistoryById(int id)
    {
    	HistoriaItem result = null;
    
    	String query = new StringBuilder()
    	        .append("select h.id, h_item.Nm_History as Nome, h_item.Part as Parte, h_item.Title as Titulo, h_item.description as Descricao ")
    	        .append("from tb_history h ")
    	        .append("inner join tb_history_item h_item ")
    	        .append("on h_item.Nm_History = h.nm_History ")
    	        .append("where h.Id = '"+ id + "' ")
    	        .append("and h_item.Part = 1").toString();
    	
    	result = executeQuery(query);
    	
    	return result;
    }
    
    public HistoriaItem getProximaParte(HistoriaItem historia) {
        String query = new StringBuilder()
        .append("select h.id, h.Nm_History as nome, h.description as descricao, h.Title as titulo, h.Part as Parte ")
        .append("from tb_history_item h ")
        .append("where h.Part = " + (historia.getParte() + 1))
        .append(" and h.Nm_History = '" + historia.getNome() + "'").toString();
        
        return executeQuery(query);       
    }
    
    public ArrayList<Historia> getHistorias()
    {
    	ArrayList<Historia> historias = new ArrayList<Historia>();
    	String query = new StringBuilder()
    	.append("select h.nm_History as Nome, h.description as Descricao ")
    	.append("from tb_history h").toString();
    	
    	try (Statement stmt = con.createStatement()) {
            
            int numero = 0;

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	numero += 1;
            	Historia h = new Historia();
                h.setNome(rs.getString("Nome"));
                h.setDescricao(rs.getString("Descricao"));
                h.setNumero(numero);
                
                historias.add(h);
            }
           
            return historias;

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            System.out.println("Código do erro: " + ex.getErrorCode());
            return null;
        }
    }
    
    private HistoriaItem executeQuery(String query)
    {
    	try (Statement stmt = con.createStatement()) {
            
            HistoriaItem historia = new HistoriaItem();
            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                historia.setNome(rs.getString("Nome"));
                historia.setDescricao(rs.getString("Descricao"));
                historia.setTitulo(rs.getString("Titulo"));
                historia.setParte(rs.getInt("Parte"));
                historia.setId(rs.getInt("id"));
            }
            return historia;

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            System.out.println("Código do erro: " + ex.getErrorCode());
            return null;
        }
    }
    
   

}
