package com.example.quizv8.controllers;

import com.example.quizv8.model.Category;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.service.ICategoryService;
import com.example.quizv8.service.IQuizListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/QuizManager")
public class QuizManagerController {
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

    @RequestMapping("/addQuiz")
    public String addQuiz(Model model){
        return "createQuiz";
    }


}
