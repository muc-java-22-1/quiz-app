package me.lukasweb.quiz.components;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuizMongoRepository extends MongoRepository<Question, String> {

    List<Question> findAllByCategory(Category category);
}
