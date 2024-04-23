package school.sptech.exercicioecommerce.dto;

import jakarta.validation.constraints.*;

public class ProdutoEstoqueAtualizacaoDto {
    @PositiveOrZero
    @NotNull
    private int novaQuantidade;

    public int getNovaQuantidade() {
        return novaQuantidade;
    }

    public void setNovaQuantidade(int novaQuantidade) {
        this.novaQuantidade = novaQuantidade;
    }
}
