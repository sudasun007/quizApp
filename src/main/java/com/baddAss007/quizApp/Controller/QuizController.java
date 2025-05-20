package com.baddAss007.quizApp.Controller;

import com.baddAss007.quizApp.Model.Question;
import com.baddAss007.quizApp.Model.QuestionWrapper;
import com.baddAss007.quizApp.Model.Response;
import com.baddAss007.quizApp.Service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
//        return new ResponseEntity<>("Quiz Created", HttpStatus.CREATED);
        return quizService.createQuiz(category,numQ,title);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){

        return quizService.getQuizQuestions(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuix(@PathVariable Integer id, @RequestBody List<Response> responces){
        return quizService.calculateResult(id,responces);

    }
}
