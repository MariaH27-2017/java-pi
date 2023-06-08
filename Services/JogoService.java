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
Última modificação: 05/06/2023 (Lauriano)
Classe JogoService

Essa classe é responsável por fornecer serviços relacionados ao jogo de pênaltis.
Ela permite ao usuário iniciar uma partida, escolher um canto para chutar e valida se foi gol ou defesa.
A classe utiliza a classe Animacao para exibir animações relacionadas ao resultado do chute.

*/
package Services;
import java.util.*;
public class JogoService {

	Scanner scanner = new Scanner(System.in);
	Animacao animacao = new Animacao();
	int contadadorErros = 0;
	
	/**
	 * 
	 * Método responsável por solicitar ao usuário que escolha um canto para chutar.
	 * 
	 * @return Um booleano que representa se o gol foi realizado ou defendido.
	 */
	public boolean iniciarPartida(int nivel) throws InterruptedException
	{
		ArrayList<Integer> numerosValidos = getNumerosGol();		

    	boolean gol = false;
    		System.out.println("\nESCOLHA UM CANTO!!!\n");

    		System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
    		System.out.println("II                              II");
    		System.out.println("II  1                        4  II");
    		System.out.println("II                              II");
    		System.out.println("II              3               II");
    		System.out.println("II                              II");
    		System.out.println("II  2                        5  II");
    		System.out.println("II                              II \n");

    		System.out.println(
    				"[1] Superior esquerdo \n[2] Inferior esquerdo \n[3] Meio \n[4] Superior Direito \n[5] Inferior Direito\n");
    		System.out.print("Opcao: ");
    		int cantoSelecionado = 0;
    		
    		boolean numeroValido = false;
        	while(numeroValido == false)
        	{
           	    scanner = new Scanner(System.in);
           	 	
        		if (scanner.hasNextInt()) 
    	         {
        			 cantoSelecionado = scanner.nextInt();
    	             numeroValido = numerosValidos.contains(cantoSelecionado);
    	             if(numeroValido == true)
    	             {
    	            	 break;
    	             }
    	         }
        		
        		escrever("Você não digitou um número válido. Escolha de 1 a 5"); 		
        		escrever("");
        	}
        	
        	int goleiro = nivel(nivel, cantoSelecionado);
        	
        	/** Verifica se o usuário fez um gol ou não, com base no canto selecionado e no valor do numero gerado para o goleiro.
			  @link JogoService#validarPenalty()
			 */
        	gol = validarPenalty(cantoSelecionado, goleiro);
        	//
        	//if(gol == false)
        	//{
        	//	contadadorErros += 1;
        	//	escrever("Tente Novamente");
        	//}
        	//
        	//if(contadadorErros > 3 && gol == false)
        	//{
        	//	break;
        	//}
    	escrever("");
		
		return gol;
    	
	}
	
	/**
	 * 
	 * Método responsável por verificar se foi gol ou defesa.
	 * 
	 * @return Booleano onde true é considerado gol e false considerado defesa.
	 */
	public boolean validarPenalty(int cantoSelecionado, int numeroGoleiro) throws InterruptedException
	{
		/** Exibe a escolha do jogador e do goleiro */
		System.out.println("Batedor: " + cantoSelecionado + " Goleiro: " + numeroGoleiro);

		boolean gol = cantoSelecionado != numeroGoleiro;
		
		/* Chama o método de animação para mostrar se o usuário fez um gol ou não
		 * * @link Animacao#gol()
		 */
		animacao.exibirMensagemGol(gol);				
		Thread.sleep(2000); 		
		return gol;
	}
	
	/**
	 * Método utilizado para gerar um número aleatório que representa a posição do
	 * goleiro no jogo de simulação de pênaltis.
	 * 
	 * @param nivel            Inteiro que determina a dificuldade do jogo (1, 2 ou
	 *                         3)
	 * @param cantoSelecionado Inteiro que representa a posição escolhida pelo
	 *                         jogador para chutar a bola (entre 1 e 5)
	 * @param goleiro          Inteiro que representa a posição do goleiro, gerado
	 *                         aleatoriamente (entre 1 e 5)
	 * @return Inteiro que representa a posição do goleiro
	 */
	protected int nivel(int nivel, int cantoSelecionado) {
		int goleiro = numeroAleatorio();
		int numero[] = new int[4]; // Vetor utilizado para armazenar os números aleatórios gerados
						 
		// Verifica o valor de nivel para decidir quantos números aleatórios deve gerar
		switch (nivel) {
		case 1:
			// Se nivel for igual a 1, gera apenas um número aleatório entre 1 e 10 e o
			// compara com o cantoSelecionado
			for (int c = 0; c <= 0; c++) {
				numero[c] = ((int) (Math.random() * 10) + 1);//(Casting explícito)  Gera um número aleatório entre 1 e 5
															 //para representar a posição do goleiro	
				if (cantoSelecionado == numero[c]) {
					// Se o número aleatório gerado for igual ao cantoSelecionado, o valor desse
					// número é atribuído à variável goleiro
					goleiro = numero[c];
				}
			}
			break;

		case 2:
			// Se nivel for igual a 2, gera 2 números aleatórios e os compara com o
			// cantoSelecionado
			for (int c = 0; c <= nivel; c++) {
				numero[c] = numeroAleatorio();
				if (cantoSelecionado == numero[c]) {
					// Se algum dos números aleatórios gerados for igual ao cantoSelecionado, o
					// valor desse número é atribuído à variável goleiro
					goleiro = numero[c];
				}
			}
			break;

		case 3:
			// Se nivel for igual a 3, gera 3 números aleatórios e os compara com o
			// cantoSelecionado
			for (int c = 0; c <= nivel; c++) {
				numero[c] = numeroAleatorio();
				if (cantoSelecionado == numero[c]) {
					// Se algum dos números aleatórios gerados for igual ao cantoSelecionado, o
					// valor desse número é atribuído à variável goleiro
					goleiro = numero[c];
				}
			}
			break;
		}

		// Retorna o valor da variável goleiro
		// Se o valor for diferente de cantoSelecionado terá que ser marcado o gol senão
		// defesa do goleiro
		
		return goleiro;		
	}
	
	/**
	 * 
	 * Método responsável por gerar um número aleatório.
	 * 
	 * @return Um número inteiro aleatório.
	 */
	protected int numeroAleatorio() {

		int cantoGoleiro = ((int) (Math.random() * 5) + 1);
		return cantoGoleiro;
	}
	
	private ArrayList<Integer> getNumerosGol()
	{

		ArrayList<Integer> numeros = new ArrayList<Integer>();
		numeros.add(1);
		numeros.add(2);
		numeros.add(3);
		numeros.add(4);
		numeros.add(5);
		
		return numeros;
	}
	
	public void escrever(Object text)
	{
		System.out.println(text);
	}
	
}
