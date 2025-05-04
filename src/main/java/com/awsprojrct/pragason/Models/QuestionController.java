package com.awsprojrct.pragason.Models;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

//    Get method By Id
    @GetMapping("/{id}")
    Object findById(@PathVariable String id){

        return QuestionRepository.findById(id);
    }

//    POST method
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(value = "/put", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
     void create (@Valid @RequestBody Question questionItem){
        questionRepository.create(questionItem);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete (@PathVariable String id) {
        questionRepository.delete((id));
    }
}



