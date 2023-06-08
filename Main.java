/*
Nome do Projeto: Penaltyfootball
Data de Criação: 01/03/2023
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
Última modificação: 07/06/2023 (Lauriano)
Classe Main.
*/
import Models.Usuario;
import Services.*;

class Main {
    public static void main(String[] args) {	

    	UsuarioService service = new UsuarioService();  
    	Usuario usuario = service.iniciarSessao();
    	if(usuario != null)
    	{
    		try {
    			MenuService.iniciar(usuario);
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Erro interno. Contate um dos desenvolvedores.");
			}
    	}
    	
    }
    
  }