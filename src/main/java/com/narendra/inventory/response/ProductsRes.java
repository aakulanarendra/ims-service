package com.narendra.inventory.response;

import lombok.Data;

import java.util.List;

@Data
public class ProductsRes {
    List<ProductDetail> productDetailList;
}
