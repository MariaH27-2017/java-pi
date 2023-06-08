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
Classe HistoriaItem (Model)
Essa classe representa um objeto de modelo para a tabela "tb_history_item" do banco de dados.
*/

package Models;

public class HistoriaItem {
    // Representa o titulo da parte da Historia.
    private String titulo;
    // Representa a descricao do texto da historia.
    private String descricao;
    // Representa o número da parte da historia.
    private int parte;
    // Representa o Nome da Historia
    private String nome;
    // Representa o Id da tabela "tb_history_item"
    private int id;
    
    // Id Get; Set;
    public int getId()
    {
    	return this.id;
    }
    
    public void setId(int value)
    {
    	this.id = value;
    }

    // Titulo Get; Set;
    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String value) {
        this.titulo = value;
    }

    // Descricao Get; Set;
    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String value) {
        this.descricao = value;
    }

    // Parte
    public int getParte() {
        return this.parte;
    }

    public void setParte(int value) {
        this.parte = value;
    }

    // Nome Get; Set;
    public String getNome() {
        return this.nome;
    }

    public void setNome(String value) {
        this.nome = value;
    }
}
