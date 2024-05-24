package school.sptech.marketplaceresumido.data;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.marketplaceresumido.entity.Produto;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

    List<Produto> findByNomeContainsIgnoreCase(String nome);

}
