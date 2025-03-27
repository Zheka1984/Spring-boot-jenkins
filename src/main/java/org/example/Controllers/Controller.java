package org.example.Controllers;

import org.example.DTOs.ClientDto;
import org.example.DTOs.CompanyDto;
import org.example.Models.Client;
import org.example.Models.Company;
import org.example.Service.ClientService;
import org.example.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    CompanyService companyService;
    @Autowired
    ClientService clientService;

    @GetMapping("client/{id}")
    public ClientDto getClient(@PathVariable long id) {
        return clientService.getClientById(id);
    }

    @GetMapping("company/{id}")
    public CompanyDto getCompany(@PathVariable long id) {
        return companyService.getCompanyById(id);
    }
}

