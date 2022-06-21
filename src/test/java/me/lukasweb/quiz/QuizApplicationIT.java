package me.lukasweb.quiz;

import me.lukasweb.quiz.components.Category;
import me.lukasweb.quiz.components.Question;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class QuizApplicationIT {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void integrationTest(){
        ResponseEntity<Question[]> response = restTemplate.getForEntity("/api/quiz", Question[].class);
        assertThat(response.getBody()).isEmpty();

        Question q = new Question(null, "q1", 0, List.of("a1", "a2"), Category.TRIVIA);

        var post = restTemplate.postForEntity("/api/quiz", q, Question.class);
        assertThat(post.getBody().getId()).isNotNull();
        response = restTemplate.getForEntity("/api/quiz", Question[].class);
        List<Question> questionList = Arrays.stream(response.getBody()).toList();
        q = questionList.get(0);
        assertThat(questionList.size()).isEqualTo(1);
        assertThat(questionList.get(0)).extracting(Question::getAnswer).isEqualTo(0);

        q.setAnswer(1);
        restTemplate.put("/api/quiz", q);

        response = restTemplate.getForEntity("/api/quiz", Question[].class);
        questionList = Arrays.stream(response.getBody()).toList();
        assertThat(questionList.get(0)).extracting(Question::getAnswer).isEqualTo(1);

        restTemplate.delete("/api/quiz/" + q.getId());
        assertThat(restTemplate.getForEntity("/api/quiz", Question[].class).getBody()).isEmpty();
    }

}