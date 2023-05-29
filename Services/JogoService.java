package Services;
import java.util.*;
public class JogoService {

	Scanner scanner = new Scanner(System.in);
	int contadadorErros = 0;
	public boolean iniciarPartida()
	{
		ArrayList<Integer> numerosValidos = getNumerosGol();		
		

    	
    	boolean gol = false;
    	while(gol == false)
    	{
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
           	 	
           	    escrever("Digite o Número da Historia: ");
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
        	
        	gol = validarPenalty(cantoSelecionado);
        	
        	if(gol == false)
        	{
        		contadadorErros += 1;
        		escrever("Tente Novamente");
        	}
        	
        	if(contadadorErros > 3 && gol == false)
        	{
        		break;
        	}
    	}
		
		return gol;
    	
	}
	
	public boolean validarPenalty(int cantoSelecionado)
	{
        int numeroGoleiro = ((int)(Math.random() * 5) + 1);

		boolean gol = cantoSelecionado != numeroGoleiro;
		
		if (gol) {
			System.out.println("PARTIIUUUU");

			System.out.println("BATEEEUUUUUUUUU");

			System.out.println("GOOOOOOOOOOOOOOOOOOOOOL");

		} else {
			System.out.println("PARTIIUUUU");

			System.out.println("BATEEEUUUUUUUUU");

			System.out.println("DEEEFENDEEEEEUUUUUUUUUU OOH GOLEIRO");

		}
		
		return gol;
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
