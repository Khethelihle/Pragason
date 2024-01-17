package com.awsprojrct.pragason.DDB;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.awsprojrct.pragason.constants.Constants;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.util.Objects;

import static com.awsprojrct.pragason.constants.Constants.client;

public class TableValidator {
    static DynamoDB dynamoDB = new DynamoDB(client);
    public static void CheckIfExist(String tableName) {

        Table table = dynamoDB.getTable(Constants.QuestionTBL);

        try {

            if (Objects.equals(tableName, table.getTableName())) {
                System.out.println("Table " + tableName + " Found");
            } else {
                table.getTableName();
                System.out.println("Table " + tableName + " Not Found");
                createTable(client, tableName);
                System.exit(1);  // The application should not exit here, it should create a table specified.
            }

        } catch (Exception e) {
            System.err.println("Retrieving table " + tableName + "failed");
            System.err.println(e.getMessage());
        }
    }
    public static void retrieveItem(String tableName) {

        Table table = dynamoDB.getTable(tableName);
        CheckIfExist(tableName);

        try {

            Item item = table.getItem("Mock_ID", "GlueETL", "GlueETL01", "GlueETL01", "Mock_ID, GlueETL01, Question, Options, Answer", null);

            System.out.println("Printing item after retrieving it....");
            System.out.println(item.toJSONPretty());

        }
        catch (Exception e) {
            System.err.println("GetItem failed.");
            System.err.println(e.getMessage());
        }

    }
    public static void createTable (AmazonDynamoDB client, String tableName) {

    }

}
