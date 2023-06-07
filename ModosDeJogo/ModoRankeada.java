/*
 * Nome do arquivo: ModoRankeada.java
 * Autor: Ana Lucia,Bruno de Oliveira, Giovanna Moreira, Lauriano Carlos, Melissa Gonçalves
 * Data de criação: 01/03/2023
 * Versão: 1.0
 * Descrição: classe que contém o modo de jogo Rankeada
 * Última modificação: 27/04/2023 (Lauriano)
 */

package ModosDeJogo;
import Services.*;
import Models.*;
public class ModoRankeada extends ModoSolo {

	public void Rankedada(Usuario usuario) throws InterruptedException {

		
		         /**@link ModoSolo#inicializacaoModoRankeada()*/
		Animacao.inicializacaoModoRankeada();
		
		Jogador jogador = new Jogador(usuario.getUsername());
		RankingService rankingService = new RankingService();
		JogoService jogoService = new JogoService();
		boolean gol = false;
		
			//O modo Rankeada se passa no modo fácil
			jogador.setNivelDeJogo(1);
			
			jogarNovamente = "S";
			
			// Define a pontuacao inicial do jogador
			placarJogador = 0;

			while (!(jogarNovamente == "N")) {
						/**@link JogoService#iniciarPartida()*/
				gol = jogoService.iniciarPartida(jogador.getNivelDeJogo());
				
			      if(gol == true) {
			    	  jogador.setPontuacao(10);
			      }else {
			    	  break;
			      }
			}
			
			System.out.println();
			System.out.println("--Fim de jogo!!!--");
			System.out.println("Sua pontuacao foi: "+ jogador.getPontuacao()+ " pontos!");
			rankingService.salvarPontuacao(jogador.getNome(), jogador.getPontuacao());
			System.out.println();
	}
}

