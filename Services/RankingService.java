package Services;
import Models.Ranking;
import Models.Usuario;
import Repositorios.RankingRepository;
import java.util.*;

public class RankingService {
	RankingRepository repository = new RankingRepository();
	String tracosEsquerda = "------------- ";
	String tracosDireita = " -------------";
	
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
	
	public void salvarPontuacao(String username, int pontuacao)
	{
		repository.salvarPontuacaoRanking(username, pontuacao);
	}
	
	public void escrever(Object texto)
	{
		System.out.println(texto);
	}
}
