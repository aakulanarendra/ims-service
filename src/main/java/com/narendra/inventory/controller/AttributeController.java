package com.narendra.inventory.controller;

import com.narendra.inventory.collection.Attributes;
import com.narendra.inventory.dto.Colour;
import com.narendra.inventory.dto.Size;
import com.narendra.inventory.repo.*;
import com.narendra.inventory.repo.AttributesRepository;
import com.narendra.inventory.repo.CustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("api")
public class AttributeController {


    private final CustomRepo customRepo;
    @Autowired
    public AttributesRepository attributeRepository;

    @Autowired
    public AttributeController(CustomRepo customRepo) {
        this.customRepo = customRepo;
    }


    @RequestMapping(method = RequestMethod.GET, value = "/attributes")
    public Attributes skuAttributes() {
        return attributeRepository.findById("1").orElse(new Attributes());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/attributes/colour")
    public Colour skuAttribute(@RequestBody Colour colour) {
        customRepo.addAttribute("colours", colour);
        return colour;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/attributes/size")
    public Size skuAttribute(@RequestBody Size size) {
        customRepo.addAttribute("sizes", size);
        return size;
    }

    @GetMapping("/tax")
    public BigDecimal getTax() {
       return customRepo.getTax();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/tax/update")
    public Attributes updateTax(@RequestBody Attributes attributes) {
        customRepo.updateTax(attributes.getTax());
        return attributes;
    }

}
