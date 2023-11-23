package org.example.banco;

import org.example.componente.Componente;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface Conectavel {
    JdbcTemplate Conexao();

    List<Componente> selectComponentes(JdbcTemplate jdbcTemplate);
}
