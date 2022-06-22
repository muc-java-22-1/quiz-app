package me.lukasweb.quiz.components;

import lombok.Data;

import java.util.List;

@Data
public class QuestionDTO {
    private String id;
    private String question;
    private List<String> choices;

    public QuestionDTO(Question question){
        id = question.getId();
        this.question = question.getQuestion();
        choices = question.getChoices();
    }
}
