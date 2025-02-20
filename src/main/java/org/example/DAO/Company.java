package org.example.DAO;

import lombok.*;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    public int id;

    public String companyName;

    @MappedCollection(idColumn = "operation_id")
    public Set<Client> set = new HashSet<>();

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", set=" + set +
                '}';
    }
}
