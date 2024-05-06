package school.sptech.projetofilmebidirecional.dto.diretor;

import school.sptech.projetofilmebidirecional.entity.Diretor;
import school.sptech.projetofilmebidirecional.entity.Filme;

import java.util.List;

public class DiretorMapper {

    public static DiretorListagemDto toDto(Diretor entity) {
        if (entity == null) return null;

        DiretorListagemDto dto = new DiretorListagemDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNacionalidade(entity.getNacionalidade());
        dto.setDataNascimento(entity.getDataNascimento());
        dto.setFilmes(toFilmeDto(entity.getFilmes()));
        return dto;
    }

    public static List<DiretorListagemDto> toDto(List<Diretor> entities) {
        return entities.stream().map(DiretorMapper::toDto).toList();
    }

    public static Diretor toEntity(DiretorCriacaoDto dto) {
        Diretor entity = new Diretor();
        entity.setNome(dto.getNome());
        entity.setNacionalidade(dto.getNacionalidade());
        entity.setDataNascimento(dto.getDataNascimento());
        return entity;
    }

    public static DiretorFilmeListagemDto toFilmeDto(Filme entity) {
        if (entity == null) return null;

        DiretorFilmeListagemDto dto = new DiretorFilmeListagemDto();
        dto.setId(entity.getId());
        dto.setTitulo(entity.getTitulo());
        dto.setGenero(entity.getGenero());
        dto.setAnoLancamento(entity.getAnoLancamento());
        dto.setSinopse(entity.getSinopse());
        return dto;
    }

    public static List<DiretorFilmeListagemDto> toFilmeDto(List<Filme> entities) {
        return entities.stream().map(DiretorMapper::toFilmeDto).toList();
    }
}
