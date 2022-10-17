package com.example.quizv8.controllers;

import com.example.quizv8.model.Category;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.repositories.QuizListRepository;
import com.example.quizv8.service.ICategoryService;
import com.example.quizv8.service.IQuizListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private IQuizListService iQuizListService;
    @Autowired
    private ICategoryService iCategoryService;
    @RequestMapping("/")
    public String home(){return "homePage";}
    @RequestMapping("/demo")
    public  String homeDemo(Model model){
        List<QuizList> quizl = iQuizListService.getQuizPublic(2);
        model.addAttribute("quizl", quizl);
        List<Category> categories = iCategoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "DemoHomePage";
    }
    @RequestMapping("/demo/find")
    public String homeDemo(@RequestParam("name") String categoryName, Model model){
        List<Category> categories = iCategoryService.getAllCategory();
        model.addAttribute("categories", categories);
        List<QuizList> quizl = iQuizListService.getQuizByCategory(categoryName);
        model.addAttribute("quizl", quizl);
        return "DemoHomePage";
    }
}
