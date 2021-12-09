package com.almanza.inventory.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductTypeEnum {
    @JsonProperty("Shirt")
    SHIRT("Shirt"),
    @JsonProperty("Shoes")
    SHOES("Shoes"),
    @JsonProperty("Pants")
    PANTS("Pants"),
    @JsonProperty("Gloves")
    GLOVES("Gloves"),
    @JsonProperty("Underpants")
    UNDERPANTS("Underpants"),
    @JsonProperty("Jacket")
    JACKET("Jacket");

    public final String value;
}
