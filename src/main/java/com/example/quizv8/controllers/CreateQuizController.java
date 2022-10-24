package com.example.quizv8.controllers;


import com.example.quizv8.model.Category;
import com.example.quizv8.service.IQuizListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.Thymeleaf;

@Controller
@RequestMapping("/QuizManager")
public class CreateQuizController {


    @Autowired
    private com.example.quizv8.service.IQuizListService IQuizListService;

    @RequestMapping(value= "addQuiz", method=RequestMethod.GET)
    public String create(Model model, @RequestParam String quizName,@RequestParam long quizCategoryId, @RequestParam long stateId){

        IQuizListService.saveQuizList(quizName,1,quizCategoryId,stateId);
        return "redirect:/QuizManager/add?id=1";
    }
}
