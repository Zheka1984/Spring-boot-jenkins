package org.example.Repositories;

import org.example.Models.Client;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    Client getClientById(Long id);
}
