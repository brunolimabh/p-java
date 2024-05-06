package school.sptech.projetofilmebidirecional.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeCriacaoDto;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeListagemDto;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeMapper;
import school.sptech.projetofilmebidirecional.entity.Diretor;
import school.sptech.projetofilmebidirecional.entity.Filme;
import school.sptech.projetofilmebidirecional.repository.DiretorRepository;
import school.sptech.projetofilmebidirecional.repository.FilmeRepository;
import school.sptech.projetofilmebidirecional.service.FilmeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeService filmeService;

    @PostMapping
    public ResponseEntity<FilmeListagemDto> criar(@Valid @RequestBody FilmeCriacaoDto request) {
        return ResponseEntity.created(null).body(FilmeMapper.toDto(filmeService.criar(request)));
    }

    @GetMapping
    public ResponseEntity<List<FilmeListagemDto>> listar() {;
        return ResponseEntity.ok(FilmeMapper.toDto(filmeService.listar()));
    }
}
