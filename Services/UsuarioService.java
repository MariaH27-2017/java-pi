/*
Nome do Projeto: Penaltyfootball
Data de Criação: 25/05/2023
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
Última modificação: 06/06/2023 (Maria Helena)
Classe UsuarioService
Essa classe é responsável por gerenciar os usuários do jogo, permitindo a criação de novos usuários,
iniciar sessões de usuários existentes e realizar o login.
Ela utiliza o objeto UsuarioRepository para acessar os dados dos usuários no banco de dados.
*/
package Services;
import java.util.*;
import Repositorios.UsuarioRepository;
import Models.Usuario;

public class UsuarioService {
	Scanner scanner = new Scanner(System.in);
	UsuarioRepository repositorio = new UsuarioRepository();
	
	/**
	 * O método `iniciarSessao` permite que o usuário inicie uma sessão.
	 * O usuário tem a opção de fornecer suas credenciais de login se já tiver um usuário,
	 * caso contrário, pode criar um novo usuário.
	 * @return o usuário que iniciou a sessão
	 */
	public Usuario iniciarSessao()
	{
		write("Possui um usuario? 1.Sim 2.Não");
		
		String r = scanner.nextLine();
		
		if(r.equalsIgnoreCase("Sim") || r.equalsIgnoreCase("1") || r.equalsIgnoreCase("S"))
		{
			return login();
		}
		else if(r.equalsIgnoreCase("Nao") || r.equalsIgnoreCase("2") || r.equalsIgnoreCase("N") || r.equalsIgnoreCase("Não"))
		{
			return cadastrarUsuario();
		}
		else
		{
			//Se o usuário digitar um valor diferente dos mencionados acima, a função exibe "Valor inválido" 
			///e chama a si própria iniciarSessao() novamente para garantir que o usuário digite uma valor válida.
			write("Valor inválido");
			return iniciarSessao();
		}
	}
	
	/**
	 * O método `cadastrarUsuario` permite que um novo usuário seja cadastrado.
	 * Solicita ao usuário um nome de usuário único e uma senha, em seguida,
	 * salva o usuário no repositório de usuários.
	 * @return o usuário cadastrado
	 */
	public Usuario cadastrarUsuario()
	{
		try 
		{
			Usuario usuario = new Usuario();
			write("Informe o nome de usuário: ");
			usuario.setUsername(scanner.nextLine());
			
			while(repositorio.verificarUsuarioExistente(usuario.getUsername()) == true)
			{
				write("Nome de usuario: '" + usuario.getUsername() + "' ja cadastrado.");
				write("Informe outro: ");
				usuario.setUsername(scanner.nextLine());
			}
			
			write("Informe a senha: ");
			usuario.setPassword(scanner.nextLine());
									
			repositorio.salvarUsuario(usuario);
			write("Usuário salvo com sucesso");
			write("");
			return usuario;
		}
   	 	catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            return null;
        }
		
	}

	/**
	 * O método `login` permite que um usuário faça o login com suas credenciais.
	 * Solicita ao usuário seu nome de usuário e senha, verifica se as credenciais são válidas
	 * e retorna o usuário logado.
	 * O usuário pode tentar fazer login novamente se as credenciais forem inválidas.
	 * @return o usuário logado
	 */
	public Usuario login()
	{
		Usuario usuario = pegarCredeciais();
		boolean usuarioLogado = repositorio.verificarCredenciais(usuario);		
		while(usuarioLogado == false)
		{
			write("Credenciais inválidas, deseja tentar novamente?");
			write("1. Sim     2. Não");
			String r = scanner.nextLine();
			if(r.equalsIgnoreCase("Sim") || r.equalsIgnoreCase("1") || r.equalsIgnoreCase("S"))
			{
				usuario = pegarCredeciais(); 
			}
			else if(r.equalsIgnoreCase("Nao") || r.equalsIgnoreCase("2") || r.equalsIgnoreCase("N") || r.equalsIgnoreCase("Não"))
			{
				break;
			}
			
			usuarioLogado = repositorio.verificarCredenciais(usuario);	
		
		}
		
		
		
		if(usuarioLogado == true)
		{
			write("Usuario Logado com Sucesso");
			write("");
			return usuario;	
		}
		else
		{
			write("Falha no login, credenciais estão inválidas");
			return null;	
		}
		
			
		
	}
	

	private Usuario pegarCredeciais()
	{
		Usuario usuario = new Usuario();
		
		write("Informe o nome de usuário: ");
		usuario.setUsername(scanner.nextLine());
		write("Informe a senha: ");
		usuario.setPassword(scanner.nextLine());
		
		return usuario;
	}
	
	
	public void write(Object text)
	{
		System.out.println(text);
	}
}
