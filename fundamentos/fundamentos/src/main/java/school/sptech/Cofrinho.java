package school.sptech;

import java.util.concurrent.ThreadLocalRandom;

public class Cofrinho {

    // Atributos
    private String meta;
    private Double valor = 0.0;
    private Boolean quebrado = false;

    // Contrutores
    // PascalCase = pois carrega o nome da classe
    public Cofrinho(String meta) {
        this.meta = meta;
        this.valor = 0.0;
        this.quebrado = false;
    }

    // Métodos
    public void depositar(Double valorDeposito) {
        if (quebrado) {
            System.out.println("Cofrinho quebrado");
        } else {
            valor += valorDeposito;
        }
    }

    public Double chacoalhar() {
        if (quebrado) {
            System.out.println("Cofrinho quebrado");
            return 0.0;
        } else {
            // Remove um valor aleatório do cofrinho
            Double valorRemovido = ThreadLocalRandom.current().nextDouble(valor);
            valor -= valorRemovido;
            return valorRemovido;
        }
    }

    public Double quebrar() {
        if (quebrado) {
            System.out.println("Cofrinho já foi quebrado");
            return 0.0;
        } else {
            Double valorRemovido = valor;
            return valorRemovido;
        }
    }

    public void situacaoCofrinho() {
        System.out.println("""
                -------------------
                Cofrinho
                Meta: %s
                ValorAtual: R$%.2f
                Estado: %s
                -------------------
                """.formatted(meta, valor, quebrado ? "Quebrado" : "Novo"));
    }

    // getter/setter/toString
    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta;
    }

    @Override
    public String toString() {
        return "Cofrinho{" +
                "meta='" + meta + '\'' +
                ", valor=" + valor +
                ", quebrado=" + quebrado +
                '}';
    }
}
