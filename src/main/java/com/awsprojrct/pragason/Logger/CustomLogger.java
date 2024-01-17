package com.awsprojrct.pragason.Logger;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.apache.logging.log4j.Logger;
import static com.awsprojrct.pragason.DDB.TableValidator.CheckIfExist;
import static com.awsprojrct.pragason.constants.Constants.client;

public class CustomLogger {
    DynamoDB dynamoDB = new DynamoDB(client);
    public static void SendToDDB (Logger logger, String message, String tableName) {

        CheckIfExist(tableName);
    }

}
