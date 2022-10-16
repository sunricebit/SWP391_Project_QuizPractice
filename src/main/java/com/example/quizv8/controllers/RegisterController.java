package com.example.quizv8.controllers;

import com.example.quizv8.model.QuizUser;
import com.example.quizv8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/SignUp")
public class RegisterController {
    public RegisterController(IUserService iUserService) {
        super();
        this.iUserService = iUserService;
    }
    @Autowired
    private IUserService iUserService;
    @ModelAttribute("quizUser")
    public QuizUser quizUser(){
        return new QuizUser();
    }
    @GetMapping
    public String showRegister(){
        return "SignUp";
    }
    @PostMapping
    public String register(@ModelAttribute("quizUser")QuizUser user){
        iUserService.saveUser(user);
        return "redirect:/SignIn";
    }
}
