package org.example.Repositories;

import org.example.DAO.Client;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper  implements RowMapper<Client> {

    @Override
    public Client mapRow(ResultSet rs, int i) throws SQLException {
        int id = rs.getInt("id");
        String name = rs.getString("name");
        String companyName = rs.getString("company_name");
        return new Client(id, name, companyName);
    }
}
