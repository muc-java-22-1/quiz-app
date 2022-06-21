package me.lukasweb.quiz.components;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class QuizRepository {
    private final Map<String, Question> questionMap = new HashMap<>();

    public List<Question> findAll() {
        return questionMap.values().stream().toList();
    }

    public Optional<Question> save(Question question) {
        return Optional.ofNullable(questionMap.put(question.getId(), question));
    }

}
