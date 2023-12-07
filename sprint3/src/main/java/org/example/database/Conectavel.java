package org.example.database;

import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

public interface Conectavel {
    JdbcTemplate Conexao();

    void insertRegistro(Double valor, LocalDateTime dataHora, Integer fkComponente, Integer fkTotem);
}
