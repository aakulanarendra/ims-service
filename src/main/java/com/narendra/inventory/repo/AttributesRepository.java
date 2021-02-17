package com.narendra.inventory.repo;

import com.narendra.inventory.collection.Attributes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributesRepository extends MongoRepository<Attributes,String> {
}
