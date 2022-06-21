package me.lukasweb.quiz.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizMongoRepository quizRepository;

    public List<Question> getAllQuestions() {
        return quizRepository.findAll();
    }

    public Question addNewQuestion(Question question) {
        return quizRepository.save(question);
    }

    public List<Question> getAllQuestionsByCategory(Category category) {
        return quizRepository.findAllByCategory(category);
    }
}
