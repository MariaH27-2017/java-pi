/* 
 Nome do Projeto: Penaltyfootball
Data de Criação: 30/07/2023
Banco de dados: MySQL
Package: Models
JDK: 17
Libraries: mysql-connector-java
Desenvolvedores:
	Ana Lucia
	Bruno de Oliveira
	Giovanna Moreira
	Lauriano Carlos
	Maria Helena dos Santos
	Melissa Gonçalves
	Última modificação: 01/06/2023 (Giovanna)
	Classe Ranking (Model)
	Essa classe representa um objeto de modelo para a tabela "tb_ranking" do banco de dados.
 */
package Models;

public class Ranking {
    // Representa o username cadastrado do usuario.
    public String username;
    // Representa o valor total de pontos adquiridos pelo usuario.
    public int score;

    // Username Get; Set;
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    // Score Get; Set;
    public int getScore() {
        return this.score;
    }

    public void setScore(int value) {
        this.score = value;
    }
}
