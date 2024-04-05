package school.sptech.projetojpadto.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetojpadto.dto.UsuarioCriacaoDto;
import school.sptech.projetojpadto.dto.UsuarioListagemDto;
import school.sptech.projetojpadto.dto.UsuarioMapper;
import school.sptech.projetojpadto.entity.Usuario;
import school.sptech.projetojpadto.repository.UsuarioRepository;

import javax.crypto.spec.OAEPParameterSpec;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    public ResponseEntity<UsuarioListagemDto> criar(
            @RequestBody @Valid UsuarioCriacaoDto usuarioCriacao
        ){
        Usuario entity = UsuarioMapper.toEntity(usuarioCriacao);
        Usuario usuarioSave = usuarioRepository.save(entity);
        UsuarioListagemDto dto = UsuarioMapper.toDto(usuarioSave);
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioListagemDto>> listar(){
        List<Usuario> usuarios = usuarioRepository.findAll();
        if (usuarios.isEmpty()) return ResponseEntity.status(204).build();
        List<UsuarioListagemDto> dtos = UsuarioMapper.toDto(usuarios);
        return ResponseEntity.status(200).body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioListagemDto> listarPorId(@PathVariable int id){
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        UsuarioListagemDto dto = UsuarioMapper.toDto(usuarioOpt.get());
        return usuarioOpt
                .map(usuario -> ResponseEntity.status(200).body(dto))
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable int id){
        if (!usuarioRepository.existsById(id)) return ResponseEntity.status(400).build();
        usuarioRepository.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
