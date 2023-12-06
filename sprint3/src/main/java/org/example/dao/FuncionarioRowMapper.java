package org.example.dao;

import org.example.model.Funcionario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FuncionarioRowMapper implements RowMapper<Funcionario> {
    public FuncionarioRowMapper() {
    }

    public Funcionario mapRow(ResultSet resultSet, int i) throws SQLException {
        Funcionario funcionario = new Funcionario();
        funcionario.setIdFuncionario(resultSet.getInt("idFuncionario"));
        funcionario.setEmail(resultSet.getString("email"));
        funcionario.setSenha(resultSet.getString("senha"));
        funcionario.setNome(resultSet.getString("nome"));
        funcionario.setFkEmpresa(resultSet.getInt("fkEmpresa"));
        return funcionario;
    }
}
