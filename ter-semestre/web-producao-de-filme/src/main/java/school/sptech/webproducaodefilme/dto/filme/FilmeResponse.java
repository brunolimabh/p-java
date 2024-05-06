package school.sptech.webproducaodefilme.dto.filme;

import lombok.Getter;
import lombok.Setter;
import school.sptech.webproducaodefilme.entity.Diretor;

@Getter
@Setter
public class FilmeResponse {
    private Integer id;
    private String titulo;
    private String genero;
    private Integer anoLancamento;
    private String sinopse;
    private Diretor diretor;
}
