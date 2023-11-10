package org.example;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class BancoH2 implements Conexao{
    private static JdbcTemplate conexao;

    @Override
    public JdbcTemplate Conexao() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/ConWay");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUsername("user_conway");
        dataSource.setPassword("urubu100");
        this.conexao = new JdbcTemplate(dataSource);
        return conexao;
    }
}

