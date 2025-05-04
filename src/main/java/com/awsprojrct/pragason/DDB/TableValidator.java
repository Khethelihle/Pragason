package com.awsprojrct.pragason.DDB;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.awsprojrct.pragason.constants.Constants;

import static com.awsprojrct.pragason.Logger.CustomLogger.log;

import java.util.Map;
import java.util.Objects;

import static com.awsprojrct.pragason.Logger.CustomLogger.log;
import static com.awsprojrct.pragason.constants.Constants.IsValidate;
import static com.awsprojrct.pragason.constants.Constants.client;

public class TableValidator {
    static DynamoDB dynamoDB = new DynamoDB(client);
    public boolean DDBTableExist = false;

    public static void CheckIfExist(String tableName) {
        Table table = dynamoDB.getTable(Constants.QuestionTBL);

        try {
            if (!Objects.equals(tableName, table.getTableName())) {
                log.info("Table {} Found", tableName);
            } else {
                table.getTableName();
                log.error("Table {} Not Found", tableName);
                //TableCreator.createTable(client,tableName,"Date",null, 5, 5);
                TableCreator.createTable(client,tableName,"MockID","QuestionID", 5, 5);
                IsValidate = true;
            }
        } catch (Exception e) {
            System.err.println();
            log.error("Retrieving table {} failed", tableName);
            log.error(e.getMessage());
        }

    }

    public static Object retrieveItem (String tableName, String PrimaryKeyName, Object PrimaryKeyValue, String SortKeyName, Object SortKeyValue)  {

        Table table = dynamoDB.getTable(tableName);

        Item item = table.getItem(PrimaryKeyName, PrimaryKeyValue, SortKeyName, SortKeyValue);
        System.out.println(item);
        System.out.println("#####################");
        return item.toJSON();
    }
}
