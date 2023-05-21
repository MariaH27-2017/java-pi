package Services;
import Models.Historia;
import Models.HistoriaItem;
import Repositorios.HistoriaRepository;
import java.util.*;

public class HistoriaService {
	
	HistoriaRepository repository = new HistoriaRepository();
	String tracosEsquerda = "------------- ";
	String tracosDireita = " -------------";
	
	public HistoriaItem exibirHistoriaPeloNome(String nome)
	{
		HistoriaItem historia = repository.getHistoryByName(nome);
		exibirHistoria(historia);
		return historia;
	}
	
	public HistoriaItem exibirHistoriaDoUsuario(String nome)
	{
		HistoriaItem historia = repository.getHistoryByUsername(nome);
		exibirHistoria(historia);
		return historia;
	}
	
	public HistoriaItem exibirProximaParte(HistoriaItem historia)
	{
		HistoriaItem proxParte = repository.getProximaParte(historia);
		exibirHistoria(proxParte);
		return proxParte;
	}
	
	public void exibirOpcoesDeHistorias()
	{
		ArrayList<Historia> historias = repository.getHistorias();
		
		if(historias == null)
		{
			escrever("Nenhuma historia cadastrada");
		}
		else
		{
			for(Historia h : historias)
		      {
		    	  escrever(h.getNumero() + ". " +  h.getNome() + " : " + h.getDescricao());
		      }
		}
	}
	
	private void exibirHistoria(HistoriaItem historia)
	{
		if(historia == null)
		{
			escrever("Nenhuma historia encontrada");
		}
		else
		{
			String texto = new StringBuilder()
				    .append(tracosEsquerda)
					.append("Parte " + historia.getParte() + " - " + historia.getTitulo())
					.append("\r\n")
					.append(historia.getDescricao())
					.append(tracosDireita).toString();
					
					escrever(texto);
		}
			
	}
	
	
	public void escrever(Object texto)
	{
		System.out.println(texto);
	}
}
