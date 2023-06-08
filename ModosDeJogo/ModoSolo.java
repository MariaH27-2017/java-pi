/*
 * Nome do arquivo: ModoSolo.java
 * Autor: lauriano <laurianocarlos@hotmail.com>
 * Data de criação: 01/03/2023
 * Versão: 1.0
 * Descrição: classe com o metodo de modoSolo, super classe
 * Colaboradores: Ana Lucia, Bruno de Oliveira, Giovanna Moreira, Maria Helena dos Santos, Melissa Gonçalve, Lauriano Carlos
 * Última modificação: 27/04/2023 (Lauriano)
 */

package ModosDeJogo;
import java.util.*;
import Services.*;
import Models.*;
public class ModoSolo {

	protected int goleiro;
	protected int placarJogador;
	protected int placarGoleiro;
	protected String jogarNovamente;
	JogoService jogoService = new JogoService();
	
	/*Metodo para atribuir dados aos atributos*/
	protected Scanner input;

	/*define um objeto Scanner para pegar dados do usuario*/
	 
	public ModoSolo() {
		this.input = new Scanner(System.in);
	}

    /**
     * Retorna o canto do goleiro.
     * @return o canto do goleiro.
     */
    public int getGoleiro() {
        return goleiro;
    }
    
    /**
     * Define o canto do goleiro.
     * @param goleiro o índice do goleiro.
     */
    public void setGoleiro(int goleiro) {
        this.goleiro = goleiro;
    }
    
    /**
     * Retorna o placar do jogador.
     * @return o placar do jogador.
     */
    public int getPlacarJogador() {
        return placarJogador;
    }
    
    /**
     * Define o placar do jogador.
     * @param placarJogador o placar do jogador.
     */
    public void setPlacarJogador(int placarJogador) {
        this.placarJogador = placarJogador;
    }
    
    /**
     * Retorna o placar do goleiro.
     * @return o placar do goleiro.
     */
    public int getPlacarGoleiro() {
        return placarGoleiro;
    }
    
    /**
     * Define o placar do goleiro.
     * @param placarGoleiro o placar do goleiro.
     */
    public void setPlacarGoleiro(int placarGoleiro) {
        this.placarGoleiro = placarGoleiro;
    }

	/**
	 * 
	 * Método responsável por solicitar ao usuário que escolha um nível de
	 * dificuldade para o jogo.
	 * 
	 * @return Um número inteiro que representa o nível escolhido pelo usuário.
	 */
	protected int escolherNivel() {

		System.out.println();
		System.out.println("DIFICULDADE:");
		System.out.println();

		System.out.println("[1] FÁCIL\n[2] MÉDIO\n[3] DIFÍCIL");
		System.out.print("Escolha uma dificuldade (Insira número): ");
		int nivel = input.nextInt();

		return nivel;
	}

	/**
	Método de jogo que simula uma partida de penaltis onde quem marcar 5 gols primeiro é o vencedor da partida
	 * @throws InterruptedException 
	*/
	public void modoSolo(Usuario usuario) throws InterruptedException {
		/*@link Animacao#inicializacaoModoSolo()
		 Chama o método de inicialização da animação*/
		Animacao.inicializacaoModoSolo();

		// Cria um objeto de usuário com o nome informado pelo jogador
		Jogador jogador = new Jogador(usuario.getUsername());

		do {
			// Entra em um loop até que o usuário escolha um nível de jogo válido (entre 1 e 3)
			jogador.setNivelDeJogo(escolherNivel());

			if (jogador.getNivelDeJogo() < 1 || jogador.getNivelDeJogo() > 3) {
				System.out.println();
				System.out.println("[Insercao invalida]");
			}

		} while (jogador.getNivelDeJogo() < 1 || jogador.getNivelDeJogo() > 3);

		jogarNovamente = "S";
		// Define os placares do jogador e do goleiro como zero
		placarJogador = 0;
		placarGoleiro = 0;

		// Entra em um loop enquanto o usuário desejar jogar novamente
		while (!(jogarNovamente == "N")) {
			
			/**@link JogoService#iniciarPartida*/
			boolean gol = jogoService.iniciarPartida(jogador.getNivelDeJogo());
							
			System.out.println();
			
			// Atualiza os placares de acordo com o resultado do pênalti
			if (gol) {
				placarJogador++;
			} else {
				placarGoleiro++;
			}

			// Exibe os placares atualizados.
			System.out.println();
			System.out.println("Gols[" + placarJogador + "] " + "Defesas[" + placarGoleiro + "]");

			System.out.println();

			// Verifica o ganhador da partida e encerra o loop/jogo
			if (placarJogador >= 5) {
				/** exibi a mensagem do vencedor
				 * @link Animacao#exibirGanhador()
				 */
				Animacao.exibirGanhador(true);
				System.out.println();
				break;
			}
			if (placarGoleiro >= 5) {
				/** exibi a mensagem do perdedor
				 * * @link Animacao#exibirGanhador()
				 */
				Animacao.exibirGanhador(false);
				System.out.println();
				break;
			}

			// Tratamento de erro,limpeza do buffer de entrada
			input.nextLine();// Isso garante que a próxima leitura do Scanner será feita corretamente.

			String entrada = "S";

			// Entra em um loop enquanto o usuário desejar jogar novamente
			do {
				System.out.print("Deseja jogar novamente (S/N)? ");
				entrada = input.nextLine().toUpperCase();

				// tratamento de erro, verifica se a entrada tem pelo menos um caractere
				if (entrada.length() > 0) {
					jogarNovamente = entrada.charAt(0) + "";
				} else {
					jogarNovamente = "";
				}

			} while (!(jogarNovamente.equalsIgnoreCase("S") || jogarNovamente.equalsIgnoreCase("N")));

			// Encerramento do modo de jogo solo
			if (jogarNovamente.equalsIgnoreCase("N")) {

				System.out.println();
				System.out.println("--- Modo solo encerrado ---");
				System.out.println();
				break;
			}
		}
	}
}
