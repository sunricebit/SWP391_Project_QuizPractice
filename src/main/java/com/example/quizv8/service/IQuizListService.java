package com.example.quizv8.service;

import com.example.quizv8.model.QuizList;

import java.util.List;

public interface IQuizListService {
    public List<QuizList> getQuizByUserID(long userId);
    public boolean deleteAnswer(long questionId);
    public boolean deleteQuestionDetail(long quizListId);
    public boolean deleteQuizList(long quizListId);
    public QuizList getQuizListById(long QuizListId);
}
