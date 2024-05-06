package school.sptech.webproducaodefilme.dto.filme;

import school.sptech.webproducaodefilme.entity.Diretor;
import school.sptech.webproducaodefilme.entity.Filme;

import java.util.List;

public class FilmeMapper {

    public static FilmeResponse toDto(Filme entity) {
        if (entity == null) return null;

        FilmeResponse dto = new FilmeResponse();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setGenero(entity.getGenero());
        dto.setAnoLancamento(entity.getAnoLancamento());
        dto.setSinopse(entity.getSinopse());
        dto.setDiretor(entity.getDiretor());
        return dto;
    }

    public static List<FilmeResponse> toDto(List<Filme> entities) {
        return entities.stream()
                .map(FilmeMapper::toDto)
                .toList();
    }

    public static Filme toEntity(FilmeRequest dto, Diretor diretor) {
        if (dto == null) return null;

        Filme entity = new Filme();
        entity.setTitulo(dto.getTitulo());
        entity.setGenero(dto.getGenero());
        entity.setAnoLancamento(dto.getAnoLancamento());
        entity.setSinopse(dto.getSinopse());
        entity.setDiretor(diretor);
        return entity;
    }
}
