package school.sptech.projetoserviceexception.dto.estabelecimento;

import school.sptech.projetoserviceexception.entity.Estabelecimento;

import java.util.List;

public class EstabelecimentoMapper {

    public static EstabelecimentoResponse toDto(Estabelecimento entity) {
        if (entity == null) return null;

        EstabelecimentoResponse dto = new EstabelecimentoResponse();
        dto.setId(entity.getId());
        dto.setNome(entity.getNome());
        dto.setCnpj(entity.getCnpj());
        if (entity.getPessoa() != null) dto.setPessoa(entity.getPessoa());
        return dto;
    }

    public static List<EstabelecimentoResponse> toDto(List<Estabelecimento> entities) {
        return entities.stream()
                .map(EstabelecimentoMapper::toDto)
                .toList();
    }

    public static Estabelecimento toEntity(EstabelecimentoRequest dto) {
        if (dto == null) return null;

        Estabelecimento entity = new Estabelecimento();
        entity.setNome(dto.getNome());
        entity.setCnpj(dto.getCnpj());
        return entity;
    }

}
