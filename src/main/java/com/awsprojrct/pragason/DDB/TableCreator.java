package com.awsprojrct.pragason.DDB;

import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
public class TableCreator {

//    public static void main(String[] args) {
//        AmazonDynamoDB client = DynamoDBFactory.getClient();
//        DynamoDbClient dynamoDbClient = DynamoDBFactory.getDynamoDbClient();
//        TableCreator.createTable(client, dynamoDbClient);
//    }

//    Tables to create :-
//    1) Questions tables with Question IDs
//    2) Catagory tables with Catagory IDs, e.g. Components of the service. this will help speed up the lookup on DynamoDB
//    3) Services that will be part of the project.

    public static void createTable(AmazonDynamoDB client, DynamoDbClient dynamoDbClient) {
        TableCreator.createTable(client, dynamoDbClient, "ProductCatalog", 10L, 5L);
        TableCreator.createTable(client, dynamoDbClient, "Forum", 10L, 5L);
        TableCreator.createTable(client, dynamoDbClient, "Thread", 10L, 5L);
    }

    public static void createTable(AmazonDynamoDB client, DynamoDbClient dynamoDbClient, String tableName, long readCapacityUnits, long writeCapacityUnits) {
        System.out.println("Creating table " + tableName);
//        TableCreator.createTable();
    }

}

