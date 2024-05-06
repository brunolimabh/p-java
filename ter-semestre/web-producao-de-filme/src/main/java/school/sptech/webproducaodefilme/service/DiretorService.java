package school.sptech.webproducaodefilme.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.webproducaodefilme.dto.diretor.DiretorMapper;
import school.sptech.webproducaodefilme.dto.diretor.DiretorRequest;
import school.sptech.webproducaodefilme.dto.diretor.DiretorResponse;
import school.sptech.webproducaodefilme.dto.filme.FilmeMapper;
import school.sptech.webproducaodefilme.dto.filme.FilmeRequest;
import school.sptech.webproducaodefilme.dto.filme.FilmeResponse;
import school.sptech.webproducaodefilme.entity.Diretor;
import school.sptech.webproducaodefilme.entity.Filme;
import school.sptech.webproducaodefilme.repository.DiretorRepository;
import school.sptech.webproducaodefilme.repository.FilmeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DiretorService {

    private DiretorRepository diretorRepository;
    private FilmeRepository filmeRepository;

    @Autowired
    public DiretorService(DiretorRepository diretorRepository, FilmeRepository filmeRepository) {
        this.diretorRepository = diretorRepository;
        this.filmeRepository = filmeRepository;
    }

    public DiretorResponse create(DiretorRequest request) {
        Diretor diretor = DiretorMapper.toEntity(request);
        Diretor saveDiretor = diretorRepository.save(diretor);
        return DiretorMapper.toDto(saveDiretor);
    }

    public List<DiretorResponse> list() {
        List<Diretor> diretores = diretorRepository.findAll();
        if (diretores.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return DiretorMapper.toDto(diretores);
    }


}
