package com.narendra.inventory.collection;

import com.narendra.inventory.dto.Colour;
import com.narendra.inventory.dto.Size;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.List;

@Data
@Document("attributes")
//TODO: Optimise
public class Attributes {
    @Id
    private String attributeId;
    private List<String> categories;
    private List<String> departments;
    private List<String> bins;
    private List<String> uom;
    private List<String> location;
    private List<Colour> colours;
    private List<Size> sizes;
    private List<String> packagingMaterial;
    private BigDecimal tax;
}
