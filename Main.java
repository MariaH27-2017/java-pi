import Repositorios.HistoriaRepository;
import Models.HistoriaItem;
import java.util.*;
import java.sql.Connection;
import Models.Ranking;
import Database.DbConnection;
import Repositorios.RankingRepository;
import Repositorios.UsuarioRepository;
import Models.Usuario;
import Models.Historia;
import ModosDeJogo.ModoHistoria;
import Services.*;

class Main {
    public static void main(String[] args) {	

    	UsuarioService service = new UsuarioService();  
    	Usuario usuario = service.iniciarSessao();
		//Usuario usuario = new Usuario("Maria", "123");
    	if(usuario != null)
    	{
    		try {
    			MenuService.iniciar(usuario);
			} catch (Exception e) {
				write(e.getMessage());
				write("Erro interno. Contate um dos desenvolvedores.");
			}
    	}
    	
    }
    
    public static void write(Object object)
    {
      System.out.println(object);
    }
  }