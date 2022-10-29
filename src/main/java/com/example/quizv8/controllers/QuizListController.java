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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/quizlist")
public class QuizListController {
    @Autowired
    private IUserService iUserService;
    @Autowired
    private IQuizListService iQuizListService;
    private long uid;
    private long qid;
    @RequestMapping("/")
    public String index(@RequestParam("id") long quizId, Model model) {
        QuizList quizList = iQuizListService.getQuizListById(quizId);
        model.addAttribute("quizList", quizList);
        List<QuestionDetail> questions = iQuizListService.getAllQuestion(quizId);
        model.addAttribute("questions", questions);
        Result result = new Result();
        model.addAttribute("result", result);
        qid = quizId;
        return "quiz";
    }

//    @RequestMapping(value = "/save",method = RequestMethod.POST)
//    public String save(Exam exam) {
//        iQuizListService.saveExam(exam);
//        return "homePage";
//    }

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    public String getResult(Result result, Model model, HttpSession session) {
        uid =(long) session.getAttribute("uid");
        QuizUser quizUser = iUserService.getUser(uid);
        QuizList quizList = iQuizListService.getQuizListById(qid);
        List<QuestionDetail> questionDetails = iQuizListService.getAllQuestion(quizList.getId());
        int leng = result.getStrResult().length();
        int mark = 0;
        String[] ansSelected = result.getStrResult().substring(1, leng).split("\t");
        for (int i = 0; i < questionDetails.size(); i++) {
            String correct = questionDetails.get(i).getCorrectAnswer().toLowerCase();
            if (correct.equals(ansSelected[i])) {
                mark += 1;
            }
        }
        int totalQuestion = questionDetails.size();
        double mark1 =(double) mark;
        double percent = mark1 *100 / totalQuestion;
        Exam exam = new Exam(quizUser, quizList.getName(), percent +"%", totalQuestion, LocalDateTime.now());
        LeaderBoard newLeader = new LeaderBoard(quizUser, quizList, percent +"%", totalQuestion, LocalDateTime.now());
        iQuizListService.saveExam(exam);
        //save to leader board
        long id = iQuizListService.findExisted(newLeader);
        long currentId = 0;
        if(id!=-1){
            LeaderBoard old = iQuizListService.getById(id);
            //so sanh diem
            double oldPercent = Double.parseDouble(old.getPercentage().substring(0, old.getPercentage().length()-1));
            if(oldPercent<percent){
                old.setPercentage(newLeader.getPercentage());
                old.setDate(newLeader.getDate());
                iQuizListService.saveLeaderBoard(old);
                currentId = old.getId();
            }
        } else{
            currentId = iQuizListService.saveLeaderBoard(newLeader).getId();
        }
        List<LeaderBoard> leaderBoard = iQuizListService.getTenLeaderBoard();
        boolean isExist = false;
        for(LeaderBoard l: leaderBoard){
            if(l.getId()==currentId){
                isExist = true;
                break;
            }
        }
        List<LeaderBoard> all = iQuizListService.getAllLeaderBoard();
        List<RankLeaderBoard> rankLeaderBoards = new ArrayList<RankLeaderBoard>();
        for (int i = 0; i < leaderBoard.size(); i++) {
            rankLeaderBoards.add(new RankLeaderBoard((i+1), leaderBoard.get(i)));
        }
        if(!isExist){
            for (int i = 0; i < all.size(); i++) {
                if(all.get(i).getId()==currentId){
                    rankLeaderBoards.add(new RankLeaderBoard((i+1), all.get(i)));
                    break;
                }
            }
        }
        model.addAttribute("leaderBoard", rankLeaderBoards);
        return "Result";
    }
}
