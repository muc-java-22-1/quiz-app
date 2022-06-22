package me.lukasweb.quiz.components;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "questions")
public class Question {
    @Id
    private String id;
    private String question;
    private int answer;
    private List<String> choices;
    private Category category;

    public Question(QuestionDTO questionDTO){
        id = questionDTO.getId();
        question = questionDTO.getQuestion();
    }
}

