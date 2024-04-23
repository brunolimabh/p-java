package school.sptech.exercicioecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.exercicioecommerce.entity.Produto;

import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
//    List<Produto> findByPrecoVendaBetween(double precoInicial, double precoFinal);
    List<Produto> findByCategoriaContainsIgnoreCaseAndPrecoVendaBetween(String categoria, double precoInicial, double precoFinal);
    List<Produto> findByQtdVendidosGreaterThan(int qtdVendidos);
}
