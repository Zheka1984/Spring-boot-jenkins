package org.example.Repositories;

import lombok.AllArgsConstructor;
import org.example.DAO.Client;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@Repository
public class JDBCClientRepository implements RepoInterface<Client> {

    private final NamedParameterJdbcTemplate jdbc;

    @Override
    public Client getById(long id){
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        //return jdbc.query("select * from clients join companies using (id) where id=:id", params, );
        return null;
    }
}
