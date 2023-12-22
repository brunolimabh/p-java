package org.example.database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

public class BancoMySQLLocal implements Conectavel {
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

    @Override
    public void insertRegistro(Double valor, LocalDateTime dataHora, Integer fkComponente, Integer fkTotem) {
        Conexao().update("INSERT INTO Registro (valor, dataHora, fkComponente, fkTotem) VALUES (?,?,?,?)",
                valor,dataHora,fkComponente,fkTotem);
    }
}

