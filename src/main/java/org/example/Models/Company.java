package org.example.Models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    private String companyName;

    @OneToMany(mappedBy = "companyName", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Client> list = new ArrayList<>();
}
