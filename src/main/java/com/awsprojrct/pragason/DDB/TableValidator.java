package com.awsprojrct.pragason.DDB;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.awsprojrct.pragason.constants.Constants;
import static com.awsprojrct.pragason.Logger.CustomLogger.log;

import java.util.Objects;

import static com.awsprojrct.pragason.Logger.CustomLogger.log;
import static com.awsprojrct.pragason.constants.Constants.IsValidate;
import static com.awsprojrct.pragason.constants.Constants.client;

public class TableValidator {
    static DynamoDB dynamoDB = new DynamoDB(client);
    public boolean DDBTableExist = false;

    public static void CheckIfExist(String tableName) {
        Table table = dynamoDB.getTable(Constants.UserTBL);
//       // Need to fix the table DynamoDB check Validator.
        try {
            if (Objects.equals(tableName, table.getTableName())) {
                log.info("Table {} Found", tableName);
            } else {
                table.getTableName();
                log.error("Table {} Not Found", tableName);
                //TableCreator.createTable(client,tableName,"Date",null, 5, 5);
                TableCreator.createTable(client,tableName,"MockID","DomainID", 5, 5);
                IsValidate = true;
            }
        } catch (Exception e) {
            System.err.println();
            log.error("Retrieving table {} failed", tableName);
            log.error(e.getMessage());
        }
//        DDBTableExist = true;
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
}
