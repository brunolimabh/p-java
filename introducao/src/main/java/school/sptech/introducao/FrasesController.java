package school.sptech.introducao;

import org.springframework.http.StreamingHttpOutputMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadLocalRandom;

@RestController
@RequestMapping("/frases") // URI
public class FrasesController {


    @GetMapping
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/sortear")
    public Integer sortear(){
        return ThreadLocalRandom.current().nextInt(0,11);
    }

    @GetMapping("/saudar/{nome}")
    public String saudar(@PathVariable String nome){
        return "Ola, " + nome;
    }

    @GetMapping("/filme")
    public Filme testeFilme(){
        return new Filme("Titanic","James Cameron",1998);
    }
}
