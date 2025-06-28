package org.example.rpl.dto;

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
public class PlayerStatusDTO {
    @NotNull(message = "Status cannot be null")
    private PlayerStatus status;
}