package com.narendra.inventory.dto;

import com.narendra.inventory.collection.Sku;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCart extends Sku {
     private Integer cartAdded;
}
