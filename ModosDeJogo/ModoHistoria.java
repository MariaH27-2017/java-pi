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

	private UsuarioService usuarioService = new UsuarioService();
	private HistoriaService historiaService = new HistoriaService();
	private RankingService rankingService = new RankingService();
	private JogoService jogoService = new JogoService();
	
	boolean continuar = true;
	
	public void iniciar(Usuario usuario) throws InterruptedException
	{
		escrever("BEM VINDO AO MODO HISTORIA\nA IMAGINAÇÃO É O COMEÇO DE TUDO...\n\n");
	    escrever("TENTE CHEGAR A FASE A FINAL DA COPA  SEM PERDER 3 PENALTIS\nO ULTIMO PENALTI É OBRIGATÓRIO MARCAR-LO PARA VENCER!\n\nA VIDA DETERMINA QUANTOS PENALTIS VOCÊ PODE ERRAR\nBOA SORTE!");
		HistoriaItem historia = historiaService.exibirOpcoesDeHistorias(usuario);
		historiaService.exibirHistoria(historia);

	    while(continuar == true)
	    {
			escrever("");
			escrever("Então vamos a partida! ");

			Thread.sleep(2000); 
			escrever("");
			
			continuar = jogoService.iniciarPartida();
			
			if(continuar)
			{
				Thread.sleep(2000); 
				historia = historiaService.exibirProximaParte(historia);
				
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
