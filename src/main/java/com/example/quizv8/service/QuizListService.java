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
    private QuestionRepository questionRepository;
    @Override
    public boolean deleteQuestionDetail(long quizListId) {
        QuizList quizList = quizListRepository.getById(quizListId);
        List<QuestionDetail> qList = questionRepository.getAllByQuizList(quizList);
        for (QuestionDetail question:qList){
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
    @Override
    public List<QuestionDetail> getAllQuestion(long quizListID) {
        QuizList quizList = quizListRepository.getById(quizListID);
        return questionRepository.getAllByQuizList(quizList);
    }

    @Override
    public QuizList saveQuiz(QuizList quizList) {
        QuizList newQuiz = new QuizList(quizList.getId(), quizList.getName(), quizList.isActive(), quizList.getVote(), quizList.getUser(), quizList.getCategory(), quizList.getState());
        return quizListRepository.save(newQuiz);
    }
}
