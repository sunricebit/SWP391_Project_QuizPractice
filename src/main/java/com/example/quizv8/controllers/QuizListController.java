package com.example.quizv8.controllers;

import com.example.quizv8.model.*;
import com.example.quizv8.service.IQuizListService;
import com.example.quizv8.service.IQuizService;
import com.example.quizv8.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/quizlist")
public class QuizListController {
    @Autowired
    private IQuizService iQuizService;
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IQuizListService iQuizListService;
    private long uid = 1;
    private long qid;

    @RequestMapping("/")
    public String index(@RequestParam("id") long id, Model model) {
        List<QuestionDetail> questions = iQuizService.getAllQuestion(id);
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
        QuizUser quizUser = iUserService.getUser(uid).get();
        QuizList quizList = iQuizListService.getQuizListById(qid);
        List<QuestionDetail> questionDetails = quizList.getQuestionDetailList();
        int leng = result.getStrResult().length();
        int mark = 0;
        String[] ansSelected = result.getStrResult().substring(1, leng).split(",");
        for (int i = 0; i < questionDetails.size(); i++) {
            if (!ansSelected[i].equals("_default")) {
                String correct = questionDetails.get(i).getCorrectAnswer();
                if (correct.equals("a")) {
                    if (questionDetails.get(i).getAnswerA().equals(ansSelected[i])) {
                        mark += 1;
                    }
                } else if (correct.equals("b")) {
                    if (questionDetails.get(i).getAnswerB().equals(ansSelected[i])) {
                        mark += 1;
                    }
                } else if (correct.equals("c")) {
                    if (questionDetails.get(i).getAnswerC().equals(ansSelected[i])) {
                        mark += 1;
                    }
                } else if (correct.equals("d")) {
                    if (questionDetails.get(i).getAnswerD().equals(ansSelected[i])) {
                        mark += 1;
                    }
                }

            }
        }
        Random rand = new Random();
        int totalQuestion = questionDetails.size();
        String percent = String.valueOf(1.0 * mark / totalQuestion);
        Exam exam = new Exam(quizUser.getId(), quizList.getName(), percent, totalQuestion, LocalDate.now());
        model.addAttribute("exam", exam);
        Exam examSave = new Exam();
        model.addAttribute("examSave",examSave);
        return "Result";
    }
}
