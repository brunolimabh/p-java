package org.example.dao;

import org.example.model.Totem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TotemRowMapper implements RowMapper<Totem> {
    public TotemRowMapper() {
    }

    public Totem mapRow(ResultSet resultSet, int i) throws SQLException {
        Totem totem = new Totem();
        totem.setIdTotem(resultSet.getInt("idTotem"));
        totem.setNome(resultSet.getString("nome"));
        totem.setFkAeroporto(resultSet.getInt("fkAeroporto"));
        totem.setFkEmpresa(resultSet.getInt("fkEmpresa"));
        return totem;
    }
}
