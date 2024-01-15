package com.awsprojrct.pragason.DDB;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.awsprojrct.pragason.constants.Constants;

public class TableValidator {
    static DynamoDB dynamoDB = new DynamoDB(Constants.clientTableValidator);
    static Table QuestionTable = dynamoDB.getTable(Constants.QuestionTBL);
    static void CheckIfExist() {

        if (QuestionTable == null) {
            System.out.println("Table Not found");
        }

    }




}
