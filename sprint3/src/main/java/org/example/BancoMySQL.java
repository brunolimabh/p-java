package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class BancoMySQL implements Conexao {
    private JdbcTemplate conexao;

    @Override
    public JdbcTemplate Conexao() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:h2:file:./banco");
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        this.conexao = new JdbcTemplate(dataSource);
        return conexao;
    }

    @Override
    public List<Componente> selectComponentes() {
        List<Componente> componentes = new ArrayList<>();
        return componentes;
    }
}
