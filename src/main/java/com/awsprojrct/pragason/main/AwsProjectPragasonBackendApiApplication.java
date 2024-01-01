package com.awsprojrct.pragason.main;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.awsprojrct.pragason.DDB.TableCreator;
import com.awsprojrct.pragason.auth.CredentialsHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

@SpringBootApplication
public class AwsProjectPragasonBackendApiApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(AwsProjectPragasonBackendApiApplication.class, args);

        String access_key = CredentialsHelper.getAccessKey();
        String secrete_key = CredentialsHelper.getSecretKey();

        AmazonDynamoDB client = DynamoDBFactory.getClient();
        DynamoDbClient dynamoDbClient = DynamoDBFactory.getDynamoDbClient();
        TableCreator.createTable(client, dynamoDbClient);


    }

}
