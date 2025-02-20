package org.example.Repositories;

import org.example.DAO.Client;
import org.example.DAO.Company;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

@Component
public class CompanyMapper implements ResultSetExtractor<Company> {


    @Override
    public Company extractData(ResultSet rs) throws SQLException, DataAccessException {
        Company company = new Company();
        String company_name = null;
        Set<Client> set = new HashSet<>();
        while(rs.next()){
            company_name = rs.getString("company_name");
            set.add(new Client(rs.getInt("id"), rs.getString("name"), company_name));
        }
        company.setCompanyName(company_name);
        company.setSet(set);
        return company;
    }
}
