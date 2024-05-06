package school.sptech.webproducaodefilme.dto.diretor;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DiretorResponse {
    private Integer id;
    private String nome;
    private String nacionalidade;
    private LocalDate dataNascimento;
}
