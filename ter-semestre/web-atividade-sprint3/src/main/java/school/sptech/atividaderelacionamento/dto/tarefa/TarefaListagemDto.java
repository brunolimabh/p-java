package school.sptech.atividaderelacionamento.dto.tarefa;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TarefaListagemDto {
    private Integer id;
    private String nome;
    private String descricao;
    private boolean concluida;
    private String prioridade;
    private Projeto projeto;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Projeto {
        private Integer id;
        private String nome;
        private String descricao;
        private LocalDate dataInicio;
        private LocalDate dataFim;
    }
}
