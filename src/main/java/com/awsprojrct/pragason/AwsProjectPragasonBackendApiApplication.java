package com.awsprojrct.pragason;

import com.awsprojrct.pragason.Models.Question;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static com.awsprojrct.pragason.Logger.CustomLogger.log;

import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class AwsProjectPragasonBackendApiApplication  {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AwsProjectPragasonBackendApiApplication.class, args);

//        try{
//            if (IsValidate) {
//                Schemas.QuestionsSchema(QuestionTBL,"Attempt01", "Data Catalog", "Customer got the following error when trying to create Indexes — INVALID_PARTITION_TYPE_DATA_ERROR", "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type,Observed When the parttitionKey is encrypted,Observed when the partition key in S3 has been deleted and a table is not updated by the crawler,Observed when the console role does not have CreatePartitionIndex permissions", "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type.");
//
//            } else {
//                CheckIfExist(QuestionTBL);
//                Schemas.QuestionsSchema(QuestionTBL,"Attempt01", "Data Catalog", "Customer got the following error when trying to create Indexes — INVALID_PARTITION_TYPE_DATA_ERROR", "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type,Observed When the parttitionKey is encrypted,Observed when the partition key in S3 has been deleted and a table is not updated by the crawler,Observed when the console role does not have CreatePartitionIndex permissions", "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type.");
//            }
//        }
//        catch(AmazonDynamoDBException e){
//            log.error(e.getMessage());
//        }
//
//        log.info("Exiting Application");


    }
    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            Question question = new Question(1, "Customer got the following error when trying to create Indexes — INVALID_PARTITION_TYPE_DATA_ERROR", "Attempt01","Data Catalog","Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type.", "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type,Observed When the parttitionKey is encrypted,Observed when the partition key in S3 has been deleted and a table is not updated by the crawler,Observed when the console role does not have CreatePartitionIndex permissions");
            log.info(question);
        };
    }
}