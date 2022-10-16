package com.example.quizv8.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.Thymeleaf;

@Controller
@RequestMapping("/quizController")
public class CreateQuizController {

    @RequestMapping(value = "createQuiz", method = RequestMethod.GET)
    public String create(Model model,@RequestParam String quiz){
        return "#";
    }
}
