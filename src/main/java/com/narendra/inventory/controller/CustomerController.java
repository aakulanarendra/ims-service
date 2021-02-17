package com.narendra.inventory.controller;

import com.narendra.inventory.collection.Customer;
import com.narendra.inventory.repo.*;
import com.narendra.inventory.response.CustomerRes;
import com.narendra.inventory.response.OrderRes;
import com.narendra.inventory.repo.CustomRepo;
import com.narendra.inventory.repo.CustomerRepository;
import com.narendra.inventory.repo.OrderRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.*;

@RestController
@RequestMapping("api")
public class CustomerController {

    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private final CustomRepo customRepo;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, OrderRepository orderRepository, CustomRepo customRepo) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.customRepo = customRepo;
    }

    @PostMapping("/customer/{customerId}")
    @ApiOperation(value = "Customer Update")
    public @ResponseBody
    ResponseEntity<?> updateOrderStatus(@PathVariable("orderId") String orderId,@RequestBody Map<String, String> payload) {
        customRepo.updateOrderStatus(orderId,payload.get("status"));
        return ResponseEntity.ok(orderId);
    }

    @GetMapping("/customernames")
    @ApiOperation(value = "Get Customers")
    public @ResponseBody
    ResponseEntity<?> listCustomerNames() {
        List<Customer> customerList = customerRepository.getCustomersBy();
        return ResponseEntity.ok(customerList);
    }

    @GetMapping("/customerlist")
    @ApiOperation(value = "Get Customers")
    public @ResponseBody
    ResponseEntity<?> listCustomers() {
        List<Customer> customerList = customerRepository.findAll();
        List<CustomerRes> customerResList = new ArrayList<>();
        customerList.forEach(customer -> {
            CustomerRes customerRes = new CustomerRes();
            customerRes.setCustomerId(customer.getCustomerId());
            customerRes.setCustomerName(customer.getFirstName()+customer.getLastName());
            customerRes.setPhone(customer.getPhone());
            customerRes.setRating(customer.getRating());
            customerRes.setRole(customer.getRoles());
            List<OrderRes> orderResList = new ArrayList<>();
            orderRepository.findOrdersByCustomerCustomerId(customer.getCustomerId()).forEach(order -> {
                OrderRes orderRes = new OrderRes();
                orderRes.setOrderId(order.getOrderId());
                orderRes.setOrderDate(order.getCreated());
                orderRes.setOrderStatus(order.getStatus());
                double total = order.getProducts()
                        .stream()
                        .map(productInfo -> Double.valueOf(productInfo.getPrice())*productInfo.getQuantity())
                        .mapToDouble(Double::valueOf).sum();
                orderRes.setOrderTotal(BigDecimal.valueOf(total));
                orderResList.add(orderRes);
            });

            customerRes.setOrders(orderResList);
            customerResList.add(customerRes);

        });

        return ResponseEntity.ok(customerResList);
    }
}
