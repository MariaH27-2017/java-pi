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
	Última modificação: 01/06/2023 (Melissa)
	Classe Historia (Model)
	Essa classe representa um objeto de modelo para a tabela "tb_hystory" do banco de dados.
 */

package Models;

public class Historia {
	// representa o número da história
	private int numero;
	// representa o nome da história
    private String nome;
    // representa a descrição da história
    private String descricao;
    
    public Historia() {}
    
    public Historia(int numero, String nome, String descricao)
    {
    	this.numero = numero;
    	this.nome = nome;
    	this.descricao = descricao;
    }
    
    // Numero Get; Set;
    public int getNumero()
    {
    	return this.numero;
    }
    
    public void setNumero(int value)
    {
    	this.numero = value;
    }
    
    // Nome Get; Set;
    public String getNome()
    {
        return this.nome;
    }

    public void setNome(String value)
    {
        this.nome = value;
    }

    // Descricao Get; Set;
    public String getDescricao()
    {
        return this.descricao;
    }

    public void setDescricao(String value)
    {
        this.descricao = value;
    }


}
