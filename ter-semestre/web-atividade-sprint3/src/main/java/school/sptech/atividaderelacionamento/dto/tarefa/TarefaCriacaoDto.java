package school.sptech.atividaderelacionamento.dto.tarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class TarefaCriacaoDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String descricao;
    private boolean concluida;
    @NotBlank
    private String prioridade;
    @NotNull
    private Integer projetoId;
}
