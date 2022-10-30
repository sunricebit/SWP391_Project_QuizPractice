package com.example.quizv8.controllers;


import com.example.quizv8.model.Category;
import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.repositories.CategoryRepository;
import com.example.quizv8.repositories.QuizListRepository;
import com.example.quizv8.repositories.StateRepository;
import com.example.quizv8.repositories.UserRepository;
import com.example.quizv8.service.IQuestionDetailService;
import com.example.quizv8.service.IQuizListService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.thymeleaf.Thymeleaf;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/QuizManager")
public class CreateQuizController {


    @Autowired
    private com.example.quizv8.service.IQuestionDetailService iQuestionDetailService;
    @Autowired
    private com.example.quizv8.service.IQuizListService IQuizListService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private QuizListRepository quizListRepository;
    private Logger logger = LogManager.getLogger(this.getClass());


    @RequestMapping(value= "addQuiz", method=RequestMethod.POST)
    public String create(Model model, @RequestParam String quizName, @RequestParam long quizCategoryId, @RequestParam long stateId, @RequestParam String[] Question, @RequestParam String[] answerA,
                         @RequestParam String[] answerB, @RequestParam String[] answerC, @RequestParam String[] answerD, @RequestParam(value = "TrueAnswer[]") String[] TrueAnswer, HttpSession session){

        logger.info("Hello");
        QuizList quizList = new QuizList(quizName,false,0,userRepository.getById(1).get(),categoryRepository.getById(quizCategoryId),stateRepository.getById(stateId));

        QuizList qList =IQuizListService.saveQuiz(quizList);
        for (int i=0;i< answerA.length;i++){
            try{
                logger.info("i= "+i);
                logger.info("quizListId: "+qList.getId());
                logger.info("answerA["+i+"]= "+answerA[i]);
                logger.info("answerB["+i+"]= "+answerB[i]);
                logger.info("answerC["+i+"]= "+answerC[i]);
                logger.info("answerD["+i+"]= "+answerD[i]);
                logger.info("TrueAnswer: "+TrueAnswer[i]);
                QuestionDetail qDetail = new QuestionDetail(qList,Question[i],answerA[i],answerB[i],answerC[i],answerD[i],TrueAnswer[i]);

                qDetail=iQuestionDetailService.saveQuestionDetail(qDetail);
            }catch (Exception ex){
                logger.info("Question insert err:" + ex.getMessage());
            }
        model.addAttribute("retMess","Add quiz success!");
        }
        return "redirect:/QuizManager/?userId="+session.getAttribute("uid");
    }
}
