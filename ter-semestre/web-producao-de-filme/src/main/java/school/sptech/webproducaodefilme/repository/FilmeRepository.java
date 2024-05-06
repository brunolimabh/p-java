package school.sptech.webproducaodefilme.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.webproducaodefilme.entity.Filme;

import java.util.List;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    List<Filme>
}
