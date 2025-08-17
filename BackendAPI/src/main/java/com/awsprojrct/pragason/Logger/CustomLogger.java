package com.awsprojrct.pragason.Logger;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.text.SimpleDateFormat;
import java.util.Date;
import static com.awsprojrct.pragason.DDB.TableValidator.CheckIfExist;
import static com.awsprojrct.pragason.constants.Constants.client;

public class CustomLogger {
    DynamoDB dynamoDB = new DynamoDB(client);

    public static final Logger log = LogManager.getLogger(CustomLogger.class);

    private static final Logger logger = LogManager.getLogger("Initiating Application Logger Class : log4j");
//    https://logging.apache.org/log4j/2.x/manual/eventlogging.html
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
