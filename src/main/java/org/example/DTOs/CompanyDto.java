package org.example.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import java.util.List;
import java.util.Set;

/**
 * DTO for {@link org.example.Models.Company}
 */
public class CompanyDto {
    String companyName;
    List<ClientDto> list;

    public CompanyDto() {
    }

    public CompanyDto(String companyName, List<ClientDto> list) {
        this.companyName = companyName;
        this.list = list;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<ClientDto> getList() {
        return list;
    }

    public void setList(List<ClientDto> list) {
        this.list = list;
    }
}