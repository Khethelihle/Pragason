package com.awsprojrct.pragason.constants;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;

public class Constants {

    public static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
//    DynamoDB dynamoDB = new DynamoDB(client);
    public static String QuestionTBL = "Questions";
    public static String UserTBL = "Users";
    public static String CatagoryTBL = "Catagory";
    public static String LoggerBLT = "Logger";


}
