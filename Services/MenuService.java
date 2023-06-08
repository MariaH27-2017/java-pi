/*
Nome do Projeto: Penaltyfootball
Data de Criação: 29/05/2023
Banco de dados: MySQL
Package: Services
JDK: 17
Libraries: mysql-connector-java
Desenvolvedores:
Ana Lucia
Bruno de Oliveira
Giovanna Moreira
Lauriano Carlos
Maria Helena dos Santos
Melissa Gonçalves
Última modificação: 01/06/2023 (Lauriano)
Classe MenuService
Essa classe é responsável por exibir o menu principal do jogo e permitir que o usuário escolha um modo de jogo.
Ela cria instâncias dos objetos ModoSolo, MultiJogador, ModoRankeada e ModoHistoria para cada modo de jogo.
*/

package Services;
import java.util.*;
import ModosDeJogo.*;
import Models.Usuario;

public class MenuService {

	/**
	 * O método `iniciar` é responsável por exibir o menu principal do jogo e
	 * permitir que o usuário escolha um modo de jogo. Ele cria instâncias dos
	 * objetos `ModoSolo`, `MultiJogador`, `ModoRankeada` e `ModoHistoria` para cada
	 * modo de jogo e exibe o menu principal até que o usuário escolha a opção "0"
	 * para sair do jogo.
	 * @throws InterruptedException 
	 */

	public static void iniciar(Usuario usuario) throws InterruptedException {

		int opcao = -1;
	
		Scanner input = new Scanner(System.in);
		ModoSolo modoSolo = new ModoSolo();
		MultiJogador multiJogador = new MultiJogador();
		ModoRankeada modoRankeada = new ModoRankeada();
		ModoHistoria modoHistoria = new ModoHistoria();
		RankingService ranking = new RankingService();		
		do {

			Animacao.exibirMenuInicial();
			System.out.print("Opcao: ");

			// Entra em um loop até que o usuário escolha uma opcção válida (entre 0 e 5)
			boolean numeroValido = false;		
        	while(numeroValido == false)
        	{
        		input = new Scanner(System.in);
           	 	
        		if (input.hasNextInt()) 
    	         {
        			 opcao = input.nextInt();
    	             numeroValido = opcao >= 0 || opcao <= 5;
    	             if(numeroValido == true)
    	             {
    	            	 break;
    	             }
    	         }
        		
        		System.out.println("Você não digitou um número válido. Escolha a opção de 0 a 5"); 		
        		System.out.println("");
        	}

			switch (opcao) {
			case 1:
				modoSolo.modoSolo(usuario);
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
				modoRankeada.Rankedada(usuario);
				break;
			case 5:
				ranking.exibirRanking();
				break;
			case 0:
				System.out.println("Obrigado por jogar! Volte sempre para novas aventuras e desafios emocionantes!");
				break;
			default:
				System.out.println("Opcao Inválida");
				break;
			}

		} while (opcao != 0);

		input.close();
	}

}
