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
Última modificação: 03/06/2023 (Ana)
Classe RankingService
Essa classe é responsável por exibir o ranking do jogo e salvar as pontuações dos usuários.
Ela utiliza o  RankingRepository para acessar os dados do ranking no banco de dados.
*/
package Services;
import Models.Ranking;
import Repositorios.RankingRepository;
import java.util.*;

public class RankingService {
	RankingRepository repository = new RankingRepository();
	String tracosEsquerda = "------------- ";
	String tracosDireita = " -------------";

	/**
	 * O método `exibirRanking` exibe o ranking atual do jogo.
	 * Se o ranking estiver vazio, exibe a mensagem "Ranking Vazio".
	 * Caso contrário, exibe o título do ranking e a posição, nome de usuário e pontuação de cada jogador no ranking.
	 */
	public void exibirRanking()
	{
		ArrayList<Ranking> ranking = repository.getRanking();
		
		if(ranking == null)
		{
			escrever("Ranking Vazio.");
		}
		else
		{
			String titulo = new StringBuilder()
			.append(tracosEsquerda + "RANKING" + tracosDireita)			
			.toString();
			escrever(titulo);
			
			int posicao = 0;
			for(Ranking r : ranking)
		      {
				posicao += 1;
				String texto = new StringBuilder()
				.append(posicao + ". ")
				.append(r.getUsername() + " : " + r.getScore())
				.toString();
				
				escrever(texto);				
		      }

			escrever("-----------------------------------");
		}
	}
	
	/**
	 * O método `salvarPontuacao` salva a pontuação do jogador no ranking.
	 * Se o jogador já tiver uma pontuação registrada, a pontuação existente é atualizada.
	 * Caso contrário, uma nova entrada é criada no ranking para o jogador.
	 * @param username o nome de usuário do jogador
	 * @param pontuacao a pontuação do jogador a ser salva
	 */
	public void salvarPontuacao(String username, int pontuacao)
	{
		if(repository.usuarioPossuiRanking(username))
		{
			repository.alterarRanking(username, pontuacao);
		}
		else
		{
			repository.salvarPontuacaoRanking(username, pontuacao);
		}						
	}
	
	
	public void escrever(Object texto)
	{
		System.out.println(texto);
	}
}
