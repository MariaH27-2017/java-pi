/*
Nome do Projeto: Penaltyfootball
Data de Criação:  01/03/2023
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
Última modificação: 03/03/2023 (Lauriano)
Classe Jogador (Model)
Essa classe representa um objeto de modelo para o Modo Solo, Multiplayer e Modo Ranqueado.
*/
package Models;

public class Jogador {
	private String nome;
	private int nivelDeJogo;
	private int cantoSelecionado;
	private int pontuacao;
	private int id_usuario;

	/**
	 * Construtor padrão da classe. Inicializa o nome com o valor "Batedor", o nível
	 * de jogo com 1, o canto selecionado com 1 e a pontuação com 0.
	 */
	public Jogador() {
		this.nome = "Batedor";
		this.nivelDeJogo = 1;
		this.cantoSelecionado = 1;
		this.pontuacao = 0;
	}

	/**
	 * Construtor da classe que recebe o nome do usuário como parâmetro.
	 * 
	 * @param nome o nome do usuário.
	 */
	public Jogador(String nome) {
		this.nome = nome;
		this.nivelDeJogo = 1;
		this.cantoSelecionado = 1;
		this.pontuacao = 0;
	}

	/**
	 * 
	 * Método para obter o nome do usuário.
	 * 
	 * @return o nome do usuário.
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * 
	 * Método para definir o nome do usuário.
	 * 
	 * @param nome o nome do usuário.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
	 * 
	 * Método para obter o nível de jogo do usuário.
	 * 
	 * @return o nível de jogo do usuário.
	 */
	public int getNivelDeJogo() {
		return nivelDeJogo;
	}

	/**
	 * 
	 * Método para definir o nível de jogo do usuário.
	 * 
	 * @param nivelDeJogo o nível de jogo do usuário.
	 */
	public void setNivelDeJogo(int nivelDeJogo) {
		this.nivelDeJogo = nivelDeJogo;
	}

	/**
	 * 
	 * Método para obter a pontuação atual do usuário.
	 * 
	 * @return a pontuação atual do usuário.
	 */
	public int getPontuacao() {
		return pontuacao;
	}

	/**
	 * 
	 * Método para atualizar a pontuação do usuário.
	 * 
	 * @param pontuacao a pontuação a ser somada à pontuação atual do usuário.
	 */
	public void setPontuacao(int pontuacao) {
		this.pontuacao += pontuacao;
	}

	/**
	 * 
	 * Método para obter o canto selecionado pelo usuário.
	 * 
	 * @return o canto selecionado pelo usuário.
	 */
	public int getCantoSelecionado() {
		return cantoSelecionado;
	}

	/**
	 * 
	 * Método para definir o canto selecionado pelo usuário.
	 * 
	 * @param cantoSelecionado o canto selecionado pelo usuário.
	 */
	public void setCantoSelecionado(int cantoSelecionado) {
		this.cantoSelecionado = cantoSelecionado;
	}

	/**
	 * 
	 * Método para obter o ID do usuário.
	 * 
	 * @return o ID do usuário.
	 */
	public int getId_usuario() {
		return id_usuario;
	}

	/**
	 * 
	 * Método para definir o ID do usuário.
	 * 
	 * @param id_usuario o ID do usuário.
	 */
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
}
