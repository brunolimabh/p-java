package school.sptech.projetojpadto.dto;

import school.sptech.projetojpadto.entity.Usuario;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UsuarioMapper {

    public static  UsuarioListagemDto toDto(Usuario entity){
        if (entity == null) return null;

        UsuarioListagemDto dto = new UsuarioListagemDto();
        dto.setId(entity.getId());
        dto.setNomeCompleto(entity.getNome());
        dto.setEmail(entity.getEmail());
        dto.setDataCriacao(entity.getDataCriacao());
        return dto;

    }

    public static Usuario toEntity(UsuarioCriacaoDto dto){
        if (dto == null) return null;

        Usuario entity = new Usuario();
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setSenha(dto.getSenha());
        return entity;
    }

    public static List<UsuarioListagemDto> toDto(List<Usuario> entities){
        return entities.stream()
                .map(UsuarioMapper::toDto)
                .toList();
    }
}
