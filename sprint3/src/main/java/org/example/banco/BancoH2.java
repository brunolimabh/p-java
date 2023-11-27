package org.example.banco;

import org.apache.commons.dbcp2.BasicDataSource;
import org.example.componente.Componente;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class BancoH2 implements Conectavel {
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
    public void insertRegistro(Double valor, LocalDateTime dataHora, Integer fkComponente, Integer fkTotem) {

    }
}
