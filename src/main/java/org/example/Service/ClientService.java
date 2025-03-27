package org.example.Service;

import org.example.DTOs.ClientDto;
import org.example.Models.Client;
import org.example.Repositories.ClientRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    private ClientRepository clientRepo;

    ModelMapper map = new ModelMapper();

    @Autowired
    ClientService(ClientRepository repo){
        this.clientRepo = repo;
    }

    public ClientDto getClientById(Long id){
        TypeMap<Client, ClientDto> mapping = map.createTypeMap(Client.class, ClientDto.class);
        mapping.addMappings(mapping1 -> mapping1.map(src -> src.getCompanyName(), ClientDto::setCompanyName));
        mapping.addMappings(mapping1 -> mapping1.map(src -> src.getName(), ClientDto::setName));
       return map.map(clientRepo.getClientById(id), ClientDto.class);
    }

}
