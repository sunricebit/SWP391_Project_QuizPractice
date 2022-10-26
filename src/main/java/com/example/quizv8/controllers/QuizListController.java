package com.example.quizv8.controllers;
import com.example.quizv8.model.*;
import com.example.quizv8.service.IQuizListService;
import com.example.quizv8.service.IUserService;
import com.example.quizv8.model.QuestionDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/quizlist")
public class QuizListController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IQuizListService iQuizListService;
    private long uid = 1;
    private long qid;
    @RequestMapping("/")
    public String index(@RequestParam("id") long id, Model model) {
        List<QuestionDetail> questions = iQuizListService.getAllQuestion(id);
        model.addAttribute("questions", questions);
        Result result = new Result();
        model.addAttribute("result", result);
        qid = id;
        return "quiz";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Exam exam) {
        iQuizListService.saveExam(exam);
        return "homePage";
    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String getResult(Result result, Model model) {
        QuizUser quizUser = iUserService.getUser(uid);
        QuizList quizList = iQuizListService.getQuizListById(qid);
        List<QuestionDetail> questionDetails = iQuizListService.getAllQuestion(quizList.getId());
        int leng = result.getStrResult().length();
        int mark = 0;
        String[] ansSelected = result.getStrResult().substring(1, leng).split(",");
        for (int i = 0; i < questionDetails.size(); i++) {
            String correct = questionDetails.get(i).getCorrectAnswer().toLowerCase();
            if (correct.equals(ansSelected[i])) {
                mark += 1;
            }
        }

        int totalQuestion = questionDetails.size();
        double mark1 =(double) mark;
        double percent = mark1 *100 / totalQuestion;
        Exam exam = new Exam(quizUser, quizList.getName(), String.valueOf(percent) +"%", totalQuestion, LocalDateTime.now());
        iQuizListService.saveExam(exam);
        List<ExamWithRank> leaderBoard = iQuizListService.getLeaderBoard(exam, uid, qid);
        model.addAttribute("leaderBoard", leaderBoard);
        return "Result";
    }
}
