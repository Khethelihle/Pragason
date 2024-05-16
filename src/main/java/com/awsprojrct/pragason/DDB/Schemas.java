package com.awsprojrct.pragason.DDB;


import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.awsprojrct.pragason.Logger.CustomLogger;
import software.amazon.awssdk.services.dynamodb.model.DynamoDbException;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;


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

    public static void QuestionsSchema(String tableName, String hashKeyValue, String rangeKeyValue, String Question, String Options, String Answer) {
        try {

            Table table = dynamoDB.getTable(tableName);

            ArrayList<String> OptionsList = getStrings(Options);

            Item item = new Item()
                    .withString("MockID", hashKeyValue)
                    .withString("QuestionID", rangeKeyValue)
                    .withString("Question", Question)
                    .withList("Options", OptionsList)
                    .withString("Answer", Answer);

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


    public static Object RetrieveItems(String tableName, String PrimaryKeyName, Object PrimaryKeyValue, String SortKeyName, Object SortKeyValue) {

        ScanRequest scanRequest = new ScanRequest()
                .withTableName(tableName);

        ScanResult result = client.scan(scanRequest);

        return new ArrayList<>(result.getItems());

    }


}

