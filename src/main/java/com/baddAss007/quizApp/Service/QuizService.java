package com.baddAss007.quizApp.Service;

import com.baddAss007.quizApp.Model.Question;
import com.baddAss007.quizApp.Model.QuestionWrapper;
import com.baddAss007.quizApp.Model.Quiz;
import com.baddAss007.quizApp.Model.Response;
import com.baddAss007.quizApp.Repo.QuestionRepo;
import com.baddAss007.quizApp.Repo.QuizRepo;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizService {
    @Autowired
    QuizRepo quizRepo;
    @Autowired
    QuestionRepo questionRepo;


    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepo.findRandomQuestionsByCategory(category,numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);

        quizRepo.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {

        Optional<Quiz> quiz =quizRepo.findById(id);
        List<Question> questionsFromDB = quiz.get().getQuestions();


        List<QuestionWrapper> questionsForUser = new ArrayList<>();
        for(Question q : questionsFromDB){
            QuestionWrapper qw = new QuestionWrapper(q.getId(),q.getQuestionTitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
            questionsForUser.add(qw);
        }


        return new ResponseEntity<>(questionsForUser, HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateResult(Integer id, List<Response> responces) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Question> questions = quiz.getQuestions();

        int rightAnswers = 0;
        int i =0;
        for(Response r : responces){
            if(r.getResponse().equals(questions.get(i).getRightAnswer()))
                rightAnswers++;

            i++;
        }
        return new ResponseEntity<>(rightAnswers, HttpStatus.OK);
    }
}
