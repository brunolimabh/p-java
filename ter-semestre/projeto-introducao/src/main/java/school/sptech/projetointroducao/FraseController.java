package school.sptech.projetointroducao;

import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping("/personalizada")
    public String personalizada(){
        return "Olá " + "" + "! Tudo bem?";
    }
}
