package school.sptech.projetoserviceexception.dto.pessoa;

import school.sptech.projetoserviceexception.entity.Estabelecimento;
import school.sptech.projetoserviceexception.entity.Pessoa;

import java.util.List;

public class PessoaMapper {

    public static PessoaResponse toDto(Pessoa entity) {
        if (entity == null) return null;

        PessoaResponse dto = new PessoaResponse();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public static List<PessoaResponse> toDto(List<Pessoa> entities) {
        return entities.stream()
                .map(PessoaMapper::toDto)
                .toList();
    }

    public static Pessoa toEntity(PessoaRequest dto) {
        if (dto == null) return null;

        Pessoa entity = new Pessoa();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        return entity;
    }
}
