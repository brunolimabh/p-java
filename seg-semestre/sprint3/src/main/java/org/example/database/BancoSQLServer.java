package org.example.database;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;

public class BancoSQLServer implements Conectavel {
    private static JdbcTemplate conexao;

    @Override
    public JdbcTemplate Conexao() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:sqlserver://18.232.10.255:1433;databaseName=ConWay;encrypt=false;");
        dataSource.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dataSource.setUsername("sa");
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



