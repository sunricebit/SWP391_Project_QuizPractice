package com.example.quizv8.controllers;

import com.example.quizv8.model.QuizUser;
import com.example.quizv8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
@RequestMapping("/home")
public class LoginController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping("/")
    public String getLoginForm( Model model) {
        model.addAttribute("user", new QuizUser());
        return "DemoHomePage";
    }

    @RequestMapping(value = "/demologin")
    public String newUser(Model model) {
        model.addAttribute("user", new QuizUser());
        return "DemoLogin";
    }
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(QuizUser user, Model model, HttpServletRequest request) {
        Optional<QuizUser> currentUser = iUserService.getUserbyEmail(user.getEmail());
        if (currentUser.isPresent()) {
            if (currentUser.get().getPassword().equals(user.getPassword())) {
                //set cookie
                model.addAttribute("currentUser", currentUser);

                return "redirect:/home/";
            }
        }
        return "redirect:/DemoLogin/";

    }
}
