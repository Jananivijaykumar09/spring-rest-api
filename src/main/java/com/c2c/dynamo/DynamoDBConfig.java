package com.c2c.dynamo;

import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class DynamoDBConfig {

    @Autowired
    private Environment environment;

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        if(environment.getActiveProfiles()[0].equals("local")){
            return AmazonDynamoDBClientBuilder.standard()
                    .withCredentials(amazonAWSCredentialsProvider())
                    .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration("http://localhost:4567", "ap-south-1"))
                    .build();
        }
        else if (environment.getActiveProfiles()[0].equals("dev"))
            return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(amazonAWSCredentialsProvider())
                .withRegion(Regions.AP_SOUTH_1)
                .build();
        else
            return AmazonDynamoDBClientBuilder.standard()
                .withCredentials(amazonAWSCredentialsProvider())
                .withRegion(Regions.AP_SOUTH_1)
                .build();
    }

    /*@Bean
    public AWSCredentials amazonAWSCredentials() {
        // Or use an AWSCredentialsProvider/AWSCredentialsProviderChain
        return new BasicAWSCredentials(amazonAWSAccessKey, amazonAWSSecretKey);
    }*/

    public AWSCredentialsProvider amazonAWSCredentialsProvider() {
        return new DefaultAWSCredentialsProviderChain();
    }

}
