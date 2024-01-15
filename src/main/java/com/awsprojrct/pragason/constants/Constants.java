package com.awsprojrct.pragason.constants;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;

public class Constants {

    public static AmazonDynamoDB clientTableValidator = AmazonDynamoDBClientBuilder.standard().build();
    public static String QuestionTBL = "Questions";
    public static String UserTBL = "Users";
    public static String CatagoryTBL = "Catagory";
}
