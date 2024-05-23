package school.sptech.atividaderelacionamento.dto.tarefa;

import school.sptech.atividaderelacionamento.dto.projeto.ProjetoListagemDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoMapper;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;

import java.util.List;
import java.util.stream.Collectors;

public class TarefaMapper {

    public static TarefaListagemDto toDto(Tarefa entity) {
        if (entity == null) return null;

        TarefaListagemDto dto = new TarefaListagemDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setConcluida(entity.isConcluida());
        dto.setPrioridade(entity.getPrioridade());
        dto.setProjeto(TarefaListagemDto.Projeto.builder()
                .id(entity.getProjeto().getId())
                .nome(entity.getProjeto().getNome())
                .descricao(entity.getProjeto().getDescricao())
                .dataInicio(entity.getProjeto().getDataInicio())
                .dataFim(entity.getProjeto().getDataFim())
                .build());
        return dto;
    }

    public static List<TarefaListagemDto> toDto(List<Tarefa> entities) {
        return entities.stream()
                .map(TarefaMapper::toDto)
                .toList();
    }

    public static Tarefa toEntity(TarefaCriacaoDto dto) {
        if (dto == null) return null;

        Tarefa entity = new Tarefa();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setConcluida(dto.isConcluida());
        entity.setPrioridade(dto.getPrioridade());
        return entity;
    }
}
