package school.sptech.projetofilmebidirecional.dto.filme;

import lombok.Data;

@Data
public class FilmeListagemDto {
    private Integer id;
    private String titulo;
    private String genero;
    private Integer anoLancamento;
    private String sinopse;
    private FilmeDiretorListagemDto diretor;
}
