package com.narendra.inventory.controller;

import com.narendra.inventory.collection.Product;
import com.narendra.inventory.collection.product.BasicInfo;
import com.narendra.inventory.dto.Inventory;
import com.narendra.inventory.dto.PriceUpdate;
import com.narendra.inventory.service.ProductService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ApiOperation(value = "Save Product")
    public @ResponseBody
    ResponseEntity<?> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));
    }

    @PostMapping("update")
    @ApiOperation(value = "Update Product")
    public @ResponseBody
    ResponseEntity<?> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @DeleteMapping("{id}")
    @ApiOperation(value = "Delete Product")
    public @ResponseBody
    ResponseEntity<?> deleteProduct(@PathVariable("id") String id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("deleted");
    }

    @GetMapping("/list")
    @ApiOperation(value = "Get Products")
    public @ResponseBody
    ResponseEntity<?> listproducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get Product by id")
    public @ResponseBody
    ResponseEntity<?> listOrders(@PathVariable("id") String id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("edit/{id}")
    @ApiOperation(value = "Get Edit Product Info by id")
    public @ResponseBody
    ResponseEntity<?> getProductInfo(@PathVariable("id") String id) {
        return ResponseEntity.ok(productService.getProductInfo(id));
    }

    @GetMapping("/inventory")
    @ApiOperation(value = "Inventory List")
    public @ResponseBody
    ResponseEntity<?> listInventory() {
        return ResponseEntity.ok(productService.inventory());
    }

    @GetMapping("/search/{searchTerm}")
    @ApiOperation(value = "Product List")
    public @ResponseBody
    ResponseEntity<?> listProducts(@PathVariable("searchTerm") String searchTerm) {
        return ResponseEntity.ok(productService.searchProducts(searchTerm));
    }


    @PostMapping("/price")
    @ApiOperation(value = "Price Update")
    public @ResponseBody
    ResponseEntity<?> updatePrices(@RequestBody PriceUpdate priceUpdate) {
        productService.updatePriceActivity(priceUpdate);
        return ResponseEntity.ok(priceUpdate);
    }

    @PostMapping("/tax")
    @ApiOperation(value = "Tax Update")
    public @ResponseBody
    ResponseEntity<?> updateTax(@RequestBody BasicInfo basicInfo) {
        productService.updateTax(basicInfo);
        return ResponseEntity.ok(basicInfo);
    }

    @PostMapping("/inventory")
    @ApiOperation(value = "Tax Update")
    public @ResponseBody
    ResponseEntity<?> updateTax(@RequestBody Inventory inventory) {
        productService.updateInventory(inventory);
        return ResponseEntity.ok(inventory);
    }
}
