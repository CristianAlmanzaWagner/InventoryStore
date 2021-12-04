package com.almanza.inventory.controller.player.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlayerToUpdateDTO {
    private Integer id;
    private String name;
    private Integer number;
}
