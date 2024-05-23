package school.sptech.atividaderelacionamento.controller.projeto;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoCriacaoDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoListagemDto;
import school.sptech.atividaderelacionamento.dto.projeto.ProjetoMapper;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.service.projeto.ProjetoService;

import java.util.List;

@RestController
@RequestMapping("/projetos")
@RequiredArgsConstructor
public class ProjetoController {

    private final ProjetoService service;

    @GetMapping
    public ResponseEntity<List<ProjetoListagemDto>> listarProjetos() {
        List<Projeto> projetos = service.listarProjetos();
        if (projetos.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok().body(ProjetoMapper.toDto(projetos));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjetoListagemDto> buscarProjeto(@PathVariable Integer id) {
        return ResponseEntity.ok().body(ProjetoMapper.toDto(service.buscarProjetoPorId(id)));
    }

    @PostMapping
    public ResponseEntity<ProjetoListagemDto> criarProjeto(@Valid @RequestBody ProjetoCriacaoDto projetoCriacaoDto) {
        return ResponseEntity.created(null).body(ProjetoMapper.toDto(service.salvarProjeto(ProjetoMapper.toEntity(projetoCriacaoDto))));
    }
}
