package org.example.rpl.dto.team;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SimpleTeamResponseDTO {
    private Integer id;
    private String name;
    private String city;
    private String rating;
}