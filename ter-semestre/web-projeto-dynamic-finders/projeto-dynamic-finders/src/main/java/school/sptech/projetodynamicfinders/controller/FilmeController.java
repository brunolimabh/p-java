package school.sptech.projetodynamicfinders.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetodynamicfinders.entity.Filme;
import school.sptech.projetodynamicfinders.repository.FilmeRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/filmes")
public class FilmeController {
    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping
    public ResponseEntity<List<Filme>> listar(){
        List<Filme> fIlmes = filmeRepository.findAll();
        if (fIlmes.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(fIlmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> listarPorId(@PathVariable Integer id){
        Optional<Filme> filmeOpt = filmeRepository.findById(id);
        return filmeOpt
                .map(fIlme -> ResponseEntity.status(200).body(fIlme))
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @GetMapping("/filtro-nome")
    public ResponseEntity<List<Filme>> listarPorNome(@RequestParam String nome){
        List<Filme> fIlmes = filmeRepository.findByNomeContainsIgnoreCase(nome);
        if (fIlmes.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(fIlmes);
    }

    @GetMapping("/filtro-nota-maior")
    public ResponseEntity<List<Filme>> listarPoNotaMaior(@RequestParam Double nota){
        List<Filme> fIlmes = filmeRepository.findByNotaGreaterThan(nota);
        if (fIlmes.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(fIlmes);
    }

    @GetMapping("/filtro-nota-menor")
    public ResponseEntity<List<Filme>> listarPorNotaMenor(@RequestParam Double nota){
        List<Filme> filmes = filmeRepository.findByNotaLessThan(nota);
        if (filmes.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(filmes);
    }

    @GetMapping("/favorito")
    public ResponseEntity<Filme> listarFavorito(){
        Optional<Filme> filmeOpt = filmeRepository.findFirstByOrderByNotaDesc();
        return filmeOpt
                .map(fIlme -> ResponseEntity.status(200).body(fIlme))
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    @GetMapping("/top-tres")
    public ResponseEntity<List<Filme>> listarTop3(){
        List<Filme> filmes = filmeRepository.findTop3ByOrderByNotaDesc();
        if (filmes.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(filmes);
    }

    @GetMapping("/contagem-diretor")
    public ResponseEntity<Integer> ListarFilmesPorDiretor(@RequestParam String diretor){
        int contagem = filmeRepository.countByDiretor(diretor);
        return ResponseEntity.status(200).body(contagem);
    }

    @GetMapping("/filtro-data")
    public ResponseEntity<List<Filme>> listarPorData(@RequestParam LocalDate data){
        List<Filme> filmes = filmeRepository.findByDataLancamentoGreaterThanEqual(data);
        if (filmes.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(filmes);
    }

    @GetMapping("/filtro-filmes-diretor")
    public ResponseEntity<List<Filme>> ListarFilmesPorDiretorENome(
            @RequestParam String diretor,
            @RequestParam String nome){
        List<Filme> filmes = filmeRepository.findByDiretorAndNomeContainsIgnoreCase(diretor, nome);
        if (filmes.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(filmes);
    }

    @PostMapping
    public ResponseEntity<Filme> criar(@RequestBody @Valid Filme filme){
        filme.setId(null);
        Filme filmeSave = filmeRepository.save(filme);
        return ResponseEntity.status(201).body(filmeSave);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Filme> atualizar(
            @RequestBody @Valid Filme filme,
            @PathVariable int id){
        if (!filmeRepository.existsById(id)) return ResponseEntity.status(404).build();
        filme.setId(id);
        Filme filmeSave = filmeRepository.save(filme);
        return ResponseEntity.status(201).body(filmeSave);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id){
        if (!filmeRepository.existsById(id)) return ResponseEntity.status(400).build();
        filmeRepository.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
