package school.sptech.projetoserviceexception.dto.estabelecimento;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import school.sptech.projetoserviceexception.entity.Pessoa;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EstabelecimentoResponse {

    private Integer id;
    private String nome;
    private String cnpj;
    private Pessoa pessoa;

}
