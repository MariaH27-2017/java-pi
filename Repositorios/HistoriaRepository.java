package Repositorios;

import java.sql.Connection;
import java.util.*;
import Models.Historia;
import Models.HistoriaItem;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import Database.DbConnection;

public class HistoriaRepository {

    DbConnection db = new DbConnection();
    Connection con = db.getConexaoMySQL();

    public HistoriaItem getHistoryByUsername(String username) {
    	
    	HistoriaItem result = null;
    	
        String query = new StringBuilder()
        .append("select h.Nm_History as Nome, h.Part as Parte, h.Title as Titulo, h.description as Descricao ")
        .append("from tb_save s ")
        .append("inner join tb_history_item h ")
        .append("on s.id_history_item = h.id ")
        .append("where s.username = '" + username + "'").toString();
        
        result = executeQuery(query);
        
        if(result.getParte() == 0)
        {
        	query = new StringBuilder()
        	        .append("select h.Nm_History as Nome, h.Part as Parte, h.Title as Titulo, h.description as Descricao ")
        	        .append("from tb_history_item h ")
        	        .append("on s.id_history_item = h.id ")
        	        .append("where h.Parte = 1").toString();
        	
        	result = executeQuery(query);
        	     	
        }     
        
        return result;
    }

    public HistoriaItem getProximaParte(HistoriaItem historia) {
        String query = new StringBuilder()
        .append("select h.Nm_History as nome, h.description as descricao, h.Title as titulo, h.Part as Parte ")
        .append("from tb_history_item h ")
        .append("where h.Part = " + (historia.getParte() + 1))
        .append(" and h.Nm_History = '" + historia.getNome() + "'").toString();
        
        return executeQuery(query);
        
    }
    
    private HistoriaItem executeQuery(String query)
    {
    	try (Statement stmt = con.createStatement()) {
            
            String nome = "";
            String descricao = "";
            String titulo = "";
            int parte = 0;

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                nome = rs.getString("Nome");
                descricao = rs.getString("Descricao");
                titulo = rs.getString("Titulo");
                parte = rs.getInt("Parte");
            }
            HistoriaItem historia = new HistoriaItem(titulo, descricao, parte, nome);
           
            return historia;

        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            System.out.println("Código do erro: " + ex.getErrorCode());
            return null;
        }
    }
    

    

}
