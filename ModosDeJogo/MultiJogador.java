/*
 * Nome do arquivo: MultiJogador.java
 * Autor: Ana Lucia,Bruno de Oliveira, Giovanna Moreira, Lauriano Carlos, Melissa Gonçalves
 * Data de criação: 01/03/2023
 * Versão: 1.0
 * Descrição: classe que contém o modo de jogo MultiJogador
 * Última modificação: 27/04/2023 (Lauriano)
 */
package ModosDeJogo;
import Services.Animacao;
import Models.Jogador;
public class MultiJogador extends ModoSolo {

	
	/**
	 * Pede ao usuário para inserir o nome do jogador e retorna o nome inserido.
	 * Se verificarJogador for verdadeiro, solicita o nome do goleiro.
	 * Se verificarJogador for falso, solicita o nome do batedor.
	 * 
	 * @param verificarJogador um valor booleano que indica se o jogador a ser inserido é um goleiro ou um batedor.
	 * @return o nome do jogador inserido.
	 */
	private String nomeJogador(boolean verificarJogador) {

		if (verificarJogador == false) {
			System.out.print("Insira seu BATEDOR: ");
		} else {
			System.out.print("Insira nome do GOLEIRO: ");
		}
		String nome = input.nextLine();

		System.out.println();

		System.out.println("Seja Bem vindo, " + nome);
		System.out.println();
		return nome;
	}

	/**
	 * Exibe um gol de futebol e solicita ao usuário que escolha um canto para chutar a bola.
	 * 
	 * @param nome o NOME do jogador que está chutando a bola.
	 * @return um número que representa o canto escolhido pelo jogador.
	 */
	private int escolherCanto(String nome) {

		System.out.println("\nESCOLHA UM CANTO!!!\n");

		System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
		System.out.println("II                              II");
		System.out.println("II  1                        4  II");
		System.out.println("II                              II");
		System.out.println("II              3               II");
		System.out.println("II                              II");
		System.out.println("II  2                        5  II");
		System.out.println("II                              II \n");

		System.out.println(
				"[1] Superior esquerdo \n[2] Inferior esquerdo \n[3] Meio \n[4] Superior Direito \n[5] Inferior Direito\n");
		System.out.print("Insira sua opcao " + nome.toUpperCase() + ":");
		int canto = input.nextInt();
		return canto;
	}

	
	/**
	Método de jogo que simula uma partida de penaltis 1x1, onde quem marcar 5 gols primeiro é o vencedor da partida
	*/
	public void multiJogador() {
		
		/**
		 * Inicia a animação de introdução do modo multiJogador
		 * @link Animacao#inicializacaoMultiJogador()
		 */        
		Animacao.inicializacaoMultiJogador();

		System.out.println();

		// Cria um objeto Usuario para o batedor e outro para o goleiro
		Jogador batedor = new Jogador(nomeJogador(false));
		Jogador goleiro = new Jogador(nomeJogador(true));

		jogarNovamente = "";
		// Inicializa os placares
		placarJogador = 0;
		placarGoleiro = 0;

		do {

			// Loop para o batedor escolher um canto válido
			do {
				batedor.setCantoSelecionado(escolherCanto(batedor.getNome()));
				// Verifica se a escolha do canto é inválida e exibe mensagem de erro
				if (batedor.getCantoSelecionado() < 1 || batedor.getCantoSelecionado() > 5) {
					System.out.println();
					System.out.println("[Insercao invalida]");
					System.out.println();
				}

			} while (batedor.getCantoSelecionado() > 5 || batedor.getCantoSelecionado() < 1);

			// Loop para o goleiro escolher um canto válido
			do {
				goleiro.setCantoSelecionado(escolherCanto(goleiro.getNome()));
				// Verifica se a escolha do canto é inválida e exibe mensagem de erro
				if (goleiro.getCantoSelecionado() < 1 || goleiro.getCantoSelecionado() > 5) {
					System.out.println();
					System.out.println("[Insercao invalida]");
					System.out.println();
				}

			} while (goleiro.getCantoSelecionado() > 5 || goleiro.getCantoSelecionado() < 1);

			
			boolean gol = true;
			// Verifica se o batedor acertou o canto do goleiro, se sim, não é gol
			if (batedor.getCantoSelecionado() == goleiro.getCantoSelecionado()) {
				gol = false;
			}
			// Atualiza o placar de acordo com o resultado da jogada
			if (gol) {
				placarJogador++;
			} else {
				placarGoleiro++;
			}
			
			System.out.println();
			// Exibe os resultados da jogada e o placar atual
			System.out
					.println("Canto: " + batedor.getCantoSelecionado() + " Goleiro: " + goleiro.getCantoSelecionado());
			System.out.println(
					batedor.getNome() + " [" + placarJogador + "] " + goleiro.getNome() + " [" + placarGoleiro + "]");

			System.out.println();

			// Verifica se um dos jogadores já atingiu a pontuação mínima para ganhar o jogo
			if (placarJogador >= 5) {
				Animacao.exibirGanhador(true);
				break;
			}
			if (placarGoleiro >= 5) {
				Animacao.exibirGanhador(false);
				break;
			}

			// Tratamento de erro, limpeza do buffer de entrada
			input.nextLine();// Isso garante que a próxima leitura do Scanner será feita corretamente.
			String entrada = "";

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

			// Encerramento do modo multiJogador
			if (jogarNovamente.equalsIgnoreCase("N")) {

				System.out.println();
				System.out.println("--- Modo MutiJogador encerrado ---");
				System.out.println();

				break;
			}

		} while ((jogarNovamente.equalsIgnoreCase("S") || jogarNovamente.equalsIgnoreCase("N")));
	}
}

