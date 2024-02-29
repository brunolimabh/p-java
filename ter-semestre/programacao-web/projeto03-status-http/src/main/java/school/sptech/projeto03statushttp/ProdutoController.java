package school.sptech.projeto03statushttp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/estoque/{qtdEstoque}")
    public ResponseEntity<List<Produto>> listarPorQtdEstoque(@PathVariable int qtdEstoque){
        List<Produto> produtosQtdEstoque = new ArrayList<>();
        if (Objects.nonNull(qtdEstoque)){
            for (Produto produtoDaVez: produtos){
                if (produtoDaVez.getQtdEstoque() >= qtdEstoque){
                    produtosQtdEstoque.add(produtoDaVez);
                }
            }
            if (produtosQtdEstoque.isEmpty()){
                return ResponseEntity.status(204).body(produtosQtdEstoque);
            }
            return ResponseEntity.status(200).body(produtosQtdEstoque);
        }
        return ResponseEntity.status(400).build();
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
