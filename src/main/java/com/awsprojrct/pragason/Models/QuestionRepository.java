package com.awsprojrct.pragason.Models;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.awsprojrct.pragason.DDB.CRUD;
import com.awsprojrct.pragason.DDB.TableValidator;
import com.awsprojrct.pragason.constants.Constants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;

import static com.awsprojrct.pragason.DDB.CRUD.QuestionsSave;

@Repository
public class QuestionRepository {

    private static final Log log = LogFactory.getLog(QuestionRepository.class);

    public QuestionRepository () {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard().build();
    }

    static Object findById(String id) {

       return TableValidator.retrieveItem(Constants.QuestionTBL,"MockID", "Attempt01", "QuestionID", id);

    }

    void create(Question questionItem) {

        QuestionsSave(Constants.QuestionTBL, questionItem.getMockID(), questionItem.getQuestionID(), questionItem.getDomainID(), questionItem.getQuestionText(), questionItem.getQuestionsOptions(), questionItem.getCorrectAnswer());
        log.info("Questions Options");
        log.info(questionItem.getQuestionsOptions());
    }

//    void update(Question question, Integer id) {
//        Optional<Question> existingRun = findById(id);
//        if (existingRun.isPresent()) {
//            questions.set(questions.indexOf(existingRun.get()), question);
//        }
//    }

    void delete(String id) {

        CRUD.DeleteItem(Constants.QuestionTBL, "Attempt01", id);
    }

    public static Object findAll(String tableName) {

        return CRUD.RetrieveItems(tableName);

    }
}
