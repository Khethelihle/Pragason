package com.awsprojrct.pragason.Models;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class QuestionController {

//    Question question = new Question(1, "Customer got the following error when trying to create Indexes — INVALID_PARTITION_TYPE_DATA_ERROR", "Attempt01","Data Catalog","Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type.", "Observed when the partitionKey value is not a valid value for the corresponding partitionKey data type,Observed When the parttitionKey is encrypted,Observed when the partition key in S3 has been deleted and a table is not updated by the crawler,Observed when the console role does not have CreatePartitionIndex permissions");

    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("/api/questions")
    List<Question> findAll() {
        return  questionRepository.findAll();
    }

    }



