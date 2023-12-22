package org.example.dao;

import org.example.model.TotemComponente;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TotemComponenteRowMapper implements RowMapper<TotemComponente> {
    public TotemComponenteRowMapper() {
    }

    public TotemComponente mapRow(ResultSet resultSet, int i) throws SQLException {
        TotemComponente totemComponente = new TotemComponente();
        totemComponente.setFkComponente(resultSet.getInt("fkComponente"));
        totemComponente.setFkTotem(resultSet.getInt("fkTotem"));
        totemComponente.setValor(resultSet.getInt("valor"));
        totemComponente.setAlerta(resultSet.getInt("alerta"));
        totemComponente.setCritico(resultSet.getInt("critico"));
        return totemComponente;
    }
}
