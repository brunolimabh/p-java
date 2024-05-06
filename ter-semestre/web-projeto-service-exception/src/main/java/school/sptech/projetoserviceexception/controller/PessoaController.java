package school.sptech.projetoserviceexception.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetoserviceexception.dto.pessoa.PessoaMapper;
import school.sptech.projetoserviceexception.dto.pessoa.PessoaRequest;
import school.sptech.projetoserviceexception.dto.pessoa.PessoaResponse;
import school.sptech.projetoserviceexception.entity.Pessoa;
import school.sptech.projetoserviceexception.service.PessoaService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoas")
@RequiredArgsConstructor
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaResponse> criar(@Valid @RequestBody PessoaRequest request) {
        Pessoa entity = pessoaService.criar(request);
        URI uri = URI.create("/pessoas/" + entity.getId());
        return ResponseEntity.created(null).body(PessoaMapper.toDto(entity));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> listar() {
        List<Pessoa> pessoas = pessoaService.listar();
        if (pessoas.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(PessoaMapper.toDto(pessoas));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaResponse> listarPorId(@PathVariable int id) {
        return ResponseEntity.ok(PessoaMapper.toDto(pessoaService.listarPorId(id)));
    }

}
