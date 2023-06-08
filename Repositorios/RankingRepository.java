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
Classe RankingRepository
Essa classe representa o repositório de rankings, responsável por acessar o banco de dados e obter informações sobre os rankings da tabela "tb_ranking".
*/
package Repositorios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Database.DbConnection;
import Models.HistoriaItem;
import Models.Ranking;
import java.util.*;

public class RankingRepository {
	
    DbConnection db = new DbConnection();
    Connection con = db.getConexaoMySQL();

/**
 * Obtém os dados do ranking.
 * 
 * @return Uma lista de objetos Ranking contendo os nomes de usuário e as pontuações.
 */
    public ArrayList<Ranking> getRanking() {
        
    	ArrayList<Ranking> ranking = new ArrayList<Ranking>();
    	String query = new StringBuilder()
                .append(" select Username as Nome, Score as Pontuacao")
                .append(" from tb_ranking")
                .append(" order by Score Desc")
                .append(" limit 10;").toString();
        
        try (Statement stmt = con.createStatement()) {
            
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
            	Ranking r = new Ranking();
            	r.setUsername(rs.getString("Nome"));
            	r.setScore(rs.getInt("Pontuacao"));
            	
            	ranking.add(r);
            }
           
            return ranking;
            

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            System.out.println("Código do erro: " + ex.getErrorCode());
            return null;
        }
    }

/**
 * Salva a pontuação no ranking.
 * 
 * @param username  O nome de usuário.
 * @param pontuacao A pontuação a ser salva.
 */
    public void salvarPontuacaoRanking(String username, int pontuacao) {
        String query = new StringBuilder()
                .append("insert into tb_ranking (Username, Score)")
                .append(" values (?,?)").toString();
        
        try {
    		java.sql.PreparedStatement pst = con.prepareStatement(query);
    		pst.setString(1, username);
    		pst.setInt(2, pontuacao);
    		pst.execute();
    	}
    	 catch (SQLException ex) {
             System.out.println("SQL Exception: " + ex.getMessage());
             System.out.println("Código do erro: " + ex.getErrorCode());
         }
        
    }

 /**
 * Altera a pontuação de um usuário no ranking.
 * 
 * @param username  O nome de usuário.
 * @param pontuacao A nova pontuação.
 */   
    public void alterarRanking(String username, int pontuacao) {
        String query = new StringBuilder()
                .append("UPDATE tb_ranking SET score = ?")
                .append(" where username = ?")
                .toString();
        
        try {
    		java.sql.PreparedStatement pst = con.prepareStatement(query);
    		pst.setInt(1, pontuacao);
    		pst.setString(2, username);
    		pst.execute();
    	}
    	 catch (SQLException ex) {
             System.out.println("SQL Exception: " + ex.getMessage());
             System.out.println("Código do erro: " + ex.getErrorCode());
         }
    }


/**
* Verifica se um usuário possui ranking.
*
* @param username O nome de usuário.
* @return true se o usuário possuir ranking, false caso contrário.
*/
    public boolean usuarioPossuiRanking(String username)
    {
    	 String query = new StringBuilder()
                 .append("SELECT COUNT(1) as count")
                 .append(" FROM tb_ranking")
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
}
