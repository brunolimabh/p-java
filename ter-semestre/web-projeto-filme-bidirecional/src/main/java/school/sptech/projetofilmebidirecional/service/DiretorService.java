package school.sptech.projetofilmebidirecional.service;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetofilmebidirecional.dto.diretor.DiretorCriacaoDto;
import school.sptech.projetofilmebidirecional.dto.diretor.DiretorMapper;
import school.sptech.projetofilmebidirecional.entity.Diretor;
import school.sptech.projetofilmebidirecional.repository.DiretorRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiretorService {

    private final DiretorRepository diretorRepository;

    public Diretor criar(DiretorCriacaoDto diretorCriacaoDto) {
        Diretor diretorEntity = DiretorMapper.toEntity(diretorCriacaoDto);
        Diretor diretorSalvo = diretorRepository.save(diretorEntity);
        return diretorSalvo;
    }

    public List<Diretor> listar() {
        List<Diretor> diretores = diretorRepository.findAll();
        if (diretores.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return diretores;
    }
}
