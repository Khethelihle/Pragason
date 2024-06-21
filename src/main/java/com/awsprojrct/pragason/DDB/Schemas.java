package com.awsprojrct.pragason.DDB;


import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.DeleteItemSpec;
import com.amazonaws.services.dynamodbv2.model.*;
import com.awsprojrct.pragason.Logger.CustomLogger;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;

import java.util.*;

import static com.awsprojrct.pragason.Logger.CustomLogger.log;
import static com.awsprojrct.pragason.constants.Constants.client;

public class Schemas {

    static final DynamoDB dynamoDB = new DynamoDB(client);

    public static void LoggerSchema(String tableName, String message) throws InterruptedException {

        try {

            Table table = dynamoDB.getTable(tableName);

            Item item = new Item()
                    .withPrimaryKey("Date", CustomLogger.LogDate())
                    .withString("Message", message);

            PutItemOutcome outcome = table.putItem(item);

            //outcome.wait(LoggerTimeOut);
            log.info("Done writing Records to DDB table: {}", tableName);

        } catch (DynamoDbException e) {
            log.error(e.getMessage());
        }

    }

    public static void QuestionsSave(String tableName, String hashKeyValue, String rangeKeyValue, String Domain,String Question, String Options, String Answer) {
        try {

            Table table = dynamoDB.getTable(tableName);

            ArrayList<String> OptionsList = getStrings(Options);

            Item item = new Item()
                    .withString("MockID", hashKeyValue)
                    .withString("QuestionID", rangeKeyValue)
                    .withString("DomainID", Domain)
                    .withString("QuestionText", Question)
                    .withList("QuestionsOptions", OptionsList)
                    .withString("CorrectAnswer", Answer);

            log.info("Writing Records to DDB table: {}", tableName);
            log.info(item.toJSONPretty());

            PutItemOutcome outcome = table.putItem(item);

        } catch (DynamoDbException e) {
            log.warn("Error in Questions Schema method: ");
            log.error(e.getMessage());
        }
    }

    public static ArrayList<String> getStrings(String Options) {
        List<String> optionslist = Arrays.asList(Options.split(","));
        String optionOne = optionslist.get(0);
        String optionTwo = optionslist.get(1);
        String optionThree = optionslist.get(2);
        String optionFour = optionslist.get(3);

        ArrayList<String> OptionsList = new ArrayList<String>();
        OptionsList.add(optionOne);
        OptionsList.add(optionTwo);
        OptionsList.add(optionThree);
        OptionsList.add(optionFour);
        return OptionsList;
    }

//    Will enhance this method on version 2.0


    public static String RetrieveItems(String tableName) {

        Map<String, AttributeValue> lastKeyEvaluated = null;
        Map<String, AttributeValue> Resultitem = new HashMap<>();
        do {
            ScanRequest scanRequest = new ScanRequest()
                    .withTableName(tableName)
                    .withLimit(10)
                    .withExclusiveStartKey(lastKeyEvaluated);

            ScanResult result = client.scan(scanRequest);

            for (Map<String, AttributeValue> DDBItems : result.getItems()){

                assert false;
                Resultitem = DDBItems;
                log.info(Resultitem);
            }
            lastKeyEvaluated = result.getLastEvaluatedKey();
        } while (lastKeyEvaluated != null);

        return Resultitem.toString();

    }

    public static void DeleteItem (String tableName, String hashKeyValue, String rangeKeyValue) {

        Table table = dynamoDB.getTable(tableName);
        try {
            DeleteItemSpec deleteItemSpec = new DeleteItemSpec()
                    .withPrimaryKey(new PrimaryKey("MockID", hashKeyValue, "QuestionID", rangeKeyValue));

            log.info("Attempting a conditional delete...");
            table.deleteItem(deleteItemSpec);

        }catch (DynamoDbException e) {
            log.warn("Error in Deleting Item");
            log.error(e.getMessage());
        }
    }
}

