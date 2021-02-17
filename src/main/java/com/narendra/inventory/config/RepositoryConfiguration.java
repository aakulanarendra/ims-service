package com.narendra.inventory.config;

import com.narendra.inventory.collection.Customer;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class RepositoryConfiguration implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(Customer.class);
        RepositoryRestConfigurer.super.configureRepositoryRestConfiguration(config);
    }
}
