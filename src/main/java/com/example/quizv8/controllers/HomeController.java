package com.example.quizv8.controllers;

import com.example.quizv8.model.*;
import com.example.quizv8.repositories.ExamRepository;
import com.example.quizv8.repositories.QuizListRepository;
import com.example.quizv8.service.ICategoryService;
import com.example.quizv8.service.IQuizListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.persistence.Index;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
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
    @RequestMapping("/home")
    public String Home(Model model){
        PartName partName = new PartName();
        model.addAttribute("partName",partName);
        List<QuizList> quizl = iQuizListService.getQuizPublic(2);
        model.addAttribute("quizl", quizl);
        List<Category> categories = iCategoryService.getAllCategory();
        model.addAttribute("categories", categories);
        return "home";
    }
    @RequestMapping("/find")
    public String homeDemo(@RequestParam("categoryName") String categoryName, Model model){
        PartName partName = new PartName();
        model.addAttribute("partName",partName);
        List<Category> categories = iCategoryService.getAllCategory();
        model.addAttribute("categories", categories);
        List<QuizList> quizl = iQuizListService.getQuizByCategory(categoryName);
        model.addAttribute("quizl", quizl);
        return "home";
    }
    @RequestMapping("/search")
    public String searchPartName(PartName partName, Model model ){
        List<Category> categories = iCategoryService.getAllCategory();
        model.addAttribute("categories", categories);
        List<QuizList> quizl = iQuizListService.searchByPartName(partName.getPart());
        model.addAttribute("quizl", quizl);
        return "home";
    }
    @RequestMapping("/quizDetail")
    public String showDetails(Model model,@RequestParam("qid") long qid ){
        QuizList quizList = iQuizListService.getQuizListById(qid);
        model.addAttribute("quizList", quizList);
        List<LeaderBoard> leaderBoards = iQuizListService.getTenLeaderBoard(qid);
        List<RankLeaderBoard> rankLeaderBoards = new ArrayList<RankLeaderBoard>();
        for (int i = 0; i < leaderBoards.size(); i++) {
            rankLeaderBoards.add(new RankLeaderBoard(i+1,leaderBoards.get(i)));
        }
        model.addAttribute("rankLeaderBoards", rankLeaderBoards);
        return "QuizDetail";
    }
    @RequestMapping("history")
    public String showHistory(Model model,HttpSession session){
        List<Exam> history = iQuizListService.getAllExam((long)session.getAttribute("uid"));
        model.addAttribute("history",history);
        return "ExamHistory";
    }
    @RequestMapping(value = "/logout")
    public String logout(HttpSession session){
        if(session.getAttribute("uid")!=null){
            session.removeAttribute("uid");
        }
        return "homePage";
    }
}
