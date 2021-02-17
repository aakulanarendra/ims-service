package com.narendra.inventory.controller;

import com.narendra.inventory.dto.Dashboard;
import com.narendra.inventory.repo.CustomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dashboard")
public class DashboardController {

    private final CustomRepo customRepo;

    @Autowired
    public DashboardController(CustomRepo customRepo) {
        this.customRepo = customRepo;
    }

    @GetMapping
    public Dashboard getDashboard() {
        return customRepo.getDashboardInfo();
    }

}
