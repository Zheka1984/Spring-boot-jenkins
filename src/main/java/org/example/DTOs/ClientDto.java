package org.example.DTOs;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Value;

/**
 * DTO for {@link org.example.Models.Client}
 */
@Data
public class ClientDto {
    String name;
    String companyName;
}