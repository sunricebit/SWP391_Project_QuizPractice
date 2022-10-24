package com.example.quizv8.controllers;

import com.example.quizv8.model.Category;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.model.QuizState;
import com.example.quizv8.model.QuizUser;
import com.example.quizv8.service.ICategoryService;
import com.example.quizv8.service.IQuizListService;
import com.example.quizv8.service.IStateService;
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
@RequestMapping("/QuizManager")
public class QuizManagerController {
    private long uid=1;
    @Autowired
    private ICategoryService ICategoryService;
    @Autowired
    private IQuizListService IQuizListService;
    @RequestMapping("/")
    public String showAllQuizList(Model model, @RequestParam long userId){
        List<QuizList> qList = IQuizListService.getQuizByUserID(userId);
        model.addAttribute("qList",qList);
        //Set model cho category
        return "QuizManager";
    }

    @RequestMapping("/delete")
    public String deleteQuiz(Model model, @RequestParam("id") long quizListId){
        IQuizListService.deleteQuizList(quizListId);
        model.addAttribute("RetMessage","Delete success!");
        return "redirect:/QuizManager/?userId=1";
    }
    @RequestMapping("/add")
    public String redirectToCreateQuizPage(Model model,@RequestParam("id") long userId){
        List<Category> list = ICategoryService.getAllCategory();
        model.addAttribute("cList",list);
        return "createQuiz";
    }

    @Autowired
    private  IUserService iUserService;
    @Autowired
    private IStateService iStateService;
    @RequestMapping("/addQuiz")
    public String addQuiz(Model model){
        model.addAttribute("cate", new Category());
        List<Category> cList = ICategoryService.getAllCategory();
        model.addAttribute("cList", cList);
        model.addAttribute("newQuiz", new QuizList());
        return "createQuiz";
    }
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveQuiz(QuizList newQuiz, Category cate){
        QuizUser currentUser = iUserService.getUser(uid);
        QuizState state = iStateService.getQuizState(1);
        QuizList quizList = new QuizList(newQuiz.getId(), newQuiz.getName(), false, 0, currentUser, cate, state);
        IQuizListService.saveQuiz(quizList);
        return "redirect:/QuizManager/?userId=1";
    }
}
