package org.example.totemcomponente;

import org.example.totem.Totem;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TotemComponenteRowMapper implements RowMapper<TotemComponente> {
    public TotemComponenteRowMapper() {
    }

    public TotemComponente mapRow(ResultSet resultSet, int i) throws SQLException {
        TotemComponente totemComponente = new TotemComponente();
        totemComponente.setNome(resultSet.getString("nome"));
        totemComponente.setFkTotem(resultSet.getInt("fkTotem"));
        totemComponente.setValor(resultSet.getInt("valor"));
        return totemComponente;
    }
}
