package com.baddAss007.quizApp.Controller;

import com.baddAss007.quizApp.Model.Question;
import com.baddAss007.quizApp.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;

    @GetMapping("/allQuestions")
    public ResponseEntity<List<Question>> getAllQuestion(){

        return questionService.getAllQuestion();
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getFromCategory(category);
    }

    @GetMapping("/difficultyLevel/{difficultyLevel}")
    public ResponseEntity<List<Question>> getQuestionByDifficultyLevel(@PathVariable String difficultyLevel){

        return questionService.getFromDifficultyLevel(difficultyLevel);
    }


    @PostMapping("/addQuestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
        return questionService.addQuestion(question);
    }


    @PostMapping("/deleteQuestion")/// cannot delete entire body on delete method
    public ResponseEntity<String> deleteQuestion(@RequestBody Question question){
        return questionService.deleteQuestion(question);
    }

    @DeleteMapping("/deleteQuestionById/{id}")
    public ResponseEntity<String> deleteQuestionById(@PathVariable Integer id){
        return questionService.deleteQuestionById(id);
    }

    @PostMapping("/addMultipleQuestions")
    public String addMultipleQuestions(@RequestBody List<Question> question){
        return questionService.addMultipleQuestions(question);
    }

    @PutMapping("/updateQuestion")
    public String updateQuestion(@RequestBody Question question){
        return questionService.updateQuestion(question);
    }

    @PutMapping("/updateQuestionById/{id}")
    public String updateQuestionById(@PathVariable Integer id, @RequestBody Question updatequestion){
        return questionService.updateQuestionById(id,updatequestion);
    }


}
