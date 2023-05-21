package Models;

public class Historia {
	private int numero;
    private String nome;
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
