package school.sptech.marketplaceresumido.service.calculadora;

public class CalculadoraService {

    public Double icms(Double preco) {

        if (preco == null) {
            throw new IllegalArgumentException("Não pode ser nulo");
        }

        if (preco < 0) {
            throw new IllegalArgumentException("Não pode ser negativo");
        }

        if (preco == 0) {
            throw new IllegalArgumentException("Não pode ser zero");
        }

        return preco * 0.18;
    }

}
