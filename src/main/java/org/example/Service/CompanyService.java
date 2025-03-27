package org.example.Service;

import org.example.DTOs.ClientDto;
import org.example.DTOs.CompanyDto;
import org.example.Models.Client;
import org.example.Models.Company;
import org.example.Repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyService {

    private CompanyRepository repo;

    ModelMapper map = new ModelMapper();

    CompanyService(CompanyRepository repo){
        this.repo = repo;
    }

    public CompanyDto getCompanyById(Long id){
        Company cmp = repo.getCompanyById(id);
        List<ClientDto> listDto = new ArrayList<>();
        List<Client> list = cmp.getList();
        cmp.getList().forEach(t -> System.out.println(t.getCompanyName() +" " +t.getName()));
       listDto = list.stream().map(t -> {
            ClientDto dto = new ClientDto();
            dto.setCompanyName(cmp.getCompanyName());
            dto.setName(t.getName());
            return  dto;
        })
                .toList();
        return new CompanyDto(cmp.getCompanyName(), listDto);
    }
}
