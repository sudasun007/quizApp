package com.baddAss007.quizApp.Service;

import com.baddAss007.quizApp.Model.Question;
import com.baddAss007.quizApp.Repo.QuestionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionRepo questionRepo;

    public ResponseEntity<List<Question>> getAllQuestion() {

        try{
            return new ResponseEntity<>(questionRepo.findAll(), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<List<Question>> getFromCategory(String category) {

        try{
            return new ResponseEntity<>(questionRepo.findAllByCategory(category), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);


    }

    public ResponseEntity<List<Question>> getFromDifficultyLevel(String difficultyLevel) {

        try{
            return new ResponseEntity<>(questionRepo.findAllByDifficultyLevel(difficultyLevel), HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<String> addQuestion(Question question) {

        questionRepo.save(question);
        try{
            return new ResponseEntity<>("Question Added Successfully",HttpStatus.CREATED);

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Question Not Added",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> deleteQuestion(Question question) {
        questionRepo.delete(question);

        try{
            return new ResponseEntity<>("Question Deleted Successfully",HttpStatus.OK);

        }catch (Exception e){
            e.printStackTrace();
        return new ResponseEntity<>("Question Not Deleted",HttpStatus.BAD_REQUEST);}
    }

    public ResponseEntity<String> deleteQuestionById(Integer id){

        try{
            if(questionRepo.existsById(id)){
                questionRepo.deleteById(id);
                return new ResponseEntity<>("Question Deleted Successfully",HttpStatus.OK);

            }else {
                return new ResponseEntity<>("Question Not Found",HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Question Not Deleted",HttpStatus.BAD_REQUEST);
        }

//        questionRepo.deleteById(id);
//        try{        return new ResponseEntity<>("Question Deleted Successfully",HttpStatus.OK);
//        }catch (Exception e){
//            e.printStackTrace();
//        return new ResponseEntity<>("Question Not Deleted",HttpStatus.BAD_REQUEST);}
    }

    public String addMultipleQuestions(List<Question> question) {
        questionRepo.saveAll(question);
        return "Questions Added Successfully";
    }

    public String updateQuestion(Question question) {
        questionRepo.save(question);
        return "Question Updated Successfully";
    }

    public String updateQuestionById(Integer id, Question updatequestion) {
        return questionRepo.findById(id).map(existingQuestion -> {
            existingQuestion.setQuestionTitle(updatequestion.getQuestionTitle());
            existingQuestion.setOption1(updatequestion.getOption1());
            existingQuestion.setOption2(updatequestion.getOption2());
            existingQuestion.setOption3(updatequestion.getOption3());
            existingQuestion.setOption4(updatequestion.getOption4());
            existingQuestion.setRightAnswer(updatequestion.getRightAnswer());
            existingQuestion.setDifficultyLevel(updatequestion.getDifficultyLevel());
            existingQuestion.setCategory(updatequestion.getCategory());
            questionRepo.save(existingQuestion);
            return "Question Updated Successfully";
        }).orElse ("Question not found with ID: " +id);
    }
}
