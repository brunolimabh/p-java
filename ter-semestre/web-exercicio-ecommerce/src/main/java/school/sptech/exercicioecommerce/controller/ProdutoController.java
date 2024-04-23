package school.sptech.exercicioecommerce.controller;

import jakarta.validation.Valid;
import org.aspectj.apache.bcel.Repository;
import org.hibernate.usertype.LoggableUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exercicioecommerce.dto.*;
import school.sptech.exercicioecommerce.entity.Produto;
import school.sptech.exercicioecommerce.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<ProdutoListagemDto> criar(
            @RequestBody @Valid ProdutoCriacaoDto produtoCriacao){
        Produto entity = ProdutoMapper.toEntity(produtoCriacao);
        Produto entitySave = produtoRepository.save(entity);
        ProdutoListagemDto dto = ProdutoMapper.toDto(entitySave);
        return ResponseEntity.status(201).body(dto);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoListagemDto>> listar(){
        List<Produto> produtos = produtoRepository.findAll();
        if (produtos.isEmpty()) return ResponseEntity.status(400).build();
        List<ProdutoListagemDto> dtos= ProdutoMapper.toDto(produtos);
        return ResponseEntity.status(200).body(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoListagemDto> listarPorId(@PathVariable int id){
        if (!produtoRepository.existsById(id)) return ResponseEntity.status(404).build();
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        ProdutoListagemDto dto = ProdutoMapper.toDto(produtoOpt.get());
        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping("/{id}/cliente")
    public ResponseEntity<ProdutoClienteListagemDto> listarPorIdVisaoCliente(@PathVariable int id){
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isEmpty()) return ResponseEntity.status(404).build();
        ProdutoClienteListagemDto dto = ProdutoMapper.toClienteDto(produtoOpt.get());
        return ResponseEntity.status(200).body(dto);
    }

    @PatchMapping("/{id}/estoque")
    public ResponseEntity<ProdutoListagemDto> alterarEstoque(
            @PathVariable int id,
            @RequestBody @Valid ProdutoEstoqueAtualizacaoDto produtoAtualizado){
        Optional<Produto> produtoOpt = produtoRepository.findById(id);
        if (produtoOpt.isEmpty()) return ResponseEntity.status(404).build();;
        Produto entity = ProdutoMapper.toEntityEstoque(produtoAtualizado, produtoOpt.get());
        Produto entitySave = produtoRepository.save(entity);
        ProdutoListagemDto dto = ProdutoMapper.toDto(entitySave);
        return ResponseEntity.status(200).body(dto);
    }

    @PostMapping("/{id}/compra")
    public ResponseEntity<ProdutoClienteListagemDto> finalizarCompra(
            @PathVariable int id){
        Optional<Produto> entity = produtoRepository.findById(id);
        if (entity.isEmpty()) return ResponseEntity.status(404).build();;
        entity.get().setQtdEstoque(entity.get().getQtdEstoque() - 1);
        entity.get().setQtdVendidos(entity.get().getQtdVendidos() + 1);
        Produto entitySave = produtoRepository.save(entity.get());
        ProdutoClienteListagemDto dto = ProdutoMapper.toClienteDto(entitySave);
        return ResponseEntity.status(200).body(dto);
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<ProdutoClienteListagemDto>> listarPorFiltro(
            @RequestParam String categoria,
            @RequestParam int precoInicial,
            @RequestParam int precoFinal){
        if (precoInicial > precoFinal) return ResponseEntity.status(400).build();
        List<Produto> produtos = produtoRepository.findByCategoriaContainsIgnoreCaseAndPrecoVendaBetween(categoria, precoInicial, precoFinal);
        if (produtos.isEmpty()) return ResponseEntity.status(400).build();
        List<ProdutoClienteListagemDto> dtos = ProdutoMapper.toClienteDto(produtos);
        return ResponseEntity.status(200).body(dtos);
    }

    @GetMapping("/mais-vendidos")
    public ResponseEntity<List<ProdutoListagemDto>> listarMaisVendidos(@RequestParam int quantidadeVendidos){
        List<Produto> produtos = produtoRepository.findByQtdVendidosGreaterThan(quantidadeVendidos);
        if (produtos.isEmpty()) return ResponseEntity.status(400).build();
        List<ProdutoListagemDto> dtos = ProdutoMapper.toDto(produtos);
        return ResponseEntity.status(200).body(dtos);
    }
}
