package com.narendra.inventory.repo;

import com.narendra.inventory.collection.Pages;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagesRepository extends MongoRepository<Pages,String> {
}
