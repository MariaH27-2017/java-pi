package ModosDeJogo;
import java.util.*;
import Services.Animacao;
public class ModoSolo {

	protected int goleiro;
	protected int placarJogador;
	protected int placarGoleiro;
	protected String jogarNovamente;

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
	 * Método responsável por gerar um número aleatório.
	 * 
	 * @return Um número inteiro aleatório.
	 */
	protected int numeroAleatorio() {

		int cantoGoleiro = ((int) (Math.random() * 5) + 1);
		return cantoGoleiro;
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
	 * Método utilizado para gerar um número aleatório que representa a posição do
	 * goleiro no jogo de simulação de pênaltis.
	 * 
	 * @param nivel            Inteiro que determina a dificuldade do jogo (1, 2 ou
	 *                         3)
	 * @param cantoSelecionado Inteiro que representa a posição escolhida pelo
	 *                         jogador para chutar a bola (entre 1 e 5)
	 * @param goleiro          Inteiro que representa a posição do goleiro, gerado
	 *                         aleatoriamente (entre 1 e 5)
	 * @return Inteiro que representa a posição do goleiro
	 */
	protected int nivel(int nivel, int cantoSelecionado, int goleiro) {
		int numero[] = new int[4]; // Vetor utilizado para armazenar os números aleatórios gerados
		
		
		 
		// Verifica o valor de nivel para decidir quantos números aleatórios deve gerar
		switch (nivel) {
		case 1:
			// Se nivel for igual a 1, gera apenas um número aleatório entre 1 e 10 e o
			// compara com o cantoSelecionado
			for (int c = 0; c <= 0; c++) {
				numero[c] = ((int) (Math.random() * 10) + 1);//(Casting explícito)  Gera um número aleatório entre 1 e 5
															 //para representar a posição do goleiro	
				if (cantoSelecionado == numero[c]) {
					// Se o número aleatório gerado for igual ao cantoSelecionado, o valor desse
					// número é atribuído à variável goleiro
					goleiro = numero[c];
				}
			}
			break;

		case 2:
			// Se nivel for igual a 2, gera 2 números aleatórios e os compara com o
			// cantoSelecionado
			for (int c = 0; c <= nivel; c++) {
				numero[c] = numeroAleatorio();
				if (cantoSelecionado == numero[c]) {
					// Se algum dos números aleatórios gerados for igual ao cantoSelecionado, o
					// valor desse número é atribuído à variável goleiro
					goleiro = numero[c];
				}
			}
			break;

		case 3:
			// Se nivel for igual a 3, gera 3 números aleatórios e os compara com o
			// cantoSelecionado
			for (int c = 0; c <= nivel; c++) {
				numero[c] = numeroAleatorio();
				if (cantoSelecionado == numero[c]) {
					// Se algum dos números aleatórios gerados for igual ao cantoSelecionado, o
					// valor desse número é atribuído à variável goleiro
					goleiro = numero[c];
				}
			}
			break;

		default:
			// Se nivel não for igual a 1, 2 ou 3, exibe uma mensagem de erro no console
			System.out.println("Erro... Reinicie o jogo!");
		}

		// Retorna o valor da variável goleiro
		// Se o valor for diferente de cantoSelecionado terá que ser marcado o gol senão
		// defesa di goleiro
		return goleiro;
	}
	

	/**
	 * 
	 * Método responsável por verificar se foi gol ou defesa.
	 * 
	 * @return Booleano onde true é considerado gol e false considerado defesa.
	 */
	protected boolean verificarPenalty(int cantoSelecionado, int goleiro) {

		boolean gol = true;

		if (cantoSelecionado == goleiro) {
			gol = false;
		}

		return gol;
	}

	/**
	 * 
	 * Método responsável por solicitar ao usuário que insira seu nome.
	 * 
	 * @return String que representa o nome escolhido pelo usuário.
	 */
	protected String nomeJogador() {

		System.out.print("Insira seu nome: ");
		String nome = input.nextLine();

		System.out.println();

		System.out.println("Seja Bem vindo, " + nome);
		System.out.println();
		System.out.println("Vamos as cobranças?!");

		System.out.println();

		return nome;
	}

	/**
	 * 
	 * Método responsável por solicitar ao usuário que escolha um canto para chutar.
	 * 
	 * @return Um número inteiro que representa o canto escolhido pelo usuário.
	 */
	protected int escolherCanto() {

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
		System.out.print("Opcao: ");
		int canto = input.nextInt();
		return canto;
	}
	
	/**
	Método de jogo que simula uma partida de penaltis onde quem marcar 5 gols primeiro é o vencedor da partida
	*/

	public void modoSolo() {
		/*@link Animacao#inicializacaoModoSolo()
		 Chama o método de inicialização da animação*/
		Animacao.inicializacaoModoSolo();

		// Cria um objeto de usuário com o nome informado pelo jogador
		Usuario usuario = new Usuario(nomeJogador());

		do {
			// Entra em um loop até que o usuário escolha um nível de jogo válido (entre 1 e
			// 3)
			usuario.setNivelDeJogo(escolherNivel());

			if (usuario.getNivelDeJogo() < 1 || usuario.getNivelDeJogo() > 3) {
				System.out.println();
				System.out.println("[Insercao invalida]");
			}

		} while (usuario.getNivelDeJogo() < 1 || usuario.getNivelDeJogo() > 3);

		jogarNovamente = "S";
		// Define os placares do jogador e do goleiro como zero
		placarJogador = 0;
		placarGoleiro = 0;

		// Entra em um loop enquanto o usuário desejar jogar novamente
		while (!(jogarNovamente == "N")) {

			// Entra em um loop até que o usuário escolha um canto válido (entre 1 e 5)
			do {
				usuario.setCantoSelecionado(escolherCanto());

				if (usuario.getCantoSelecionado() < 1 || usuario.getCantoSelecionado() > 5) {
					System.out.println();
					System.out.println("[Insercao invalida]");
				}

			} while (usuario.getCantoSelecionado() < 1 || usuario.getCantoSelecionado() > 5);

			          /**@link ModoSolo#numeroAleatorio*/
			goleiro = numeroAleatorio();
			
			int nivelLooping = nivel(usuario.getNivelDeJogo(), usuario.getCantoSelecionado(), goleiro);
			/** Verifica se o usuário fez um gol ou não, com base no canto selecionado e no
			 * @link ModoSolo#nivel
			 */
			boolean gol = verificarPenalty(usuario.getCantoSelecionado(), nivelLooping);

			/* Chama o método de animação para mostrar se o usuário fez um gol ou não
			 * * @link Animacao#gol()
			 */
			Animacao.gol(gol);

			System.out.println();
			// Atualiza os placares de acordo com o resultado do pênalti
			if (gol) {
				placarJogador++;
			} else {
				placarGoleiro++;
			}

			// Exibe os placares atualizados e a escolha do jogador e do goleiro
			System.out.println();
			System.out.println("Batedor: " + usuario.getCantoSelecionado() + " Goleiro: " + nivelLooping);
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
	
	public class Usuario {

		private String nome;
		private int nivelDeJogo;
		private int cantoSelecionado;
		private int pontuacao;
		private int id_usuario;

		/**
		 * Construtor padrão da classe. Inicializa o nome com o valor "Batedor", o nível
		 * de jogo com 1, o canto selecionado com 1 e a pontuação com 0.
		 */
		public Usuario() {
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
		public Usuario(String nome) {
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

}
