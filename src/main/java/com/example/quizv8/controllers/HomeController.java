package com.example.quizv8.controllers;

import com.example.quizv8.model.QuizUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
    @RequestMapping(value = "/")
    public String home() {
        return "home";
    }

    @RequestMapping(value = "/homepage")
    public String homePage() {
        return "homePage";
    }

    @RequestMapping(value = "/profile")
    public String profile() {
        return "profile";
    }
}
