package org.example.rpl.dto.player;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.rpl.entity.Player.PlayerStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerRequestDTO {
    @NotNull(message = "Name cannot be null")
    private String name;

    @NotNull(message = "Rating cannot be null")
    private int rating;

    @NotNull(message = "Position cannot be null")
    private String position;

    @NotNull(message = "Age cannot be null")
    private int age;

    @NotNull(message = "Status cannot be null")
    private PlayerStatus status;

    private Integer teamId;
}