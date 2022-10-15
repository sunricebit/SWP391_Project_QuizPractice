package com.example.quizv8.controllers;

import com.example.quizv8.model.Question;
import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/quizlist")
public class QuizListController {
    @Autowired
    private IQuizService iQuizService;
    @RequestMapping("/")
    public String index(Model model){
        List<Question> ques = iQuizService.getAllQuestion();
        model.addAttribute("quizlists",ques);
        return "quiz";
    }

//    Boolean submitted = false;
//    @RequestMapping("/submit")
//    public String submit(@ModelAttribute QuestionDetail questionDetail, Model m){
//    if(!submitted){
//
//    }
//        return "result.html";
//    }


}
