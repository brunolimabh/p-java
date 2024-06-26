package school.sptech.projetofilmebidirecional.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.projetofilmebidirecional.dto.diretor.DiretorCriacaoDto;
import school.sptech.projetofilmebidirecional.dto.diretor.DiretorListagemDto;
import school.sptech.projetofilmebidirecional.dto.diretor.DiretorMapper;
import school.sptech.projetofilmebidirecional.entity.Diretor;
import school.sptech.projetofilmebidirecional.repository.DiretorRepository;
import school.sptech.projetofilmebidirecional.service.DiretorService;

import java.util.List;

@RestController
@RequestMapping("/diretores")
@RequiredArgsConstructor
public class DiretorController {

    private final DiretorService diretorService;

    @PostMapping
    public ResponseEntity<DiretorListagemDto> criar(@RequestBody @Valid DiretorCriacaoDto diretorCriacaoDto) {
        return ResponseEntity.created(null).body(DiretorMapper.toDto(diretorService.criar(diretorCriacaoDto)));
    }

    @GetMapping
    public ResponseEntity<List<DiretorListagemDto>> listar() {
        return ResponseEntity.ok(DiretorMapper.toDto(diretorService.listar()));
    }
}