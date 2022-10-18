package com.example.quizv8.service;

import com.example.quizv8.model.QuestionDetail;
import com.example.quizv8.model.QuizList;
import com.example.quizv8.model.QuizState;

import java.util.List;

public interface IQuizListService {
    public List<QuizList> getQuizByUserID(long userId);
    public boolean deleteQuestionDetail(long quizListId);
    public boolean deleteQuizList(long quizListId);
    public QuizList getQuizListById(long QuizListId);
    public List<QuizList> getQuizPublic(long stateId);

    public List<QuizList> getQuizByCategory(String categoryName);
    public List<QuestionDetail> getAllQuestion(long quizListID);
}
