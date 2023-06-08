package Services;
import java.util.*;
import Repositorios.UsuarioRepository;
import Models.Usuario;

public class UsuarioService {
	Scanner scanner = new Scanner(System.in);
	UsuarioRepository repositorio = new UsuarioRepository();
	
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
			write("Valor inválido");
			return iniciarSessao();
		}
	}
	
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
