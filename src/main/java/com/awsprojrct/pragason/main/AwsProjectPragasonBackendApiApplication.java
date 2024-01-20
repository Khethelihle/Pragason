package com.awsprojrct.pragason.main;

import com.awsprojrct.pragason.DDB.Schemas;
import com.awsprojrct.pragason.constants.Constants;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import static com.awsprojrct.pragason.Logger.CustomLogger.SendToDDB;
import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;


@SpringBootApplication
public class AwsProjectPragasonBackendApiApplication  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AwsProjectPragasonBackendApiApplication.class, args);

        // TableValidator.retrieveItem(Constants.QuestionTBL);
        //SendToDDB(Constants.QuestionTBL, null);
        Schemas.QuestionsSchema(Constants.QuestionTBL,"Attempt01", "Data Catalog", "Customer got the following error when trying to create Indexes — INVALID_PARTITION_TYPE_DATA_ERROR", "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type,Observed When the parttitionKey is encrypted,Observed when the partition key in S3 has been deleted and a table is not updated by the crawler,Observed when the console role does not have CreatePartitionIndex permissions", "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type.");
        //Schemas.LoggerSchema(Constants.LoggerBLT, "2nd Message to confirm the date");
        //String tableName, String hashKeyValue, String rangeKeyValue, String Question, String Options, String Answer )


        System.out.println("Exiting .........");

    }
}