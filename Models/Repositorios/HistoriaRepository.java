package Models.Repositorios;

import java.sql.Connection;

import Models.Historia;
import Models.HistoriaItem;
import Models.Database.DbConnection;
import java.sql.*;
import java.sql.DriverManager;

import java.sql.SQLException;

public class HistoriaRepository {

    DbConnection db = new DbConnection();
    Connection con = db.getConexaoMySQL();

    public HistoriaItem getHistoryByUsername(String username) {
        try (Statement stmt = con.createStatement()) {
            
            String query = "select h.Nm_History as nome, h.description as descricao, h.Title as titulo from tb_save s inner join tb_history_item h on s.id_history_item = h.id where Username = '" 
                    + username + "'";

            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                String nome = rs.getString("nome");
                String descricao = rs.getString("descricao");
                String titulo = rs.getString("titulo");
            }
            HistoriaItem historia = new HistoriaItem();
            return historia;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex.getMessage());
            System.out.println("Código do erro: " + ex.getErrorCode());

        }
    }

    public HistoriaItem getProximaParte(HistoriaItem historia) {
        String query = new StringBuilder()
        .append("select h.Nm_History as nome, h.description as descricao, h.Title as titulo")
        .append("from tb_history_item h")
        .append("where h.Part = " + (historia.getParte() + 1)).toString();
        
        
    }

    

}
