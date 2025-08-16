package com.awsprojrct.pragason.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import software.amazon.awssdk.services.dynamodb.streams.endpoints.internal.Value;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Set;

public class Question {

        @JsonProperty("QuestionID")
        private String QuestionID;
        @JsonProperty("MockID")
        private String MockID;
        @JsonProperty("DomainID")
        private String DomainID;
        @JsonProperty("QuestionText")
        private String QuestionText;
        @JsonProperty("CorrectAnswer")
        private String CorrectAnswer;
        @JsonProperty("QuestionsOptions")
        private Set QuestionsOptions;

        public Question() {
        }

        public Question(String questionID, String mockID, String domainID, String questionText, String correctAnswer, Set questionsOptions) {
                this.QuestionID = questionID;
                this.MockID = mockID;
                this.DomainID = domainID;
                this.QuestionText = questionText;
                this.CorrectAnswer = correctAnswer;
                this.QuestionsOptions = questionsOptions;
        }

        public String getQuestionID() {
                return QuestionID;
        }

        public String getQuestionText() {
                return QuestionText;
        }

        public String getMockID() {
                return MockID;
        }

        public String getDomainID() {
                return DomainID;
        }

        public String getCorrectAnswer() {
                return CorrectAnswer;
        }

        public Set getQuestionsOptions() {
                return QuestionsOptions;
        }

        public void setQuestionID(String questionID) {
                QuestionID = questionID;
        }

        public void setQuestionText(String questionText) {
                QuestionText = questionText;
        }

        public void setMockID(String mockID) {
                MockID = mockID;
        }

        public void setDomainID(String domainID) {
                DomainID = domainID;
        }

        public void setCorrectAnswer(String correctAnswer) {
                CorrectAnswer = correctAnswer;
        }

        public void setQuestionsOptions(Set questionsOptions) {
                QuestionsOptions = questionsOptions;
        }

        @Override
        public String toString() {
                return "Question{" +
                        "QuestionID=" + QuestionID +
                        ", QuestionText='" + QuestionText + '\'' +
                        ", MockID='" + MockID + '\'' +
                        ", DomainID='" + DomainID + '\'' +
                        ", CorrectAnswer='" + CorrectAnswer + '\'' +
                        ", QuestionsOptions='" + QuestionsOptions + '\'' +
                        '}';
        }
}
