package school.sptech.atividaderelacionamento.dto.projeto;

import school.sptech.atividaderelacionamento.entity.projeto.Projeto;

import java.util.List;
import java.util.stream.Collectors;

public class ProjetoMapper {

    public static ProjetoListagemDto toDto(Projeto entity) {
        if (entity == null) return null;

        ProjetoListagemDto dto = new ProjetoListagemDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setDescricao(entity.getDescricao());
        dto.setDataInicio(entity.getDataInicio());
        dto.setDataFim(entity.getDataFim());
        if (entity.getTarefas() != null) dto.setTarefas(entity.getTarefas().stream()
                .map(t -> ProjetoListagemDto.Tarefa.builder()
                        .id(t.getId())
                        .nome(t.getNome())
                        .descricao(t.getDescricao())
                        .concluida(t.isConcluida())
                        .prioridade(t.getPrioridade())
                        .build())
                .collect(Collectors.toList()));
        return dto;
    }

    public static List<ProjetoListagemDto> toDto(List<Projeto> entityList) {
        return entityList.stream()
                .map(ProjetoMapper::toDto)
                .toList();
    }

    public static Projeto toEntity(ProjetoCriacaoDto dto) {
        if (dto == null) return null;

        Projeto entity = new Projeto();
        entity.setNome(dto.getNome());
        entity.setDescricao(dto.getDescricao());
        entity.setDataInicio(dto.getDataInicio());
        entity.setDataFim(dto.getDataFim());
        return entity;
    }
}
