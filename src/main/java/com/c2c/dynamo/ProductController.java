package com.c2c.dynamo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.c2c.dynamo.model.Products;
import com.c2c.dynamo.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private DynamoDBConfig dynamoDBConfig;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;

    @PostMapping
    public ResponseEntity<?> saveProduct(@RequestBody Products products) {
        try {
            productRepository.save(products);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getProducts() {
        try {
            return new ResponseEntity<>(productRepository.findAll(), HttpStatus.OK);
        } catch(Exception e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            return new ResponseEntity<>("Failure", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
