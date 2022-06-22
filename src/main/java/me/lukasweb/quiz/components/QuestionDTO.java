package me.lukasweb.quiz.components;

import lombok.Data;

@Data
public class QuestionDTO {
    private String id;
    private String question;

    public QuestionDTO(Question question){
        id = question.getId();
        this.question = question.getQuestion();
    }
}
