package school.sptech.webproducaodefilme.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.webproducaodefilme.dto.diretor.DiretorResponse;
import school.sptech.webproducaodefilme.dto.filme.FilmeRequest;
import school.sptech.webproducaodefilme.dto.filme.FilmeResponse;
import school.sptech.webproducaodefilme.repository.DiretorRepository;
import school.sptech.webproducaodefilme.repository.FilmeRepository;
import school.sptech.webproducaodefilme.service.FilmeService;

import java.util.List;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class FilmeController {

    private final FilmeRepository filmeRepository = null;
    private final DiretorRepository diretorRepository = null;

    FilmeService filmeService = new FilmeService(filmeRepository, diretorRepository);

    @PostMapping
    public ResponseEntity<FilmeResponse> create(
            @Valid @RequestBody FilmeRequest request) {
        return ResponseEntity.created(null).body(filmeService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<FilmeResponse>> list() {
        return ResponseEntity.ok(filmeService.list());
    }

    @GetMapping("filtro-nacionalidade")
    public ResponseEntity<List<FilmeResponse>> listByNacionalidadeDiretor(
            @RequestParam String nacionalidade) {
        return ResponseEntity.ok(filmeService.listByNacionalidadeDiretor(nacionalidade));
    }
}
