package org.example;

import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface Conectavel {
    JdbcTemplate Conexao();

    List<Componente> selectComponentes(JdbcTemplate jdbcTemplate);
}
