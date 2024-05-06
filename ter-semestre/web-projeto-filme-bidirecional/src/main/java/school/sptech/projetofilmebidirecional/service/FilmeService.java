package school.sptech.projetofilmebidirecional.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeCriacaoDto;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeListagemDto;
import school.sptech.projetofilmebidirecional.dto.filme.FilmeMapper;
import school.sptech.projetofilmebidirecional.entity.Diretor;
import school.sptech.projetofilmebidirecional.entity.Filme;
import school.sptech.projetofilmebidirecional.repository.DiretorRepository;
import school.sptech.projetofilmebidirecional.repository.FilmeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmeService {

    private final FilmeRepository filmeRepository;
    private final DiretorRepository diretorRepository;

    public Filme criar(FilmeCriacaoDto request) {
        Optional<Diretor> diretorOpt = diretorRepository.findById(request.getDiretorId());
        if (diretorOpt.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        Filme filme = FilmeMapper.toEntity(request, diretorOpt.get());
        filme = filmeRepository.save(filme);
        return filme;
    }

    public List<Filme> listar() {
        List<Filme> filmes = filmeRepository.findAll();
        if (filmes.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return filmes;
    }
}
