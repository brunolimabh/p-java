package org.example.banco;

import org.example.componente.Componente;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

public interface Conectavel {
    JdbcTemplate Conexao();

    void insertRegistro(Double valor, LocalDateTime dataHora, Integer fkComponente, Integer fkTotem);
}
