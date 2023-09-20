import java.util.ArrayList;
import java.util.List;

public class CadastroLogin {

    private List<Usuario> cadastros = new ArrayList();

    private String mensagem;

    public List<Usuario> getCadastros() {
        return cadastros;
    }

    public void setCadastros(List<Usuario> cadastros) {
        this.cadastros = cadastros;
    }

    void cadastrar(Usuario usuario){
        cadastros.add(usuario);
    }


    public Usuario login(String usuario, String senha){

        Usuario usuarioCadastrado;
        Boolean loginEfetuado = false;

        for (Integer i = 0 ; i < cadastros.size() ; i++){

            usuarioCadastrado = cadastros.get(i);

            if (usuarioCadastrado.getUsuario().equals(usuario)){

                if (usuarioCadastrado.getSenha().equals(senha)){
                    loginEfetuado = true;
                    Usuario usuarioLogado = usuarioCadastrado;
                    return usuarioLogado;
                }
            }
        }

        return null;
    }

}
