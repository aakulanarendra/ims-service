package com.narendra.inventory.controller;

import com.narendra.inventory.collection.Customer;
import com.narendra.inventory.dto.AuthRes;
import com.narendra.inventory.repo.CustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/customer")
public class LoginController {

    @Autowired
    private CustomRepo customRepo;

    @PostMapping("login")
    public AuthRes authRes(@RequestBody Customer customer) {
        return customRepo.authUser(customer);
    }
}
