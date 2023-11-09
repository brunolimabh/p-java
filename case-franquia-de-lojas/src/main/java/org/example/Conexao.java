package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class Conexao {
    private JdbcTemplate conexao;

    public Conexao() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:h2:file:./banco");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");

        this.conexao = new JdbcTemplate(dataSource);
    }

    public JdbcTemplate getConexao() {
        return conexao;
    }
}
