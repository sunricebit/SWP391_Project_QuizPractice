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
        QuestionDetail questionDetail = questionRepository.getById(questionId);
        List<Answer> aList = answerRepository.getAllByQuestion(questionDetail);
        for (Answer answer:aList){
                answerRepository.delete(answer);
        }
        return true;
    }
    @Autowired
    private QuestionRepository questionRepository;
    @Override
    public boolean deleteQuestionDetail(long quizListId) {
        QuizList quizList = quizListRepository.getById(quizListId);
        List<QuestionDetail> qList = questionRepository.getAllByQuizList(quizList);
        for (QuestionDetail question:qList){
            deleteAnswer(question.getQuestionNo());
            questionRepository.delete(question);
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
