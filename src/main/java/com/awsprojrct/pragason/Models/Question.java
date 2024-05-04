package com.awsprojrct.pragason.Models;

import jakarta.validation.constraints.NotEmpty;

public record Question(

        Integer QuestionID,
        @NotEmpty
        String QuestionText,
        String MockID,
        String DomainID,
        String CorrectAnswer,
        String QuestionsOptions


) {}
