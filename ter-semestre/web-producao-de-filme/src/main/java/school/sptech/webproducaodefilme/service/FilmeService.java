package school.sptech.webproducaodefilme.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.webproducaodefilme.dto.filme.FilmeMapper;
import school.sptech.webproducaodefilme.dto.filme.FilmeRequest;
import school.sptech.webproducaodefilme.dto.filme.FilmeResponse;
import school.sptech.webproducaodefilme.entity.Diretor;
import school.sptech.webproducaodefilme.entity.Filme;
import school.sptech.webproducaodefilme.repository.DiretorRepository;
import school.sptech.webproducaodefilme.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private FilmeRepository filmeRepository;
    private DiretorRepository diretorRepository;

    @Autowired
    public FilmeService(FilmeRepository filmeRepository, DiretorRepository diretorRepository) {
        this.filmeRepository = filmeRepository;
        this.diretorRepository = diretorRepository;
    }

    public FilmeResponse create(FilmeRequest request) {
        Optional<Diretor> diretorOpt = diretorRepository.findById(request.getDiretorId());
        if (diretorOpt.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Filme filme = FilmeMapper.toEntity(request, diretorOpt.get());
        Filme saveFilme = filmeRepository.save(filme);
        return FilmeMapper.toDto(saveFilme);
    }

    public List<FilmeResponse> list() {
        List<Filme> filmes = filmeRepository.findAll();
        if (filmes.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return FilmeMapper.toDto(filmes);
    }

    public List<FilmeResponse> listByNacionalidadeDiretor(String nacionalidade){
        List<Filme> filmes = filmeRepository.findAll();
        if (filmes.isEmpty()) throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        return FilmeMapper.toDto(filmes);
    }
}
