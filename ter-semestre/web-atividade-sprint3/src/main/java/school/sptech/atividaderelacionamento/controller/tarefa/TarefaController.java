package school.sptech.atividaderelacionamento.controller.tarefa;

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
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaCriacaoDto;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaListagemDto;
import school.sptech.atividaderelacionamento.dto.tarefa.TarefaMapper;
import school.sptech.atividaderelacionamento.entity.tarefa.Tarefa;
import school.sptech.atividaderelacionamento.service.tarefa.TarefaService;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService service;

    @GetMapping
    public ResponseEntity<List<TarefaListagemDto>> listarTarefas() {
        List<Tarefa> list = service.listarTarefas();
        if (list.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return ResponseEntity.ok().body(TarefaMapper.toDto(list));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TarefaListagemDto> buscarTarefa(@PathVariable Integer id) {
        return ResponseEntity.ok().body(TarefaMapper.toDto(service.buscarTarefaPorId(id)));
    }

    @PostMapping
    public ResponseEntity<TarefaListagemDto> criarTarefa(@Valid @RequestBody TarefaCriacaoDto tarefaCriacaoDto) {
        return ResponseEntity.created(null).body(TarefaMapper.toDto(service.salvarTarefa(TarefaMapper.toEntity(tarefaCriacaoDto), tarefaCriacaoDto.getProjetoId())));
    }
}
