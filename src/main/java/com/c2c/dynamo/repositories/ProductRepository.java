package com.c2c.dynamo.repositories;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.c2c.dynamo.model.Products;

@Repository
@EnableScan
public interface ProductRepository extends CrudRepository<Products, Integer> {
}
