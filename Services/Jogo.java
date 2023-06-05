package Services;
import java.util.*;
import ModosDeJogo.*;
import Repositorios.RankingRepository;
import Models.Usuario;
public class Jogo {

	/**
	 * O método `iniciar` é responsável por exibir o menu principal do jogo e
	 * permitir que o usuário escolha um modo de jogo. Ele cria instâncias dos
	 * objetos `ModoSolo`, `MultiJogador`, `ModoRankeada` e `ModoHistoria` para cada
	 * modo de jogo e exibe o menu principal até que o usuário escolha a opção "0"
	 * para sair do jogo.
	 */

	public static void iniciar() {

		int opcao = -1;

		Scanner input = new Scanner(System.in);
		ModoSolo modoSolo = new ModoSolo();
		MultiJogador multiJogador = new MultiJogador();
		ModoRankeada modoRankeada = new ModoRankeada();
		ModoHistoria modoHistoria = new ModoHistoria();
		RankingRepository ranking = new RankingRepository();
		Usuario usuario = new Usuario("Maria", "123");
		
		do {

			Animacao.exibirMenuInicial();
			System.out.print("Opcao: ");

			// tratamento de excecao
			if (input.hasNextInt()) { // verifica se há um valor inteiro disponível no fluxo de entrada
				opcao = input.nextInt(); // se houver, lê o valor inteiro e atribui à variável "opcao"
			} else {
				System.out.println("Entrada inválida. Por favor, tente novamente."); // se não houver, exibe uma
																						// mensagem de erro
			}

			do {
				// Entra em um loop até que o usuário escolha uma opcção válida (entre 0 e 5)
				if (opcao < 0 || opcao > 5) {
					System.out.println();
					System.out.println("[Insercao invalida]");
					System.out.println();
					System.out.print("Opcao: ");
					opcao = input.nextInt();

				}
			} while (opcao < 1 || opcao > 5);

			switch (opcao) {
			case 1:
				modoSolo.modoSolo();
				break;
			case 2:
				multiJogador.multiJogador();
				break;
			case 3:
				try {
					modoHistoria.iniciar(usuario);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 4:
				modoRankeada.Rankedada();
				break;
			case 5:
				ranking.getRanking();
				break;
			default:
				System.out.println("Opcao Inválida");
				break;
			}

		} while (opcao != 0);

		input.close();
	}

}
