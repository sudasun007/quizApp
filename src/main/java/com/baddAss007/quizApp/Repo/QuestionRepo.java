package com.baddAss007.quizApp.Repo;

import com.baddAss007.quizApp.Model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface QuestionRepo extends JpaRepository<Question, Integer> {


    List<Question> findAllByCategory(String category);

    List<Question> findAllByDifficultyLevel(String difficultyLevel);

    @Query(value = "SELECT * FROM question q WHERE LOWER(q.category)=LOWER(:category) ORDER BY RANDOM() LIMIT :numQ ",nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category, int numQ);
}
