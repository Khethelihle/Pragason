package com.awsprojrct.pragason.Models;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.awsprojrct.pragason.DDB.Schemas;
import com.awsprojrct.pragason.DDB.TableValidator;
import com.awsprojrct.pragason.constants.Constants;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.util.*;

import static com.awsprojrct.pragason.DDB.CRUD.RetrieveItems;
import static com.awsprojrct.pragason.constants.Constants.dynamoDB;

@Repository
public class QuestionRepository {



    public QuestionRepository () {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    }

    private static List<Question> questions = new ArrayList<>();


    static Object findById(String id) {

         return TableValidator.retrieveItem(Constants.QuestionTBL,"MockID", "Attempt01", "QuestionID", id);

//         String tableName, String PrimaryKeyName, Object PrimaryKeyValue, Integer SortKeyName, Object SortKeyValue
    };

    void create(Question question) {
        questions.add(question);
    }

//    void update(Question question, Integer id){
//        Optional<Question> existingRun = findById(id);
//        if (existingRun.isPresent()) {
//            questions.set(questions.indexOf(existingRun.get()), question);
//        }
//    }

    void delete(Integer id) {
        questions.removeIf(question -> question.QuestionID().equals(id));
    }

    public static Object findAll(String tableName) {

        return Schemas.RetrieveItems(tableName, "MockID", "Attempt01", "QuestionID", 2);

    }

//    @PostConstruct
//    private void init(){
//        questions.add(new Question(1,
//                "Customer got the following error when trying to create Indexes — INVALID_PARTITION_TYPE_DATA_ERROR",
//                "Attempt01",
//                "Data Catalog",
//                "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type.",
//                "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type,Observed When the PartitionKey is encrypted,Observed when the partition key in S3 has been deleted and a table is not updated by the crawler,Observed when the console role does not have CreatePartitionIndex permissions"
//        ));
//
//        questions.add(new Question(2,
//                "A customer came to you and mentioned they are getting an error when running their streaming job after update the catalog table schema manually which was created from schema registry. What is the cause for this issue ?",
//                "Attempt01",
//                "Attempt01",
//                "Customer job is failing due to new schema referenced in the Schema Registry may be incompatible",
//                "The customers job should point to GSR instead of catalog table for streaming jobs,Customer job is failing due to new schema referenced in the Schema Registry may be incompatible,Catalog table cannot be created using schema registry, the job would never succeeded even if the schema was never updated,The Catalog table version changed because of the update and both schema registry and catalog table should be in the same versions"
//        ));
//    }

}
