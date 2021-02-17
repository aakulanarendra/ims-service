package com.narendra.inventory.repo;

import com.narendra.inventory.collection.Role;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role,String> {
}
