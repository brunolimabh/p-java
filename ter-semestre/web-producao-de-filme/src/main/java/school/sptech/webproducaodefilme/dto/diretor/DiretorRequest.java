package school.sptech.webproducaodefilme.dto.diretor;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DiretorRequest {
    @NotBlank
    @Min(3)
    private String nome;
    @NotBlank
    private String nacionalidade;
    @NotNull
    @PastOrPresent
    private LocalDate dataNascimento;
}
