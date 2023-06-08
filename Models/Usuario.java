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
	Classe Usuario (Model)
	Essa classe representa um objeto de modelo para a tabela "tb_user" do banco de dados.
 */
package Models;

public class Usuario {
    public String username;
    public String password;

    public Usuario() 
    { }
    
    public Usuario(String username, String password)
    {
    	this.username = username;
    	this.password = password;
    }
    
    // Username Get; Set;
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    // Password Get; Set;
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String value) {
        this.password = value;
    }
}
