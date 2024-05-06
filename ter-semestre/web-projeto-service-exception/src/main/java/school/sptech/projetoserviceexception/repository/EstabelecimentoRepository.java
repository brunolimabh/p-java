package school.sptech.projetoserviceexception.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.projetoserviceexception.entity.Estabelecimento;

public interface EstabelecimentoRepository extends JpaRepository<Estabelecimento, Integer> {
    boolean existsByCnpj(String cnpj);
}
