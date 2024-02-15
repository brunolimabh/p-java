package school.sptech.projeto01respostajson;

import org.apache.coyote.http11.filters.SavedRequestInputFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    private List<String> listaPokemon = new ArrayList<>();

    @GetMapping
    public String exibirLista(){
        return "Total de pokemon cadastrado:" + listaPokemon.size();
//        return pokemon;
    }

    @GetMapping("cadastrar/{nome}")
    public String cadastrar(@PathVariable String nome) {
        listaPokemon.add(nome);
        return "Pokemon cadastrado";
    }

    @GetMapping("recuperar/{indice}")
    public String recuperar(@PathVariable int indice) {
        if (existePokemon(indice)){
            return listaPokemon.get(indice);
        }
        return "Pokemon não encontrado";
    }

    @GetMapping("excluir/{indice}")
    public String excluir(@PathVariable int indice) {
        if (existePokemon(indice)){
            listaPokemon.remove(indice);
            return "Excluído";
        }
        return "Pokemon não encontrado";
    }

    @GetMapping("atualizar/{indice}/{nome}")
    public String atualizar(@PathVariable int indice, @PathVariable String nome) {
        if (existePokemon(indice)){
            listaPokemon.set(indice, nome);
            return "Pokemon atualizado";
        }
        return "Pokemon não encontrado";
    }

    public boolean existePokemon(int indice){
        return indice >= 0 && indice < listaPokemon.size();
//        if (indice >= 0 && indice < listaPokemon.size()){
//            return true;
//        }
//        return false;
    }
}
