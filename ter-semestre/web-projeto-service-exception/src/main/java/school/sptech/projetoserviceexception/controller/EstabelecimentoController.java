package school.sptech.projetoserviceexception.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetoserviceexception.dto.estabelecimento.EstabelecimentoMapper;
import school.sptech.projetoserviceexception.dto.estabelecimento.EstabelecimentoRequest;
import school.sptech.projetoserviceexception.dto.estabelecimento.EstabelecimentoResponse;
import school.sptech.projetoserviceexception.dto.estabelecimento.EstabelecimentoVincularRequest;
import school.sptech.projetoserviceexception.entity.Estabelecimento;
import school.sptech.projetoserviceexception.service.EstabelecimentoService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estabelecimentos")
@RequiredArgsConstructor
public class EstabelecimentoController {

    private final EstabelecimentoService estabelecimentoService;

    @PostMapping
    public ResponseEntity<EstabelecimentoResponse> criar(@Valid @RequestBody EstabelecimentoRequest request) {
        Estabelecimento entity = estabelecimentoService.criar(request);
        URI uri = URI.create("/estabelecimentos/" + entity.getId());
        return ResponseEntity.created(null).body(EstabelecimentoMapper.toDto(entity));
    }

    @GetMapping
    public ResponseEntity<List<EstabelecimentoResponse>> listar() {
        List<Estabelecimento> estabelecimentos = estabelecimentoService.listar();
        if (estabelecimentos.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(EstabelecimentoMapper.toDto(estabelecimentos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstabelecimentoResponse> listarPorId(@PathVariable int id) {
        return ResponseEntity.ok(EstabelecimentoMapper.toDto(estabelecimentoService.listarPorId(id)));
    }

    @PatchMapping("/vincular")
    public ResponseEntity<EstabelecimentoResponse> vincular(@Valid @RequestBody EstabelecimentoVincularRequest request) {
        return ResponseEntity.ok(EstabelecimentoMapper.toDto(estabelecimentoService.vincular(request)));
    }

}
