package Models.Repositorios;

import Models.Usuario;

public class UsuarioRepository {

    public void salvarUsuario(Usuario usuario) {
        String query = new StringBuilder()
                .append("insert into tb_user (Username, `Password`)")
                .append("values ('" + usuario.getUsername() + " ', " + usuario.getPassword() + "),").toString();
    }

    public void verificarUsuarioSenha(Usuario usuario) {
        String query = new StringBuilder()
                .append("select Username, `Password`")
                .append("from tb_user")
                .append("where Username = '" + usuario.getUsername() + "'")
                .append("and `Password` = '" + usuario.getPassword() + "';").toString();
    }

    public void verificarSeUsuarioExiste(String username) {
        String query = new StringBuilder()
                .append("select count(*)")
                .append("from tb_user")
                .append("where Username = '" + username + "';").toString();
    }

    public void alterarUsuario(Usuario usuario) {
        String query = new StringBuilder()
                .append("UPDATE tb_user")
                .append("Username = '" + usuario.getUsername() + " ', `Password` = " + usuario.getPassword() + "),")
                .toString();
    }
}
