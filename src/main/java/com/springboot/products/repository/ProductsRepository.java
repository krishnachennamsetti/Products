package com.springboot.products.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.products.entity.Products;

@Repository
public interface ProductsRepository extends MongoRepository<Products, String>{

}
