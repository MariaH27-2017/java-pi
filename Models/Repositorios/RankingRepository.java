package Models.Repositorios;

import Models.Ranking;

public class RankingRepository {

    public void getRanking() {
        String query = new StringBuilder()
                .append("select Username as Nome, Score as Pontuacao")
                .append("from tb_ranking")
                .append("order by Score Desc")
                .append("limit 10;").toString();
    }

    public void salvarPontuacaoRanking(String username, int pontuacao) {
        String query = new StringBuilder()
                .append("insert into tb_ranking (Username, Score)")
                .append("values ('" + username + " ', " + pontuacao + "),").toString();
    }

    public void alterarRanking(String username, int pontuacao) {
        String query = new StringBuilder()
                .append("UPDATE tb_ranking")
                .append("Username = '" + username + " ', Score = " + pontuacao + "),")
                .toString();
    }
}
