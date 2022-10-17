package com.example.quizv8.service;

import com.example.quizv8.model.*;
import com.example.quizv8.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizListService implements IQuizListService {
    @Autowired
    private QuizListRepository quizListRepository;
    @Override
    public List<QuizList> getQuizByUserID(long id) {
        List<QuizList> quizLists =  quizListRepository.findAll();
        List<QuizList> userquiz = new ArrayList<QuizList>();
        for (int i = 0; i < quizLists.size(); i++) {
            if(quizLists.get(i).getUser().getId()==id){
                userquiz.add(quizLists.get(i));
            }
        }
        return userquiz;
    }

    @Autowired
    private AnswerRepository answerRepository;
    @Override
    public boolean deleteAnswer(long questionId) {
        List<Answer> aList = answerRepository.findAll();
        for (Answer answer:aList){
            if(answer.getQuestionID()==questionId){
                answerRepository.delete(answer);
            }
        }
        return true;
    }
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public boolean deleteQuestionDetail(long quizListId) {

        List<QuestionDetail> qList = questionRepository.findAll();
        for (QuestionDetail question:qList){
            deleteAnswer(question.getQuestionNo());
            if(question.getQuizListID()==quizListId){
                questionRepository.delete(question);
            }
        }
        return true;
    }

    @Override
    public boolean deleteQuizList(long quizListId) {

        QuizList quizList = quizListRepository.getById(quizListId);
        deleteQuestionDetail(quizListId);
        quizListRepository.delete(quizList);
        return true;
    }

    @Override
    public QuizList getQuizListById(long QuizListId) {
        return quizListRepository.getById(QuizListId);
    }
    @Autowired
    private QuizStateRepositoty quizStateRepositoty;
    @Override
    public List<QuizList> getQuizPublic(long stateId) {
//        List<QuizList> listsQuiz = quizListRepository.findAll();
//        List<QuizList> publicQuiz = new ArrayList<QuizList>();
//        for (QuizList quiz: listsQuiz) {
//            if(quiz.getState().getId()==stateId){
//                publicQuiz.add(quiz);
//            }
//        }
//        return publicQuiz;
        QuizState state = quizStateRepositoty.findById(stateId);
        return quizListRepository.findQuizListsByState(state);
    }
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<QuizList> getQuizByCategory(String categoryName) {
        long stateID = 2;
        QuizState state = quizStateRepositoty.findById(stateID);
        Category category = categoryRepository.findCategoryByCategoryName(categoryName);
        return quizListRepository.findQuizListByCategoryAndState(category, state);
    }

}
