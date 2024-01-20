package com.awsprojrct.pragason.Logger;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.awsprojrct.pragason.DDB.TableValidator.CheckIfExist;
import static com.awsprojrct.pragason.constants.Constants.client;

public class CustomLogger {
    DynamoDB dynamoDB = new DynamoDB(client);
    public static void SendToDDB (String tableName, String loggerBLT) {

        CheckIfExist(tableName);

    }

    public static String LogDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd:HH:mm:ss");
        //System.out.println(currentDateTime);
        return dateFormat.format(currentDate);
    }

}
