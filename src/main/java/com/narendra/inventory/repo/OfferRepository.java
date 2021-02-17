package com.narendra.inventory.repo;

import com.narendra.inventory.collection.Offer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends MongoRepository<Offer,String> {
}
