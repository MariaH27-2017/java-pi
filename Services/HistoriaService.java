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
Última modificação: 07/06/2023 (Maria Helena)
Classe HistoriaService
Essa classe é responsável por fornecer serviços relacionados às histórias do jogo.
Ela utiliza os repositórios de História e Save para obter informações do banco de dados.
*/
package Services;
import Models.Historia;
import Models.HistoriaItem;
import Models.Usuario;
import Repositorios.HistoriaRepository;
import Repositorios.SaveRepository;

import java.util.*;

public class HistoriaService {
	
	HistoriaRepository repository = new HistoriaRepository();
    SaveRepository saveRepository = new SaveRepository();
	String tracosEsquerda = "------------- ";
	String tracosDireita = " -------------";
	
/**
 * Exibe a história correspondente ao nome informado.
 * @param nome O nome da história.
 * @return O objeto HistoriaItem correspondente à história exibida.
 */
	public HistoriaItem exibirHistoriaPeloNome(String nome)
	{
	    // O método "getHistoryByName" é responsável por obter uma história pelo nome.
		HistoriaItem historia = repository.getHistoryByName(nome);
		exibirHistoria(historia);
		return historia;
	}

/**
 * Exibe a próxima parte da história, com base no histórico do usuário.
 * @param historia O objeto HistoriaItem representando a parte atual da história.
 * @param username O nome de usuário do usuário.
 * @return O objeto HistoriaItem correspondente à próxima parte da história exibida.
 */
	public HistoriaItem exibirProximaParte(HistoriaItem historia, String username)
	{
		// O método "getProximaParte" é responsável por obter a próxima parte de uma história.
		HistoriaItem proxParte = repository.getProximaParte(historia);

		if(proxParte == null || proxParte.getParte() == 0)
		{
			escrever("");
			escrever("Parabéns você concluiu a história: " + historia.getNome() + "!");
			
			return null;
		}
		else
		{
		    // O método "salvar" é responsável por salvar o progresso do usuário.
			saveRepository.salvar(username, proxParte.getId());
			exibirHistoria(proxParte);
			return proxParte;
		}
		
		
	}

/**
 * Exibe as opções de histórias disponíveis para o usuário.
 * Verifica se o usuário possui um save de história e, caso positivo, oferece a opção de continuar a partir do save.
 * Caso contrário, exibe todas as histórias disponíveis para escolha.
 * @param usuario O objeto Usuario representando o usuário.
 * @return O objeto HistoriaItem correspondente à história escolhida pelo usuário.
 */
	public HistoriaItem exibirOpcoesDeHistorias(Usuario usuario)
	{
		HistoriaItem historia = repository.getHistoryByUsername(usuario.getUsername());
		Scanner scanner = new Scanner(System.in);

		if(historia.getNome() != null)
		{
			escrever("Você possui um save com a historia: " + historia.getNome());
			escrever("Deseja continuar? 1.Sim 2.Não");
			String r = scanner.nextLine();
			
			if(r.equalsIgnoreCase("Sim") || r.equalsIgnoreCase("1"))
			{
				return historia;
			}
		}
		
		// O método "getHistorias" é responsável por obter a lista de histórias disponíveis.
		ArrayList<Historia> historias = repository.getHistorias();
		
		if(historias == null)
		{
			escrever("Nenhuma historia cadastrada");
		}
		else
		{
			ArrayList<Integer> numerosHistorias = new ArrayList<Integer>();
			escrever("Escolha uma historia: ");
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

				// Verifica se o usuário digitou um número válido para a história.
	    		if (scanner.hasNextInt()) 
		         {
		             numero = scanner.nextInt();

					// Verifica se o número é válido, ou seja, se corresponde a uma história existente.
		             numeroValido = numerosHistorias.contains(numero);
		             if(numeroValido == true)
		             {
		            	 break;
		             }
		         }
	    		
	    		escrever("Você não digitou um número válido."); 		
	    		escrever("");
	    	}
			
	    	// O método "getHistoryById" é responsável por obter uma história pelo seu número.
	       historia = repository.getHistoryById(numero);
		}
		
		return historia;
	}

/**
Exibe a parte da história atualmente selecionada.

@param historia O objeto HistoriaItem representando a parte da história a ser exibida.
*/
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
			escrever("");
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
		
	public void escrever(Object texto)
	{
		System.out.println(texto);
	}
}
