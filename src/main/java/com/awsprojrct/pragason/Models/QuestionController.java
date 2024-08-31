package com.awsprojrct.pragason.Models;

import com.amazonaws.services.dynamodbv2.document.Item;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.awsprojrct.pragason.constants.Constants.QuestionTBL;

@CrossOrigin
@RestController
//@RequestMapping(path="/JSON", produces="application/json")
@RequestMapping("/api/questions")

public class QuestionController {

    private static final Logger log = LoggerFactory.getLogger(QuestionController.class);
    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("")
    Object findAll() {
        return QuestionRepository.findAll(QuestionTBL);
    }

//    Get method
    @GetMapping("/{id}")
    Object findById(@PathVariable String id){

        return QuestionRepository.findById(id);
    }

//    POST method
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(" ")
     void create (@Valid @RequestBody Question questionItem){
        questionRepository.create(questionItem);
    }
//
////      UPDATE method
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/{id}")
//    void update(@Valid @RequestBody Question question, @PathVariable Integer id) {
//        questionRepository.update(question, id);
//    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete (@PathVariable String id) {
        questionRepository.delete((id));
    }
}



