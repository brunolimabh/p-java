package school.sptech.atividaderelacionamento.service.projeto;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.atividaderelacionamento.entity.projeto.Projeto;
import school.sptech.atividaderelacionamento.repository.projeto.ProjetoRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjetoService {

    private final ProjetoRepository repository;

    public List<Projeto> listarProjetos() {
        return repository.findAll();
    }

    public Projeto buscarProjetoPorId(Integer id) {
        Optional<Projeto> projetoOpt = repository.findById(id);
        if (projetoOpt.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return projetoOpt.get();
    }

    public Projeto salvarProjeto(Projeto projeto) {
        if (projeto.getDataInicio().isAfter(projeto.getDataFim())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        return repository.save(projeto);
    }
}
