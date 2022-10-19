package com.example.quizv8.controllers;

import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.service.IQuizListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/quizlist")
public class QuizListController {

    @Autowired
    private IQuizListService iQuizListService;
    @RequestMapping("/")
    public String index(@RequestParam("id") long id, Model model){
        List<QuestionDetail> questions = iQuizListService.getAllQuestion(id);
        model.addAttribute("questions",questions);
        return "quiz";
    }

}
