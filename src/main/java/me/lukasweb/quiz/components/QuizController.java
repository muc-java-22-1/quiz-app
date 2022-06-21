package me.lukasweb.quiz.components;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/quiz")
public class QuizController {

    private final QuizService quizService;

    @GetMapping
    public List<Question> getAllQuestions() {
        return quizService.getAllQuestions();
    }

    @PostMapping
    public void addQuestion(@RequestBody Question question){
        quizService.addNewQuestion(question);
    }

    @GetMapping("/{category}")
    public List<Question> getAllQuestionsByCategory(@PathVariable String category) {
        return quizService.getAllQuestionsByCategory(Category.valueOf(category.toUpperCase()));
    }
}
