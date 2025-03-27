package org.example.Repositories;

import org.example.Models.Client;
import org.example.Models.Company;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository<Company, Long> {
    Company getCompanyById(Long id);
}
