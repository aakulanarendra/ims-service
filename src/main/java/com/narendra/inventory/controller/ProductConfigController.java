package com.narendra.inventory.controller;

import com.narendra.inventory.collection.Customer;
import com.narendra.inventory.repo.CustomRepo;
import com.narendra.inventory.repo.CustomerRepository;
import com.narendra.inventory.repo.OrderRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
public class ProductConfigController {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final CustomRepo customRepo;

    @Autowired
    public ProductConfigController(CustomerRepository customerRepository, OrderRepository orderRepository, CustomRepo customRepo) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.customRepo = customRepo;
    }


    @GetMapping("/subcategory")
    @ApiOperation(value = "Get Customers")
    public @ResponseBody
    ResponseEntity<?> listCustomerNames() {
        List<Customer> customerList = customerRepository.getCustomersBy();
        return ResponseEntity.ok(customerList);
    }

}
