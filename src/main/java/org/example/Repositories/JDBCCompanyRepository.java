package org.example.Repositories;

import lombok.AllArgsConstructor;
import org.example.DAO.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Repository
public class JDBCCompanyRepository implements RepoInterface<Company>{

    private final NamedParameterJdbcTemplate jdbc;

    @Autowired
    CompanyMapper mapper;

    @Override
    public Company getById(long id) {
        Map<String, Object> params = new HashMap<>();
        params.put("id", id);
        return jdbc.query("select cl.id, name, company_name from clients cl join companies co on cl.company_id = co.id where company_id = :id",
                params, mapper);
    }
}
