package me.lukasweb.quiz.components;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "questions")
public class Question {
    @Id
    private String id;
    private String question;
    private int answer;
    private List<String> choices;
    private Category category;
}