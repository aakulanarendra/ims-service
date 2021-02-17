package com.narendra.inventory.repo;

import com.narendra.inventory.collection.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin
public interface OrderRepository extends MongoRepository<Order,String> {
    List<Order> findOrdersByCustomerCustomerId(String customerID);
    Order findOrderCustomerByOrderId(String orderId);
}
