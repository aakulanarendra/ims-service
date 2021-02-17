package com.narendra.inventory.repo;

import com.narendra.inventory.collection.Sku;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuRepository extends MongoRepository<Sku,String> {
}
