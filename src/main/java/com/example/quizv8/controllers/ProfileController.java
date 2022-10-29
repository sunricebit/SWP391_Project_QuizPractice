package com.example.quizv8.controllers;

import com.example.quizv8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping
    public String Profile(){
        return "profile";
    }
}
