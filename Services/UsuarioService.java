package Services;
import java.sql.SQLException;
import java.util.*;
import Repositorios.UsuarioRepository;
import Models.Usuario;

public class UsuarioService {
	Scanner scanner = new Scanner(System.in);
	UsuarioRepository repositorio = new UsuarioRepository();
	
	public void cadastrarUsuario()
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
		}
   	 	catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
            
        }
		
	}

	public boolean login()
	{
		Usuario usuario = pegarCredeciais();
				
		while(repositorio.verificarCredenciais(usuario) == false)
		{
			write("Credenciais inválidas, deseja tentar novamente?");
			write("1. Sim     2. Não");
			String r = scanner.nextLine();
			
			if(r.equalsIgnoreCase("2") || r.equalsIgnoreCase("Não"))
			{
				break;
			}
			else
			{
				usuario = pegarCredeciais(); 
			}			
		}
		
		boolean usuarioLogado = repositorio.verificarCredenciais(usuario);
		
		if(usuarioLogado == true)
		{
			write("Usuario Logado com Sucesso");
		}
		else
		{
			write("Falha no login, credenciais estão inválidas");
		}
		
		return usuarioLogado;
		
		
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
