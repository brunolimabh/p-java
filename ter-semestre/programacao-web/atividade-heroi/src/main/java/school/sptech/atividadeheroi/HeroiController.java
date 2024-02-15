package school.sptech.atividadeheroi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.Binding;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/herois")
public class HeroiController {
    private List<Heroi> herois = new ArrayList<>();

    public HeroiController() {
        Heroi heroi = new Heroi("Homem sereia", 6000, "Nada", 500, true);
        herois.add(heroi);
    }

    @GetMapping("/favorito")
    public Heroi favorito(){
        return herois.get(0);
    }

    @GetMapping
    public List<Heroi> listagem() {
        return herois;
    }

    @GetMapping("/{indice}")
    public Heroi indice(@PathVariable int indice) {
        if (isHeroi(indice)){
            return herois.get(indice);
        }
        return null;
    }

    @GetMapping("/cadastrar/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi cadastrar(
            @PathVariable String nome,
            @PathVariable String habilidade,
            @PathVariable int idade,
            @PathVariable int forca,
            @PathVariable boolean vivo) {
        Heroi novoHeroi = new Heroi(nome,forca,habilidade,idade,vivo);
        herois.add(novoHeroi);
        return novoHeroi;
    }

    @GetMapping("/atualizar/{indice}/{nome}/{habilidade}/{idade}/{forca}/{vivo}")
    public Heroi atualizar(
            @PathVariable int indice,
            @PathVariable String nome,
            @PathVariable String habilidade,
            @PathVariable int idade,
            @PathVariable int forca,
            @PathVariable boolean vivo){
        if (isHeroi(indice)){
            Heroi heroiAtualizado = new Heroi(nome,forca,habilidade,idade,vivo);
            herois.set(indice, heroiAtualizado);
            return heroiAtualizado;
        }
        return null;
    }

    @GetMapping("/remover/{indice}")
    public String remover(@PathVariable int indice){
        if (isHeroi(indice)){
            herois.remove(indice);
            return "Heroi removido";
        }
        return "Herou não encontrado";
    }

    public boolean isHeroi(int indice) {
        return indice >= 0 && indice < herois.size();
    }
}
