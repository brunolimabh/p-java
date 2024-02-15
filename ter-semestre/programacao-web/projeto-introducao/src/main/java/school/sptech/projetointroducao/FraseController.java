package school.sptech.projetointroducao;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/frases")
public class FraseController {

    @GetMapping
    public String olaMundo() {
        return "Olá, mundo!";
    }

    @GetMapping("/tudo-bem")
    public String tudoBem() {
        return "Tudo Bem?";
    }

    @GetMapping("/personalizada/{nome}")
    public String personalizada(@PathVariable String nome){
        return "Olá " + nome + "! Tudo bem?";
    }

    @GetMapping("/personalizadaNS/{nome}/{sobrenome}")
    public String personalizadaNomeSobrenome(
            @PathVariable String nome,
            @PathVariable String sobrenome){
        return "Olá " + nome + sobrenome + "! Tudo bem?";
    }
}
