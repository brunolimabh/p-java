package school.sptech;

import java.util.ArrayList;
import java.util.List;

public class Repositorio {

    // Atributos
    private List<Recurso> lista;        // Lista de recursos
    private PilhaObj<Operacao> pilha;   // Pilha usada para desfazer as operações de deletar ou aumentarRecurso

    // Construtor
    /* Não recebe argumento, deve instanciar a lista e a pilha
       Pode instanciar a pilha com tamanho 10
    */
    public Repositorio() {
        this.lista = new ArrayList<>();
        this.pilha = new PilhaObj<>(10);
    }

    // Métodos

    /* Metodo salvar - recebe um Recurso r como argumento
       Adiciona esse recurso a lista
    */
    public void salvar(Recurso r) {
        lista.add(r);
    }

    /* Metodo deletar - recebe como argumento o id do recurso a ser deletado
       Se nao encontrar o recurso, deve lancar IllegalArgumentException
       Se encontrar, deve remover o recurso da lista e como essa operacao pode ser desfeita, deve
       criar uma operacao com tipo "deletar" e atributo recursoDeletado = ao recurso deletado,
       null nos outros 2 atributos de operacao e empilhar a operacao na pilha
     */
    public void deletar(int id) {
        Recurso recurdoDeletado = null;
        for (Recurso recurso: lista) {
            if (recurso.getId() == id) {
                recurdoDeletado = recurso;
            }
        }
        if (recurdoDeletado == null) throw new IllegalArgumentException();


        lista.remove(recurdoDeletado);

        Operacao operacao = new Operacao(
                "deletar",
                recurdoDeletado,
                null,
                0);
        pilha.push(operacao);
    }

    /* Metodo aumentarRecurso - recebe como argumento a categoria de recursos que sofrerao aumento
       e o valor a ser aumentado nas quantidades de cada recurso da lista
       Percorre a lista de recursos e aumenta a quantidade de recursos dessa categoria, somando
       a quantidade anterior com o valor de aumento
       Por exemplo: se um recurso adicionado na lista eh (id: 1, nome: "medico", categoria: "pessoal", quantidade: 3)
       E os argumentos forem categoria="pessoal, valorAumento=2, apos a execucao desse metodo, esse recurso ficara
       (id: 1, nome: "medico", categoria: "pessoal", quantidade: 5)
       Isso deve ser feito em todos os recursos que estao salvos na lista que sejam dessa categoria.
       Pode supor que sempre vai ter recurso da categoria desejada.
       Como essa operacao pode ser desfeita, deve criar uma operacao com tipo "aumentarRecurso", null em recursoDeletado,
       categoria e valorAumentado setados corretamente e empilhar a operacao na pilha
     */

    public void aumentarRecurso(String categoria, int valorAumento) {
        for (Recurso recurso: lista) {
            if (recurso.getCategoria().equalsIgnoreCase(categoria)) {
                recurso.setQuantidade(recurso.getQuantidade()+valorAumento);
            }
        }
        Operacao operacao = new Operacao(
                "aumentarRecurso",
                null,
                categoria,
                valorAumento
        );
        pilha.push(operacao);
    }

    /* Metodo diminuirRecurso - recebe como argumento a categoria do recurso que sofrera reducao e
       o valor a ser diminuido nas quantidades de cada recurso da lista dessa categoria
       Eh o metodo que faz o inverso do aumentarRecurso
       Percorre a lista de recursos e para cada recurso dessa categoria,  diminui a quantidade
       de recursos subtraindo da quantidade anterior o valor de diminuicao
       Por exemplo: se um recurso adicionado na lista eh (id: 1, nome: "medico", categoria: "pessoal", quantidade: 5)
       E os argumentos forem categoria="pessoal", valorDiminuicao=2, apos a execucao desse metodo, esse recurso ficara
       (id: 1, nome: "medico", categoria: "pessoal", quantidade: 3)
       Isso deve ser feito em todos os recursos que estao salvos na lista que sejam dessa categoria.
       Pode supor que sempre vai ter recurso da categoria desejada.
     */
    public void diminuirRecurso(String categoria, int valorDiminuicao) {
        for (Recurso recurso: lista) {
            if (recurso.getCategoria().equalsIgnoreCase(categoria)) {
                recurso.setQuantidade(recurso.getQuantidade()-valorDiminuicao);
            }
        }
    }

    /* Metodo desfazer - nao recebe argumentos
       Se a pilha estiver vazia, lanca IllegalStateException
       Se a pilha nao estiver vazia, desempilha uma operacao.
       Se a operacao desempilhada tiver o tipo "deletar" faz o inverso de "deletar" usando o recursoDeletado.
       Se a operacao desempilhada tiver o tipo "aumentarRecurso, faz o "inverso do aumentarRecurso",
       passando a categoria e o valorAumentado que estão no objeto desempilhado
     */
    public void desfazer() {
        if (pilha.isEmpty()) throw new IllegalStateException();
        for (int i = 0; i < 10; i++) {
            if (pilha.peek() != null) {
                Operacao operacao = pilha.pop();
                if (operacao.getTipo().equalsIgnoreCase("deletar")) {
                    lista.add(operacao.getRecursoDeletado());
                } else if (operacao.getTipo().equalsIgnoreCase("aumentarRecurso")) {
                    for (Recurso recurso: lista) {
                        if (recurso.getCategoria().equalsIgnoreCase(operacao.getCategoria())) {
                            recurso.setQuantidade(recurso.getQuantidade() - operacao.getValorAumentado());
                        }
                    }
                }
            }
        }
    }


    // Getters - usados nos testes automatizados
    // Favor nao altera-los
    public List<Recurso> getLista() {
        return lista;
    }

    public PilhaObj<Operacao> getPilha() {
        return pilha;
    }
}
