package school.sptech.webproducaodefilme.dto.diretor;

import school.sptech.webproducaodefilme.entity.Diretor;

import java.util.List;

public class DiretorMapper {

    public static DiretorResponse toDto(Diretor entity) {
        if (entity == null) return null;

        DiretorResponse dto = new DiretorResponse();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNacionalidade(entity.getNacionalidade());
        dto.setDataNascimento(entity.getDataNascimento());
        return dto;
    }

    public static List<DiretorResponse> toDto(List<Diretor> entities) {
        return entities.stream()
                .map(DiretorMapper::toDto)
                .toList();
    }

    public static Diretor toEntity(DiretorRequest dto) {
        if (dto == null) return null;

        Diretor entity = new Diretor();
        entity.setNome(dto.getNome());
        entity.setNacionalidade(dto.getNacionalidade());
        entity.setDataNascimento(dto.getDataNascimento());
        return entity;
    }
}
