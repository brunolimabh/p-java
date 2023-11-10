package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public interface Conexao {
    JdbcTemplate Conexao();

    List<Componente> selectComponentes();

}
