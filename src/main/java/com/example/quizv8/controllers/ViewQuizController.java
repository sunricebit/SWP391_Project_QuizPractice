package com.example.quizv8.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/ViewQuiz")
public class ViewQuizController {

    @RequestMapping("/")
    public String viewAllQuiz(Model model, @RequestParam String id){
        return "ViewQuiz";
    }
}
