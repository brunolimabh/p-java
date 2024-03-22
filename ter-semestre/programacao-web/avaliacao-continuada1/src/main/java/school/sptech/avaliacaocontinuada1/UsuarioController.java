package school.sptech.avaliacaocontinuada1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    private List<Usuario> usuarios = new ArrayList<>();
    private int identificador = 0;

    @PostMapping
    public ResponseEntity<Usuario> cadastrar(@RequestBody Usuario usuario){
        if (!emailValido(usuario.getEmail())) return ResponseEntity.status(400).build();
        if (emailExistente(usuario.getEmail())) return ResponseEntity.status(409).build();
        usuario.setId(++identificador);
        usuarios.add(usuario);
        return ResponseEntity.status(201).body(usuario);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar(){
        if (usuarios.isEmpty()) return ResponseEntity.status(204).build();
        return ResponseEntity.status(200).body(usuarios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> listarPorId(@PathVariable int id){
        Usuario usuario = idExistente(id);
        if (usuario == null) return ResponseEntity.status(404).build();
        return ResponseEntity.status(200).body(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable int id, @RequestBody Usuario usuarioNovo){
        Usuario usuario = idExistente(id);
        if (usuario == null) return ResponseEntity.status(404).build();
        if (!emailValido(usuarioNovo.getEmail())) return ResponseEntity.status(400).build();
        if (emailExistenteOutroUsuario(usuarioNovo.getEmail(),id)) return ResponseEntity.status(409).build();
        usuario.setId(usuarioNovo.getId());
        usuario.setNome(usuarioNovo.getNome());
        usuario.setEmail(usuarioNovo.getEmail());
        usuario.setSenha(usuarioNovo.getSenha());
        usuario.setDataNascimento(usuarioNovo.getDataNascimento());
        return ResponseEntity.status(200).body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id){
        Usuario usuario = idExistente(id);
        if (usuario == null) return ResponseEntity.status(404).build();
        usuarios.remove(usuario);
        return ResponseEntity.status(204).build();
    }

    public boolean emailValido(String email){
        return email.contains("@") && email.length() >= 10;
    }

    public boolean emailExistente(String email){
        return usuarios.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
    }

    public boolean emailExistenteOutroUsuario(String email, int id){
        return usuarios.stream()
                .anyMatch(u -> u.getEmail().equalsIgnoreCase(email) && u.getId() != id);
    }

    public Usuario idExistente(int id){
        return usuarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
