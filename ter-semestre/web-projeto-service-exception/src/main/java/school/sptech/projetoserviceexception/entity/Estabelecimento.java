package school.sptech.projetoserviceexception.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Estabelecimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String cnpj;
    @ManyToOne
    private Pessoa pessoa;

}
