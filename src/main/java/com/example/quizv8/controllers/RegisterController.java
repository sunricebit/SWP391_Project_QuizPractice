package com.example.quizv8.controllers;

import com.example.quizv8.model.QuizUser;
import com.example.quizv8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
@RequestMapping("/SignUp")
public class RegisterController {
    public RegisterController(IUserService iUserService) {
        super();
        this.iUserService = iUserService;
    }

    @Autowired
    private IUserService iUserService;

    @RequestMapping("register")
    public String showRegister( Model model) {
        model.addAttribute("quizUser", new QuizUser());
        return "SignUp";
    }
    @RequestMapping("/sign_up")
    public String register(@ModelAttribute("quizUser") QuizUser user, HttpServletRequest res, Model model) {
        String pass = res.getParameter("Pass");
        String rePass = res.getParameter("rePass");
        if (!user.getPassword().equals(rePass)) {
            model.addAttribute("notification", true);
            return "forward:/SignUp/register/";
        } else {
            iUserService.saveUser(user);
            return "redirect:/SignIn/In?success";
        }

    }

}
