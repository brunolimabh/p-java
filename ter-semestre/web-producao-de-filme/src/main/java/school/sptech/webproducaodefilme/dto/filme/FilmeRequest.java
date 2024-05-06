package school.sptech.webproducaodefilme.dto.filme;

import jakarta.validation.constraints.*;
import lombok.Data;
import school.sptech.webproducaodefilme.entity.Diretor;


@Data
public class FilmeRequest {
    @NotBlank
    @Min(3)
    private String titulo;
    @NotBlank
    @Min(3)
    private String genero;
    @Positive
    private Integer anoLancamento;
    @Min(3)
    @Max(255)
    private String sinopse;
    private Integer diretorId;
}
