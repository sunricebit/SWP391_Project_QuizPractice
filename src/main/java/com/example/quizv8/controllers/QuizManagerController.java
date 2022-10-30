package com.example.quizv8.controllers;

import com.example.quizv8.model.*;
import com.example.quizv8.service.*;
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
    @Autowired
    private IQuestionDetailService iQuestionDetailService;

    @RequestMapping("/")
    public String showAllQuizList(Model model, @RequestParam long userId){
        List<QuizList> qList = IQuizListService.getQuizByUserID(userId);
        model.addAttribute("qList",qList);
        //Set model cho category
        return "QuizManager";
    }
    //Delete button
    @RequestMapping("/delete")
    public String deleteQuiz(Model model, @RequestParam("id") long quizListId){
        IQuizListService.deleteQuizList(quizListId);
        model.addAttribute("RetMessage","Delete success!");
        return "redirect:/QuizManager/?userId=1";
    }
    //Add button
    @RequestMapping("/add")
    public String redirectToCreateQuizPage(Model model,@RequestParam("id") long userId){
        List<Category> list = ICategoryService.getAllCategory();
        model.addAttribute("cList",list);
        List<QuizState> sList = iStateService.getAllState();
        model.addAttribute("sList",sList);

        return "createQuiz";
    }
    @RequestMapping("/edit")
    public String redirectToEditQuizPage(Model model,@RequestParam long id){
        List<Category> list = ICategoryService.getAllCategory();
        model.addAttribute("cList",list);
        List<QuizState> sList = iStateService.getAllState();
        model.addAttribute("sList",sList);
        QuizList quiz = IQuizListService.getQuizListById(id);
        model.addAttribute("quizName",quiz.getName()    );
        model.addAttribute("quizCate",quiz.getCategory());
        model.addAttribute("quizState", quiz.getState() );
        model.addAttribute("quizId", id                 );
        List<QuestionDetail> qDList = iQuestionDetailService.getQuestionByQuizId(id);
        model.addAttribute("qDList",qDList);
        return "editQuiz";
    }

    @Autowired
    private  IUserService iUserService;
    @Autowired
    private IStateService iStateService;


}
