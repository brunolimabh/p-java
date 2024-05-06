package school.sptech.webproducaodefilme.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.webproducaodefilme.dto.diretor.DiretorRequest;
import school.sptech.webproducaodefilme.dto.diretor.DiretorResponse;
import school.sptech.webproducaodefilme.dto.filme.FilmeRequest;
import school.sptech.webproducaodefilme.dto.filme.FilmeResponse;
import school.sptech.webproducaodefilme.repository.DiretorRepository;
import school.sptech.webproducaodefilme.repository.FilmeRepository;
import school.sptech.webproducaodefilme.service.DiretorService;
import school.sptech.webproducaodefilme.service.FilmeService;

import java.util.List;

@RestController
@RequestMapping("/diretores")
@RequiredArgsConstructor
public class DiretorController {

    private final DiretorRepository diretorRepository = null;
    private final FilmeRepository filmeRepository = null;

    DiretorService diretorService = new DiretorService(diretorRepository, filmeRepository);

    @PostMapping
    public ResponseEntity<DiretorResponse> create(
            @Valid @RequestBody DiretorRequest request) {
        return ResponseEntity.created(null).body(diretorService.create(request));
    }

    @GetMapping
    public ResponseEntity<List<DiretorResponse>> list() {
        return ResponseEntity.ok(diretorService.list());
    }

}
