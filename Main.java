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
class Main {
    public static void main(String[] args) {

      HistoriaRepository repository = new HistoriaRepository();
      HistoriaItem teste = repository.getHistoryByUsername("Sonic");
      write("------- " + teste.getNome() + "--------------");
      write("");
      
      write("Parte: " + teste.getParte() + " - " + teste.getTitulo());
      write(teste.getDescricao());
     
      write("");
      
      HistoriaItem proxParte = repository.getProximaParte(teste);
      write("Parte: " + proxParte.getParte() + " - " + proxParte.getTitulo());
      write(proxParte.getDescricao());
      
      RankingRepository rr = new RankingRepository();
      
      //rr.salvarPontuacaoRanking("Sonic", 400);
      
      ArrayList<Ranking> testeArray = rr.getRanking();
      write("");
      write("Exibir Ranking:");
      for(Ranking r : testeArray)
      {
    	  write(r.getUsername() + " : " + r.getScore());
      }
      
      //UsuarioRepository userRepository = new UsuarioRepository();
      //Usuario user = new Usuario("Sonic", "123");
      //userRepository.salvarUsuario(user);
      
      ArrayList<Historia> historias = repository.getHistorias();       
      write("");
      write("Exibir Historias:");
      for(Historia h : historias)
      {
    	  write(h.getNumero() + ". " +  h.getNome() + " : " + h.getDescricao());
      }
      
      write("teste historia by name");
      HistoriaItem hi = repository.getHistoryByName("O Duelo Intenso");
      write("Parte: " + hi.getParte() + " - " + hi.getTitulo());
      write(hi.getDescricao());
      
    }
    public static void write(Object object)
    {
      System.out.println(object);
    }
  }