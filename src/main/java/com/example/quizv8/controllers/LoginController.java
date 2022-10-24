package com.example.quizv8.controllers;

import com.example.quizv8.model.Category;
import com.example.quizv8.model.QuizUser;
import com.example.quizv8.service.ICategoryService;
import com.example.quizv8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/SignIn")
public class LoginController {
    @Autowired
    private IUserService iUserService;


    @RequestMapping("/In")
    public String getQuizUser(Model model, HttpServletRequest request) {
        model.addAttribute("user", new QuizUser());
        return "SignIn";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(QuizUser user, Model model, HttpServletRequest request, HttpSession session) {
        Optional<QuizUser> currentUser = iUserService.getUserbyEmail(user.getEmail());
        if (currentUser.isPresent()) {
            if (currentUser.get().getPassword().equals(user.getPassword())) {
                //set cookie
                if (currentUser.get().isStatus()) {
                    session.setAttribute("currentUser",currentUser);
                    //model.addAttribute("currentUser", currentUser);
                    return "redirect:/home";
                }
                else {
                    model.addAttribute("notification2", true);
                    return "forward:/SignIn/In";
                }
            }
        }
        model.addAttribute("notification", true);
        return "forward:/SignIn/In";
    }
}
