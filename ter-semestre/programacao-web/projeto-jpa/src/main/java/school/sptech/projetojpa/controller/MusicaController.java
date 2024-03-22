package school.sptech.projetojpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetojpa.MusicaRepository;
import school.sptech.projetojpa.entities.Musica;

import javax.swing.plaf.multi.MultiDesktopIconUI;
import java.util.*;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private MusicaRepository musicaRepository;

    @PostMapping
    public ResponseEntity<Musica> create(@RequestBody Musica musica){
        musica.setId(null);
        Musica saveMusica = musicaRepository.save(musica);
        return ResponseEntity.status(201).body(saveMusica);
    }

    @GetMapping
    public ResponseEntity<List<Musica>> list(){
        List<Musica> musicas = musicaRepository.findAll();
        if (musicas.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(musicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> listId(@PathVariable Integer id){
        Optional<Musica> musicaOpt = musicaRepository.findById(id);
        return musicaOpt
                .map(musica -> ResponseEntity.status(200).body(musica))
                .orElseGet(() -> ResponseEntity.status(404).build());
    }

    //TODO - terminar
    @GetMapping("/busca-por-nome")
    public ResponseEntity<List<Musica>> listNome(@RequestParam String nome){
        List<Musica> musicas = musicaRepository.findByNome(nome);
        if (musicas.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(musicas);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id){
        if (!musicaRepository.existsById(id)) return ResponseEntity.status(404).build();
        musicaRepository.deleteById(id);
        return ResponseEntity.status(204).build();
    }
}
