package school.sptech.atividaderelacionamento.dto.projeto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.beans.PropertyEditor;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoListagemDto {
    private Integer id;
    private String nome;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Tarefa> tarefas;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Tarefa {
        private Integer id;
        private String nome;
        private String descricao;
        private boolean concluida;
        private String prioridade;
    }
}
