package school.sptech.projetoserviceexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projetoserviceexception.entity.Estabelecimento;
import school.sptech.projetoserviceexception.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
    boolean existsByEmail(String email);
}
