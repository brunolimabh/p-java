package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ListaProduto {
    public static void main(String[] args) {
        List<Produto> produtos = Arrays.asList(
            new Produto(1, "Computador", "Eletrônicos", 3000.0, 50),
            new Produto(2, "Guaraviton", "Bebidas", 3.5, 40),
            new Produto(3, "Pão de Batata", "Alimentos", 9.9, 10),
            new Produto(4, "Celular", "Eletrônicos", 1500.0, 15),
            new Produto(5, "Cama", "Móveis", 900.00, 20),
            new Produto(6, "Cadeira", "Móveis", 200.0, 30),
            new Produto(7, "Trento", "Alimentos", 3.0, 100),
            new Produto(8, "Perfume", "Higiene", 150.0, 80)
        );

        System.out.println("(a) Exiba os valores dos produtos da lista");
        produtos.forEach(System.out::println);

        System.out.println("\n(b) Exiba somente os nomes dos produtos, em caixa alta (tudo maiúsculo), ordenados");
        produtos.stream()
                .map(p -> p.getNome().toUpperCase())
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n(c) Crie um predicate para filtrar os preços entre um intervalo de valores. Exiba os" +
                "produtos que atendem esse filtro, ordenados.");
        Predicate<Produto> filtroPreco = p -> p.getPreco() >= 10 && p.getPreco() <= 1500;
        produtos.stream()
                .filter(filtroPreco)
                .sorted(Comparator.comparing(Produto::getPreco))
                .forEach(System.out::println);

        System.out.println("\n(d) Exiba o primeiro produto que atende a esse filtro (predicate criado no item c)");
        produtos.stream()
                .filter(filtroPreco)
                .findFirst()
                .ifPresent(System.out::println);

        System.out.println("\n(e) Crie uma Function que retorna para cada produto o seu nome e uma outra Function " +
                "que retorna para cada produto a sua categoria. Crie um Comparator que compara " +
                "primeiro a categoria e depois o nome do produto. Exiba a lista dos produtos " +
                "ordenados por esse comparator");
        Function<Produto, String> getNome = Produto::getNome;
        Function<Produto, String> getCategoria = Produto::getCategoria;
        produtos.stream()
                .sorted(Comparator.comparing(getCategoria).thenComparing(getNome))
                .forEach(System.out::println);

        System.out.println("\n(f) Exiba as categorias distintas da lista, em ordem alfabética");
        produtos.stream()
                .map(Produto::getCategoria)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n(g) Exiba a soma dos preços dos produtos usando .sum()");
        double somaPrecos = produtos.stream()
                .mapToDouble(Produto::getPreco)
                .sum();
        System.out.println("Soma: " + somaPrecos);

        System.out.println("\n(h) Exiba a soma dos preços dos produtos usando reduce");
        double somaPrecosReduce = produtos.stream()
                .map(Produto::getPreco)
                .reduce(0.0, Double::sum);
        System.out.println("Soma (reduce): " + somaPrecosReduce);

        System.out.println("\n(i) Exiba a média dos preços dos produtos");
        produtos.stream()
                .mapToDouble(Produto::getPreco)
                .average()
                .ifPresent(media -> System.out.println("Média: " + media));

        System.out.println("\n(j) Exiba a soma das quantidades de estoque usando .sum()");
        int somaEstoque = produtos.stream()
                .mapToInt(Produto::getQtdEstoque)
                .sum();
        System.out.println(somaEstoque);

        System.out.println("\n(k) Exiba os produtos agrupados pela categoria");
        Map<String, List<Produto>> produtosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria));
        System.out.println(produtosPorCategoria);

        System.out.println("\n(l) Exiba a quantidade de produtos agrupados pela categoria");
        Map<String, Long> quantidadePorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.counting()));
        System.out.println(quantidadePorCategoria);

        System.out.println("\n(m) Desafio: exiba a soma dos preços dos produtos agrupados pela categoria");
        Map<String, Double> somaPrecosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.summingDouble(Produto::getPreco)));
        System.out.println(somaPrecosPorCategoria);

        System.out.println("\n(n) Desafio: exiba a média dos preços dos produtos agrupados pela categoria");
        Map<String, Double> mediaPrecosPorCategoria = produtos.stream()
                .collect(Collectors.groupingBy(Produto::getCategoria, Collectors.averagingDouble(Produto::getPreco)));
        System.out.println(mediaPrecosPorCategoria);
    }
}
