package com.example.quizv8.controllers;

import com.example.quizv8.model.QuizList;
import com.example.quizv8.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/QuizManager")
public class QuizManagerController {
    @Autowired
    private IQuizService IQuizService;
    @RequestMapping("/")
    public String showAllQuizList(Model model){
        List<QuizList> qList = IQuizService.getAllQuiz();
        model.addAttribute("qList",qList);
        return "QuizManager";
    }
}
