package com.baddAss007.quizApp.Repo;

import com.baddAss007.quizApp.Model.Quiz;
import com.baddAss007.quizApp.Service.QuizService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepo extends JpaRepository<Quiz,Integer> {
}
