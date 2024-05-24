package school.sptech.marketplaceresumido.service.produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import school.sptech.marketplaceresumido.entity.Produto;
import school.sptech.marketplaceresumido.data.ProdutoRepository;
import school.sptech.marketplaceresumido.exception.EntidadeNaoEncontradaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @InjectMocks
    private ProdutoService service;

    @Mock
    private ProdutoRepository repository;


    @Test
    @DisplayName("Deve retornar lista com 3 produtos")
    void deveRetornarListaProduto() {
        // CONFIGURACAO DO TESTE

        // GIVEN
        List<Produto> produtos = List.of(
                new Produto(1, "p1", "legal", "124124", 11.0),
                new Produto(2, "p2", "legal", "124124", 11.0),
                new Produto(3, "p3", "legal", "124124", 11.0)
        );

        // WHEN
        Mockito.when(repository.findAll()).thenReturn(produtos);

        // -----------------------------------------------------

        // THEN
        List<Produto> produtosRetorno = service.listar();

        // ASSERT
        assertEquals(produtos.size(), produtosRetorno.size());
        assertEquals(3, produtosRetorno.size());
        assertFalse(produtosRetorno.isEmpty());
        assertEquals(produtos.get(0).getNome(), produtosRetorno.get(0).getNome());

        Mockito.verify(repository, Mockito.times(1)).findAll();
    }

    @Test
    @DisplayName("Retorna lista vazia")
    void retornaListaVazia() {
        // GIVEN
        List<Produto> produtos = new ArrayList<>();

        // WHEN
        Mockito.when(repository.findAll()).thenReturn(produtos);

        // THEN
        List<Produto> produtosListados = service.listar();

        // ASSERT
        assertTrue(produtosListados.isEmpty());
        Mockito.verify(repository, Mockito.times(1)).findAll();

    }

    @Test
    @DisplayName("Deve retornar o objeto salvo")
    void testSalvaProduto() {

        // GIVEN
        Produto produto = new Produto(1, "p1", "legal", "2345", 15.0);
        Produto novoProduto = new Produto(null, "p1", "legal", "2345", 15.0);

        // WHEN
        Mockito.when(repository.save(novoProduto)).thenReturn(produto);

        // THEN
        Produto produtoSalvo = service.salvar(novoProduto);

        // ASSERT
        assertEquals(produto.getId(), produtoSalvo.getId());
        Mockito.verify(repository, Mockito.times(1)).save(novoProduto);

    }

    @Test
    @DisplayName("Deve retornar o objeto pelo id")
    void retonaObjetoPeloId() {
        // GIVEN
        Produto produto = new Produto(1, "p1", "legal", "2345", 15.0);
        Integer idBusca = 1;

        // WHEN
        Mockito.when(repository.findById(idBusca)).thenReturn(Optional.of(produto));

        // THEN
        Produto produtoEncontrado = service.buscaPorId(idBusca);

        // ASSERT
        assertEquals(produtoEncontrado.getId(), idBusca);

        Mockito.verify(repository, Mockito.times(1)).findById(idBusca);

    }

    @Test
    @DisplayName("Deve retornar ResponseStatusException caso não exista o id")
    void retornaExceptionCasoNaoExiste() {

        // GIVEN
        Integer idBusca = 100;

        // WHEN
        Mockito.when(repository.findById(idBusca)).thenReturn(Optional.empty());

        // THEN
        // ASSERT
        EntidadeNaoEncontradaException exception =
                assertThrows(EntidadeNaoEncontradaException.class,
                () -> service.buscaPorId(idBusca));

        assertEquals("Produto não encontrado!", exception.getLocalizedMessage());

        Mockito.verify(repository, Mockito.times(1)).findById(idBusca);
    }

    @Test
    @DisplayName("Buscar por letra 'a' deve retornar 2 produtos")
    void retornaProdutosComLetraA() {
        // GIVEN
        List<Produto> produtos = List.of(
                new Produto(1, "lega", "legal", "124124", 11.0),
                new Produto(2, "lega", "legal", "124124", 11.0)
        );

        // WHEN
        Mockito.when(repository.findByNomeContainsIgnoreCase("a")).thenReturn(produtos);

        // THEN
        List<Produto> listProdutos = service.buscarPorNome("a");

        // ASSERT
        assertEquals(produtos.size(), listProdutos.size());
        assertFalse(listProdutos.isEmpty());

        Mockito.verify(repository, Mockito.times(1)).findByNomeContainsIgnoreCase("a");
    }

    @Test
    @DisplayName("Buscar por letra 'w' e retornar lista vazia")
    void retornaListaVaziaComLetraW() {
        // GIVEN
        List<Produto> produtos = new ArrayList<>();
        // WHEN
        Mockito.when(repository.findByNomeContainsIgnoreCase("w")).thenReturn(produtos);

        // THEN
        List<Produto> produtosListados = service.buscarPorNome("w");

        // ASSERT
        assertTrue(produtosListados.isEmpty());
        Mockito.verify(repository, Mockito.times(1)).findByNomeContainsIgnoreCase("w");
    }

    @Test
    @DisplayName("Dado que possuo o id no banco e passo o objeto, atualize com sucesso ")
    void dadoQueAtualizacaoCorreta() {
        // GIVEN
        Produto produtoAtualizacao = new Produto(null, "Bolacha 2", "top", "123", 5.0);
        Integer idInformado = 1;
        Produto produtoRetorno = new Produto(idInformado, "Bolacha 2", "top", "123", 5.0);

        // WHEN
        Mockito.when(repository.save(produtoAtualizacao)).thenReturn(produtoRetorno);
        Mockito.when(repository.existsById(idInformado)).thenReturn(true);

        // THEN
        Produto resposta = service.atualizar(idInformado, produtoAtualizacao);

        // ASSERT
        assertEquals(idInformado, resposta.getId());
        assertEquals(produtoAtualizacao.getNome(), resposta.getNome());

        Mockito.verify(repository, Mockito.times(1)).existsById(idInformado);
        Mockito.verify(repository, Mockito.times(1)).save(produtoAtualizacao);
    }

}