/*
 * Nome do arquivo: Animacao.java
 * Autor: lauriano <laurianocarlos@hotmail.com>
 * Data de criação: 01/03/2023
 * Versão: 1.0
 * Descrição: classe que contém as animacoes do jogo
 * Colaboradores: Ana Lucia, Bruno de Oliveira, Giovanna Moreira, Melissa Gonçalve, Lauriano Carlos
 * Última modificação: 27/04/2023 (Lauriano)
 */

package Services;

public class Animacao {
	/*Exibe o menu inicial do jogo Penalty Football com as opções disponíveis.
	*/
	public static void exibirMenuInicial() {
		System.out.println("PENALTY FOOTBALL GAME");
		System.out.println();
		System.out.println("--[1] MODO SOLO\n--[2] MULTIPLAYER\n--[3] MODO HISTORIA\n--[4] RANKEADA\n--[5] RANKING GLOBAL\n--[0] SAIR \n");
	}

	/*Exibe a tela de inicialização do modo solo do jogo  penalty football.
	*/
	public static void inicializacaoModoSolo() {
		System.out.println("PENALTY FOOTBALL");
		System.out.println();
		System.out.println("BEM VINDO A EMOÇÃO, É HORA DE TESTAR O CORAÇÃO!");
		System.out.println();
		System.out.println("QUALIDADE OU SORTE?");
		System.out.println();
		System.out.println("VAMOS DESCOBRIR...");
		System.out.println();

	}
	
	/*Exibe a tela de inicialização do modo MultiJogador do jogo penalty football.
	*/
	public static void inicializacaoMultiJogador() {
		System.out.println("PENALTY FOOTBALL MULTIJOGADOR");
		System.out.println();
		System.out.println("QUE VENÇA O MELHOR! ");
		System.out.println();
	}
	
	/*Exibe a tela de inicialização do modo Rankeada do jogo penalty football.
	*/
	/**
	 * 
	 */
	public static void inicializacaoModoRankeada() {
		System.out.println("PENALTY FOOTBALL RANKEADA");
		System.out.println();
		System.out.println("PROIBIDO ERRAR! VAI TREMER?");
		System.out.println();
		System.out.println("Converta o penalti para continuar, cada gol acrescenta uma pontuacao! boa sorte.");
		System.out.println();

	}

	/**
	Exibe mensagem de gol ou defesa durante o jogo.
	@param gol se true, exibe mensagem de gol, se false, exibe mensagem de defesa.
	*/
	public static void gol(boolean gol) {

		if (gol) {
			System.out.println("PARTIIUUUU");

			System.out.println("BATEEEUUUUUUUUU");

			System.out.println("GOOOOOOOOOOOOOOOOOOOOOL");

		} else {
			System.out.println("PARTIIUUUU");

			System.out.println("BATEEEUUUUUUUUU");

			System.out.println("DEEEFENDEEEEEUUUUUUUUUU OOH GOLEIRO");

		}

	}

	/**
	Exibe uma mensagem com uma imagem de parabéns se o parâmetro for verdadeiro (true),
	caso contrário, exibe uma mensagem com uma imagem de derrota.
	@param vdd valor booleano que indica se o jogador venceu (true) ou perdeu (false) o jogo
	*/
	public static void exibirGanhador(boolean vdd) {

		if (vdd) {
			System.out.println("      PARABÉNS VOCÊ GANHOU         ");
			System.out.println("            ____                 ");
			System.out.println("           (    )            ");
			System.out.println("            \\  /             ");
			System.out.println("             ||              ");
			System.out.println("             ||              ");
			System.out.println("            [__]             ");
			System.out.println("           /)  (\\            ");
			System.out.println("          (( () ))           ");
			System.out.println("           \\__            ");
			System.out.println("            `..'             ");
			System.out.println("             ||              ");
			System.out.println("             ||              ");
			System.out.println("            //\\__           ");
			System.out.println("          ((  `--'          ");
			System.out.println("           \\)               ");
			System.out.println("        '''''''''''''''      ");

		} else {

			System.out.println("      VOCÊ PERDEU  ");
			System.out.println("         _       ");
			System.out.println("        |.|      ");
			System.out.println("        ]^[      ");
			System.out.println("      ,-|||~\\   ");
			System.out.println("     {<|||||>}   ");
			System.out.println("      \\|||||/    ");
			System.out.println("      {/   \\}    ");
			System.out.println("      /__9__\\    ");
			System.out.println("      | / \\ |    ");
			System.out.println("      (<   >)     ");
			System.out.println("     _|)   (|_    ");
			System.out.println(" ,.,.(  |.,.|  ).,.,. ");
		}
	}

}
