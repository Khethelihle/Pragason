package com.awsprojrct.pragason.constants;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import org.apache.logging.log4j.Logger;

public class Constants {

    public static AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    public static final DynamoDB dynamoDB = new DynamoDB(client);

    //    DynamoDB dynamoDB = new DynamoDB(client);
    public static String QuestionTBL = "Questions";
    public  static String TestTBL = "test";
    public static String UserTBL = "Users";
    public static String CatagoryTBL = "Catagory";
    public static String LoggerBLT = "Logger";
    public static int LoggerTimeOut = 30000;
    public static boolean IsValidate;



}
