package school.sptech.projeto_feign_data_rest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projeto_feign_data_rest.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
