package school.sptech.projetojpa;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projetojpa.entities.Musica;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Integer> {

    List<Musica> findByNome (String nome);

}
