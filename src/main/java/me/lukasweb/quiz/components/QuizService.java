package me.lukasweb.quiz.components;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuizService {
    private final QuizMongoRepository quizRepository;

    public List<QuestionDTO> getAllQuestions() {
        return quizRepository.findAll().stream().map(QuestionDTO::new).toList();
    }

    public Question addNewQuestion(Question question) {
        return quizRepository.save(question);
    }

    public List<Question> getAllQuestionsByCategory(Category category) {
        return quizRepository.findAllByCategory(category);
    }

    public Question changeQuestion(Question question) {
        if(quizRepository.existsById(question.getId())){
            return quizRepository.save(question);
        }
        return null;
    }

    public void deleteQuestionById(String id) {
        quizRepository.findById(id).ifPresent(quizRepository::delete);
    }
}
