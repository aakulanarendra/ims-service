package com.narendra.inventory.dto;

import lombok.Data;

@Data
public class PriceUpdate {
    private String priceId;
    private PriceActivity priceActivity;
}
