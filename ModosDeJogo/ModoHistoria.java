/*

Nome do Projeto: Penaltyfootball
Data de Criação: 27/05/2023
Banco de dados: MySQL
Package: ModosDeJogo
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
Classe ModoHistoria
Essa classe representa o modo de jogo História, onde o usuário joga através de uma série de histórias narradas, obtidas a partir do banco de dados.
Ela contém métodos provenientes da classe HistoriaService e da classe JogoService para iniciar o modo de jogo, exibir histórias, realizar partidas de penalidades e avançar nas histórias.
*/
package ModosDeJogo;
import Services.*;
import Models.*;
import Models.HistoriaItem;

public class ModoHistoria {

	private HistoriaService historiaService = new HistoriaService();
	private JogoService jogoService = new JogoService();
	
	boolean continuar = true;
	boolean gol = false;
	int contadorErrors = 0;
	public void iniciar(Usuario usuario) throws InterruptedException
	{
		escrever("BEM VINDO AO MODO HISTORIA\nA IMAGINAÇÃO É O COMEÇO DE TUDO...\n\n");
	    escrever("TENTE CHEGAR A FASE A FINAL DA COPA  SEM PERDER 3 PENALTIS\nO ULTIMO PENALTI É OBRIGATÓRIO MARCAR-LO PARA VENCER!\n\nA VIDA DETERMINA QUANTOS PENALTIS VOCÊ PODE ERRAR\nBOA SORTE!");
		escrever("");
		
	    HistoriaItem historia = historiaService.exibirOpcoesDeHistorias(usuario);
		// "exibirHistoria"  é responsável por exibir uma história específica
		historiaService.exibirHistoria(historia);
		escrever("Então vamos a partida! ");

	    while(continuar == true)
	    {
			escrever("");

			// é usado para introduzir uma pausa de 1 segundo na execução do programa dentro do loop.
			Thread.sleep(1000); 
			escrever("");
			
			// "iniciarPartida" é proveniente da classe JogoService e é responsável por iniciar uma partida de penalidades.
			// Retornando um valor booleano indicando se o gol foi realizado ou não.
			gol = jogoService.iniciarPartida(1);

			// Verifica se o valor da variável "gol" é falso e se o contador de erros é menor ou igual a 3.
			// Para somar + 1 no contador de erros.
			if(gol == false && contadorErrors <= 3)
        	{
				contadorErrors += 1;
        		escrever("Tente Novamente");       	        		
        	}
			else
			{			
				// Verifica se o contador de erros é maior ou igual a 3 e se o valor de "gol" é falso.
				// Para encerrar o jogo devido ao limite de erros ao tentar marcar um gol.
				if(contadorErrors >= 3 && gol == false)
	        	{
					escrever("Lamento, você excedeu o limite de erros no jogo de penalidades. É o fim do jogo.");
					escrever("");
	        		break;
	        	}
				
				//é usado para introduzir uma pausa de 1 segundo na execução do programa dentro do loop.
				Thread.sleep(2000); 
				contadorErrors = 0;
				//"exibirProximaParte" é utilizado para avançar para a próxima parte da história
				historia = historiaService.exibirProximaParte(historia, usuario.getUsername());
				
				// Se o valor da variável "historia" for nulo, significa que não há uma próxima parte da história disponível, 
				//portanto, a variável "continuar" deve ser definida como falso para encerrar o loop e finalizar o modo de jogo.
				if(historia == null)
				{
					continuar = false;
				}	
			}
			
			
					
	    }
						
	}
	
	
	public void escrever(Object text)
	{
		System.out.println(text);
	}
}
