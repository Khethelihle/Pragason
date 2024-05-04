package com.awsprojrct.pragason.Models;

import com.awsprojrct.pragason.errors.QuestionNotFoundException;
import jakarta.validation.Valid;
import org.apache.http.protocol.HTTP;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/questions")

public class QuestionController {

    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping("")
    List<Question> findAll() {
        return  questionRepository.findAll();
    }

//    Get method

    @GetMapping("/{id}")
    Question findById(@PathVariable Integer id){

        Optional <Question> question = QuestionRepository.findById(id);

        if(question.isEmpty()) {
            throw new QuestionNotFoundException();
        }
        return question.get();
    }

//    POST method
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create (@Valid @RequestBody Question question){
        questionRepository.create(question);
    }

//      UPDATE method
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Question question, @PathVariable Integer id) {
        questionRepository.update(question, id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete (@PathVariable Integer id) {
        questionRepository.delete((id));
    }


}



