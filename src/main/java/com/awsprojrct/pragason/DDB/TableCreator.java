package com.awsprojrct.pragason.DDB;

import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.*;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;

import java.util.ArrayList;
import java.util.List;

import static com.awsprojrct.pragason.DDB.TableValidator.dynamoDB;

public class TableCreator {

//    Tables to create :-
//    1) Questions tables with Question IDs
//    2) Category tables with Category IDs, e.g. Components of the service. this will help speed up the lookup on DynamoDB
//    3) Services that will be part of the project.

    public static void createTable(AmazonDynamoDB client, String tableName, String hashKeyName, String rangeKeyName, long readCapacityUnits, long writeCapacityUnits) throws InterruptedException {

        List<AttributeDefinition> attributeDefinitions = new ArrayList<AttributeDefinition>();
        attributeDefinitions.add(new AttributeDefinition().withAttributeName(hashKeyName).withAttributeType("S"));
        attributeDefinitions.add(new AttributeDefinition().withAttributeName(rangeKeyName).withAttributeType("S"));

        List<KeySchemaElement> keySchema = new ArrayList<KeySchemaElement>();
        keySchema.add(new KeySchemaElement().withAttributeName(hashKeyName).withKeyType(KeyType.HASH));
        keySchema.add(new KeySchemaElement().withAttributeName(rangeKeyName).withKeyType(KeyType.RANGE));

        CreateTableRequest request = new CreateTableRequest()
                .withTableName(tableName)
                .withKeySchema(keySchema)
                .withAttributeDefinitions(attributeDefinitions)
                .withProvisionedThroughput(new ProvisionedThroughput()
                        .withReadCapacityUnits(readCapacityUnits)
                        .withWriteCapacityUnits(writeCapacityUnits));

        Table table = dynamoDB.createTable(request);
        System.out.println("Creating table " + tableName);

        table.waitForActive();

        TableDescription tableDescription =
                dynamoDB.getTable(tableName).describe();

        System.out.printf("%s: %s \t ReadCapacityUnits: %d \t WriteCapacityUnits: %d",
                tableDescription.getTableStatus(),
                tableDescription.getTableName(),
                tableDescription.getProvisionedThroughput().getReadCapacityUnits(),
                tableDescription.getProvisionedThroughput().getWriteCapacityUnits());

    }

}

