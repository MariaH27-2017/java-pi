package Models;

public class HistoriaItem {
    private String titulo;
    private String descricao;
    private int parte;
    private String nome;
    private int id;

    public HistoriaItem() {

    }

    public HistoriaItem(String titulo, String descricao, int parte, String nome) 
    {
        this.titulo = titulo;
        this.descricao = descricao;
        this.parte = parte;
        this.nome = nome;
    }
    
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
