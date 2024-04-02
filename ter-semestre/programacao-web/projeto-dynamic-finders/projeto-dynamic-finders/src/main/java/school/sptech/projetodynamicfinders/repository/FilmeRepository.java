package school.sptech.projetodynamicfinders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.sptech.projetodynamicfinders.entity.Filme;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Integer> {
    /*
        findBy = SELECT f from Filme f
        Nome = Where nome
        Contains = LIKE %?%
        IgnoreCase = UPPER(nome) LIKE UPPER(%?%)
     */
    List<Filme> findByNomeContainsIgnoreCase(String nome);
    List<Filme> findByNotaGreaterThan(Double nome);
    List<Filme> findByNotaLessThan(Double nome);
    Optional<Filme> findFirstByOrderByNotaDesc();
    List<Filme> findTop3ByOrderByNotaDesc();
    int countByDiretor(String diretor);
    // para data, podemos utilizar after, mas somente ele (após)
    List<Filme> findByDataLancamentoGreaterThanEqual(LocalDate data);
    List<Filme> findByDiretorAndNomeContainsIgnoreCase(String diretor, String nome);

    @Query("SELECT f FROM Filme f WHERE f.nome ILIKE %:nome%")
    List<Filme> buscaPorNomeComLikeIgnorando(String nome);

}
