package org.example.rpl.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlayerBasicDTO {
    private int id;
    private String name;
    private String position;
    private int rating;
}