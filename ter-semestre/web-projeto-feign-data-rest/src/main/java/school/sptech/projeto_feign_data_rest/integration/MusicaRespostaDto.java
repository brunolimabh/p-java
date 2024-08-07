package school.sptech.projeto_feign_data_rest.integration;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MusicaRespostaDto {
    private Integer id;
    private String nome;
    private String artista;
    private String genero;
//    @JsonProperty(value = "data_lancamento")
    private LocalDateTime dataLancamento;
}
