/*
 * Nome do arquivo: ModoRankeada.java
 * Autor: Ana Lucia,Bruno de Oliveira, Giovanna Moreira, Lauriano Carlos, Melissa Gonçalves
 * Data de criação: 01/03/2023
 * Versão: 1.0
 * Descrição: classe que contém o modo de jogo Rankeada
 * Última modificação: 27/04/2023 (Lauriano)
 */

package ModosDeJogo;
import Services.Animacao;
import Repositorios.RankingRepository;
public class ModoRankeada extends ModoSolo {

	public void Rankedada() {

		
		         /**@link ModoSolo#inicializacaoModoRankeada()*/
		Animacao.inicializacaoModoRankeada();
		
		Usuario usuario = new Usuario(nomeJogador());
		RankingRepository repository = new RankingRepository();
		
	//O modo Rankeada se passa no modo fácil
			usuario.setNivelDeJogo(1);
			
			jogarNovamente = "S";
			// Define a pontuacao inicial do jogador
			placarJogador = 0;

			while (!(jogarNovamente == "N")) {

				boolean gol = true;
				
				do {
					                            /**@link ModoSolo#escolherCanto()*/
					usuario.setCantoSelecionado(escolherCanto());
					input.nextLine();

					if (usuario.getCantoSelecionado() < 1 || usuario.getCantoSelecionado() > 5) {
						System.out.println();
						System.out.println("[Insercao invalida]");
					}

				} while (usuario.getCantoSelecionado() < 1 || usuario.getCantoSelecionado() > 5);

				                  /**@link ModoSolo#nivel()*/
				int nivelLooping = nivel(usuario.getNivelDeJogo(), usuario.getCantoSelecionado(), goleiro);
				
				         /**@link ModoSolo#verificarPenalty()*/
			      gol = verificarPenalty(usuario.getCantoSelecionado(), nivelLooping);
			      
			      Animacao.gol(gol);
			      
			      if(gol == true) {
			    	  usuario.setPontuacao(10);
			      }else {
			    	  break;
			      }
			}
			
			System.out.println();
			System.out.println("--Fim de jogo!!!--");
			System.out.println("Sua pontuacao foi: "+ usuario.getPontuacao()+ " pontos!");
			
			repository.alterarRanking(usuario.getNome(), usuario.getPontuacao());
			System.out.println();

	}
}

