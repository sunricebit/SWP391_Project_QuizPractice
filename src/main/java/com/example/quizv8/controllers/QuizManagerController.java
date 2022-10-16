package com.example.quizv8.controllers;

import com.example.quizv8.model.Category;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.model.QuizState;
import com.example.quizv8.service.ICategoryService;
import com.example.quizv8.service.IQuizService;
import com.example.quizv8.service.IStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/QuizManager")
public class QuizManagerController {
    @Autowired
    private IQuizService IQuizService;
    @Autowired
    private IStateService IStateService;
    @Autowired
    private ICategoryService ICategoryService;
    @RequestMapping("/")
    public String showAllQuizList(Model model, @RequestParam long userId){
        List<QuizList> qList = IQuizService.getAllQuizByUserId(userId);
        model.addAttribute("qList",qList);
        return "QuizManager";
    }

    @RequestMapping("/delete")
    public String deleteQuiz(Model model, @RequestParam long id){
        IQuizService.deleteQuiz(id);
        model.addAttribute("RetMessage","Delete success!");
        return "QuizManager/?userId=1";
    }


}
