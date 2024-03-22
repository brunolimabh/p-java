package school.sptech.projetovalidations.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projetovalidations.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private int identificador = 0;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody @Valid Usuario usuario){
        usuario.setIdUsuario(++identificador);
        usuarios.add(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        if (usuarios.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(usuarios);
    }

    @DeleteMapping
    public ResponseEntity<Void> excluir(@PathVariable int naosei){

        usuarios.remove(1);
        return ResponseEntity.status(204).build();
    }


}
