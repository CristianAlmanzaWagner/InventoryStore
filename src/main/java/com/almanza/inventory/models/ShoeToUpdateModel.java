package com.almanza.inventory.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShoeToUpdateModel {
    private Integer id;
    private String name;
    private String brand;
}
