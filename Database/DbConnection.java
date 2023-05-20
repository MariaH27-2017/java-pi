package Models.Database;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class DbConnection {
    public static String status = "Não conectou...";
    
    public DbConnection(){
        
    }
    public static java.sql.Connection getConexaoMySQL() 
    {

        Connection connection = null;          //atributo do tipo Connection



    try {

        // Carregando o JDBC Driver padrão
            
        String driverName = "com.mysql.jdbc.Driver";
            
        Class.forName(driverName);
            
            
            
        // Configurando a nossa conexão com um banco de dados//
            
                String serverName = "localhost";    //caminho do servidor do BD
            
                String mydatabase = "";        //nome do seu banco de dados
            
                String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
            
                String username = "root";        //nome de um usuário de seu BD
            
                String password = "123456";      //sua senha de acesso
            
                connection = DriverManager.getConnection(url, username, password);



                //Testa sua conexão//

                if (connection != null) 
                {
                
                    status = ("STATUS--->Conectado com sucesso!");
                
                } 
                else 
                {
                
                    status = ("STATUS--->Não foi possivel realizar conexão");
                
                }



        return connection;



        } catch (ClassNotFoundException e) {  //Driver não encontrado



            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {

        //Não conseguindo se conectar ao banco

            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }



    }


    public static void adicionarNaTabelaRanking(String nome, int pontuacao) {
        // Atributos de conexão JBDC
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // Carrega o driver JDBC do MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Define os parâmetros de conexão
            String url = "jdbc:mysql://containers-us-west-39.railway.app:7370/railway";
            String usuario = "root";
            // senha do banco de dados
            String senha = "lMnPfO3W5wHiMC8kANDh";

            // Estabelece a conexão
            conn = DriverManager.getConnection(url, usuario, senha);
            // Verifica se já existe um registro com o mesmo nome
            String sqlSelect = "SELECT * FROM rankeada WHERE nome = ?";
            PreparedStatement stmtSelect = conn.prepareStatement(sqlSelect);
            stmtSelect.setString(1, nome);
            rs = stmtSelect.executeQuery();

            // Se já existe um registro com o mesmo nome
            if (rs.next()) {
                int id = rs.getInt("id"); // obtém o ID do registro existente
                int pontuacaoExistente = rs.getInt("pontuacao"); // obtém a pontuação existente
                // Se a pontuação atual for maior do que a existente, atualiza a pontuação
                if (pontuacao > pontuacaoExistente) {
                    String sqlUpdate = "UPDATE rankeada SET pontuacao = ? WHERE id = ?";
                    PreparedStatement stmtUpdate = conn.prepareStatement(sqlUpdate);
                    stmtUpdate.setInt(1, pontuacao);
                    stmtUpdate.setInt(2, id);
                    stmtUpdate.executeUpdate();
                    System.out.println("--Novo Recorde!!--");
                } else {
                    System.out.println();
                }

            }

            // Se não existe um registro com o mesmo nome, insere um novo registro
            else {
                String sqlInsert = "INSERT INTO rankeada (nome, pontuacao) VALUES (?, ?)";
                PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);
                stmtInsert.setString(1, nome);
                stmtInsert.setInt(2, pontuacao);
                stmtInsert.executeUpdate();
                System.out.println("Novo registro inserido com sucesso.");
            }

        } catch (ClassNotFoundException e) {
            // Se o driver JDBC não puder ser carregado, exibe uma mensagem de erro
            e.printStackTrace();
        } catch (SQLException e) {
            // Se ocorrer um erro durante a conexão ou consulta, exibe uma mensagem de erro
            e.printStackTrace();
        } finally {
            try {
                // Fecha os recursos
                if (stmt != null) {
                    stmt.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                // Se ocorrer um erro ao fechar os recursos, exibe uma mensagem de erro
                e.printStackTrace();
            }
        }
    }

}