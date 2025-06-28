package org.example.rpl.dto.team;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamRequestDTO {
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "City cannot be null")
    private String city;

    @NotNull(message = "Rating cannot be null")
    private String rating;
}