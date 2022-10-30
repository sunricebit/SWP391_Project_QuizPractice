package com.example.quizv8.controllers;

import com.example.quizv8.model.Category;
import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.model.QuizState;
import com.example.quizv8.repositories.CategoryRepository;
import com.example.quizv8.repositories.QuizListRepository;
import com.example.quizv8.repositories.StateRepository;
import com.example.quizv8.repositories.UserRepository;
import com.example.quizv8.service.ICategoryService;
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

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/editQuiz")
public class EditQuizController {

    @Autowired
    private IQuestionDetailService iQuestionDetailService;
    @Autowired
    private IQuizListService IQuizListService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StateRepository stateRepository;
    @Autowired
    private QuizListRepository quizListRepository;
    private final Logger logger = LogManager.getLogger(this.getClass());


    @RequestMapping("")
    public String editQuiz(Model model, @RequestParam long quizId, @RequestParam String quizName, @RequestParam long quizCategoryId, @RequestParam long stateId, @RequestParam String[] Question, @RequestParam String[] answerA,
                           @RequestParam String[] answerB, @RequestParam String[] answerC, @RequestParam String[] answerD, @RequestParam(value = "TrueAnswer[]") String[] TrueAnswer, HttpSession session) {
        QuizList quizList = IQuizListService.getQuizListById(quizId);
        quizList.setName(quizName);
        Category cate = categoryRepository.getById(quizCategoryId);
        quizList.setCategory(cate);
        QuizState state = stateRepository.getById(stateId);
        quizList.setState(state);
        quizList = IQuizListService.saveQuiz(quizList);
        List<QuestionDetail> qDList = iQuestionDetailService.getQuestionByQuizId(quizId);
        for(QuestionDetail qD:qDList){
            iQuestionDetailService.deleteQuestionDetail(qD);
        }
        for (int i=0;i< answerA.length;i++){
            try{
                QuestionDetail qDetail = new QuestionDetail(quizList,Question[i],answerA[i],answerB[i],answerC[i],answerD[i],TrueAnswer[i]);

                qDetail=iQuestionDetailService.saveQuestionDetail(qDetail);
            }catch (Exception ex){
                logger.info("Question insert err:" + ex.getMessage());
            }

        }
        model.addAttribute("retMess","Edit quiz success!");
        return "redirect:/QuizManager/?userId="+session.getAttribute("uid");
    }
}