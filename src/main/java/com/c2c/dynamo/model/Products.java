package com.c2c.dynamo.model;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBTable(tableName = "Products")
public class Products {

    @DynamoDBAttribute
    @DynamoDBHashKey
    @DynamoDBTyped(DynamoDBMapperFieldModel.DynamoDBAttributeType.N)
    private Integer id;

    @DynamoDBAttribute
    private String name;

    @DynamoDBAttribute
    private String description;
}
