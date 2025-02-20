package org.example;

import org.example.DAO.Client;
import org.example.DAO.Company;
import org.example.Repositories.JDBCClientRepository;
import org.example.Repositories.JDBCCompanyRepository;
import org.example.Repositories.RepoInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    JDBCClientRepository repoClient;

    @Autowired
    JDBCCompanyRepository repoCompany;

    @GetMapping("client/{id}")
    public Client getClient(@PathVariable long id) {
        return repoClient.getById(id);
    }

    @GetMapping("company/{id}")
    public Company getCompany(@PathVariable long id) {
        return repoCompany.getById(id);
    }
}

