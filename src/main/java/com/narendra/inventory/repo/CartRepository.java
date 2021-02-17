package com.narendra.inventory.repo;

import com.narendra.inventory.collection.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends MongoRepository<Cart,String> {

}
