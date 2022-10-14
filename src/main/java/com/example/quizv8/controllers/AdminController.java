package com.example.quizv8.controllers;

import com.example.quizv8.model.QuizUser;
import com.example.quizv8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IUserService iUserService;
    @RequestMapping(value = "/add")
    public String addUser(Model model) {
        model.addAttribute("user", new QuizUser());
        return "addUser";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String editUser(@RequestParam("id") Long userId, Model model) {
        Optional<QuizUser> userEdit = iUserService.getUser(userId);
        userEdit.ifPresent(user -> model.addAttribute("user", user));
        return "editUser";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(QuizUser user) {
        iUserService.saveUser(user);
        return "redirect:/quizmanager/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam("id") Long userId, Model model) {
        iUserService.deleteUser(userId);
        return "redirect:/quizmanager/";
    }
    //API show list
    @RequestMapping("/")
    public String index(Model model) {
        List<QuizUser> users = iUserService.getAllUser();

        model.addAttribute("users", users);

        return "index";
    }
}
