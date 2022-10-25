package com.example.quizv8.controllers;

import com.example.quizv8.model.QuizList;
import com.example.quizv8.model.QuizUser;
import com.example.quizv8.service.IQuizListService;
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
    @Autowired
    private IQuizListService iQuizListService;
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
        return "redirect:/admin/";
    }

<<<<<<< HEAD
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
=======
    @RequestMapping("/delete")
    public String deleteQuiz(Model model, @RequestParam("id") long quizListId){
        iQuizListService.deleteQuizList(quizListId);
        model.addAttribute("RetMessage","Delete success!");
        return "redirect:/QuizManager/?userId=1";
    }
    @RequestMapping(value = "/LockOrUnlock", method = RequestMethod.GET)
>>>>>>> 44983280f7a622ad61a096bf6539c05cb89badc6
    public String deleteUser(@RequestParam("id") Long userId, Model model) {
        iUserService.deleteUser(userId);
        return "redirect:/admin/";
    }
    //API show list
    @RequestMapping("/")
    public String index(Model model) {
        List<QuizUser> allUser = iUserService.getAllUser();

        model.addAttribute("allUser", allUser);

        return "index";
    }
    @RequestMapping("/user")
    public String showAllQuizList(Model model, @RequestParam("id") long userId){
        List<QuizList> qList = iQuizListService.getQuizByUserID(userId);
        model.addAttribute("qList",qList);
        //Set model cho category
        return "QuizManager";
    }
}