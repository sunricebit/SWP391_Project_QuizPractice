package com.example.quizv8.controllers;

import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.service.IQuestionDetailService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/ViewQuiz")
public class ViewQuizController {


    @Autowired
    private IQuestionDetailService iQuestionDetailService;

    private final Logger logger = LogManager.getLogger(this.getClass());

    @RequestMapping("/")
    public String viewAllQuiz(Model model, @RequestParam long quizId, @RequestParam String pagestr) {
        List<QuestionDetail> qDList = iQuestionDetailService.getQuestionByQuizId(quizId);
        if (qDList.size() == 0) {
            model.addAttribute("retmsg", "No questions available");
        } else {
            int page = Integer.parseInt(pagestr);
            QuestionDetail questionDetail = qDList.get(page);
            model.addAttribute("Question", questionDetail.getQuestion());
            switch (questionDetail.getCorrectAnswer()) {
                case "A":
                    model.addAttribute("Answer", questionDetail.getAnswerA());
                    break;
                case "B":
                    model.addAttribute("Answer", questionDetail.getAnswerB());
                    break;
                case "C":
                    model.addAttribute("Answer", questionDetail.getAnswerC());
                    break;
                case "D":
                    model.addAttribute("Answer", questionDetail.getAnswerD());
                    break;
            }
            model.addAttribute("pagestr", page);
            logger.info("Max size: " + qDList.size());
            model.addAttribute("qDList", qDList);
        }
        model.addAttribute("quizId", "" + quizId);

        model.addAttribute("maxLength", qDList.size());
        return "ViewQuiz";
    }
}
