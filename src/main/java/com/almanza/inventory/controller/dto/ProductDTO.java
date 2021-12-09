package com.almanza.inventory.controller.dto;

import com.almanza.inventory.enums.ProductTypeEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("productType")
    private ProductTypeEnum productType;
    @JsonProperty("color")
    private String color;
    @JsonProperty("creationDate")
    private LocalDateTime creationDate;
}
