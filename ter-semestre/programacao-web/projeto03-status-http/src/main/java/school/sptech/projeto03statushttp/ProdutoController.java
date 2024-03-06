package school.sptech.projeto03statushttp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sound.sampled.Port;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    private List<Produto> produtos = new ArrayList<>();

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        produtos.add(produto);
        return ResponseEntity.status(201).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        if (produtos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produtos);
    }
    @GetMapping("/estoque")
    public ResponseEntity<List<Produto>> listarPorQtdEstoque(@RequestParam int qtdEstoque){
        List<Produto> produtosQtdEstoque = produtos
                    .stream()
                    .filter(produtoDaVez ->
                            produtoDaVez.getQtdEstoque() >= qtdEstoque)
                    .toList();
            if (produtosQtdEstoque.isEmpty()){
                return ResponseEntity.status(204).body(produtosQtdEstoque);
            }
            return ResponseEntity.status(200).body(produtosQtdEstoque);
    }

    @GetMapping("/busca-por-nome")
    public ResponseEntity<List<Produto>> buscaPorNome(
            @RequestParam String nome) {

        List<Produto> produtosPorNome = produtos.stream()
                .filter(produto -> produto.getNome().contains(nome))
                .toList();
        if (produtosPorNome.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produtosPorNome);
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Produto> alterarProduto(
            @PathVariable int indice,
            @RequestBody Produto produtoNovo){
        if (isProduto(indice)){
            produtos.set(indice, produtoNovo);
            return ResponseEntity.status(200).body(produtos.get(indice));
        }
        return ResponseEntity.status(400).build();
    }

    public boolean isProduto(int indice) {
        return indice >= 0 && indice < produtos.size();
    }


}
