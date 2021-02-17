package com.narendra.inventory.repo;

import com.narendra.inventory.collection.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends MongoRepository<Category,String> {

    @Query(fields = "{ 'categoryCode': 1, 'categoryName':1}")
    List<Category> getCategoriesBy();
    @Query(fields = "{ 'tax': 1}")
    Category getCategoryByCategoryCode(String categoryCode);
}
