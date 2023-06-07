package ModosDeJogo;
import java.util.*;
import java.lang.*;
import Services.UsuarioService;
import Services.RankingService;
import Services.HistoriaService;
import Services.JogoService;
import Models.Usuario;
import Models.Ranking;
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
		historiaService.exibirHistoria(historia);

	    while(continuar == true)
	    {
			escrever("");
			escrever("Então vamos a partida! ");

			Thread.sleep(2000); 
			escrever("");
			
			gol = jogoService.iniciarPartida(1);
			
			if(gol == false && contadorErrors < 3)
        	{
				contadorErrors += 1;
        		escrever("Tente Novamente");
        	}
			else
			{
				Thread.sleep(2000); 
				contadorErrors = 0;
				historia = historiaService.exibirProximaParte(historia);
				
				if(historia == null)
				{
					continuar = false;
				}	
			}
			
			if(contadorErrors > 3 && gol == false)
        	{
				escrever("Lamento, você excedeu o limite de erros no jogo de penalidades. É o fim do jogo.");
				escrever("");
        		break;
        	}
					
	    }
						
	}
	
	
	public void escrever(Object text)
	{
		System.out.println(text);
	}
}
