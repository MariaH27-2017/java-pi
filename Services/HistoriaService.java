package Services;
import Models.Historia;
import Models.HistoriaItem;
import Models.Usuario;
import Repositorios.HistoriaRepository;
import java.util.*;

public class HistoriaService {
	
	HistoriaRepository repository = new HistoriaRepository();
	Scanner scanner = new Scanner(System.in);
	String tracosEsquerda = "------------- ";
	String tracosDireita = " -------------";
	
	public HistoriaItem exibirHistoriaPeloNome(String nome)
	{
		HistoriaItem historia = repository.getHistoryByName(nome);
		exibirHistoria(historia);
		return historia;
	}

	public HistoriaItem exibirProximaParte(HistoriaItem historia)
	{
		HistoriaItem proxParte = repository.getProximaParte(historia);
		exibirHistoria(proxParte);
		return proxParte;
	}
	
	public HistoriaItem exibirOpcoesDeHistorias(Usuario usuario)
	{
		HistoriaItem historia = repository.getHistoryByUsername(usuario.getUsername());
		
		if(historia != null)
		{
			escrever("Você possui um save com a historia: " + historia.getNome());
			escrever("Deseja continuar? 1.Sim 2.Não");
			String r = scanner.nextLine();
			
			if(r.equalsIgnoreCase("Sim") || r.equalsIgnoreCase("1"))
			{
				return historia;
			}
		}
		
		ArrayList<Historia> historias = repository.getHistorias();
		
		if(historias == null)
		{
			escrever("Nenhuma historia cadastrada");
		}
		else
		{
			ArrayList<Integer> numerosHistorias = new ArrayList<Integer>();
			for(Historia h : historias)
		      {
		    	  escrever(h.getNumero() + ". " +  h.getNome() + " : " + h.getDescricao());
		    	  numerosHistorias.add(h.getNumero());
		      }
			
			int numero = 0;
	    	boolean numeroValido = false;
	    	while(numeroValido == false)
	    	{
	       	    scanner = new Scanner(System.in);
	       	 	
	       	    escrever("Digite o Número da Historia: ");
	    		if (scanner.hasNextInt()) 
		         {
		             numero = scanner.nextInt();
		             numeroValido = numerosHistorias.contains(numero);
		             if(numeroValido == true)
		             {
		            	 break;
		             }
		         }
	    		
	    		escrever("Você não digitou um número válido."); 		
	    		escrever("");
	    	}
	    	
	       historia = repository.getHistoryById(numero);
		}
		
		return historia;
	}
	
	public void exibirHistoria(HistoriaItem historia)
	{
		if(historia == null)
		{
			escrever("Nenhuma historia encontrada");
		}
		else if (historia.getParte() == 0)
		{
			escrever("Fim da historia, parabens jogador!");
		}
		else
		{
			String texto = new StringBuilder()
				    .append(tracosEsquerda)
					.append("Parte " + historia.getParte() + " - " + historia.getTitulo())
					.append(tracosDireita)
					.append("\r\n")
					.append(historia.getDescricao())
					.toString();
					
			escrever(texto);
			escrever("");
					
		}
			
	}
	
	private Historia filtrarHistoriaPeloNumero(int numero, ArrayList<Historia> historias)
	{
		Historia historia = null;
        for (Historia h : historias) {
            if (h.getNumero() == numero) {
                historia = h;
                break; 
            }
        }
        
        return historia;
	}
	
	public void escrever(Object texto)
	{
		System.out.println(texto);
	}
}
