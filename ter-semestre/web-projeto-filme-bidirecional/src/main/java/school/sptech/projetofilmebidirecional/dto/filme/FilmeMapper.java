package school.sptech.projetofilmebidirecional.dto.filme;

import school.sptech.projetofilmebidirecional.entity.Diretor;
import school.sptech.projetofilmebidirecional.entity.Filme;

import java.util.List;

public class FilmeMapper {

    public static Filme toEntity(FilmeCriacaoDto dto, Diretor diretor) {
        if (dto == null || diretor == null) return null;

        Filme entity = new Filme();
        entity.setTitulo(dto.getTitulo());
        entity.setGenero(dto.getGenero());
        entity.setAnoLancamento(dto.getAnoLancamento());
        entity.setSinopse(dto.getSinopse());
        entity.setDiretor(diretor);
        return entity;
    }

    public static FilmeListagemDto toDto(Filme entity) {
        if (entity == null) return null;

        FilmeListagemDto dto = new FilmeListagemDto();
        dto.setTitulo(entity.getTitulo());
        dto.setGenero(entity.getGenero());
        dto.setAnoLancamento(entity.getAnoLancamento());
        dto.setSinopse(entity.getSinopse());
        dto.setDiretor(toDiretorDto((entity.getDiretor())));
        return dto;
    }

    public static List<FilmeListagemDto> toDto(List<Filme> entities) {
        return entities.stream()
                .map(FilmeMapper::toDto)
                .toList();
    }

    public static FilmeDiretorListagemDto toDiretorDto(Diretor entity){
        if (entity == null) return null;

        FilmeDiretorListagemDto dto = new FilmeDiretorListagemDto();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setNacionalidade(entity.getNacionalidade());
        dto.setDataNascimento(entity.getDataNascimento());
        return dto;
    }

}
