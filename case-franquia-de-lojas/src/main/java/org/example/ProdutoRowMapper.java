package org.example;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProdutoRowMapper implements RowMapper<Produto> {

    @Override
    public Produto mapRow(ResultSet resultSet, int i) throws SQLException {
        // Qual coluna que eu quero pegar?
        String tipo = resultSet.getString("tipo");

        if (tipo.equals("ELETRONICO")){
            Eletronico eletronico = new Eletronico();
            eletronico.setId((resultSet.getInt("id")));
            eletronico.setNome((resultSet.getString("nome")));
            eletronico.setPrecoBase((resultSet.getDouble("precoBase")));
            eletronico.setTensao((resultSet.getInt("tensao")));
            eletronico.setPeso((resultSet.getDouble("peso")));
            eletronico.setFabricante((resultSet.getString("fabricante")));
            return eletronico;
        } else {
            Vestuario vestuario = new Vestuario();
            vestuario.setId((resultSet.getInt("id")));
            vestuario.setNome((resultSet.getString("nome")));
            vestuario.setPrecoBase((resultSet.getDouble("precoBase")));
            vestuario.setTamanho((resultSet.getString("tamanho")));
            vestuario.setCor((resultSet.getString("cor")));
            vestuario.setWhiteLabel((resultSet.getBoolean("whiteLabel")));
            return vestuario;
        }
    }
}
